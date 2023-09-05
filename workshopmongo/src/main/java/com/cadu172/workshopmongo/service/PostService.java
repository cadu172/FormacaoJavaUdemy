package com.cadu172.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadu172.workshopmongo.domain.Post;
import com.cadu172.workshopmongo.repository.PostRepository;
import com.cadu172.workshopmongo.service.exception.ResourceNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public List<Post> findAll() {
		
		List<Post> listPost = postRepository.findAll();
		
		return listPost;
		
	}
	
	public Post findById(String id) {
		
		Optional<Post> post = postRepository.findById(id);
		
		return post.orElseThrow(() -> new ResourceNotFoundException("Post ID "+id+" não encontrado"));
	
	}
	
	public Post insert(Post post) {
		
		return postRepository.insert(post);
		
	}
	
	public void deleteById(String id) {
		postRepository.deleteById(id);		
	}
	
	public Post update(Post post) {
		
		Post postDB = this.findById(post.getId());		
		
		// atualizar o id do objeto pa
		post.setId(postDB.getId());
		
		/*if ( user.getId()==null ) {
			throw new ResourceNotFoundException("Operacao update obrigatorio informar o id");
		}
		else if ( user.getEmail() == null  ) {
			throw new ResourceNotFoundException("Operacao update obrigatorio informar o campo email");
		}
		else if ( user.getName() == null  ) {
			throw new ResourceNotFoundException("Operacao update obrigatorio informar o campo name");
		}*/	
		
		return postRepository.save(post);
	
	}
	
}
