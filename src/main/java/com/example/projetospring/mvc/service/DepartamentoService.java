package com.example.projetospring.mvc.service;

import java.util.List;

import com.example.projetospring.mvc.domain.Departamento;

public interface DepartamentoService {

	void salvar(Departamento dpt);
	
	void editar(Departamento dpt);
	
	void excluir(Long id);
	
	Departamento obterPorId(Long id);
	
	List<Departamento> obterTodos();

	boolean departamentoTemCargos(Long id);
	
}
