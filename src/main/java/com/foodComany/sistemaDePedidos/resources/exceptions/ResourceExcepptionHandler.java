package com.foodComany.sistemaDePedidos.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.foodComany.sistemaDePedidos.services.exceptions.BancoDeDadosExcecao;
import com.foodComany.sistemaDePedidos.services.exceptions.RecursoNaoEncontradoExcecao;

@ControllerAdvice
public class ResourceExcepptionHandler {

	@ExceptionHandler(RecursoNaoEncontradoExcecao.class)
	public ResponseEntity<StandardError> recursoNaoEncontrado(RecursoNaoEncontradoExcecao e, HttpServletRequest request){
		String error = "Recurso nao encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError erro = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
	    return ResponseEntity.status(status).body(erro);
	}
	
	@ExceptionHandler(BancoDeDadosExcecao.class)
	public ResponseEntity<StandardError> recursoNaoEncontrado(BancoDeDadosExcecao e, HttpServletRequest request){
		String error = "Erro no banco de dados";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError erro = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
	    return ResponseEntity.status(status).body(erro);
	}
}
