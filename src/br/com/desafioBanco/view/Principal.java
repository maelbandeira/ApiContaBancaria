package br.com.desafioBanco.view;



import br.com.desafioBanco.Cliente;
import br.com.desafioBanco.Conta;
import br.com.desafioBanco.ContaCorrente;
import br.com.desafioBanco.ContaPoupanca;

public class Principal {

	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		
		Conta cc = new ContaCorrente(cliente);
		cc.depositar(500);
		
		
		Conta poupanca = new ContaPoupanca(cliente);
		
		cc.transferir(100, poupanca);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();

	}

}
