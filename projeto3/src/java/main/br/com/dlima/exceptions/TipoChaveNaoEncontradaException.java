package br.com.dlima.exceptions;

public class TipoChaveNaoEncontradaException extends Exception {

	private static final long serialVersionUID = -8363012122072257978L;
	
	public TipoChaveNaoEncontradaException(String msg) {
		this(msg, null);
	}
	
	public TipoChaveNaoEncontradaException(String msg, Throwable e) {
		super(msg, e);
	}

}
