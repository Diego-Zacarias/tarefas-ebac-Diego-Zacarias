package br.com.dlima.domain;

import java.util.Date;

public class Cliente extends Entity {
	private String nome;
	private String codigo;
	private Date dataCadastro;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	@Override
	public String toString() {
		return 	this.id + "\n"
				+ nome + ", codigo: " + codigo + ", data de cadastro: " + dataCadastro;
	}
	
	

}
