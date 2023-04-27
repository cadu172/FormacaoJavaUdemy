package br.com.udemy.java.secao19;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Aula240TiposCoringas {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		List<Integer> listaInteger = new ArrayList<>();		
		listaInteger.add(1);
		listaInteger.add(2);
		listaInteger.add(3);
		
		
		List<String> listaString = new ArrayList<>();		
		listaString.add("CARLOS");		
		listaString.add("EDUARDO");
		listaString.add("DOS SANTOS ROBERTO");
		
		System.out.println("Lista de integer");
		printList(listaInteger);
		
		System.out.println("Lista de string");
		printList(listaString);	
		
	}
	
	public static void printList( List<?> myList ) {
		
		/* nao é possivel incluir um item em uma lista de parametro coringa porque
		 * o compilador nao sabe qual o tipo passado como parametro */
		//myList.add("TESTE"); 
		
		for (Object listItem : myList) {
			System.out.println(listItem);
		}		
	}

}
