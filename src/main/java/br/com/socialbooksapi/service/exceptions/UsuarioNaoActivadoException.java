package br.com.socialbooksapi.service.exceptions;

import org.springframework.security.core.AuthenticationException;

/**
 * This exception is throw in case of a not activated user trying to authenticate.
 */
public class UsuarioNaoActivadoException extends AuthenticationException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioNaoActivadoException(String message) {
        super(message);
    }

    public UsuarioNaoActivadoException(String message, Throwable t) {
        super(message, t);
    }
}
