package com.foodComany.sistemaDePedidos.entites.enums;

public enum ModoPedido {
	ENTREGA(1),
	RETIRADA_NO_LOCAL(2),
	CANCELADO(3);
	
	private int codigo;
	
	private ModoPedido(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public static ModoPedido valorCodigo(int codigo) {
		for(ModoPedido valor: ModoPedido.values()) {
			if(valor.getCodigo() == codigo) {
				return valor;
			}
		}
		throw new IllegalArgumentException("Codigo invalido");
	}

}
