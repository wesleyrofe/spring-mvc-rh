package com.example.projetospring.mvc.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.projetospring.mvc.domain.Funcionario;

public interface FuncionarioService {
	
	void salvar(Funcionario func);
	void editar(Funcionario fun);
	void excluir(Long id);
	Funcionario obterPorId(Long id);
	List<Funcionario> obterTodos();

	List<Funcionario> buscarPorNome(String nome);
	List<Funcionario> burcarPorCargo(Long id);
	List<Funcionario> buscarPorData(LocalDate entrada, LocalDate saida);

}
