package com.example.projetospring.mvc.dao;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.example.projetospring.mvc.domain.Funcionario;


@Repository
public class FuncionarioDaoImpl extends AbstractDAO<Funcionario, Long> implements FuncionarioDAO{

	@Override
	public List<Funcionario> findByNome(String nome) {

	
		return createQuery("select f from Funcionario f where f.nome like concat('%',?1,'%') ", nome);	
	}

	@Override
	public List<Funcionario> findByCargoId(Long id) {
		return createQuery("select f from Funcionario f where f.cargo.id = ?1", id);
	}

	@Override
	public List<Funcionario> findByDataEntradaDataSaida(LocalDate entrada, LocalDate saida) {
		// Alternativa de execução de uma query concatenada
		String jpql = new StringBuilder ("select f from Funcionario f ")
				.append("where f.dataEntrada >= ?1 and f.dataSaida <= ?2 ")
				.append("order by f.dataEntrada asc")
				.toString();
				
		return createQuery(jpql, entrada, saida);	
		//return createQuery("select f from Funcionario f where f.dataEntrada >= ?1 && fdataSaida <= ?2 order by f.dataEntrada asc", entrada, saida);
	}

	@Override
	public List<Funcionario> findByDataEntrada(LocalDate entrada) {
		return createQuery("select f from Funcionario f where f.dataEntrada >= ?1 order by f.dataEntrada asc", entrada);
	}

	@Override
	public List<Funcionario> findByDataSaida(LocalDate saida) {
		return createQuery("select f from Funcionario f where f.dataSaida >= ?1 order by d.dataEntrada asc", saida);
	}
	
}
