package br.com.apicontabancaria.account.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apicontabancaria.account.domain.Account;
import br.com.apicontabancaria.account.enuns.TypeAccount;
/**
 * @author ABMAEL
 *
 */

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

	List<Account> findByTypeAccount(TypeAccount typeAccount);
	
	Optional<Account> findByAccountNumber(int numberAccount);
	

}
