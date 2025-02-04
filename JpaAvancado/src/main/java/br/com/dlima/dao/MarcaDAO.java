package br.com.dlima.dao;

import br.com.dlima.dao.generic.GenericDAO;
import br.com.dlima.domain.Marca;

public class MarcaDAO extends GenericDAO<Marca> {

	@Override
	public Class<Marca> getTipoClasse() {
		return Marca.class;
	}

	@Override
	protected String getBuscarTodosQuery() {
		StringBuilder sb = new StringBuilder();
		sb.append("select m from Marca m");
		return sb.toString();
	}


}
