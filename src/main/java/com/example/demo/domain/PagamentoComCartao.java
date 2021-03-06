package com.example.demo.domain;

import javax.persistence.Entity;

import com.example.demo.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento  {

	private static final long serialVersionUID = 1L;
 
	private Integer numeroDeParcelas;

	public PagamentoComCartao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.setNumeroDeParcelas(numeroDeParcelas);
		// TODO Auto-generated constructor stub
	}
 
	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	

}
