package com.ufpb.dcx.projeto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ufpb.dcx.projeto.model.Filme;
import com.ufpb.dcx.projeto.service.FilmesService;
@CrossOrigin
@RestController
public class FilmesController {
	@Autowired
	FilmesService filmesService=new FilmesService();

	@RequestMapping(method = RequestMethod.POST, value = "/filmes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Filme> cadastrar(@RequestBody Filme filme) {
		System.out.println("chamou");
		Filme filmeCadastrado = this.filmesService.cadastrarFilme(filme);
		System.out.println(filmeCadastrado.getNome());
		return new ResponseEntity<Filme>(filmeCadastrado, HttpStatus.CREATED);
		
	}

	@RequestMapping(method = RequestMethod.GET, value = "/filmes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Filme>> BuscarFilmes() {
		Collection<Filme> filmesBuscados = this.filmesService.buscarTodos();
		return new ResponseEntity<>(filmesBuscados, HttpStatus.OK);
		
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/filmes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Filme> BuscarFilme(@PathVariable Integer id) {
		Filme filmesBuscados = this.filmesService.buscarPorId(id);
		return new ResponseEntity<>(filmesBuscados, HttpStatus.OK);
		
		
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/filmes/{id}")
	public ResponseEntity<Filme> deletarFilme(@PathVariable Integer id ) {
		Filme filmeEncontrado = filmesService.buscarPorId(id);
		System.out.println(id+"id");
		if(filmeEncontrado==null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		this.filmesService.excluir(filmeEncontrado);
		System.out.println("remveu");
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/filmes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Filme> alterarFilme(@RequestBody Filme filme) {
		Filme filmeAlterado = this.filmesService.alterar(filme);
		return new ResponseEntity<Filme>(filmeAlterado, HttpStatus.OK);
	}

	
}
