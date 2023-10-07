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

import com.example.demo.entities.Comentario;
import com.example.demo.entities.Postagem;
import com.example.demo.entities.Usuario;
import com.example.demo.repositories.ComentarioRepository;

import jakarta.validation.Valid;

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
	
//	@PostMapping("/cadastrar")
//	public Comentario insert(@RequestBody Comentario comentario) {
//		Comentario result = repository.save(comentario);
//		return result;
//	}
	
	
	@PostMapping("/cadastrar")
	public Comentario insert(@Valid @RequestBody Comentario comentario, BindingResult bindingResult) {
		Comentario result = new Comentario();
		if (bindingResult.hasErrors()) {			
			for (ObjectError obj : bindingResult.getAllErrors()) {
				System.out.println(obj.getDefaultMessage());
			}
			return result;
		} else {
			result = repository.save(comentario);
		}
		
		return result;
	}
	
	
	
	@DeleteMapping(value = "/deletar")
	@ResponseBody
	public String delete(@PathVariable @Valid @RequestParam Long id)	{
		
		Optional<Comentario> existingEntity = repository.findById(id);
        if (existingEntity.isPresent()) {
           
        	repository.delete(existingEntity.get());
        	return "Comentario Deletada com sucesso";
        } else {
        	return "Comentario não encontrada";
        }
		
		
	}
	
	@PutMapping(value = "/atualizar")
	@ResponseBody
	public ResponseEntity<Comentario> atualizar(@RequestBody Comentario comentario) {
		
		Comentario comment = repository.saveAndFlush(comentario);
		
		return new ResponseEntity<Comentario>(comment, HttpStatus.OK);
	}

}
