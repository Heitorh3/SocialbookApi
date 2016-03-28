package br.com.socialbooksapi.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.socialbooksapi.domain.DetalhesError;
import br.com.socialbooksapi.service.exceptions.AutorExistenteException;
import br.com.socialbooksapi.service.exceptions.AutorNaoEncontradoException;
import br.com.socialbooksapi.service.exceptions.LivroNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(LivroNaoEncontradoException.class)
	public ResponseEntity<DetalhesError> HandleLivroNaoEncontradoException(LivroNaoEncontradoException e, HttpServletRequest request){
		
		DetalhesError erro = new DetalhesError("O livro não pode ser encontrado", 
											404l, 
											System.currentTimeMillis(), 
											"http://erros.socialbooksa.com/404");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(AutorExistenteException.class)
	public ResponseEntity<DetalhesError> HandleAutorExistenteException(AutorExistenteException e, HttpServletRequest request){
		
		DetalhesError erro = new DetalhesError("Autor já existente!", 
											409l, 
											System.currentTimeMillis(), 
											"http://erros.socialbooksa.com/409");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(AutorNaoEncontradoException.class)
	public ResponseEntity<DetalhesError> HandleAutorNaoEncontradoException(AutorNaoEncontradoException e, HttpServletRequest request){
		
		DetalhesError erro = new DetalhesError("Autor não encontrador!", 
											404l, 
											System.currentTimeMillis(), 
											"http://erros.socialbooksa.com/404");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
}
