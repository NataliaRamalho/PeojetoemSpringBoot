package com.foodComany.sistemaDePedidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodComany.sistemaDePedidos.entites.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido,Long>{
	

}
