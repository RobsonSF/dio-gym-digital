package com.github.robsonsf.diogymdigital.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.robsonsf.diogymdigital.entities.Matricula;
import com.github.robsonsf.diogymdigital.entities.form.MatriculaForm;
import com.github.robsonsf.diogymdigital.service.impl.MatriculaServiceImpl;


@RestController
@RequestMapping(value = "/matriculas")
public class MatriculaController {
	
	@Autowired
	MatriculaServiceImpl service;
	
	@GetMapping(value = "/{id}")
	public Matricula getById(@PathVariable Long id) {
	    return service.get(id);
	}
	
	@GetMapping
	public List<Matricula> getAll(@RequestParam(value = "bairro", required = false)
	                                  String bairro){
	return service.getAll(bairro);
	}

	@PostMapping
	public Matricula create(@RequestBody MatriculaForm form) {	
		return service.create(form);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
