package com.example.market.empresa;

import com.example.market.endereco.Endereco;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

	@Embedded
	private Endereco endereco;

	public Empresa(DadosCadastroEmpresa dados) {
		this.cnpj = dados.cnpj();
		this.razao = dados.razao();
		this.endereco = new Endereco(dados.endereco());
	}

}
