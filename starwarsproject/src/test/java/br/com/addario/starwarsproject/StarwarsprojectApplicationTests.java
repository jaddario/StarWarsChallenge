package br.com.addario.starwarsproject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.addario.starwarsproject.model.Result;
import br.com.addario.starwarsproject.model.SwapiPlaneta;


@SpringBootTest
class StarwarsprojectApplicationTests {

	@Test
	void consumirApi() {
		RestTemplate template = new RestTemplate();

		UriComponents uri = UriComponentsBuilder
				.newInstance()
				.scheme("https")
				.host("swapi.dev")
				.path("api/planets/")
				.queryParam("search", "tatooine")
				.build();

		ResponseEntity<SwapiPlaneta> entity = template.getForEntity(uri.toUriString(), SwapiPlaneta.class);
		
		SwapiPlaneta swapiPlaneta = entity.getBody();
		List<Result> results = swapiPlaneta.getResults();
		Result result = results.get(0);
		assertEquals(1, swapiPlaneta.getCount());
		assertEquals(5, result.getFilms().size());
		
	}
}	