package Bancos;

public class ContaCorrente extends Conta 
{
	protected int numeroTalaoCheque;

	
	//construtor
	public ContaCorrente(int numeroConta) {
		super(numeroConta);
	}
	public ContaCorrente(int numeroConta, String cpf) {
		super(numeroConta, cpf);
	}

	//ENCAPSULAMENTO
	
	public int getNumeroTalaoCheque() {
		return numeroTalaoCheque;
	}

	public void setNumeroTalaoCheque(int numeroTalaoCheque) {
		this.numeroTalaoCheque = numeroTalaoCheque;
	}
	
	
	
}