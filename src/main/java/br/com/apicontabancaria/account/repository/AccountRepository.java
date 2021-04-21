package br.com.apicontabancaria.account.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apicontabancaria.account.domain.Account;
/**
 * @author ABMAEL
 *
 */

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

	Optional<Account> findByNumberAccount(Long numberAccount);
	

}
