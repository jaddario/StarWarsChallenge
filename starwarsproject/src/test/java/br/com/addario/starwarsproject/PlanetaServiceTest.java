package br.com.addario.starwarsproject;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.addario.starwarsproject.services.PlanetaService;

class PlanetaServiceTest {

	@Test
	void deveRetornarZeroAparicoesCincoComPlanetaInexistente() {
		PlanetaService service = new PlanetaService();
		int numeroDeAparicoes = service.numeroDeAparicoes("terra");
		assertEquals(0, numeroDeAparicoes);
	}

	@Test
	void deveRetornarCincoAparicoesCincoComTatooine() {
		PlanetaService service = new PlanetaService();
		int numeroDeAparicoes = service.numeroDeAparicoes("tatooine");
		assertEquals(5, numeroDeAparicoes);
	}

}
