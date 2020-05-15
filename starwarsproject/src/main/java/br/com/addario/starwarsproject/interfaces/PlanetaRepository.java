package br.com.addario.starwarsproject.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.addario.starwarsproject.pojo.Planeta;

public interface PlanetaRepository extends JpaRepository<Planeta, Long> {

}
