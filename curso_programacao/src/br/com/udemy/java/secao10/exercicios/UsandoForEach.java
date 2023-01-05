package br.com.udemy.java.secao10.exercicios;

public class UsandoForEach {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] nomes = new String[] {"CADU172","CARLOS EDUARDO","DOS SANTOS ROBERTO"};
		
		//   equivalente ao foreach(elemento in array) {}
		for ( String element : nomes ) {
			
			System.out.println(element);
			
		}

	}

}
