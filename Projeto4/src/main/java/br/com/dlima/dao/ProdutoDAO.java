package br.com.dlima.dao;

import br.com.dlima.dao.generic.GenericDAO;
import br.com.dlima.domain.Produto;

public class ProdutoDAO extends GenericDAO<Produto> implements IProdutoDAO {
    public ProdutoDAO() {
        super(Produto.class);
    }
}
