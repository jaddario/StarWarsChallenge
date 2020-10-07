package br.com.addario.starwarsproject.services;

import java.util.List;
import java.util.Optional;

import br.com.addario.starwarsproject.model.Planeta;

public interface PlanetaService {

	public List<Planeta> listaPlanetas();

	public Planeta adicionaPlaneta(Planeta planeta);

	public Optional<Planeta> buscaPorId(long id);

	public Optional<Planeta> buscaPlanetaPeloNome(String nome);

	public void deleteById(long id);

	public void removePlaneta(long id);

	public int retornaNumeroDeAparicoesEmFilmes(String nomeDoPlaneta);
}
