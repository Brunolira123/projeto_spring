package com.example.market.empresa;

import com.example.market.endereco.Endereco;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Empresa")
@Table(name = "empresa")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String razao;
	private String cnpj;
	
	private Boolean ativo;

	@Embedded
	private Endereco endereco;

	public Empresa(DadosCadastroEmpresa dados) {
		this.ativo = true;
		this.cnpj = dados.cnpj();
		this.razao = dados.razao();
		this.endereco = new Endereco(dados.endereco());
	}

	public void atualizarInfo(@Valid DadosAtualizarEmpresa dados) {
		if(dados.razao() != null) {			
			this.razao = dados.razao();
		}
		if(dados.cnpj() != null) {
			this.cnpj = dados.razao();
		}
		if(dados.endereco() != null) {
			this.endereco.atualizarInfo(dados.endereco()) ;
		}
		
	}

	public void excluir() {
		this.ativo = false;
	}

}
