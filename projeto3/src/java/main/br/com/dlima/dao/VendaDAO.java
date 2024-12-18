package br.com.dlima.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.dlima.dao.factory.ProdutoVendaFactory;
import br.com.dlima.dao.factory.VendaFactory;
import br.com.dlima.dao.generic.GenericDAO;
import br.com.dlima.domain.ProdutoVenda;
import br.com.dlima.domain.Venda;
import br.com.dlima.domain.Venda.StatusVenda;
import br.com.dlima.exceptions.DAOException;
import br.com.dlima.exceptions.MaisDeUmRegistroException;
import br.com.dlima.exceptions.TableException;
import br.com.dlima.exceptions.TipoChaveNaoEncontradaException;

public class VendaDAO extends GenericDAO<Venda, String> implements IVendaDAO {

	@Override
	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
		Connection conn = null;
		PreparedStatement stm = null;
		
		try {
			String sql = "UPDATE TB_VENDA SET STATUS_VENDA = ? WHERE ID = ?";
			conn = getConnection();
			stm = conn.prepareStatement(sql);
			stm.setString(1, StatusVenda.CONCLUIDA.name());
			stm.setLong(2, venda.getId());
			stm.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("ERRO ATUALIZANDO OBJETO", e);
		} finally {
			closeConnection(conn, stm, null);
		}
		
	}

	@Override
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
		Connection conn = null;
		PreparedStatement stm = null;
		
		try {
			String sql = "UPDATE TB_VENDA SET STATUS_VENDA = ? WHERE ID = ?";
			conn = getConnection();
			stm = conn.prepareStatement(sql);
			stm.setString(1, StatusVenda.CANCELADA.name());
			stm.setLong(2, venda.getId());
			stm.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("ERRO ATUALIZANDO OBJETO", e);
		} finally {
			closeConnection(conn, stm, null);
		}
		
	}

	@Override
	public Class<Venda> getTipoClasse() {
		return Venda.class;
	}

	@Override
	public void atualizarDados(Venda entity, Venda entityCadastrado) {
		entityCadastrado.setCodigo(entity.getCodigo());
		entityCadastrado.setStatusVenda(entity.getStatusVenda());
		
	}

	@Override
	public void excluir(String valor) throws DAOException {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	@Override
	public String getQueryInsercao() {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO TB_VENDA ");
		sb.append("(ID, CODIGO, ID_CLIENTE_FK, VALOR_TOTAL, DATA_VENDA, STATUS_VENDA) ");
		sb.append("VALUES (nextval('sq_venda'),?,?,?,?,?)");
		return sb.toString();
	}

	@Override
	public String getQueryExclusao() {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	@Override
	public String getQueryAtualizacao() {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	@Override
	public void setParametrosQueryInsercao(PreparedStatement stmInsert, Venda entity) throws SQLException {
		stmInsert.setString(1, entity.getCodigo());
		stmInsert.setLong(2, entity.getCliente().getId());
		stmInsert.setBigDecimal(3, entity.getValorTotal());
		stmInsert.setTimestamp(4, Timestamp.from(entity.getDataVenda()));
		stmInsert.setString(5, entity.getStatusVenda().name());
		
	}

	@Override
	public void setParametrosQueryExclusao(PreparedStatement stmDelete, String value) throws SQLException {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
		
	}

	@Override
	public void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Venda entity) throws SQLException {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
		
	}

	@Override
	public void setParametrosQuerySelect(PreparedStatement stmUpdate, String valor) throws SQLException {
		stmUpdate.setString(1, valor);
	}

	@Override
	public Venda consultar(String valor) throws MaisDeUmRegistroException, TableException, DAOException {
		StringBuilder sb = sqlBaseSelect();
		sb.append("WHERE V.CODIGO = ? ");
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			stm = conn.prepareStatement(sb.toString());
			setParametrosQuerySelect(stm, valor);
			rs = stm.executeQuery();
			if (rs.next()) {
				Venda venda = VendaFactory.convert(rs);
				buscarAssociacaoVendaProdutos(conn, venda);
				return venda;
			}
		} catch (SQLException e) {
			throw new DAOException("ERRO CONSULTANDO OBJETO", e);
		} finally {
			closeConnection(conn, stm, rs);
		}
		return null;
	}
	
	@Override
	public Collection<Venda> buscarTodos() throws DAOException {
		List<Venda> lista = new ArrayList<>();
		StringBuilder sb = sqlBaseSelect();
		
		try {
			Connection conn = getConnection();
			PreparedStatement stm = conn.prepareStatement(sb.toString());
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				Venda venda = VendaFactory.convert(rs);
				buscarAssociacaoVendaProdutos(conn, venda);
				lista.add(venda);
			}
		} catch (SQLException e) {
			throw new DAOException("ERRO CONSULTANDO OBJETO", e);
		}
		return lista;
	}

	@Override
	public Boolean cadastrar(Venda entity) throws TipoChaveNaoEncontradaException, DAOException {
		Connection conn = null;
		PreparedStatement stm = null;
		
		try {
			conn = getConnection();
			stm = conn.prepareStatement(getQueryInsercao(), Statement.RETURN_GENERATED_KEYS);
			int rowsAffected = stm.executeUpdate();
			
			if (rowsAffected > 0) {
				try (ResultSet rs = stm.getGeneratedKeys()){
					if (rs.next()) {
						entity.setId(rs.getLong(1));
					}
				}
				
				for (ProdutoVenda prodV : entity.getProdutos()) {
					stm = conn.prepareStatement(getQueryInsercaoProdVenda());
					setParametrosQueryInsercaoProdVenda(stm, entity, prodV);
					rowsAffected = stm.executeUpdate();
				}
				
				return true;
			}
		} catch (SQLException e) {
			throw new DAOException("ERRO CADASTRO OBJETO ", e);
		} finally {
			closeConnection(conn, stm, null);
		}
		return false;
	}
	
	private String getQueryInsercaoProdVenda() {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO TB_PRODUTO_VENDA ");
		sb.append("(ID, ID_PRODUTO_FK, ID_VENDA_FK, QUANTIDADE, VALOR_TOTAL) ");
		sb.append("VALUES (nextval('sq_produto_venda'),?,?,?,?)");
		return sb.toString();
	}
	
	private void setParametrosQueryInsercaoProdVenda(
		PreparedStatement stm, 
		Venda venda, 
		ProdutoVenda prodVenda
	) throws SQLException {
		stm.setLong(1, prodVenda.getProduto().getId());
		stm.setLong(2, venda.getId());
		stm.setInt(3, prodVenda.getQuantidade());
		stm.setBigDecimal(4, prodVenda.getValorTotal());
	}

	private void buscarAssociacaoVendaProdutos(Connection conn, Venda venda) throws DAOException {
		PreparedStatement stmProd = null;
		ResultSet rsProd = null;
		
		try {
			StringBuilder sbProd = new StringBuilder();
			sbProd.append("SELECT PV.ID, PV.QUANTIDADE, PV.VALOR_TOTAL, ");
			sbProd.append("P.ID AS ID_PRODUTO, P.CODIGO, P.NOME, P.DESCRICAO, P.VALOR ");
			sbProd.append("FPOM TB_PRODUTO_VENDA PV ");
			sbProd.append("INNER JOIN TB_PRODUTO P ON P.ID = PV.ID_PRODUTO_FK ");
			sbProd.append("WHERE PV.ID_VENDA_FK = ? ");
			
			stmProd = conn.prepareStatement(sbProd.toString());
			stmProd.setLong(1, venda.getId());
			
			rsProd = stmProd.executeQuery();
			Set<ProdutoVenda> produtos = new HashSet<>();
			while (rsProd.next()) {
				ProdutoVenda prodV = ProdutoVendaFactory.convert(rsProd);
				produtos.add(prodV);
			}
			
			venda.setProdutos(produtos);
			venda.recalcularValorTotalVenda();
		} catch (SQLException e) {
			throw new DAOException("ERRO CONSULTANDO OBJETO", e);
		} finally {
			closeConnection(conn, stmProd, rsProd);
		}
	}
	
	private StringBuilder sqlBaseSelect() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT V.ID AS ID_VENDA, V.CODIGO, V.VALOR_TOTAL, V.DATA_VENDA, V.STATUS_VENDA, ");
		sb.append("C.ID AS ID_CLIENTE, C.NOME, C.CPF, C.TELEFONE, C.ENDERECO, C.NUMERO, C.CIDADE, C.ESTADO ");
		sb.append("FROM TB_VENDA V ");
		sb.append("INNER JOIN TB_CLIENTE C ON V.ID_CLIENTE_FK = C.ID;");
		return sb;
	}
	
}









































