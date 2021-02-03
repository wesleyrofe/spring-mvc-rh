package com.example.projetospring.mvc.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.projetospring.mvc.domain.Departamento;
import com.example.projetospring.mvc.service.DepartamentoService;

@Component
public class StringToDepartamentoConverter implements Converter<String, Departamento> {

	@Autowired
	private DepartamentoService service;
	
	public Departamento convert(String text) {
		if(text.isEmpty()){
			return null;
		}
		Long id = Long.valueOf(text);
		return service.obterPorId(id);
	}

}
