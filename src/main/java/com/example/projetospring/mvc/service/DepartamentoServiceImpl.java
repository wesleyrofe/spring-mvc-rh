package com.example.projetospring.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.projetospring.mvc.dao.DepartamentoDAO;
import com.example.projetospring.mvc.domain.Departamento;

@Service
@Transactional(readOnly = false)
public class DepartamentoServiceImpl implements DepartamentoService{
	
	@Autowired
	DepartamentoDAO dao;

	@Override
	public void salvar(Departamento dpt) {
		// TODO Auto-generated method stub
		dao.save(dpt);
	}

	@Override
	public void editar(Departamento dpt) {
		// TODO Auto-generated method stub
		dao.update(dpt);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Departamento obterPorId(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Departamento> obterTodos() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public boolean departamentoTemCargos(Long id) {
		// TODO Auto-generated method stub
		if(obterPorId(id).getCargos().isEmpty()) {
			return false;
		}
		return true;
	}
	
	
	
	
}
