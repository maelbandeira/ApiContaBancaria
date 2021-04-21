package br.com.apicontabancaria.account.service;

import java.util.List;
import java.util.Optional;

import br.com.apicontabancaria.account.domain.Account;

public interface AccountService {
	
	

	Account create(Account account);	

	
	Optional<Account> getByNumberAccount(Long numberAccount);
	
	void removeByNumberAccount(Long numberAccount) throws Exception;	

	List<Account> getAll();	
	
	public void withdrawMoney(Account account, double value) throws Exception;
	
	public void depositMoney(Account account, double value);
	
	public void transferMoney(Account accountOrigin, Account accountDestiny,double value) throws Exception;
	
	

}
