package br.com.dlima.domain;

import java.math.BigDecimal;

import br.com.dlima.annotation.ColunaTabela;
import br.com.dlima.annotation.Tabela;
import br.com.dlima.annotation.TipoChave;

@Tabela("TB_PRODUTO")
public class Produto implements Persistente{
	
	@ColunaTabela(dbName = "id", setJavaName = "setId")
	private Long id;
	
	@ColunaTabela(dbName = "nome", setJavaName = "setNome")
	private String nome;
	
	@TipoChave("getCodigo")
	@ColunaTabela(dbName = "codigo", setJavaName = "setCodigo")
	private String codigo;
	
	@ColunaTabela(dbName = "descricao", setJavaName = "setDescricao")
	private String descricao;
	
	@ColunaTabela(dbName = "valor", setJavaName = "setValor")
	private BigDecimal valor;
	
	@ColunaTabela(dbName = "aliquota_icms", setJavaName = "setAliquotaIcms")
	private BigDecimal aliquotaIcms;
	
	public BigDecimal getAliquotaIcms() {
		return aliquotaIcms;
	}
	public void setAliquotaIcms(BigDecimal aliquotaIcms) {
		this.aliquotaIcms = aliquotaIcms;
	}
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		
	}

}
