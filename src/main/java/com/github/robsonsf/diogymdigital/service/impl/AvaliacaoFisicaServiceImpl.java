package com.github.robsonsf.diogymdigital.service.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.ResourceClosedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.robsonsf.diogymdigital.entities.Aluno;
import com.github.robsonsf.diogymdigital.entities.AvaliacaoFisica;
import com.github.robsonsf.diogymdigital.entities.form.AvaliacaoFisicaForm;
import com.github.robsonsf.diogymdigital.entities.form.AvaliacaoFisicaUpdateForm;
import com.github.robsonsf.diogymdigital.repositories.AlunoRepository;
import com.github.robsonsf.diogymdigital.repositories.AvaliacaoFisicaRepository;
import com.github.robsonsf.diogymdigital.service.IAvaliacaoFisicaService;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {
	
	@Autowired
	AvaliacaoFisicaRepository repository;
	
	@Autowired
	AlunoRepository alunoRepository;

	@Override
	@Transactional
	public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
		AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
		Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();
		
		avaliacaoFisica.setAluno(aluno);
		avaliacaoFisica.setPeso(form.getPeso());
		avaliacaoFisica.setAltura(form.getAltura());
		return repository.save(avaliacaoFisica);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AvaliacaoFisica> getAll() {
		List<AvaliacaoFisica> list = repository.findAll();
		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public AvaliacaoFisica get(Long id) {
		Optional<AvaliacaoFisica> obj =  repository.findById(id);
		AvaliacaoFisica avaliacaoFisica = obj.orElseThrow(
				() -> new ResourceClosedException("Entity not found"));
		return avaliacaoFisica;
	}

	@Override
	@Transactional
	public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm form) {
		Optional<AvaliacaoFisica> obj =  repository.findById(id);
		AvaliacaoFisica avaliacaoFisica = obj.orElseThrow(
				() -> new ResourceClosedException("Entity not found"));
		avaliacaoFisica.setPeso(form.getPeso());
		avaliacaoFisica.setAltura(form.getAltura());
		return avaliacaoFisica;
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
