package br.com.dlima.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.dlima.dao.jdbc.ConnectionFactory;
import br.com.dlima.domain.Produto;

public class ProdutoDAO implements IProdutoDAO {

	@Override
	public Integer cadastrar(Produto entity) throws Exception {
		Connection conn = null;
		PreparedStatement stm = null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "INSERT INTO TB_PRODUTO (QUANTIDADE, NOME, DATA_CADASTRO) VALUES(?,?,?)";
			stm = conn.prepareStatement(sql);
			stm.setInt(1, entity.getQuantidade());
			stm.setString(2, entity.getNome());
			stm.setDate(3, new Date(entity.getDataCadastro().getTime()));
			return stm.executeUpdate();
		} catch (Exception e) {
			throw e; 
		} finally {
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
			
		}
	}

	@Override
	public Produto consultar(String nome) throws Exception {
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		Produto entity = null;
		String nomeBusca = nome;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM TB_PRODUTO WHERE NOME = ?";
			stm = conn.prepareStatement(sql);
			stm.setString(1, nomeBusca);
			rs = stm.executeQuery();
			if (rs.next()) {
				entity = new Produto();
				entity.setId(rs.getString("id"));
				entity.setQuantidade(rs.getInt("quantidade"));
				entity.setNome(rs.getString("nome"));
				entity.setDataCadastro(rs.getDate("data_cadastro"));
			}
			return entity;
		} catch (Exception e) {
			throw e;
		} finally {
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		}
	}

	@Override
	public Integer excluir(String id) throws Exception {
		Connection conn = null;
		PreparedStatement stm = null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "DELETE FROM TB_PRODUTO WHERE ID = ?::UUID";
			stm = conn.prepareStatement(sql);
			stm.setString(1, id);
			return stm.executeUpdate();
		} catch (Exception e) {
			throw e; 
		} finally {
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}	
		}
	}

	@Override
	public Integer alterar(Produto newEntity, String oldId) throws Exception {
		Connection conn = null;
		PreparedStatement stm = null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "UPDATE TB_PRODUTO SET quantidade = ?, nome = ?, data_cadastro = ? WHERE id = ?::UUID";
			stm = conn.prepareStatement(sql);
			stm.setInt(1, newEntity.getQuantidade());
			stm.setString(2, newEntity.getNome());
			stm.setDate(3, new Date(newEntity.getDataCadastro().getTime()));
			stm.setString(4, newEntity.getId());
			return stm.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		}
	}

	@Override
	public Collection<Produto> buscarTodos() throws Exception {
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		List<Produto> entities = new ArrayList<Produto>();
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM TB_PRODUTO";
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			if (rs.next()) {
				while (rs.next()) {
					Produto entity = new Produto();
					entity.setId(rs.getString("id"));
					entity.setQuantidade(rs.getInt("quantidade"));
					entity.setNome(rs.getString("nome"));
					entity.setDataCadastro(rs.getDate("data_cadastro"));
					entities.add(entity);
					
				}
			}
			return entities;
		} catch (Exception e) {
			throw e;
		} finally {
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
			
		}
	}
	
}
