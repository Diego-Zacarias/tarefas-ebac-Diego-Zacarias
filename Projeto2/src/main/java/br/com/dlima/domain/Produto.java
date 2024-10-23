package br.com.dlima.domain;

import br.com.dlima.annotation.TipoChave;

public class Produto implements Persistente {
	@TipoChave("getCodigo")
	private String codigo;
	private String descricao;
	private float preco;
	private int quantidade;

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}	
}
