package br.com.udemy.java.secao19;

import br.com.udemy.java.secao19.model.entities.Cliente;

public class Aula242HashCodeEquals {

	public static void main(String[] args) {
		
		
		Cliente cliente1 = new Cliente("Carlos","cadu172@gmail.com"); 
		Cliente cliente2 = new Cliente("Carlos","cadu172@gmail.com");
		
		System.out.println("Cliente 1 HASH: " + cliente1.hashCode());
		System.out.println("Cliente 2 HASH: " + cliente2.hashCode());
		
		System.out.println("Cliente 2 == Cliente 1 [Endereco de memoria]: " + ( cliente2 == cliente1));
		System.out.println("Cliente 2 Equals Cliente 1 [Comparacao de conteudo]: " + ( cliente2.equals(cliente1)));

	}

}
