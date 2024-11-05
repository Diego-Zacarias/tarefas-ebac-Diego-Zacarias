package br.com.dlima.dao;

import java.util.Collection;

import br.com.dlima.domain.Produto;

public interface IProdutoDAO {
	public Integer cadastrar(Produto entity) throws Exception;
	public Produto consultar(String nome) throws Exception;
	public Integer excluir(String id) throws Exception;
	public Integer alterar(Produto newEntity, String oldId) throws Exception;
	public Collection<Produto> buscarTodos() throws Exception;
}
