package br.com.udemy.java.secao19;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.com.udemy.java.secao19.model.entities.Circle;
import br.com.udemy.java.secao19.model.entities.InterfaceShape;
import br.com.udemy.java.secao19.model.entities.Retangle;

public class Aula241CuringasDelimitados {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		List<InterfaceShape> listaFormaGeometrica = new ArrayList<InterfaceShape>();
		
		listaFormaGeometrica.add(new Circle(2.0));
		listaFormaGeometrica.add(new Retangle(3.0, 2.0));
		
		System.out.println("soma das areas: " + areaTotal(listaFormaGeometrica));

	}
	
	public static Double areaTotal(List<InterfaceShape> list) {
		
		Double soma = 0.0;
		
		for (InterfaceShape itemList : list) {
			soma += itemList.area();			
		}
		
		return soma;
		
	}

}
