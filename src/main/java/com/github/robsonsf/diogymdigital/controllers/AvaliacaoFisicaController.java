package com.github.robsonsf.diogymdigital.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.robsonsf.diogymdigital.entities.AvaliacaoFisica;
import com.github.robsonsf.diogymdigital.entities.form.AvaliacaoFisicaForm;
import com.github.robsonsf.diogymdigital.entities.form.AvaliacaoFisicaUpdateForm;
import com.github.robsonsf.diogymdigital.service.impl.AvaliacaoFisicaServiceImpl;

@RestController
@RequestMapping(value = "/avaliacoes")
public class AvaliacaoFisicaController {
	
	@Autowired
	AvaliacaoFisicaServiceImpl service;
	
	@GetMapping
	public List<AvaliacaoFisica> getAll() {
		List<AvaliacaoFisica> list = service.getAll();
		return list;
	}
	
	@GetMapping(value = "/{id}")
	public AvaliacaoFisica getAll(@PathVariable Long id) {
		AvaliacaoFisica avaliacao = service.get(id);
		return avaliacao;
	}

	@PostMapping
	public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaForm form) {	
		return service.create(form);
	}
	
	@PutMapping(value = "/{id}")
	public AvaliacaoFisica update(@PathVariable Long id, @RequestBody AvaliacaoFisicaUpdateForm form) {	
		return service.update(id, form);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
