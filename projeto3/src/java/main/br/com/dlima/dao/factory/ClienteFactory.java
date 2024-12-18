package br.com.dlima.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.dlima.domain.Cliente;

public class ClienteFactory {
	public static Cliente convert(ResultSet rs) throws SQLException {
		Cliente cliente = new Cliente();
		cliente.setId(rs.getLong("ID_CLIENTE"));
		cliente.setNome(rs.getNString("NOME"));
		cliente.setCpf(rs.getLong(("CPF")));
		cliente.setTelefone(rs.getString(("TEL")));
		cliente.setEndereco(rs.getString(("ENDERECO")));
		cliente.setCidade(rs.getString(("CIDADE")));
		cliente.setEstado(rs.getString(("ESTADO")));
		return cliente;
	}
}

