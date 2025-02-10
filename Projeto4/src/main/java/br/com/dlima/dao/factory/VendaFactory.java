package br.com.dlima.dao.factory;

import br.com.dlima.domain.Cliente;
import br.com.dlima.domain.Venda;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VendaFactory {
    public static Venda convert(ResultSet rs) throws SQLException {
        Cliente cliente = ClienteFactory.convert(rs);
        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.setId(rs.getLong("ID_VENDA"));
        venda.setCodigo(rs.getString("CODIGO"));
        venda.setValorTotal(rs.getBigDecimal("VALOR_TOTAL"));
        venda.setDataVenda(rs.getTimestamp("DATA_VENDA").toInstant());
        venda.setStatusVenda(Venda.StatusVenda.getByName(rs.getString("STATUS_VENDA")));
        return venda;
    }
}
