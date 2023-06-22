package aplicacao;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		
		Pessoa p1 = new Pessoa(1,"Carlos Eduardo","cadu172@gmail.com");
		Pessoa p2 = new Pessoa(2,"Marco Antonio Silva","marco@gmail.com");
		Pessoa p3 = new Pessoa(3,"Ronaldo Silva","r9@gmail.com");
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);

	}

}
