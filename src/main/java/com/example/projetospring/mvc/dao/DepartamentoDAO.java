package com.example.projetospring.mvc.dao;

import java.util.List;

import com.example.projetospring.mvc.domain.Departamento;

public interface DepartamentoDAO {
	
	void save(Departamento departamento);
	
	void update(Departamento departamento);
	
	void delete(Long id);
	
	Departamento findById(Long id);
	
	List<Departamento> findAll();
	
	
	
}
