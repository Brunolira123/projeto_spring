package com.example.market.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Endereco {

	public Endereco(DadosEndereco dados) {
		this.bairro = dados.bairro();
		this.cidade = dados.cidade();
		this.complemento = dados.complemento();
		this.uf = dados.uf();
		this.cep = dados.cep();
	}
	
	private String bairro;
	private String cidade;
	private String complemento;
	private String uf;
	private String cep;
	
}
