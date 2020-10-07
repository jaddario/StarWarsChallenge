package br.com.addario.starwarsproject.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
public class SwapiPlaneta {
	private int count;
	private List<Result> results;

}
