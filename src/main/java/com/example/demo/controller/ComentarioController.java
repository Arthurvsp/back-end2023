package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Comentario;
import com.example.demo.repositories.ComentarioRepository;

@RestController
@RequestMapping(value = "/comentarios")
public class ComentarioController {
	
	@Autowired
	private ComentarioRepository repository;
	
	@GetMapping("/listar")
	public List<Comentario> findAll() {
		List<Comentario> result = repository.findAll();
		return result;
	}
	
	@PostMapping("/cadastrar")
	public Comentario insert(@RequestBody Comentario comentario) {
		Comentario result = repository.save(comentario);
		return result;
	}

}
