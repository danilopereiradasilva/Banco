package Bancos;

import java.util.Scanner;

public class ContaEmpresa extends Conta 
{
	private double emprestimoEmpresa;
	
	//encapsulamento
	public ContaEmpresa(int numeroConta, double emprestimoEmpresa) {
		super(numeroConta);
		this.emprestimoEmpresa = emprestimoEmpresa;
	}

	
	public ContaEmpresa(int numeroConta, String cpf, double emprestimoEmpresa) {
		super(numeroConta, cpf);
		this.emprestimoEmpresa = emprestimoEmpresa;
	}



	//encapsulamento - getters and setters



	public double getEmprestimoEmpresa() {
		return emprestimoEmpresa;
	}

	
	public void setEmprestimoEmpresa(double emprestimoEmpresa) {
		this.emprestimoEmpresa = emprestimoEmpresa;
	}
	
	
	public void pediEmprestimo(double valor)
	{
		super.credito(valor);
		//this.emprestimoEmpresa = this.emprestimoEmpresa - valor;
		this.emprestimoEmpresa -= valor;
		
	}
	
	
	@Override
	public boolean testarSaldo(double valor) 
	{
		
		boolean teste;
		if (valor <= super.getSaldo()) 
		{
			teste = true;
		} 
		else if (valor <= (this.emprestimoEmpresa+super.getSaldo()))
		{
			// 100 saldo 1000 limite  valor pedido: 200 reais
			//1000 + (200)
			double valorCredito= valor - super.getSaldo();
			super.credito(valorCredito);
			this.emprestimoEmpresa = this.emprestimoEmpresa - valorCredito;
			teste = true;
		}
		else
		{
			teste = false;
		}
	
	return teste;
	}
	
	
}