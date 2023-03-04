package com.github.robsonsf.diogymdigital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.robsonsf.diogymdigital.entities.Aluno;

@Repository
public interface MatriculaRepository extends JpaRepository<Aluno, Long>{
}
