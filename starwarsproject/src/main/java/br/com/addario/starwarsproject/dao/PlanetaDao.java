package br.com.addario.starwarsproject.dao;

import java.util.Optional;

import br.com.addario.starwarsproject.pojo.Planeta;


public interface PlanetaDao {

	public Optional<Planeta> buscaPlanetaPeloNome(String nome);
}
