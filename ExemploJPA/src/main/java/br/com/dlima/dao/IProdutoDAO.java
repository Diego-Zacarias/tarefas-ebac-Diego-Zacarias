package br.com.dlima.dao;

import java.util.List;

import br.com.dlima.domain.Produto;

public interface IProdutoDAO {
	public Produto cadastrar(Produto produto);
	
	public Produto buscarPorID(Long id);

	public void excluir(Produto produto);

	public Produto alterar(Produto produto);

	public List<Produto> buscarTodos();
}
