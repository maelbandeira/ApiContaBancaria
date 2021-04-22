package br.com.apicontabancaria.account.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

import br.com.apicontabancaria.account.enuns.TypeAccount;
import br.com.apicontabancaria.client.domain.Client;
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
@CrossOrigin(origins="*")
public class Account implements Serializable{

	/**
	 * @author ABMAEL
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	
	@Column(name="agencia")
	private int agency;
	
	@Column(name="numero_conta")
	private int accountNumber;
	
	@Column(name="saldo")
	private Double balance;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "ID_CLIENT"))
	private Client client;
	
	@Enumerated(EnumType.STRING)
	private TypeAccount typeAccount;
	


}
