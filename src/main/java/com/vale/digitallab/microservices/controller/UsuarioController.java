package com.vale.digitallab.microservices.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vale.digitallab.microservices.model.Usuario;
import com.vale.digitallab.microservices.repository.UsuarioRepository;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public List<Usuario> findAll() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios = repository.findAll(); 
		return usuarios;
	}
	
	@RequestMapping(value = "/usuarios", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody Usuario usuario) {
		this.repository.save(usuario);
	}

}	
