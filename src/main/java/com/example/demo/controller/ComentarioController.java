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

import com.example.demo.entities.Comentario;
import com.example.demo.entities.Usuario;
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
	
	@DeleteMapping(value = "/deletar")
	@ResponseBody
	public ResponseEntity<String> delete(@RequestParam Long id)	{
		
		repository.deleteById(id);
		
		return new ResponseEntity<>("comentario deletado com sucesso", HttpStatus.OK);
	}
	
	@PutMapping(value = "/atualizar")
	@ResponseBody
	public ResponseEntity<Comentario> atualizar(@RequestBody Comentario comentario) {
		
		Comentario comment = repository.saveAndFlush(comentario);
		
		return new ResponseEntity<Comentario>(comment, HttpStatus.OK);
	}

}
