package br.com.dlima.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.dlima.domain.Produto;

public class ProdutoDAO extends GenericDAO<Produto> implements IProdutoDAO {
	
	public ProdutoDAO() {
        super();
        Map<String, Produto> mapaInterno = 
        		(Map<String, Produto>) SingletonMap
        		.getInstance()
        		.getMap()
        		.get(getTipoClasse());
        if (mapaInterno == null) {
            mapaInterno = new HashMap<>();
            SingletonMap.getInstance().getMap().put(getTipoClasse(), mapaInterno);
        }
    }

	@Override
	public Class<Produto> getTipoClasse() {
		return Produto.class;
	}

	@Override
	public void atualizarDados(Produto entity, Produto entityCadastrado) {
		entityCadastrado.setCodigo(entity.getCodigo());
		entityCadastrado.setDescricao(entity.getDescricao());
		entityCadastrado.setPreco(entity.getPreco());
		entityCadastrado.setQuantidade(entity.getQuantidade());
	}
}
