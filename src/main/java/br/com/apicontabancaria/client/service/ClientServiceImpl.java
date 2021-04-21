package br.com.apicontabancaria.client.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.apicontabancaria.client.domain.Client;
import br.com.apicontabancaria.client.domain.dto.ClientDTO;
import br.com.apicontabancaria.client.repository.ClientRepository;
import lombok.RequiredArgsConstructor;

/**
 * @author ABMAEL
 *
 */

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
	
	private final ClientRepository clientRepository;


	@Override
	public List<Client> getAll() {
		return this.clientRepository.findAll();
	}

	@Override
	public Optional<Client> getById(Long id) {
		return this.clientRepository.findById(id);
	}

	@Override
	public Optional<Client> getByEmail(String email) {
		return this.clientRepository.findByEmail(email);
	}

	@Override
	public void removeById(Long id) throws Exception {
		if(this.clientRepository.findById(id).get() != null) {
			this.clientRepository.deleteById(id);
		}else {
			throw new Exception("Client not found");
		}
	}

	@Override
	public Client removeByEmail(String email) throws Exception {
		Client client = this.clientRepository.findByEmail(email).get();
		if(client != null) {
			this.clientRepository.deleteById(client.getId());
			return client;
		}
		
		throw new Exception("Client not found");
	}

	@Override
	public Client create(Client client) {
		return this.clientRepository.save(client);
	}

	@Override
	public Client update(Client client, ClientDTO clientDTO) {
		client.setName(clientDTO.getName());
		client.setCpf(clientDTO.getCpf());		
		client.setCnpj(clientDTO.getCnpj());
		client.setPhone(clientDTO.getPhone());
		client.setEmail(clientDTO.getEmail());		
		return this.clientRepository.save(client);
	}

}
