package br.com.udemy.java.secao20.application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Aula259Stream {

	public static void main(String[] args) {
		
		List<Integer> numList = Arrays.asList(1,2,3,4,5,6,7,8,9);		
		Stream<Integer> st1 = numList.stream();		
		System.out.println(Arrays.toString(st1.toArray()));
		
		Stream<String> st2 = Stream.of("CARLOS","EDUARDO","MARIA");
		System.out.println(Arrays.toString(st2.toArray()));
		
		Stream<Integer> st3 = Stream.iterate(1, p -> p * 2);
		System.out.println(Arrays.toString(st3.limit(10).toArray()));
		
		Stream<Integer> st4 = Stream
					.iterate(new Integer[] {0,1}, p -> new Integer[] {p[1],p[0]+p[1]} )
					.map(p -> p[0]);
		System.out.println(Arrays.toString(st4.limit(10).toArray()));

	}

}
