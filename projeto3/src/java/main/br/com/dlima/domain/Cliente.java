package br.com.dlima.domain;

import br.com.dlima.annotation.ColunaTabela;
import br.com.dlima.annotation.Tabela;

@Tabela("TB_CLIENTE")
public class Cliente implements Persistente {
	
	public enum StatusCliente {
		ATIVO, INATIVO, INADIMPLENTE;
		
		public static StatusCliente getByName(String value) {
			for (StatusCliente status : StatusCliente.values()) {
				if (status.name().equals(value)) {
					return status;
				}
			}
			return null;
		}
	}
	
	@ColunaTabela(dbName = "id", setJavaName = "setId")
	private Long id;
	
	@ColunaTabela(dbName = "nome", setJavaName = "setNome")
	private String nome;
	
	@ColunaTabela(dbName = "cpf", setJavaName = "setCpf")
	private Long cpf;
	
	@ColunaTabela(dbName = "telefone", setJavaName = "setTelefone")
	private String telefone;
	
	@ColunaTabela(dbName = "endereco", setJavaName = "setEndereco")
	private String endereco;
	
	@ColunaTabela(dbName = "cidade", setJavaName = "setCidade")
	private String cidade;
	
	@ColunaTabela(dbName = "entado", setJavaName = "setEstado")
	private String estado;
	
	@ColunaTabela(dbName = "status_cliente", setJavaName = "setStatusCliente")
	private String statusCliente;

	public String getStatusCliente() {
		return statusCliente;
	}

	public void setStatusCliente(String statusCliente) {
		this.statusCliente = statusCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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
