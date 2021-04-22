package br.com.apicontabancaria.account.domain.dto;

import br.com.apicontabancaria.client.domain.dto.ClientDTO;
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

public class AccountDTO {
	
	private ClientDTO clientDTO;
	
	
	private int agency;
	

	private int accountNumber;
	
	
	private Double balance;
	

}
