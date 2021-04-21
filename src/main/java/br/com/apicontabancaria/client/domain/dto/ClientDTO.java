package br.com.apicontabancaria.client.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author ABMAEL
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientDTO {
	
	
	private String name;
	
	private String email;
	
	private String phone;
	
	private String address;
	
	private String cpf;

	private String cnpj;
}
