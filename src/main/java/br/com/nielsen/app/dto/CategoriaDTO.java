package br.com.nielsen.app.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.nielsen.app.domain.Categoria;


public class CategoriaDTO extends AbstrataDTO {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotEmpty(message="O preenchimento do campo nome é obrigatório!")
	@Length(min=5, max=100, message="O tamanho do nome deve estar entre 5 e 100 caracteres!")
	private String nome;

	public CategoriaDTO() {
		super();
	}

	public CategoriaDTO(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
