package br.com.apicontabancaria.account.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apicontabancaria.account.domain.Account;
import br.com.apicontabancaria.account.repository.AccountRepository;
import br.com.apicontabancaria.client.service.ClientService;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private final ClientService clientService;
	@Autowired
	private final AccountRepository accountRepository;
	

	@Override
	public Account create(Account account) {
		return this.accountRepository.save(account);
	}
	

	@Override
	public void removeByNumberAccount(Long numberAccount) throws Exception {
		Account account = this.accountRepository.findByNumberAccount(numberAccount).get();
		if(account !=null) {
			this.accountRepository.delete(account);
		}
		throw new Exception("Account not found !!");		
	}
	
	@Override
	public List<Account> getAll() {
		return this.accountRepository.findAll();
	}

	
	@Override
	public Optional<Account> getByNumberAccount(Long numberAccount) {
		return this.accountRepository.findByNumberAccount(numberAccount);
	}


	public ClientService getClientService() {
		return this.clientService;
	}
	
	@Transactional(rollbackOn = Exception.class) // se caso der erro na transação
	public void withdrawMoney(Account account, double value) throws Exception{
		if(account.getBalance()< value) {
			throw new Exception("Account not found !!");
		}
		account.setBalance(account.getBalance()- value);
		 this.accountRepository.save(account);
	}


	@Override
	@Transactional(rollbackOn = Exception.class) // se caso der erro na transação
	public void depositMoney(Account account, double value) {
		account.setBalance(account.getBalance()+ value);
		 this.accountRepository.save(account);
	}


	@Override
	public void transferMoney(Account accountOrigin, Account accountDestiny, double value) throws Exception {
		
		//Transação de saída
		if (accountOrigin.getBalance() < value) {
			throw new Exception("Balance not found !!");
		}	
		accountOrigin.setBalance(accountOrigin.getBalance() - value);
		this.accountRepository.save(accountOrigin);
		
				
		//Transferênica de entrada
		accountDestiny.setBalance(accountDestiny.getBalance() + value);
		this.accountRepository.save(accountDestiny);
	}
}
