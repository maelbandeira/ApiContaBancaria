package br.com.desafioBanco;

public interface ContratoConta {
	
	void sacar (double valor);
	
	void depositar (double valor);
	
	void transferir (double valor, Conta contaDestino);
	
	void imprimirExtrato();

}
