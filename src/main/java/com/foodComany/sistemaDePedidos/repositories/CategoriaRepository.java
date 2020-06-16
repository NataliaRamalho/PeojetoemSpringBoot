package com.foodComany.sistemaDePedidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodComany.sistemaDePedidos.entites.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria,Long>{
	

}
