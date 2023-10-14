package com.example.market.produto;

import com.example.market.empresa.DadosAtualizarEmpresa;
import com.example.market.empresa.Empresa;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "Produto")
@Table(name = "produto")
public class Produto {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private String ean;

	
	private Boolean ativo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empresa")
	private Empresa empresa;

	
	public void excluir() {
		this.ativo = false;
	}


	public Produto(@Valid DadosCadastroProduto dados) {
		this.ativo = true;
		this.descricao = dados.descricao();
		this.ean =  dados.ean();
		
	}
	
}
