package br.com.desafioBanco;

public abstract class Conta implements ContratoConta {

	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	
	protected int numero;
	protected int agencia;
	protected double saldo;
	protected Cliente cliente;
	
	@Override
	public void sacar(double valor) {
		this.saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		this.saldo += valor;
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}
	
	protected void imprimirInforComuns() {
		System.out.println(String.format("Agência: %d" , this.agencia));
		System.out.println(String.format("Numero: %d" , this.numero));
		System.out.println(String.format("Saldo: %.2f" , this.saldo));
	}
	
	
	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}
	

	public Conta(int numero, int agencia, double saldo) {		
		this.numero = numero;
		this.agencia = agencia;
		this.saldo = saldo;
	}

	public int getNome() {
		return numero;
	}
	
	public int getAgencia() {
		return agencia;
	}

	public double getSaldo() {
		return saldo;
	}
}
