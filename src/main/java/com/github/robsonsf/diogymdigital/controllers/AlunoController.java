package com.github.robsonsf.diogymdigital.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.robsonsf.diogymdigital.entities.Aluno;
import com.github.robsonsf.diogymdigital.service.impl.AlunoServiceImpl;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {
	
	@Autowired
	AlunoServiceImpl service;
	
	@GetMapping
	public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false)
	                                  String dataDeNacimento){
	return service.getAll(dataDeNacimento);
	}


	}
