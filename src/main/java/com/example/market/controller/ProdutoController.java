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
import com.example.market.empresa.Empresa;
import com.example.market.produto.DadosCadastroProduto;
import com.example.market.produto.DadosListagemProduto;
import com.example.market.produto.Produto;
import com.example.market.produto.ProdutoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("produto")
public class ProdutoController {
	
	@Autowired
	ProdutoRepository repository;
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody @Valid DadosCadastroProduto dados, UriComponentsBuilder uriBuilder) {
		
		var produto = new Produto(dados);
		repository.save(produto);
		
		var uri = uriBuilder.path("/produto/{id}").buildAndExpand(produto.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new DadosListagemProduto(produto));
	}
	

	
	@GetMapping
	public ResponseEntity<Page<DadosListagemProduto>>listar(@PageableDefault(size = 10, sort = {"descricao"}) Pageable pag){
		var page = repository.findAll(pag).map(DadosListagemProduto::new);
		
		return ResponseEntity.ok(page);
	}
	
//	@PutMapping
//	@Transactional
//	public ResponseEntity<?> atualizar(@RequestBody @Valid DadosListagemProduto dados) {
//		
//		var empresa = repository.getReferenceById(dados.id());
//		empresa.atualizarInfo(dados);
//		
//		return ResponseEntity.ok(dados);
//	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		var produto = repository.getReferenceById(id);
		produto.excluir();
		
		return ResponseEntity.noContent().build();
	}

}
