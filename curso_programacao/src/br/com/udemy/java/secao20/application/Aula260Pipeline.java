package br.com.udemy.java.secao20.application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Aula260Pipeline {

	public static void main(String[] args) {
		
		List<Integer> numList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);		
		Stream<Integer> st1 = numList.stream().map(p -> p * 10);		
		System.out.println(Arrays.toString(st1.toArray()));
		
		Integer soma = numList.stream().reduce(0, (x, y) -> x + y);
		System.out.println("Soma = " + soma);
		
		List<Integer> newList = numList.stream()
				.filter(p -> p % 2 == 0)
				.map(p -> p * 10)
				.collect(Collectors.toList());
		
		System.out.println(newList.toString());
		
	}

}
