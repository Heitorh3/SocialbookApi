package br.com.socialbooksapi.service.exceptions;

public class AutorExistenteException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AutorExistenteException(String mensagem){
		super(mensagem);
	}
	
	public AutorExistenteException(String mensagem, Throwable causa){
		super(causa);
	}
}
