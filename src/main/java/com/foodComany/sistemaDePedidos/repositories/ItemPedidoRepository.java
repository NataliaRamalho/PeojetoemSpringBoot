package com.foodComany.sistemaDePedidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodComany.sistemaDePedidos.entites.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido,Long>{
	

}
