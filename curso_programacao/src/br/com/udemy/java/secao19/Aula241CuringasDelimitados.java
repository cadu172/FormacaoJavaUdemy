package br.com.udemy.java.secao19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import br.com.udemy.java.secao19.model.entities.InterfaceShape;

public class Aula241CuringasDelimitados {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
	
		/*List<InterfaceShape> listaShape = new ArrayList<InterfaceShape>();		
		listaShape.add(new Circle(2.0));
		listaShape.add(new Retangle(3.0, 2.0));		
		
		List<Circle> listaCircle = new ArrayList<Circle>();
		listaCircle.add(new Circle(2.0));
		listaCircle.add(new Circle(3.0));
		
		List<Retangle> listaRetangle = new ArrayList<Retangle>();
		listaRetangle.add(new Retangle(3.0, 2.0));
		listaRetangle.add(new Retangle(3.0, 2.0));		
		
		System.out.println("Area dos Circulos: " + areaTotal(listaCircle));		
		System.out.println("Area dos Retangulos: " + areaTotal(listaRetangle));*/

		
		/* Princípio get/put - covariância
		 * Exemplo de Covariancia: quando podemos consultar elementos da lista mas nao podemos incluir 
		 * porque o compilador nao consegue saber se o que esta sendo inserido é compatil com a lista
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(10);
		intList.add(5);
		
		List<? extends Number> list = intList;
		Number x = list.get(0);
		list.add(20); // erro de compilacao
		*/	
		
		
		//Princípio get/put - contravariância
		/*
		 * No principio de contravariancia podemos incluir elementos na lista porque a lista mas nao podemos consultar
		 * porque como a lista é generica o compilador não sabe o tipo de retorno do metodo get
		 * 
		 * */
		/*List<Object> myObjs = new ArrayList<Object>();
		myObjs.add("Maria");
		myObjs.add("Alex");
		List<? super Number> myNums = myObjs;
		myNums.add(10);
		myNums.add(3.14);
		Number x = myNums.get(0); // erro de compilacao*/
	
		List<Integer> myInts = Arrays.asList(1, 2, 3, 4);
		List<Double> myDoubles = Arrays.asList(3.14, 6.28);
		List<Number> myObjs = new ArrayList<Number>(); // no lugar de Number pode ser Object já que Object é uma superclasse de Number
		
		copy(myInts, myObjs);
		
		print(myObjs);
		
		copy(myDoubles, myObjs);		
		print(myObjs);
	
	}
	
	public static void copy(List<? extends Number> listOrigem, List<? super Number> listDestino) {
		for (Number item : listOrigem) {
			listDestino.add(item);
		}
	}
	
	public static void print(List<?> lista) {
		System.out.print("[");
		for (Object item : lista) {
			System.out.print(item + " ");
		}		
		System.out.print("]\n");
	}
	
	public static Double areaTotal(List<? extends InterfaceShape> list) {
		/*
		 * List<? extends InterfaceShape>
		 * O Java aceita desta forma porque estou declarando que qualquer objeto List passado que implemente a interface InterfaceShape será aceito 
		 * */
		
		// list.add() não é possível usar o metodo add quando usamos curingas
		
		Double soma = 0.0;
		
		for (InterfaceShape itemList : list) {
			soma += itemList.area();			
		}
		
		return soma;
		
	}

}
