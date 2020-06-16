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

import com.foodComany.sistemaDePedidos.entites.Categoria;
import com.foodComany.sistemaDePedidos.services.CategoriaServices;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaRecursos {

	@Autowired
	private CategoriaServices services;

	@GetMapping
	public ResponseEntity<List<Categoria>> ProcurarCategorias() {
		List<Categoria> list = services.ProcurarCategorias();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id) {
		Categoria obj = services.findyById(id);
		return ResponseEntity.ok().body(obj);

	}
	
	@PostMapping
	public ResponseEntity<Categoria> inserirCategoria(@RequestBody Categoria obj){ 
		obj = services.inserirCategoria(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		services.deletarCategoria(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping(value= "/{id}")
	public ResponseEntity<Categoria> atualizar(@PathVariable Long id,@RequestBody Categoria obj){
		obj = services.atualizarCategoria(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
