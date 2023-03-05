package com.github.robsonsf.diogymdigital.entities.form;

import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoForm implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Preencha o campo corretamente.")
	@Size(min = 3, max =50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
	private String nome;
	
	@NotEmpty(message = "Preencha o campo corretamente.")
	@CPF(message = "'${validatedValue}' é inválido!")
	private String cpf;
	
	@NotNull(message = "Prencha o campo corretamente.")
	@Past(message = "Data '${validatedValue}' é inválida.")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataDeNascimento;
	
	@NotEmpty(message = "Preencha o campo corretamente.")
	@Size(min = 3, max =50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
	private String bairro;
}
