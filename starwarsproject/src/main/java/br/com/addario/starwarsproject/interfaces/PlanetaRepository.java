package br.com.addario.starwarsproject.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.addario.starwarsproject.model.Planeta;

public interface PlanetaRepository extends JpaRepository<Planeta, Long> {

	@Query("select p from Planeta p where p.nome = :nome")
	public Optional<Planeta> buscaPlanetaPeloNome(@Param("nome") String nome);
}
