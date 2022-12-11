package br.com.udemy.java.secao08.util;

public class CurrencyConverter {
	
	public static final double iof = 1.06;
	
	public static double calcAmoundPaidInReal( double p_DollarPrice, double p_AmountDollar ) {
		return ( p_DollarPrice * p_AmountDollar ) * iof;	
	}

}
