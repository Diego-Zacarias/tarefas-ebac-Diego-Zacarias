package br.com.dlima.exceptions;

public class TipoChaveNaoEncontradaException extends Exception {
	
	private static final long serialVersionUID = -4620919784697633035L;

	public TipoChaveNaoEncontradaException(String msg) {
		this(msg, null);
	}

	public TipoChaveNaoEncontradaException(String msg, Throwable e) {
		super(msg, e);
	}
}
