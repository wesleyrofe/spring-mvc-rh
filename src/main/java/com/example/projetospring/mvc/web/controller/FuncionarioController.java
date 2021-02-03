package com.example.projetospring.mvc.web.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.projetospring.mvc.domain.Cargo;
import com.example.projetospring.mvc.domain.Funcionario;
import com.example.projetospring.mvc.domain.UF;
import com.example.projetospring.mvc.service.CargoService;
import com.example.projetospring.mvc.service.FuncionarioService;
import com.example.projetospring.mvc.web.validator.FuncionarioValidator;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcService;
	
	@Autowired
	private CargoService cargoService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new FuncionarioValidator());
	}
	
	@GetMapping("/cadastrar")
	public String cadastro(Funcionario funcionario) {
		return "funcionario/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("funcionarios", funcService.obterTodos());
		return "funcionario/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "funcionario/cadastro";
		}
		funcService.salvar(funcionario);
		System.out.println(funcionario.getEndereco().getCep());
		attr.addFlashAttribute("success", "Funcionado cadastrado com sucesso.");
		return "redirect:/funcionarios/cadastrar";
	}
	
	@GetMapping("/editar/{id}")	
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("funcionario", funcService.obterPorId(id));
		return "funcionario/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "funcionario/cadastro";
		}
		funcService.editar(funcionario);
		attr.addFlashAttribute("success", "Funcionário editado com sucesso");
		return "redirect:/funcionarios/cadastrar";
		
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		funcService.excluir(id);
		attr.addFlashAttribute("success", "Funcionario removido com sucesso.");
		return "redirect:/funcionarios/listar";
	}
	
	@GetMapping("/buscar/nome")
	public String buscarPorNome(@RequestParam("nome") String nome, ModelMap model) {
		
		model.addAttribute("funcionarios", funcService.buscarPorNome(nome));
		return "funcionario/lista";
	}
	
	@GetMapping("/buscar/cargo")
	public String burcarPorCargo(@RequestParam("id") Long id, ModelMap model) {
		model.addAttribute("funcionarios", funcService.burcarPorCargo(id));
		return "funcionario/lista";
	}
	
	@GetMapping("/buscar/data")
	public String buscarPorData(@RequestParam(name = "entrada", required = false) @DateTimeFormat(iso = ISO.DATE) LocalDate entrada, @RequestParam(name = "saida", required = false) @DateTimeFormat(iso = ISO.DATE) LocalDate saida, ModelMap model) {
		model.addAttribute("funcionarios", funcService.buscarPorData(entrada,saida));
		return "funcionario/lista";
	}
	
	

	@ModelAttribute("cargos")
	public List<Cargo> listaDeCargos(){
		return cargoService.buscarTodos();
	}
	
	@ModelAttribute("ufs")
	public UF[] listaDeUF(){
		return UF.values();
	}
}
	
