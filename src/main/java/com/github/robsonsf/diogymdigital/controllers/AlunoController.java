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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.robsonsf.diogymdigital.entities.Aluno;
import com.github.robsonsf.diogymdigital.entities.AvaliacaoFisica;
import com.github.robsonsf.diogymdigital.entities.form.AlunoForm;
import com.github.robsonsf.diogymdigital.entities.form.AlunoUpdateForm;
import com.github.robsonsf.diogymdigital.service.impl.AlunoServiceImpl;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {
	
	@Autowired
	AlunoServiceImpl service;
	
	@GetMapping(value = "/{id}")
	public AlunoForm getById(@PathVariable Long id) {
	    return service.get(id);
	}
	
	@GetMapping
	public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false)
	                                  String dataDeNacimento){
	return service.getAll(dataDeNacimento);
	}
	
	@GetMapping(value = "/avaliacoes/{id}")
	public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable Long id){
		return service.getAllAvaliacaoFisicaId(id);
	}
	
	@PostMapping
	public Aluno create(@RequestBody AlunoForm form) {	
		return service.create(form);
	}
	
	@PutMapping(value = "/{id}")
	public Aluno update(@PathVariable Long id, @RequestBody AlunoUpdateForm form) {
		return service.update(id, form);
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
