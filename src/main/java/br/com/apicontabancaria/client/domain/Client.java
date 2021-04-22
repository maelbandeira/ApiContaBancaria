package br.com.apicontabancaria.client.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ABMAEL
 */


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tb_clients")
@CrossOrigin(origins="*")
public class Client implements Serializable{	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="Nome")
	private String name;	
	
	@Column(name="CPF")	
	private String cpf;
	
	@Column(name="cnpj")	
	private String cnpj;
	
	
	@Column(name="Email")
	private String email;	
	
	@Column(name="Phone")
	private String phone;
	
	@Column(name="address")
	private String address;
	
	
	
	
	
	
	
	

	
}
