package com.example.market.produto;

import com.example.market.empresa.Empresa;

public record DadosListagemProduto(Long id, String descricao, String ean, Boolean ativo, Empresa empresa) {
	
	public DadosListagemProduto(Produto produto) {
		this(produto.getId(), produto.getDescricao(), produto.getEan(), produto.getAtivo(), produto.getEmpresa());
	}


}
