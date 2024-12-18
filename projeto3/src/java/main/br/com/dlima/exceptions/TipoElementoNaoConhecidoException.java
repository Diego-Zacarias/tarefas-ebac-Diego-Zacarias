package br.com.dlima.exceptions;

public class TipoElementoNaoConhecidoException extends Exception {

	private static final long serialVersionUID = -142194374629580863L;
	
	public TipoElementoNaoConhecidoException(String msg) {
		this(msg, null);
	}
	
	public TipoElementoNaoConhecidoException(String msg, Throwable e) {
		super(msg, e);
	}
}
