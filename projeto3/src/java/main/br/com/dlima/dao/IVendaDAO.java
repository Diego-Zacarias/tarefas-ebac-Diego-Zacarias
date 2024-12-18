package br.com.dlima.dao;

import br.com.dlima.dao.generic.IGenericDAO;
import br.com.dlima.domain.Venda;
import br.com.dlima.exceptions.DAOException;
import br.com.dlima.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {
	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
