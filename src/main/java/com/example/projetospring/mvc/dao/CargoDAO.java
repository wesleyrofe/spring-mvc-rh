package com.example.projetospring.mvc.dao;

import java.util.List;

import com.example.projetospring.mvc.domain.Cargo;

public interface CargoDAO {
	
	void save(Cargo cargo);
	
	void update(Cargo cargo);
	
	void delete(Long id);
	
	Cargo findById(Long id);
	
	List<Cargo> findAll();
	
	
	
}
