package com.example.projetospring.mvc.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.projetospring.mvc.dao.CargoDAO;
import com.example.projetospring.mvc.domain.Cargo;

@Service
@Transactional(readOnly = false)
public class CargoServiceImpl implements CargoService{
	
	@Autowired
	private CargoDAO dao;
	
	@Override
	public void salvar(Cargo cargo) {
		// TODO Auto-generated method stub
		dao.save(cargo);
	}

	@Override
	public void editar(Cargo cargo) {
		// TODO Auto-generated method stub
		dao.update(cargo);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Cargo buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cargo> buscarTodos() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public boolean cargoTemFuncionarios(Long id) {
		if(buscarPorId(id).getFuncionario().isEmpty()) {
			return false;
		}
		return true;
	}
	
	
	

}
