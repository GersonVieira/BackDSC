package com.ufpb.dcx.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ufpb.dcx.projeto.model.Usuario;
import com.ufpb.dcx.projeto.service.UsuarioService;

@CrossOrigin
@RestController
public class UsuarioControler {
	@Autowired
	UsuarioService usuarioService;
	@RequestMapping(method = RequestMethod.POST, value="/usuarios", consumes= MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario){
		System.out.println("post em usuario");
		Usuario usuarioCadastrado=this.usuarioService.salvar(usuario);
		return new ResponseEntity<Usuario>(usuarioCadastrado , HttpStatus.CREATED);
		
	}

}
