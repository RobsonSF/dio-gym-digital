package com.github.robsonsf.diogymdigital.entities.form;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoUpdateForm {

	private String nome;
	
	private String bairro;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataDeNascimento;
}