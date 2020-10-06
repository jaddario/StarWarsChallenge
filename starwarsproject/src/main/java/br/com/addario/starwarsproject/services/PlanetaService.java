package br.com.addario.starwarsproject.services;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.addario.starwarsproject.interfaces.PlanetaRepository;
import br.com.addario.starwarsproject.model.Planeta;

@Service
public class PlanetaService {

	private static final String SWAPI_URL = "https://swapi.dev/api/planets/?search=";

	@Autowired
	private PlanetaRepository planetaRepository;

	public List<Planeta> listaPlanetas() {
		return planetaRepository.findAll();
	}

	public Planeta adicionaPlaneta(Planeta planeta) {
		return planetaRepository.save(planeta);
	}

	public Optional<Planeta> buscaPorId(long id) {
		return planetaRepository.findById(id);
	}
	public Optional<Planeta> buscaPlanetaPeloNome(String nome) {
		return planetaRepository.buscaPlanetaPeloNome(nome);
	}

	public void deleteById(long id) {
		planetaRepository.deleteById(id);
	}

	public void removePlaneta(long id) {
		planetaRepository.deleteById(id);
	}

	public int numeroDeAparicoes(String nomeDoPlaneta) {
		Client client = Client.create();
		WebResource resource = client.resource(SWAPI_URL + nomeDoPlaneta);
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		String entity = response.getEntity(String.class);
		JsonObject jsonObject = new JsonParser().parse(entity).getAsJsonObject();
		JsonArray results = (JsonArray) jsonObject.get("results");
		if (results.size() == 0)
			return 0;
		else {
			JsonObject planet = (JsonObject) results.get(0);
			JsonArray films = (JsonArray) planet.get("films");
			int numeroAparicoes = films.size();
			return numeroAparicoes;
		}
	}

}
