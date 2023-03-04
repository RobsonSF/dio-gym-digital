package com.github.robsonsf.diogymdigital.service;

import java.util.List;

import com.github.robsonsf.diogymdigital.entities.Matricula;
import com.github.robsonsf.diogymdigital.entities.form.MatriculaForm;

public interface IMatriculaService {
	
	Matricula create(MatriculaForm form);

	Matricula get(Long id);

	List<Matricula> getAll(String bairro);

	void delete(Long id);
}
