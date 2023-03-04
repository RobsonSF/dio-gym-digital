package com.github.robsonsf.diogymdigital.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.robsonsf.diogymdigital.entities.Aluno;
import com.github.robsonsf.diogymdigital.entities.AvaliacaoFisica;
import com.github.robsonsf.diogymdigital.entities.form.AlunoForm;
import com.github.robsonsf.diogymdigital.entities.form.AlunoUpdateForm;
import com.github.robsonsf.diogymdigital.service.IAlunoService;

@Service
public class AlunoServiceImpl implements IAlunoService {

	@Override
	public Aluno create(AlunoForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Aluno get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Aluno> getAll(String dataDeNascimento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Aluno update(Long id, AlunoUpdateForm formUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
