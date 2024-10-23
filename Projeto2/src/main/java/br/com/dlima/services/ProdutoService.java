package br.com.dlima.services;

import br.com.dlima.dao.IProdutoDAO;
import br.com.dlima.domain.Produto;
import br.com.dlima.exceptions.TipoChaveNaoEncontradaException;

public class ProdutoService implements IService<Produto> {
	
	IProdutoDAO produtoDAO;
	
	public ProdutoService(IProdutoDAO produtoDAO) {
		this.produtoDAO = produtoDAO;
	}

	@Override
	public Boolean cadastrar(Produto entity) throws TipoChaveNaoEncontradaException {
		return this.produtoDAO.cadastrar(entity);
	}

	@Override
	public void excluir(String chave) {
		this.produtoDAO.excluir(chave);
		
	}

	@Override
	public void alterar(Produto entity) throws TipoChaveNaoEncontradaException {
		this.produtoDAO.alterar(entity);
		
	}

	@Override
	public Produto consultar(String chave) {
		return this.produtoDAO.consultar(chave);
	}

}
