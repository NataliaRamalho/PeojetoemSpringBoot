package com.foodComany.sistemaDePedidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodComany.sistemaDePedidos.entites.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Long>{
	

}
