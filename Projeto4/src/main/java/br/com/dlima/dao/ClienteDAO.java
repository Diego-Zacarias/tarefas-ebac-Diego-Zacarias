package br.com.dlima.dao;

import br.com.dlima.dao.generic.GenericDAO;
import br.com.dlima.domain.Cliente;

public class ClienteDAO extends GenericDAO<Cliente> implements IClienteDAO {
    public ClienteDAO() {

        super(Cliente.class);
    }
}
