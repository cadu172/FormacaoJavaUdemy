package br.com.udemy.java.secao13.entities;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Post {
	
	private LocalDateTime moment;
	private String title;
	private String content;
	private int likes;
	private ArrayList<Comment> comment = new ArrayList<Comment>();
	
	
	public Post(LocalDateTime moment, String title, String content, int likes) {
		this.moment = moment;
		this.title = title;
		this.content = content;
		this.likes = likes;
	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	public void addComment(Comment comment) {
		this.comment.add(comment);
	}

	@Override
	public String toString() {
		
		/*String postPrint = "";
		postPrint += this.getTitle() + "\n";
		postPrint += this.getLikes() + " Likes - " + this.getMoment().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + "\n";
		postPrint += this.getContent() + "\n";
		postPrint += "Comments:\n";		
		for (Comment item : comment) {
			postPrint += item.getText() +  "\n";			
		}		
		return postPrint;*/
		
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.getTitle() + "\n");
		sb.append(this.getLikes() + " Likes - " + this.getMoment().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + "\n");
		sb.append(this.getContent() + "\n");
		sb.append("Comments:\n");
		
		for (Comment item : comment) {
			sb.append(item.getText() +  "\n");			
		}		
		
		return sb.toString();

	}
	
	
	
}
