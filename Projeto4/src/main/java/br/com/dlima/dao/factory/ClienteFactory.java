package br.com.dlima.dao.factory;

import br.com.dlima.domain.Cliente;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteFactory {
    public static Cliente convert(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setId(rs.getLong("ID_CLIENTE"));
        cliente.setNome(rs.getString(("NOME")));
        cliente.setCpf(rs.getString(("CPF")));
        cliente.setTelefone(rs.getString(("TELEFONE")));
        cliente.setEndereco(rs.getString(("ENDERECO")));
        cliente.setNumero(rs.getInt(("NUMERO")));
        cliente.setCidade(rs.getString(("CIDADE")));
        cliente.setEstado(rs.getString(("ESTADO")));
        return cliente;
    }
}
