package br.com.addario.starwarsproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
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

}
