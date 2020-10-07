package br.com.addario.starwarsproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.addario.starwarsproject.model.Planeta;
import br.com.addario.starwarsproject.services.PlanetaService;

@RestController
@RequestMapping("/starwars")
public class PlanetaController {

	@Autowired
	private PlanetaService service;

	@PostMapping("/adicionaplaneta")
	public Planeta adicionaPlaneta(@RequestBody Planeta planeta) {
		int numeroDeAparicoes = service.retornaNumeroDeAparicoesEmFilmes(planeta.getNome());
		planeta.setNumeroDeAparicoes(numeroDeAparicoes);
		return service.adicionaPlaneta(planeta);
	}

	@GetMapping("/listaplanetas")
	public List<Planeta> listaPlanetas() {
		return service.listaPlanetas();
	}

	@GetMapping(path = "/buscaplanetapeloid/{id}")
	public ResponseEntity<Planeta> buscaPlanetasPorId(@PathVariable long id) {
		return service.buscaPorId(id).map(planeta -> ResponseEntity.ok().body(planeta))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping(path = "/buscaplanetapornome/{nome}")
	public ResponseEntity<Planeta> buscaPlanetaPorNome(@PathVariable String nome) {
		return service.buscaPlanetaPeloNome(nome).map(planeta -> ResponseEntity.ok().body(planeta))
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = "/removeplaneta/{id}")
	public void removePlanetaPeloId(@PathVariable long id) {
		service.deleteById(id);
	}
}
