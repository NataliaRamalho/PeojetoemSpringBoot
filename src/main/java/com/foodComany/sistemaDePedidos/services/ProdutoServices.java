package com.foodComany.sistemaDePedidos.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.foodComany.sistemaDePedidos.entites.Produto;
import com.foodComany.sistemaDePedidos.repositories.ProdutoRepository;
import com.foodComany.sistemaDePedidos.services.exceptions.BancoDeDadosExcecao;
import com.foodComany.sistemaDePedidos.services.exceptions.RecursoNaoEncontradoExcecao;

@Service
public class ProdutoServices {

	@Autowired
	private ProdutoRepository repository;

	public List<Produto> ProcurarProdutos() {
		return repository.findAll();
	}

	public Produto findyById(Long id) {
		Optional<Produto> obj = repository.findById(id);
		return obj.orElseThrow(() -> new RecursoNaoEncontradoExcecao(id));
	}

	public Produto inserirProduto(Produto obj) {
		return repository.save(obj);
	}

	public void deletarProduto(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new RecursoNaoEncontradoExcecao(id);
		} catch (DataIntegrityViolationException e) {
			throw new BancoDeDadosExcecao(e.getMessage());
		}
	}

	public Produto atualizarProduto(Long id, Produto obj) {
		try {
			Produto entity = repository.getOne(id);
			atualizarDados(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new RecursoNaoEncontradoExcecao(id);
		}
	}

	private void atualizarDados(Produto entity, Produto obj) {
		entity.setNomeProduto(obj.getNomeProduto());
		entity.setPreco(obj.getPreco());
	}

}
