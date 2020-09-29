package com.foodComany.sistemaDePedidos.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class InicioRecursos {
	@GetMapping
	public ResponseEntity<String> paginaInicial(){
		 return new ResponseEntity<>("Bem vindo, rotas disponiveis: categoria, produtos, pedidos, clientes ", HttpStatus.OK);
	
	}

}
		


