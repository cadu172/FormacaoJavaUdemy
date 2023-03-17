package br.com.udemy.java.secao14.entities;

public final class PessoaJuridica extends Contribuinte {


	private int numeroDeFuncionarios = 0;

	public PessoaJuridica(String nome, double rendaAnual, int numeroDeFuncionarios) {
		super(nome, rendaAnual);
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}
	
	@Override
	public double calcularImposto() {		
				
		double valorImpostoPagar = this.getRendaAnual()*this.calcularAliquotaIR();
		
		if ( valorImpostoPagar < 0 )
		{
			valorImpostoPagar = 0;
		}
		
		return valorImpostoPagar;
	}
	
	@Override
	public double calcularAliquotaIR() {
		if( this.numeroDeFuncionarios > 10  ) {
			return 0.14d;
		}
		return 0.16d;
	}
	

}
