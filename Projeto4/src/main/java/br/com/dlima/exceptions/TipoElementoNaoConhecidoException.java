package br.com.dlima.exceptions;

public class TipoElementoNaoConhecidoException extends Exception {
    private static final long serialVersionUID = -5003032127955963931L;

    public TipoElementoNaoConhecidoException(String msg) {
        this(msg, null);
    }

    public TipoElementoNaoConhecidoException(String msg, Throwable e) {
        super(msg, e);
    }
}
