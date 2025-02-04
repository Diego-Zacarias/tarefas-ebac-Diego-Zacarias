package br.com.dlima.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class CarroAcessorio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "carro_acessorio_seq")
	@SequenceGenerator(name = "carro_acessorio_seq", sequenceName = "sq_carro_acessorio", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="carro_id")
	private Carro carro;
	
	@ManyToOne
	@JoinColumn(name="acessorio_id")
	private Acessorio acessorio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public Acessorio getAcessorio() {
		return acessorio;
	}

	public void setAcessorio(Acessorio acessorio) {
		this.acessorio = acessorio;
	}
	
}
