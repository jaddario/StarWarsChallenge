package br.com.addario.starwarsproject.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.addario.starwarsproject.pojo.Planeta;
import br.com.addario.starwarsproject.pojo.PlanetaInexistente;

@Repository
public class PlanetaDaoImpl implements PlanetaDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public Optional<Planeta> buscaPlanetaPeloNome(String nome) {
		TypedQuery<Planeta> query = entityManager.createQuery("select p from Planeta p where p.nome = :nome", Planeta.class);
		query.setParameter("nome", nome);
		List<Planeta> resultList = query.getResultList();
		resultList.forEach(System.out::println);
		return Optional.of(query.getSingleResult());
	}

}
