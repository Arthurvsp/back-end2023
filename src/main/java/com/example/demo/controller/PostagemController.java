package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

import jakarta.validation.Valid;


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
	
//	@PostMapping("/cadastrar")
//	public Postagem insert(@RequestBody Postagem postagem) {
//		Postagem result = repository.save(postagem);
//		return result;
//	}
	
	@PostMapping("/cadastrar")
	public Postagem insert(@Valid @RequestBody Postagem postagem, BindingResult bindingResult) {
		Postagem result = new Postagem();
		if (bindingResult.hasErrors()) {			
			for (ObjectError obj : bindingResult.getAllErrors()) {
				System.out.println(obj.getDefaultMessage());
			}
			return result;
		} else {
			result = repository.save(postagem);
		}
		
		return result;
	}
	
	
	
	@DeleteMapping(value = "/deletar")
	@ResponseBody
	public String delete(@PathVariable @Valid @RequestParam Long post_id)	{
		
		Optional<Postagem> existingEntity = repository.findById(post_id);
        if (existingEntity.isPresent()) {
           
        	repository.delete(existingEntity.get());
        	return "Postagem Deletada com sucesso";
        } else {
        	return "Postagem não encontrada";
        }
		
		
	}
	
	@PutMapping(value = "/atualizar")
	@ResponseBody
	public ResponseEntity<Postagem> atualizar(@RequestBody Postagem postagem) {
		
		Postagem post = repository.saveAndFlush(postagem);
		
		return new ResponseEntity<Postagem>(post, HttpStatus.OK);
	}
	

}
