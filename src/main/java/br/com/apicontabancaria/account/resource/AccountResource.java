package br.com.apicontabancaria.account.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.apicontabancaria.account.domain.Account;
import br.com.apicontabancaria.account.domain.dto.AccountConverterDTO;
import br.com.apicontabancaria.account.domain.dto.AccountDTO;
import br.com.apicontabancaria.account.service.AccountService;
import lombok.RequiredArgsConstructor;

/**
 * @author ABMAEL
 *
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class AccountResource {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		accountService.create(account);
		return ResponseEntity.ok().build();
	}
	
		
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<List<Account>> getAllClients(@RequestBody Account account) {
		return ResponseEntity.ok(this.accountService.getAll());
	}
	
	@GetMapping("/{numberAccount}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<AccountDTO> getAccountByNumberAccount(@PathVariable int numberAccount) {
		return ResponseEntity.ok(AccountConverterDTO.convertToAccountDTO(this.accountService.getByNumberAccount(numberAccount).get()));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Void> deleteAccount(@PathVariable("id") Long id) {
		try {
			this.accountService.removeAccount(id);
			return ResponseEntity.ok().build();

		} catch (Exception e) {
			return ResponseEntity.noContent().build();
		}
	}
	
	

}
