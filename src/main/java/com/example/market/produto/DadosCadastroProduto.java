package com.example.market.produto;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroProduto(
		@NotNull
		String descricao,
		@NotNull
		String ean,
		@NotNull
		Long id_empresa) {

}
