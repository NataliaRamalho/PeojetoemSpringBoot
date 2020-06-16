package com.foodComany.sistemaDePedidos.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.foodComany.sistemaDePedidos.entites.Cliente;
import com.foodComany.sistemaDePedidos.repositories.ClienteRepository;
import com.foodComany.sistemaDePedidos.services.exceptions.BancoDeDadosExcecao;
import com.foodComany.sistemaDePedidos.services.exceptions.RecursoNaoEncontradoExcecao;


@Service
public class ClienteServices {
	
	@Autowired
	private ClienteRepository repository;
	
	public List<Cliente> ProcurarClientes(){
		return repository.findAll();
	}
	
	public Cliente findyById(Long id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new RecursoNaoEncontradoExcecao(id));
	}
	
	public Cliente inserirCliente(Cliente obj) {
		return repository.save(obj);
	}
 
	public void deletarCliente(Long id) {
		try {
		  repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new RecursoNaoEncontradoExcecao(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new BancoDeDadosExcecao(e.getMessage());
		}
	}
	
	public Cliente atualizarCliente(Long id, Cliente obj) {
		try {
			Cliente entity = repository.getOne(id);
			atualizarDados(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new RecursoNaoEncontradoExcecao(id);
		}
	}

	private void atualizarDados(Cliente entity, Cliente obj) {
		entity.setName(obj.getNome());
		entity.setTelefone((obj.getTelefone()));
		entity.setEmail(obj.getEmail());
	}
}
