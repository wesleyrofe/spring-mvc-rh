package com.example.projetospring.mvc.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.projetospring.mvc.dao.FuncionarioDAO;
import com.example.projetospring.mvc.domain.Funcionario;

@Service
@Transactional(readOnly = false)
public class FuncionarioServiceImpl implements FuncionarioService{
	
	@Autowired
	private FuncionarioDAO dao;

	@Override
	public void salvar(Funcionario func) {
		// TODO Auto-generated method stub
		dao.save(func);
	}

	@Override
	public void editar(Funcionario func) {
		// TODO Auto-generated method stub
		dao.update(func);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Funcionario obterPorId(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Funcionario> obterTodos() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	
	@Transactional(readOnly = true)
	public List<Funcionario> buscarPorNome(String nome){
		return dao.findByNome(nome);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Funcionario> burcarPorCargo(Long id) {
		return dao.findByCargoId(id);
	}

	@Override
	public List<Funcionario> buscarPorData(LocalDate entrada, LocalDate saida) {
		// TODO Auto-generated method stub
		if(entrada != null && saida != null) {
			return dao.findByDataEntradaDataSaida(entrada,saida);
		}else if(entrada != null){
			return dao.findByDataEntrada(entrada);
		}else if( saida != null){
			return dao.findByDataSaida(saida);
		}else {
			return new ArrayList<>();
		}
		
	}
	
	
	
}
