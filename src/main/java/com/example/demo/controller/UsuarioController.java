package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Usuario;
import com.example.demo.repositories.UsuarioRepository;

import jakarta.validation.Valid;

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
	public Usuario insert(@Valid @RequestBody Usuario usuario, BindingResult bindingResult) {
		Usuario result = new Usuario();
		if (bindingResult.hasErrors()) {
			//response.setStatusCode("199");
			for (ObjectError obj : bindingResult.getAllErrors()) {
				//response.getMensagem().add(obj.getDefaultMessage());
				System.out.println(obj.getDefaultMessage());
			}
			return result;
		} else {
			result = repository.save(usuario);
		}
		
		return result;
	}
	@PostMapping("/cadastrar2")
	public String cadastrar2(@Valid @RequestBody Usuario dados, BindingResult bindingResult) {
//		ProfessorResponseDTO response = new ProfessorResponseDTO();
//		response.setStatusCode("200");
		if (bindingResult.hasErrors()) {
//			response.setStatusCode("199");
			for (ObjectError obj : bindingResult.getAllErrors()) {
				System.out.println(obj.getDefaultMessage());
			}
			return "Erros";
		} else {
			return "Validou";
		}
	}
	
	@DeleteMapping(value = "/deletar")
	@ResponseBody
	public ResponseEntity<String> delete(@RequestParam Long usuario_id)	{
		
		repository.deleteById(usuario_id);
		
		return new ResponseEntity<>("usuario deletado com sucesso", HttpStatus.OK);
	}
	
	@PutMapping(value = "/atualizar")
	@ResponseBody
	public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario) {
		
		Usuario user = repository.saveAndFlush(usuario);
		
		return new ResponseEntity<Usuario>(user, HttpStatus.OK);
	}
	
	
		
	/* 
	@GetMapping(value = "/encontratPorId")
	@ResponseBody
	public ResponseEntity<Usuario> atualizar(@RequestParam(name = "usuario_id") Long usuario_id)	{
		
		Usuario usuario = repository.findById(usuario_id).get();
		
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
			
	*/
	
}
