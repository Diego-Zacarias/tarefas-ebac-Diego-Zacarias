/**
 * 
 */
package br.com.dlima.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.dlima.dao.IVendaDAO;
import br.com.dlima.domain.Venda;
import br.com.dlima.domain.Venda.Status;
import br.com.dlima.exceptions.DAOException;
import br.com.dlima.exceptions.TipoChaveNaoEncontradaException;
import br.com.dlima.services.generic.GenericService;

/**
 * @author diego.lima
 *
 */
@Stateless
public class VendaService extends GenericService<Venda, Long> implements IVendaService {

	IVendaDAO dao;
	
	@Inject
	public VendaService(IVendaDAO dao) {
		super(dao);
		this.dao = dao;
	}

	@Override
	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
		venda.setStatus(Status.CONCLUIDA);
		dao.finalizarVenda(venda);
	}

	@Override
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
		venda.setStatus(Status.CANCELADA);
		dao.cancelarVenda(venda);
	}

	@Override
	public Venda consultarComCollection(Long id) {
		return dao.consultarComCollection(id);
	}

	@Override
	public Venda cadastrar(Venda entity) throws TipoChaveNaoEncontradaException, DAOException {
		entity.setStatus(Status.INICIADA);
		return super.cadastrar(entity);
	}
	
	

}