package com.cadu172.workshopmongo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadu172.workshopmongo.domain.Post;
import com.cadu172.workshopmongo.service.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
	
	@Autowired(required=true)
	private PostService postService;
	
	@GetMapping(value="/{postId}")	
	public ResponseEntity<Post> findByid(@PathVariable String postId) {
		
		Post post = postService.findById(postId);
		
		return ResponseEntity.ok().body(post);		
				
	}
	
}
