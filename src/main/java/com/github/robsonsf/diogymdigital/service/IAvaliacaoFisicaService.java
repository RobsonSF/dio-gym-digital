package com.github.robsonsf.diogymdigital.service;

import java.util.List;

import com.github.robsonsf.diogymdigital.entities.AvaliacaoFisica;
import com.github.robsonsf.diogymdigital.entities.form.AvaliacaoFisicaForm;
import com.github.robsonsf.diogymdigital.entities.form.AvaliacaoFisicaUpdateForm;

public interface IAvaliacaoFisicaService {

	AvaliacaoFisica create(AvaliacaoFisicaForm form);

	AvaliacaoFisica get(Long id);

	List<AvaliacaoFisica> getAll();

	AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate);

	void delete(Long id);
}
