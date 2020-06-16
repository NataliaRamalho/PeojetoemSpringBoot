package com.foodComany.sistemaDePedidos.services.exceptions;

public class RecursoNaoEncontradoExcecao extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public RecursoNaoEncontradoExcecao(Object id) {
		super("Recurso não encontrado id: " + id);
	}
}
