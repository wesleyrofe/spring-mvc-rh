package com.example.projetospring.mvc.dao;

import java.time.LocalDate;
import java.util.List;

import com.example.projetospring.mvc.domain.Funcionario;

public interface FuncionarioDAO {
	
	void save(Funcionario func);
	
	void update(Funcionario func);
	
	void delete(Long id);
	
	Funcionario findById(Long id);
	
	List<Funcionario> findAll();
	

	List<Funcionario> findByNome(String nome);
	
	List<Funcionario> findByCargoId(Long id);

	List<Funcionario> findByDataEntradaDataSaida(LocalDate entrada, LocalDate saida);

	List<Funcionario> findByDataEntrada(LocalDate entrada);

	List<Funcionario> findByDataSaida(LocalDate saida);
	
	
	
}
