package br.com.addario.starwarsproject.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="planeta")
public class Planeta {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(name="nome", nullable=false)
	private String nome;
	@Column(name="clima", nullable=true)
	private String clima;
	@Column(name="terreno", nullable=true)
	private String terreno;
	@Column(name="numero_de_aparicoes", nullable=true)
	private int numeroDeAparicoes;

	public Planeta() {}

	public Planeta(long id, String nome, String clima, String terreno, int numeroDeAparicoes) {
		this.id = id;
		this.nome = nome;
		this.clima = clima;
		this.terreno = terreno;
		this.numeroDeAparicoes = numeroDeAparicoes;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	public int getNumeroDeAparicoes() {
		return numeroDeAparicoes;
	}

	public void setNumeroDeAparicoes(int numeroDeAparicoes) {
		this.numeroDeAparicoes = numeroDeAparicoes;
	}
}
