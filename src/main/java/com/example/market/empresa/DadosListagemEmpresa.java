package com.example.market.empresa;

public record DadosListagemEmpresa(
		Long id,
		String razao,
		String cnpj
		) {

	public DadosListagemEmpresa(Empresa empresa) {
		this(empresa.getId(), empresa.getRazao(), empresa.getCnpj());
	}
}
 