package br.com.dlima.dao;

import br.com.dlima.dao.generic.GenericDAO;
import br.com.dlima.domain.Carro;

public class CarroDAO extends GenericDAO<Carro> {

	@Override
	public Class<Carro> getTipoClasse() {
		return Carro.class;
	}

	@Override
	protected String getBuscarTodosQuery() {
		StringBuilder sb = new StringBuilder();
		sb.append("select c ");
		sb.append("from Carro c");
		return sb.toString();
	}
}
