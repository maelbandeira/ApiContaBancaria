package br.com.apicontabancaria.account.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	private AccountService accountService;
	

}
