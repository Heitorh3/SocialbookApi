package br.com.socialbooksapi.service.exceptions;

public class LivroNaoEncontradoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LivroNaoEncontradoException(String mensagem){
		super(mensagem);
	}
	
	public LivroNaoEncontradoException(String mensagem, Throwable causa){
		super(causa);
	}
}
