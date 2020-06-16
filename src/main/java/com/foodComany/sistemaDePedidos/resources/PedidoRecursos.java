package com.foodComany.sistemaDePedidos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodComany.sistemaDePedidos.entites.Pedido;
import com.foodComany.sistemaDePedidos.services.PedidoServices;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoRecursos {
	
	@Autowired
	private PedidoServices services;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> ProcurarPedidos(){
		List<Pedido> list = services.ProcurarPedidos();
		
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Long id){
		Pedido obj = services.findyById(id);
		return ResponseEntity.ok().body(obj);
		
	}

}
