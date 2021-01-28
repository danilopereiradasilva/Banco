package Bancos;

public class ContaEspecial extends ContaCorrente
{
	private double valorLimite;

	
	//encapsulamento
	
	public ContaEspecial(int numeroConta, double valorLimite) {
		super(numeroConta);
		this.valorLimite = valorLimite;
	}

	public double getValorLimite() {
		return valorLimite;
	}

	public void setValorLimite(double valorLimite) {
		this.valorLimite = valorLimite;
	}
	
	
	@Override
	public boolean testarSaldo(double valor) {
		
		boolean teste;
		if (valor <= super.getSaldo()) 
		{
			teste = true;
		} 
		else if (valor <= (this.valorLimite+super.getSaldo()))
		{
			// 100 saldo 1000 limite  valor pedido: 200 reais
			//1000 + (200)
			double valorCredito=valor - super.getSaldo();
			super.credito(valorCredito);
			this.valorLimite = this.valorLimite - valorCredito;
			teste = true;
		}
		else
		{
			teste = false;
		}
		
		return teste;
	}
	
	
	
	
}