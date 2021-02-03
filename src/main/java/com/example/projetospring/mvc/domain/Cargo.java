package com.example.projetospring.mvc.domain;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;


import lombok.*;


@Entity
@Table(name = "cargo")
@Getter
@Setter
@SuppressWarnings("serial")
public class Cargo extends AbstractEntity<Long> {
	
	@NotBlank(message = "Informe um cargo")
	@Size(message = "O nome do cargo deve conter no máximo 60 caractéres.")
	@Column(nullable= false, unique = true, length = 60)
	private String nome;
	
	@NotNull(message = "Selecione um departamento  relativo ao cargo.")
	@ManyToOne
	@JoinColumn(name = "departamento_id")
	private Departamento departamento;
	
	@OneToMany(mappedBy = "cargo")	
	private List<Funcionario> funcionario;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Funcionario> getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(List<Funcionario> funcionario) {
		this.funcionario = funcionario;
	}
	
	
	
}
