package com.ufpb.dcx.projeto.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufpb.dcx.projeto.model.Usuario;
import com.ufpb.dcx.projeto.repostory.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository repositorio;
	
	public Usuario salvar(Usuario usuario) {
		return repositorio.save(usuario);
	}
	public Usuario buscarPorId(int id) {
		return repositorio.getOne(id);
	}
	public void excluir(Usuario usuario) {
	 this.repositorio.delete(usuario);
	}
	public Collection<Usuario> pegarTodos(){
		return this.repositorio.findAll();
	}
	
}
