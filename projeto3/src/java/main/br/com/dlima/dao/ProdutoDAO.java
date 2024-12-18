package br.com.dlima.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.dlima.dao.generic.GenericDAO;
import br.com.dlima.domain.Produto;

public class ProdutoDAO extends GenericDAO<Produto, String> implements IProdutoDAO {
	
	public ProdutoDAO() {}

	@Override
	public Class<Produto> getTipoClasse() {
		return Produto.class;
	}

	@Override
	public void atualizarDados(Produto entity, Produto entityCadastrado) {
		entityCadastrado.setCodigo(entity.getCodigo());
		entityCadastrado.setDescricao(entity.getDescricao());
		entityCadastrado.setNome(entity.getNome());
		entityCadastrado.setValor(entity.getValor());
		entityCadastrado.setAliquotaIcms(entity.getAliquotaIcms());
		
	}

	@Override
	public String getQueryInsercao() {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO TB_PRODUTO ");
		sb.append("(ID, CODIGO, NOME, DESCRICAO, VALOR, ALIQUOTA_ICMS)");
		sb.append("VALUES (nextval('sq_produto'),?,?,?,?,?)");
		return sb.toString();
	}

	@Override
	public String getQueryExclusao() {
		return "DELETE FROM TB_PRODUTO WHERE CODIGO = ?";
	}

	@Override
	public String getQueryAtualizacao() {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE TB_PRODUTO ");
		sb.append("SET CODIGO = ?,");
		sb.append("NOME = ?,");
		sb.append("DESCRICAO = ?,");
		sb.append("VALOR = ?");
		sb.append("ALIQUOTA_ICMS = ?");
		sb.append(" WHERE CODIGO = ?");
		return sb.toString();
	}

	@Override
	public void setParametrosQueryInsercao(PreparedStatement stmInsert, Produto entity) throws SQLException {
		stmInsert.setString(1, entity.getCodigo());
		stmInsert.setString(2, entity.getNome());
		stmInsert.setString(3, entity.getDescricao());
		stmInsert.setBigDecimal(4, entity.getValor());
		stmInsert.setBigDecimal(5, entity.getAliquotaIcms());
		
	}

	@Override
	public void setParametrosQueryExclusao(PreparedStatement stmDelete, String value) throws SQLException {
		stmDelete.setString(1, value);
		
	}

	@Override
	public void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Produto entity) throws SQLException {
		stmUpdate.setString(1, entity.getCodigo());
		stmUpdate.setString(2, entity.getNome());
		stmUpdate.setString(3, entity.getDescricao());
		stmUpdate.setBigDecimal(4, entity.getValor());
		stmUpdate.setBigDecimal(5, entity.getAliquotaIcms());
		stmUpdate.setString(6, entity.getCodigo());
		
	}

	@Override
	public void setParametrosQuerySelect(PreparedStatement stmUpdate, String valor) throws SQLException {
		stmUpdate.setString(1, valor);
		
	}
	
	
}
