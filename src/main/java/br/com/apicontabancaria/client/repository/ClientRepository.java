package br.com.apicontabancaria.client.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apicontabancaria.client.domain.Client;

/**
 * @author ABMAEL
 *
 */

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	
	Optional<Client> findByEmail(String email);
}
