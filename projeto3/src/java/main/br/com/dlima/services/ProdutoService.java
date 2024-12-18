package br.com.dlima.services;

import br.com.dlima.dao.generic.IGenericDAO;
import br.com.dlima.domain.Produto;
import br.com.dlima.services.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IGenericDAO<Produto, String> dao) {
		super(dao);
	}

}
