package com.projeto.bar.domain;
import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.projeto.bar.enums.EstadoPagamento;
@Entity
@JsonTypeName("pagamentoComDinheiro")
public class PagamentoComDinheiro extends Pagamento {
	private static final long serialVersionUID = 1L;

	

	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataPagamento;

	public PagamentoComDinheiro() {
	}

	public PagamentoComDinheiro(Integer id, EstadoPagamento estado, Mesa mesa, Date dataPagamento) {
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
