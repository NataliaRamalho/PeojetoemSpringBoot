package com.foodComany.sistemaDePedidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodComany.sistemaDePedidos.entites.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long>{
	

}
