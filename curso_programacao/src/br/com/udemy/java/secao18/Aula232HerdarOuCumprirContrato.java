package br.com.udemy.java.secao18;

import java.util.Locale;

import br.com.udemy.java.secao18.model.entities.AbstractShape;
import br.com.udemy.java.secao18.model.entities.Circle;
import br.com.udemy.java.secao18.model.entities.Retangle;
import br.com.udemy.java.secao18.model.enums.Color;

public class Aula232HerdarOuCumprirContrato {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		AbstractShape circle = new Circle(Color.BLACK, 2.0);
		AbstractShape retangle = new Retangle(Color.WHITE, 3.0, 4.0);
		
		System.out.println("Circle Area: " + circle.area());
		System.out.println("Retangle Area: " + retangle.area());
		System.out.println("Circle COLOR: " + circle.getColor());
		System.out.println("Retangle COLOR: " + retangle.getColor());

	}

}
