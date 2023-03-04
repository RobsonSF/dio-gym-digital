package com.github.robsonsf.diogymdigital.service;

import java.util.List;

import com.github.robsonsf.diogymdigital.entities.Aluno;
import com.github.robsonsf.diogymdigital.entities.AvaliacaoFisica;
import com.github.robsonsf.diogymdigital.entities.form.AlunoForm;
import com.github.robsonsf.diogymdigital.entities.form.AlunoUpdateForm;

public interface IAlunoService {
	Aluno create(AlunoForm form);

	Aluno get(Long id);

	List<Aluno> getAll(String dataDeNascimento);

	Aluno update(Long id, AlunoUpdateForm formUpdate);

	void delete(Long id);

	List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id);
}
