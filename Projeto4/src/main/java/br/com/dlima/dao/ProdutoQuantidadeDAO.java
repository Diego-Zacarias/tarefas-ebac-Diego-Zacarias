package br.com.dlima.dao;

import br.com.dlima.dao.generic.GenericDAO;
import br.com.dlima.domain.ProdutoQuantidade;

public class ProdutoQuantidadeDAO extends GenericDAO<ProdutoQuantidade> implements IProdutoQuantidadeDAO {
    public ProdutoQuantidadeDAO() {
        super(ProdutoQuantidade.class);
    }
}
