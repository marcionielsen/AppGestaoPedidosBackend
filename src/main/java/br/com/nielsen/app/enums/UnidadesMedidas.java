package br.com.nielsen.app.enums;

public enum UnidadesMedidas {

	UNIDADES(1, "Unidade(s)", "und"), GRAMAS(2, "Grama(s)", "gr"), PORCAO(3, "Porção(ões)", "prç"),
	KILO(4, "Kilo(s)", "Kg");

	private Integer codigo;
	private String descricao;
	private String sigla;

	private UnidadesMedidas(Integer cod, String descricao, String sigla) {
		this.codigo = cod;
		this.descricao = descricao;
		this.sigla = sigla;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getSigla() {
		return sigla;
	}

	public static UnidadesMedidas toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (UnidadesMedidas unidadeMedida : UnidadesMedidas.values()) {

			if (cod.equals(unidadeMedida.getCodigo())) {
				return unidadeMedida;
			}
		}

		throw new IllegalArgumentException("Id ENUM Inválido: " + cod.intValue());
	}

}
