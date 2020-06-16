package com.foodComany.sistemaDePedidos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodComany.sistemaDePedidos.entites.Pedido;
import com.foodComany.sistemaDePedidos.repositories.PedidoRepository;
import com.foodComany.sistemaDePedidos.services.exceptions.RecursoNaoEncontradoExcecao;


@Service
public class PedidoServices {
	
	@Autowired
	private PedidoRepository repository;
	
	public List<Pedido> ProcurarPedidos(){
		return repository.findAll();
	}
	
	public Pedido findyById(Long id) {
		Optional<Pedido> obj = repository.findById(id);
		return obj.orElseThrow(() -> new RecursoNaoEncontradoExcecao(id));		
	}
	
	
}
