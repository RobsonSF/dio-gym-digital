package com.github.robsonsf.diogymdigital.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.hibernate.ResourceClosedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.robsonsf.diogymdigital.entities.Aluno;
import com.github.robsonsf.diogymdigital.entities.AvaliacaoFisica;
import com.github.robsonsf.diogymdigital.entities.form.AlunoForm;
import com.github.robsonsf.diogymdigital.entities.form.AlunoUpdateForm;
import com.github.robsonsf.diogymdigital.repositories.AlunoRepository;
import com.github.robsonsf.diogymdigital.service.IAlunoService;
import com.github.robsonsf.diogymdigital.util.JavaTimeUtils;

@Service
public class AlunoServiceImpl implements IAlunoService {
	
	@Autowired
	AlunoRepository repository;

	@Override
	@Transactional
	public Aluno create(AlunoForm form) {
		Aluno aluno = new Aluno();
		aluno.setNome(form.getNome());
		aluno.setCpf(form.getCpf());
		aluno.setDataDeNascimento(form.getDataDeNascimento());
		aluno.setBairro(form.getBairro());
		return repository.save(aluno);
	}

	@Override
	@Transactional(readOnly = true)
	public AlunoForm get(Long id) {
		Optional<Aluno> obj = repository.findById(id);
		Aluno aluno = obj.orElseThrow(
				() -> new ResourceClosedException("Entity not found"));
		return new AlunoForm(
				aluno.getNome(),
				aluno.getCpf(),
				aluno.getDataDeNascimento(),
				aluno.getBairro());
	}

	@Override
	@Transactional(readOnly = true)
	public List<Aluno> getAll(String dataDeNascimento) {
		if(dataDeNascimento == null) {
			return repository.findAll();
		} else {
			LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
			return repository.findByDataDeNascimento(localDate);
		}
	}

	@Override
	@Transactional
	public Aluno update(Long id, AlunoUpdateForm form) {
		Aluno aluno = repository.getReferenceById(id);
		aluno.setNome(form.getNome());
		aluno.setDataDeNascimento(form.getDataDeNascimento());
		aluno.setBairro(form.getBairro());
		return repository.save(aluno);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {
		Optional<Aluno> obj = repository.findById(id);
		Aluno aluno = obj.orElseThrow(
				() -> new ResourceClosedException("Entity not found"));
		return aluno.getAvaliacoes();
	}
}
