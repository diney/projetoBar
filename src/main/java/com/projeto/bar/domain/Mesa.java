package com.projeto.bar.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Mesa  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer numero;
	private Integer numeroPessoa;
	@JsonFormat(pattern="dd/MM/yyyy HH:MM")
	private Date instante ;
	
	@JsonIgnore
	@OneToMany(mappedBy="mesa")
	private List<Pedido> pedidos = new ArrayList<>();
	
	
	public Mesa() {
		
	}


	public Mesa(Integer id, Integer numero, Integer numeroPessoa,Date instante) {
		super();
		this.id = id;
		this.numero = numero;
		this.numeroPessoa = numeroPessoa;
		this.instante = instante;
	}
	public List<ItemPedido> getPedidosMesa() {
		List<ItemPedido> ip = new  ArrayList<>();	
		for (Pedido ped : pedidos) {
			for(ItemPedido ip1:ped.getItens()) {
				ip.add(ip1);
			}
			
			
		}
		return  ip;
	}
	
	public double getSubTotal() {
		double soma = 0.0;		
		for (Pedido ped : pedidos) {
			for(ItemPedido ip:ped.getItens())
			soma = soma + ip.getTotalPedido();
		}
		return soma;
	}
	
	public double getValorTotal() {
		double soma = 0.0;
		soma = soma + getSubTotal()+getGarcon();
		return soma;
		
	}
	
	public double getGarcon() {
		 double percentual = 10.0 / 100.0; 
		double soma = 0.0;
		soma = soma + (getSubTotal()*percentual);
		return soma;
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


	public Integer getNumeroPessoa() {
		return numeroPessoa;
	}


	public void setNumeroPessoa(Integer numeroPessoa) {
		this.numeroPessoa = numeroPessoa;
	}


	public List<Pedido> getPedidos() {
		return pedidos;
	}


	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}


	public Date getInstante() {
		return instante;
	}


	public void setInstante(Date instante) {
		this.instante = instante;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mesa other = (Mesa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
	

}
