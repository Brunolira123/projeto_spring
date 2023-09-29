package com.example.market.empresa;

import com.example.market.endereco.DadosEndereco;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarEmpresa(
		@NotNull
		Long id, 
		String razao, 
		String cnpj, 
		DadosEndereco endereco) {

}
