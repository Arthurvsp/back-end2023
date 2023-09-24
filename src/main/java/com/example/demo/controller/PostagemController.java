package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Postagem;
import com.example.demo.entities.Usuario;
import com.example.demo.repositories.PostagemRepository;


@RestController
@RequestMapping(value = "/postagens")
public class PostagemController {
	
	@Autowired
	private PostagemRepository repository;
	
	@GetMapping("/listar")
	public List<Postagem> findAll() {
		List<Postagem> result = repository.findAll();
		return result;
	}
	
	@PostMapping("/cadastrar")
	public Postagem insert(@RequestBody Postagem postagem) {
		Postagem result = repository.save(postagem);
		return result;
	}
	
	@DeleteMapping(value = "/deletar")
	@ResponseBody
	public ResponseEntity<String> delete(@RequestParam Long post_id)	{
		
		repository.deleteById(post_id);
		
		return new ResponseEntity<>("postagem deletada com sucesso", HttpStatus.OK);
	}
	
	@PutMapping(value = "/atualizar")
	@ResponseBody
	public ResponseEntity<Postagem> atualizar(@RequestBody Postagem postagem) {
		
		Postagem post = repository.saveAndFlush(postagem);
		
		return new ResponseEntity<Postagem>(post, HttpStatus.OK);
	}
	

}
