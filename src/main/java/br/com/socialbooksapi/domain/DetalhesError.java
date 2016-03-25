package br.com.socialbooksapi.domain;

public class DetalhesError {
	
	private String titulo;
	private Long status;
	private Long timestamp;
	private String mensagemDesenvolvedor;
	
	public DetalhesError() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DetalhesError(String titulo, Long status, Long timestamp, String mensagemDesenvolvedor) {
		super();
		this.titulo = titulo;
		this.status = status;
		this.timestamp = timestamp;
		this.mensagemDesenvolvedor = mensagemDesenvolvedor;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public String getMensagemDesenvolvedor() {
		return mensagemDesenvolvedor;
	}
	public void setMensagemDesenvolvedor(String mensagemDesenvolvedor) {
		this.mensagemDesenvolvedor = mensagemDesenvolvedor;
	}

}
