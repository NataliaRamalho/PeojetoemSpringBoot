package com.foodComany.sistemaDePedidos.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.foodComany.sistemaDePedidos.entites.Categoria;
import com.foodComany.sistemaDePedidos.repositories.CategoriaRepository;
import com.foodComany.sistemaDePedidos.services.exceptions.BancoDeDadosExcecao;
import com.foodComany.sistemaDePedidos.services.exceptions.RecursoNaoEncontradoExcecao;


@Service
public class CategoriaServices {
	
	@Autowired
	private CategoriaRepository repository;
	
	public List<Categoria> ProcurarCategorias(){
		return repository.findAll();
	}
	
	public Categoria findyById(Long id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new RecursoNaoEncontradoExcecao(id));
		
	}
	
	public Categoria inserirCategoria(Categoria obj) {
		return repository.save(obj);
	}
 
	public void deletarCategoria(Long id) {
		try {
		  repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new RecursoNaoEncontradoExcecao(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new BancoDeDadosExcecao(e.getMessage());
		}
	}
	
	public Categoria atualizarCategoria(Long id, Categoria obj) {
		try {
			Categoria entity = repository.getOne(id);
			atualizarDados(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new RecursoNaoEncontradoExcecao(id);
		}
	}

	private void atualizarDados(Categoria entity, Categoria obj) {
		entity.setNome(obj.getNome());
	}
 
}
