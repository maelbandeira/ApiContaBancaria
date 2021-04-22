package br.com.apicontabancaria.account.service;

import java.util.List;
import java.util.Optional;

import br.com.apicontabancaria.account.domain.Account;
import br.com.apicontabancaria.account.domain.dto.AccountDTO;
import br.com.apicontabancaria.account.enuns.TypeAccount;

public interface AccountService {	

	Account create(Account account);	

	Optional<Account> getByNumberAccount(int numberAccount);	
	
	List<Account> getAll();		
	
	public void withdrawMoney(Account account, double value) throws Exception;
	
	public void depositMoney(Account account, double value);
	
	public void transferMoney(Account accountOrigin, Account accountDestiny,double value) throws Exception;

	Optional<Account> getAccountById(Long id);

	void removeAccount(Long id) throws Exception;	

}
