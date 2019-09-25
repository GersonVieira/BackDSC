package com.ufpb.dcx.projeto.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufpb.dcx.projeto.model.Filme;
import com.ufpb.dcx.projeto.repostory.FilmesRepository;
@Service
public class FilmesService {
	@Autowired
	FilmesRepository filmesRepositorio;

	public Filme cadastrarFilme(Filme filme) {
		return this.filmesRepositorio.save(filme);
	}

	public Filme buscarPorId(Integer id) {
		

		return this.filmesRepositorio.getOne(id);
	}

	public Filme alterar(Filme filme) {
		return this.filmesRepositorio.save(filme);
	}

	public void excluir(Filme filme) {
		this.filmesRepositorio.delete(filme);
	}

	public Collection<Filme> buscarTodos() {
		return this.filmesRepositorio.findAll();
	}
}
