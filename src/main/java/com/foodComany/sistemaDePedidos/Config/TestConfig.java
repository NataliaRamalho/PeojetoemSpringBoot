package com.foodComany.sistemaDePedidos.Config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.foodComany.sistemaDePedidos.entites.Categoria;
import com.foodComany.sistemaDePedidos.entites.Cliente;
import com.foodComany.sistemaDePedidos.entites.ItemPedido;
import com.foodComany.sistemaDePedidos.entites.Pedido;
import com.foodComany.sistemaDePedidos.entites.Produto;
import com.foodComany.sistemaDePedidos.entites.enums.ModoPedido;
import com.foodComany.sistemaDePedidos.repositories.CategoriaRepository;
import com.foodComany.sistemaDePedidos.repositories.ClienteRepository;
import com.foodComany.sistemaDePedidos.repositories.ItemPedidoRepository;
import com.foodComany.sistemaDePedidos.repositories.PedidoRepository;
import com.foodComany.sistemaDePedidos.repositories.ProdutoRepository;

@Configuration
@Profile("test")
public class TestConfig  implements CommandLineRunner{
	   
    @Autowired
	private ClienteRepository clienteRepository;
    
    @Autowired
	private PedidoRepository pedidoRepository;
    
    @Autowired
	private ProdutoRepository produtoRepository;
    
    @Autowired
	private CategoriaRepository categoriaRepository;
    
    @Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Override
	public void run(String... args) throws Exception {
		Produto pd1 = new Produto(null, "X-Salada", 14.00);
		Produto pd2 = new Produto(null, "X-Bacon", 16.00);
		Produto pd3 = new Produto(null, "X-Egg", 15.00);
		Produto pd4 = new Produto(null, "X-Tudo", 20.00);
		Produto pd5 = new Produto(null, "Coca-cola", 5.00);
		
	    Cliente cliente1 = new Cliente(null, "Gabriel", "gabriel@hotmail.com", "3322-0337");
	    Cliente cliente2 = new Cliente(null, "Gabriela", "gabriela@hotmail.com", "3399-0337");
	    
	    
		Pedido pedido1 = new Pedido(null, Instant.parse("2020-06-12T16:41:59Z"), ModoPedido.ENTREGA, cliente1);
		Pedido pedido2 = new Pedido(null, Instant.parse("2020-06-13T17:40:00Z"), ModoPedido.RETIRADA_NO_LOCAL, cliente2);
		produtoRepository.saveAll(Arrays.asList(pd1,pd2,pd3,pd4,pd5));
		clienteRepository.saveAll(Arrays.asList(cliente1, cliente2));
		pedidoRepository.saveAll(Arrays.asList(pedido1,pedido2));
		
		Categoria cat1 = new Categoria(null, "Bebidas");
		Categoria cat2 = new Categoria(null, "Lanches");
		Categoria cat3 = new Categoria(null, "Promocionais");
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		pd1.getCategorias().add(cat2);
		pd2.getCategorias().add(cat2);
		pd3.getCategorias().add(cat2);
		pd4.getCategorias().add(cat2);
		pd1.getCategorias().add(cat3);
		pd5.getCategorias().add(cat1);
		produtoRepository.saveAll(Arrays.asList(pd1,pd2,pd3,pd4,pd5));
		
		ItemPedido it1 = new ItemPedido(pedido1, pd5, 2, pd5.getPreco());
		ItemPedido it2 = new ItemPedido(pedido2, pd4, 5, pd4.getPreco());
		ItemPedido it3 = new ItemPedido(pedido1, pd3, 1, pd3.getPreco());
		itemPedidoRepository.saveAll(Arrays.asList(it1,it2,it3));
	}
}
