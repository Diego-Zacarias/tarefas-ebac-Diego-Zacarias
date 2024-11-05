package br.com.dlima.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.dlima.dao.jdbc.ConnectionFactory;
import br.com.dlima.domain.Cliente;

public class ClienteDAO implements IClienteDAO {

	@Override
	public Integer cadastrar(Cliente entity) throws Exception {
		Connection conn = null;
		PreparedStatement stm = null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "INSERT INTO TB_CLIENTE (CODIGO, NOME, DATA_CADASTRO) VALUES(?,?,?)";
			stm = conn.prepareStatement(sql);
			stm.setString(1, entity.getCodigo());
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
	public Cliente consultar(String codigo) throws Exception {
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		Cliente entity = null;
		String cod = codigo;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM TB_CLIENTE WHERE CODIGO = ?";
			stm = conn.prepareStatement(sql);
			stm.setString(1, cod);
			rs = stm.executeQuery();
			if (rs.next()) {
				entity = new Cliente();
				entity.setId(rs.getString("id"));
				entity.setCodigo(rs.getString("codigo"));
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
			String sql = "DELETE FROM TB_CLIENTE WHERE ID = ?::UUID";
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
	public Integer alterar(Cliente entity, String oldId) throws Exception {
		Connection conn = null;
		PreparedStatement stm = null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "UPDATE TB_CLIENTE SET codigo = ?, nome = ?, data_cadastro = ? WHERE id = ?::UUID";
			stm = conn.prepareStatement(sql);
			stm.setString(1, entity.getCodigo());
			stm.setString(2, entity.getNome());
			stm.setDate(3, new Date(entity.getDataCadastro().getTime()));
			stm.setString(4, entity.getId());
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
	public Collection<Cliente> buscarTodos() throws Exception {
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		List<Cliente> entities = new ArrayList<Cliente>();
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM TB_CLIENTE";
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			if (rs.next()) {
				while (rs.next()) {
					Cliente entity = new Cliente();
					entity.setId(rs.getString("id"));
					entity.setCodigo(rs.getString("codigo"));
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
























