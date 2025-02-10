package br.com.dlima.dao;

import br.com.dlima.dao.generic.GenericDAO;
import br.com.dlima.domain.Venda;

public class VendaDAO extends GenericDAO<Venda> implements IVendaDAO {
    public VendaDAO() {
        super(Venda.class);
    }
}
