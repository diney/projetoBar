package com.projeto.bar.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.projeto.bar.enums.EstadoPagamento;
@Entity
@JsonTypeName("pagamentoComCartao")
public class PagamentoComCartao extends Pagamento {
	private static final long serialVersionUID = 1L;


	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataPagamento;

	public PagamentoComCartao() {
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Mesa mesa, Date dataVencimento, Date dataPagamento) {
		super(id, estado, mesa);
		this.dataPagamento = dataPagamento;
		
	}


	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}	

}
