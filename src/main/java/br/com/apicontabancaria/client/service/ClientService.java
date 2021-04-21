package br.com.apicontabancaria.client.service;

import java.util.List;
import java.util.Optional;

import br.com.apicontabancaria.client.domain.Client;
import br.com.apicontabancaria.client.domain.dto.ClientDTO;

/**
 * @author ABMAEL
 *
 */


public interface ClientService {
	
	List<Client> getAll();
	
	Optional<Client> getById(Long id);
	
	Optional<Client> getByEmail(String email);
	
	void removeById(Long id) throws Exception;
	
	Client removeByEmail(String email) throws Exception;
	
	Client create(Client client);
	
	Client update(Client client, ClientDTO clientDTO);

}
