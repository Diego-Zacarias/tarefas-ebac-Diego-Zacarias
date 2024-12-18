package br.com.dlima.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.dlima.domain.Produto;
import br.com.dlima.domain.ProdutoVenda;

public class ProdutoVendaFactory {
	public static ProdutoVenda convert(ResultSet rs) throws SQLException {
		Produto prod = ProdutoFactory.convert(rs);
		ProdutoVenda prodVenda = new ProdutoVenda();
		prodVenda.setProduto(prod);
		prodVenda.setId(rs.getLong("ID"));
		prodVenda.setQuantidade(rs.getInt("QUANTIDADE"));
		prodVenda.setValorTotal(rs.getBigDecimal("VALOR_TOTAL"));
		return prodVenda;
	}
}
