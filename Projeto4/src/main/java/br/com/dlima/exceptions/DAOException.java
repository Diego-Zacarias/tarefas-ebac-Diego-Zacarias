package br.com.dlima.exceptions;

public class DAOException extends Exception {
    private static final long serialVersionUID = 101903045903566569L;

    public DAOException(String msg, Exception ex) {
        super(msg, ex);
    }
}
