package br.com.dlima.domain;

import br.com.dlima.annotation.TipoChave;

public class Entity {
	@TipoChave(value = "getId()")
	protected String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
