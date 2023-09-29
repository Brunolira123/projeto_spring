package com.example.market.empresa;

import com.example.market.endereco.DadosEndereco;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroEmpresa(
		@NotBlank
		String razao, 
		@NotBlank
		@Pattern(regexp = "\\d{10,20}")
		String cnpj, 
		
		@NotNull
		@Valid
		DadosEndereco endereco) {

}
