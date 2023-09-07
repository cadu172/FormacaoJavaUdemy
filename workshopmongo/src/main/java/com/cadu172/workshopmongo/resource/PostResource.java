package com.cadu172.workshopmongo.resource;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cadu172.workshopmongo.domain.Post;
import com.cadu172.workshopmongo.resource.util.URL;
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
	
	@GetMapping(value="/findByTitle")	
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="titleString", defaultValue="") String texto) {
		
		texto = URL.decodeParam(texto);
		
		List<Post> list = postService.findByTitle(texto);
		
		return ResponseEntity.ok().body(list);		
				
	}	
	
	@GetMapping(value="/fullSearch")	
	public ResponseEntity<List<Post>> fullSearch(
				@RequestParam(value="textSearch", defaultValue="") String texto,
				@RequestParam(value="dataInicial", defaultValue="") String dataInicial,
				@RequestParam(value="dataFinal", defaultValue="") String dataFinal ) {
		
		texto = URL.decodeParam(texto);
		
		Date dataIni = URL.converterData(dataInicial, new Date(0L));
		Date dataFin = URL.converterData(dataFinal, new Date());
		
		List<Post> list = postService.fullSearch(texto, dataIni, dataFin);
		
		return ResponseEntity.ok().body(list);		
				
	}
	
}
