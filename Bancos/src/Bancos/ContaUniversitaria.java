  
package Bancos;

public class ContaUniversitaria extends ContaEspecial
{
	private double emprestimoUniversitario;

	
	//construtor
	public ContaUniversitaria(int numeroConta, double valorLimite, double emprestimoUniversitario) {
		super(numeroConta, valorLimite);
		this.emprestimoUniversitario = emprestimoUniversitario;
	}

	//encapsulamento - getters and setters
	
	public double getEmprestimoUniversitario() {
		return emprestimoUniversitario;
	}

	public void setEmprestimoUniversitario(double emprestimoUniversitario) {
		this.emprestimoUniversitario = emprestimoUniversitario;
	}
	
	
	
}