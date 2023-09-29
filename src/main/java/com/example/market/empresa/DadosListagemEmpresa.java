package com.example.market.empresa;

public record DadosListagemEmpresa(
		String razao,
		String cnpj
		) {

	public DadosListagemEmpresa(Empresa empresa) {
		this(empresa.getRazao(), empresa.getCnpj());
	}
}
