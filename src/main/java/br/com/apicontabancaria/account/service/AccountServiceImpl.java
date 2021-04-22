package br.com.apicontabancaria.account.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apicontabancaria.account.domain.Account;
import br.com.apicontabancaria.account.domain.dto.AccountDTO;
import br.com.apicontabancaria.account.repository.AccountRepository;
import br.com.apicontabancaria.client.domain.Client;
import br.com.apicontabancaria.client.service.ClientServiceImpl;


@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private  AccountRepository accountRepository;	
	
	@Autowired
	private ClientServiceImpl clientServiceImpl;

	@Override	
	public Account create(Account account) {
		account.setClient(clientServiceImpl.getById(account.getClient().getId()).get());
		return this.accountRepository.save(account);
	}
	

	@Override
	public void removeAccount(Long id) throws Exception {
		Account account = this.accountRepository.findById(id).get();
		if(account !=null) {
			this.accountRepository.deleteById(id);
		}
		throw new Exception("Account not found !!");		
	}
	
	@Override
	public List<Account> getAll() {
		return this.accountRepository.findAll();
	}

	
	@Override
	public Optional<Account> getByNumberAccount(int numberAccount) {
		return this.accountRepository.findByAccountNumber(numberAccount);
	}
	
	
	@Transactional(rollbackOn = Exception.class) // se caso der erro na transação
	public void withdrawMoney(Account account, double value) throws Exception{
		if(account.getBalance()< value) {
			throw new Exception("Balance not found !!");
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
		withdrawMoney(accountOrigin, value);		
		depositMoney(accountDestiny, value);	
	}
	

	@Override
	public Optional<Account> getAccountById(Long id) {
		return this.accountRepository.findById(id);
	}
}
