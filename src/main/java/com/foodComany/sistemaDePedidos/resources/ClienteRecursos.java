package com.foodComany.sistemaDePedidos.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.foodComany.sistemaDePedidos.entites.Cliente;
import com.foodComany.sistemaDePedidos.services.ClienteServices;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteRecursos {
	
	@Autowired
	private ClienteServices services;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> ProcurarClientes(){
		List<Cliente> list = services.ProcurarClientes();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id){
		Cliente obj = services.findyById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Cliente> inserirCliente(@RequestBody Cliente obj){ 
		obj = services.inserirCliente(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		services.deletarCliente(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping(value= "/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id,@RequestBody Cliente obj){
		obj = services.atualizarCliente(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
