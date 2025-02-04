package br.com.dlima.dao;

import br.com.dlima.dao.generic.GenericDAO;
import br.com.dlima.domain.Acessorio;

public class AcessorioDAO extends GenericDAO<Acessorio> {

	@Override
	public Class<Acessorio> getTipoClasse() {
		return Acessorio.class;
	}

	@Override
	protected String getBuscarTodosQuery() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT a FROM Acessorio a");
		return sb.toString();
	}

}
