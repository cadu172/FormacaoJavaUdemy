package br.com.udemy.java.secao13;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import br.com.udemy.java.secao13.entities.Comment;
import br.com.udemy.java.secao13.entities.Post;

public class Exercicio2 {

	public static void main(String[] args) {
		
		Post post1 = new Post(
				LocalDateTime.parse("21/06/2018 13:05:44",DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), //Date moment, 
				"Traveling to New Zealand", //String title, 
				"I'm going to visit this wonderful country!", //String content, 
				12 //int likes
				);
		
		post1.addComment(new Comment("Have a nice trip"));
		post1.addComment(new Comment("Wow that's awesome!"));
		
		
		Post post2 = new Post(
				LocalDateTime.parse("28/07/2018 23:14:19",DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), //Date moment, 
				"Good night guys", //String title, 
				"See you tomorrow", //String content, 
				5 //int likes
				);
		
		post2.addComment(new Comment("Good night"));
		post2.addComment(new Comment("May the Force be with you"));
		
		
		//printing post1
		System.out.println(post1.toString());
		System.out.println(post2.toString());

	}

}
