package br.com.dlima.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.dlima.dao.generic.GenericDAO;
import br.com.dlima.domain.Cliente;
import br.com.dlima.domain.Cliente.StatusCliente;
import br.com.dlima.exceptions.DAOException;
import br.com.dlima.exceptions.TipoChaveNaoEncontradaException;

public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO {
	
	public ClienteDAO() {}

	@Override
	public Class<Cliente> getTipoClasse() {
		return Cliente.class;
	}

	@Override
	public void atualizarDados(Cliente entity, Cliente entityCadastrado) {
		entityCadastrado.setCidade(entity.getCidade());
		entityCadastrado.setCpf(entity.getCpf());
		entityCadastrado.setEndereco(entity.getEndereco());
		entityCadastrado.setEstado(entity.getEstado());
		entityCadastrado.setNome(entity.getNome());
		entityCadastrado.setTelefone(entity.getTelefone());
		entityCadastrado.setStatusCliente(entity.getStatusCliente());
		
	}

	@Override
	public String getQueryInsercao() {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO TB_CLIENTE ");
		sb.append("(ID, NOME, CPF, TELEFONE, ENDERECO, CIDADE, ESTADO, STATUS_CLIENTE)");
		sb.append("VALUES (nextval('sq_cliente'),?,?,?,?,?,?," + StatusCliente.ATIVO.name()+ ")");
		return sb.toString();
	}

	@Override
	public String getQueryExclusao() {
		return "DELETE FROM TB_CLIENTE WHERE CPF = ?";
	}

	@Override
	public String getQueryAtualizacao() {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE TB_CLIENTE ");
		sb.append("SET NOME = ?,");
		sb.append("TELEFONE = ?,");
		sb.append("ENDERECO = ?,");
		sb.append("CIDADE = ?,");
		sb.append("ESTADO = ?");
		sb.append(" WHERE CPF = ? ");
		return sb.toString();
	}

	@Override
	public void setParametrosQueryInsercao(PreparedStatement stmInsert, Cliente entity) throws SQLException {
		stmInsert.setString(1, entity.getNome());
		stmInsert.setLong(2, entity.getCpf());
		stmInsert.setString(3, entity.getTelefone());
		stmInsert.setString(4, entity.getEndereco());
		stmInsert.setString(5, entity.getCidade());
		stmInsert.setString(6, entity.getEstado());
		
	}

	@Override
	public void setParametrosQueryExclusao(PreparedStatement stmDelete, Long value) throws SQLException {
		stmDelete.setLong(1, value);
	}

	@Override
	public void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Cliente entity) throws SQLException {
		stmUpdate.setString(1, entity.getNome());
		stmUpdate.setString(2, entity.getTelefone());
		stmUpdate.setString(3, entity.getEndereco());
		stmUpdate.setString(4, entity.getCidade());
		stmUpdate.setString(5, entity.getEstado());
		stmUpdate.setLong(6, entity.getCpf());
		
	}

	@Override
	public void setParametrosQuerySelect(PreparedStatement stmSelect, Long valor) throws SQLException {
		stmSelect.setLong(1, valor);
		
	}

	@Override
	public void ativarCliente(Cliente entity) throws TipoChaveNaoEncontradaException, DAOException {
		alterarStatusCliente(StatusCliente.ATIVO.name(), entity.getCpf());
	}

	@Override
	public void inativarCliente(Cliente entity) throws TipoChaveNaoEncontradaException, DAOException {
		alterarStatusCliente(StatusCliente.INATIVO.name(), entity.getCpf());
	}

	@Override
	public void inadimplente(Cliente entity) throws TipoChaveNaoEncontradaException, DAOException {
		alterarStatusCliente(StatusCliente.INADIMPLENTE.name(), entity.getCpf());
	}
	
	private void alterarStatusCliente(String status, Long CPF) throws TipoChaveNaoEncontradaException, DAOException {
		Connection conn = getConnection();
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement("UPDATE TB_CLIENTE SET STATUS_CLIENTE = ? WHERE CPF = ?");
			stm.setString(1, status);
			stm.setLong(2, CPF);
			int rowsAffected = stm.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("ERRO AO ALTERAR O STATUS DO CLIENTE", e);
		} finally {
			closeConnection(conn, stm, null);
		}
	}
}
























