package br.com.dlima.dao;

import br.com.dlima.dao.generic.GenericDAO;
import br.com.dlima.domain.CarroAcessorio;

public class CarroAcessorioDAO extends GenericDAO<CarroAcessorio> {

	@Override
	public Class<CarroAcessorio> getTipoClasse() {
		return CarroAcessorio.class;
	}

	@Override
	protected String getBuscarTodosQuery() {
		StringBuilder sb = new StringBuilder();
		sb.append("select ca from CarroAcessorio ca");
		return sb.toString();
	}


}
