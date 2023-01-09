package br.com.udemy.java.secao10.exercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UsandoListas {

	public static void main(String[] args) {
		
		/*
		 aqui é feita a declaração de um tipo arraylist, o ArrayList é um tipo de classe especial que trabalha com vetores e matrizes
		 e faz a implementação da interface List, como uma interface nao pode ser instaciada ela é apenas implementada
		 Um list aceita somente variáveis do tipo wrapper como parametro em sua construcao
		 */
		List<String> lista = new ArrayList<>();
		
		// o arraylist contem um metdo chamado add(), este método é usado para incluir um elemento na lista
		lista.add("SANTOS");
		
		// o metodo add possui uma sobrecarga que permite incluir o elemento em uma determinada posicao do arraylist
		// no exemplo abaixo estou incluindo na posicao 1 da lista		
		lista.add(0, "EDUARDO");
		lista.add(0, "CARLOS");
		
		
		lista.add("ROBERTO");
		lista.add("SANTOS");
		lista.add("SANTOS");
		
		System.out.println("------------- LISTA ORIGINAL --------------------------");
		
		for(String elemento : lista) {
			// o comando indexOf encontra o indice da primeira correspondencia informada no parametro, no caso como
			// o arrayList é um elemento do tipo String passamos um parametro de string "elemento" que na verdade é o item atual do forEach
			System.out.println(elemento);
		}
		
				
		System.out.println("------------ LISTA COM OS ITENS E O INDEX OF ------------------------------------");
		
		for(String elemento : lista) {
			// o comando indexOf encontra o indice da primeira correspondencia informada no parametro, no caso como
			// o arrayList é um elemento do tipo String passamos um parametro de string "elemento" que na verdade é o item atual do forEach
			System.out.println(lista.indexOf(elemento) + " => " +  elemento);
		}
		
		
		System.out.println("-----------------------------------------------");
		
		
		
		/*
		lastIndexOf: encontra a ultima posicao de um elemento passado como argumento
		*/
		System.out.println("lastIndex: " + lista.lastIndexOf("EDUARDO") + " => " +  "EDUARDO");
		
		/*
		removeIf : Remove um item da lista se ele for igual ao argumento passado
		exemplo:   lista.removeIf(item -> item == "CARLOS"), vai remover o elemento CARLOS da lista
		
		*/
		lista.removeIf(item -> item == "CARLOS");
		
		System.out.println("------------ LISTA APOS removeIF(CARLOS) ------------------------------------");
		
		for(String elemento : lista) {
			// o comando indexOf encontra o indice da primeira correspondencia informada no parametro, no caso como
			// o arrayList é um elemento do tipo String passamos um parametro de string "elemento" que na verdade é o item atual do forEach
			System.out.println(lista.indexOf(elemento) + " => " +  elemento);
		}		
		
		System.out.println("------------ LISTA APOS filter(SANTOS) ------------------------------------");
		
		/*
		uso de expressao lambda em conjunto com as listas
		*/
		List<String> filtro = lista.stream().filter(e -> e == "SANTOS").collect(Collectors.toList());
		
		for(String elemento : filtro) {
			System.out.println("Filter: " + elemento);
			
		}
		
		
		System.out.println("------------ LISTA APOS filter(SANTOS).findFirst().orElse ------------------------------------");
		
		/*
		uso de expressao lambda em conjunto com as listas
		*/
		String filtroElse = lista.stream().filter(e -> e == "QUALQUER STRING").findFirst().orElse("Nao localizado");
		
		System.out.println(filtroElse);

	}

}
