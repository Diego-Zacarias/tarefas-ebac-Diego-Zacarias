/**
 * 
 */
package br.com.dlima.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.dlima.dao.IProdutoDAO;
import br.com.dlima.domain.Produto;
import br.com.dlima.services.generic.GenericService;

/**
 * @author diego.lima
 *
 */
@Stateless
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {
	
	private IProdutoDAO produtoDao;

	@Inject
	public ProdutoService(IProdutoDAO produtoDao) {
		super(produtoDao);
		this.produtoDao = produtoDao;
	}

	@Override
	public List<Produto> filtrarProdutos(String query) {
		return produtoDao.filtrarProdutos(query);
	}

}
