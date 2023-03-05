package com.github.robsonsf.diogymdigital.service.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.ResourceClosedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.robsonsf.diogymdigital.entities.Aluno;
import com.github.robsonsf.diogymdigital.entities.Matricula;
import com.github.robsonsf.diogymdigital.entities.form.MatriculaForm;
import com.github.robsonsf.diogymdigital.repositories.AlunoRepository;
import com.github.robsonsf.diogymdigital.repositories.MatriculaRepository;
import com.github.robsonsf.diogymdigital.service.IMatriculaService;

@Service
public class MatriculaServiceImpl implements IMatriculaService {
	
	@Autowired
	private MatriculaRepository repository;
	
	@Autowired
	private AlunoRepository alunoRepository;

	@Override
	@Transactional(readOnly = true)
	public Matricula get(Long id) {
		Optional<Matricula> obj = repository.findById(id);
		Matricula matricula = obj.orElseThrow(
				() -> new ResourceClosedException("Entity not found"));
		return matricula;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Matricula> getAll(String bairro) {
		if(bairro == null) 
			return repository.findAll();
		else 
			return repository.findByAlunoBairro(bairro);
	}
	
	@Override
	@Transactional
	public Matricula create(MatriculaForm form) {
		Aluno aluno = alunoRepository.getReferenceById(form.getAlunoId());
		Matricula matricula = new Matricula();
		matricula.setAluno(aluno);
		return repository.save(matricula);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
