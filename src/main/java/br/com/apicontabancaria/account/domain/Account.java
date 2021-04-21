package br.com.apicontabancaria.account.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_account")
public class Account implements Serializable{

	/**
	 * @author ABMAEL
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	
	
	@Column(name="agencia")
	private String agency;
	
	@Column(name="numero da conta")
	private String accountNumber;
	
	@Column(name="saldo")
	private Double balance;

	
	


}
