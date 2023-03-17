package br.com.udemy.java.secao14.entities;

public final class PessoaFisica extends Contribuinte {

	private double gastosComSaude = 0;	

	public PessoaFisica(String nome, double rendaAnual, double gastosComSaude) {
		super(nome, rendaAnual);
		this.gastosComSaude = gastosComSaude;
	}
	
	@Override
	public double calcularImposto() {
		
		final double PERCENTUAL_DEDUCAO_GASTOS_SAUDE = 0.5d;		
		double valorImpostoPagar = (this.getRendaAnual()*this.calcularAliquotaIR()) - (this.gastosComSaude*PERCENTUAL_DEDUCAO_GASTOS_SAUDE);
		
		if ( valorImpostoPagar < 0 )
		{
			valorImpostoPagar = 0;
		}
		
		return valorImpostoPagar;
	}
	
	@Override
	public double calcularAliquotaIR() {
		if( this.getRendaAnual() <= 20000.00  ) {
			return 0.15d;
		}
		return 0.25d;
	}

		
}
