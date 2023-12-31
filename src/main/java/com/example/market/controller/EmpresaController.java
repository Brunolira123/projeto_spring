package com.example.market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.market.empresa.DadosAtualizarEmpresa;
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
	public ResponseEntity<?> cadastrar(@RequestBody @Valid DadosCadastroEmpresa dados, UriComponentsBuilder uriBuilder) {
		
		var empresa = new Empresa(dados);
		repository.save(empresa);
		
		var uri = uriBuilder.path("/empresa/{id}").buildAndExpand(empresa.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new DadosListagemEmpresa(empresa));
	}
	
	@GetMapping
	public ResponseEntity<Page<DadosListagemEmpresa>>listar(@PageableDefault(size = 10, sort = {"razao"}) Pageable pag){
		var page = repository.findAllByAtivoTrue(pag).map(DadosListagemEmpresa::new);
		
		return ResponseEntity.ok(page);
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<?> atualizar(@RequestBody @Valid DadosAtualizarEmpresa dados) {
		
		var empresa = repository.getReferenceById(dados.id());
		empresa.atualizarInfo(dados);
		
		return ResponseEntity.ok(dados);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		var empresa = repository.getReferenceById(id);
		empresa.excluir();
		
		return ResponseEntity.noContent().build();
	}

}
