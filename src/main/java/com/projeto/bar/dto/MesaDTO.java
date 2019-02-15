package com.projeto.bar.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class MesaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty	
	private Integer numero;
	
	public MesaDTO() {
	
	}

	public MesaDTO(Integer id, @NotEmpty Integer numero) {
		super();
		this.id = id;
		this.numero = numero;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

}
