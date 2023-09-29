package com.example.market.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.market.empresa.DadosCadastroEmpresa;
import com.example.market.empresa.DadosListagemEmpresa;
import com.example.market.empresa.Empresa;
import com.example.market.empresa.EmpresaRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("empresa")
public class EmpresaController {
	
	@Autowired
	private EmpresaRepository repository;

	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroEmpresa dados) {
		repository.save(new Empresa(dados));
	}
	
	@GetMapping
	public List<DadosListagemEmpresa>listar(){
		return repository.findAll().stream().map(DadosListagemEmpresa::new).toList();
	}

}
