package br.com.addario.starwarsproject.services;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.addario.starwarsproject.interfaces.PlanetaRepository;
import br.com.addario.starwarsproject.model.Planeta;
import br.com.addario.starwarsproject.model.Result;
import br.com.addario.starwarsproject.model.SwapiPlaneta;

@Service
public class PlanetaServiceImpl implements PlanetaService{

	@Autowired
	private PlanetaRepository planetaRepository;

	@Override
	public List<Planeta> listaPlanetas() {
		return planetaRepository.findAll();
	}	

	@Override
	public Planeta adicionaPlaneta(Planeta planeta) {
		return planetaRepository.save(planeta);
	}

	@Override
	public Optional<Planeta> buscaPorId(long id) {
		return planetaRepository.findById(id);
	}
	
	@Override
	public Optional<Planeta> buscaPlanetaPeloNome(String nome) {
		return planetaRepository.buscaPlanetaPeloNome(nome);
	}

	@Override
	public void deleteById(long id) {
		planetaRepository.deleteById(id);
	}

	public void removePlaneta(long id) {
		planetaRepository.deleteById(id);
	}
	
	public int retornaNumeroDeAparicoesEmFilmes(String nomeDoPlaneta) {
		RestTemplate template = new RestTemplate();

		UriComponents uri = UriComponentsBuilder
				.newInstance()
				.scheme("https")
				.host("swapi.dev")
				.path("api/planets/")
				.queryParam("search", nomeDoPlaneta)
				.build();

		ResponseEntity<SwapiPlaneta> entity = template.getForEntity(uri.toUriString(), SwapiPlaneta.class);
		
		SwapiPlaneta swapiPlaneta = entity.getBody();
		List<Result> results = swapiPlaneta.getResults();
		Result result = results.get(0);
		
		return result.getFilms().size();
	}
}
