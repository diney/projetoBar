package com.projeto.bar.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.projeto.bar.domain.Categoria;

public class CategoriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotEmpty
	@Length(min=5,max=80,message="O tamanho deve ser entre 5 e 80 caracteries")
	private String nome;

	public CategoriaDTO() {

	}

	public CategoriaDTO(Categoria obj) {
		id = obj.getId();
		nome = obj.getNome();

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}