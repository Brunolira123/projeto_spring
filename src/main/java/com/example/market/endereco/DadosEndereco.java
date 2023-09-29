package com.example.market.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
		@NotBlank
		String bairro,
		@NotBlank
		String cidade,
		String complemento,
		@NotBlank
		String uf,
		@NotBlank
		@Pattern(regexp = "\\d{8}")
		String cep
		) {

}
