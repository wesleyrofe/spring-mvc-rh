package com.example.projetospring.mvc.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.projetospring.mvc.domain.Cargo;
import com.example.projetospring.mvc.service.CargoService;


@Component
public class StringToCargoConverter implements Converter<String, Cargo> {

	@Autowired
	private CargoService service;
	
	public Cargo convert(String text) {
		if(text.isEmpty()){
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}

}
