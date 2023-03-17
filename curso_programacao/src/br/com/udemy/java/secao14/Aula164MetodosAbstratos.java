/**
 * 
 */
package br.com.udemy.java.secao14;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import br.com.udemy.java.secao14.entities.Circle;
import br.com.udemy.java.secao14.entities.Retangle;
import br.com.udemy.java.secao14.entities.Shape;
import br.com.udemy.java.secao14.entities.enums.Color;

/**
 * @author I5
 *
 */
public class Aula164MetodosAbstratos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		
		ArrayList<Shape> figureList = new ArrayList<>();
		
		System.out.print("Enter the number of shapes: ");
		int figureQuantity = scan.nextInt();scan.nextLine();
		
		for (int item=1; item<=figureQuantity; item++ ) {
			
			System.out.println("Shape #"+item+" data:");
			
			System.out.print("Rectangle or Circle (r/c)? ");
			char itemType =scan.next().charAt(0);scan.nextLine();
			
			System.out.print("Color (BLACK/BLUE/RED): ");
			Color color = Color.valueOf(scan.nextLine());
			
			if ( itemType=='r' ) {				

				System.out.print("Width: ");
				float width = scan.nextFloat();
				
				System.out.print("Height: ");
				float height = scan.nextFloat();
				
				figureList.add(new Retangle(width, height, color));				
			
			}
			else if ( itemType=='c' ) {
				
				System.out.print("Radius: ");
				float radius = scan.nextFloat();			
				
				figureList.add(new Circle(color, radius));
			
			}			
			
		}		
		
		scan.close();
		
		System.out.println("");
		System.out.println("SHAPE AREAS:");
		
		for (Shape shape : figureList) {
			System.out.println(String.format("%.2f", shape.area()));
		}

	}

}
