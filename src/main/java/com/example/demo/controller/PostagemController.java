package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Postagem;
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

}
