package br.com.dlima.exceptions;

public class DAOException extends Exception { 
	
	private static final long serialVersionUID = -9021781454241756771L;

	public DAOException(String msg, Exception ex) {
		super(msg, ex);
	}
			
}
