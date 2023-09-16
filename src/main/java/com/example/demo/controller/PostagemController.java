package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Postagem;
import com.example.demo.repositories.PostagemRepository;

@RestController
@RequestMapping(value = "/postagens")
public class PostagemController {
	
	
	private PostagemRepository repository;
	
	@GetMapping
	public List<Postagem> findAll() {
		List<Postagem> result = repository.findAll();
		return result;
	}

}
