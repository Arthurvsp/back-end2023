package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Usuario;
import com.example.demo.repositories.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping("/listar")
	public List<Usuario> findAll() {
		List<Usuario> result = repository.findAll();
		return result;
	}
	
	@PostMapping("/cadastrar")
	public Usuario insert(@RequestBody Usuario usuario) {
		Usuario result = repository.save(usuario);
		return result;
	}
	
}
