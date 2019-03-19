package br.com.vv.controlePedido.model;

import java.math.BigDecimal;

public class ItemPedido extends Base {
	private static int codigoItem = 1;
	private BigDecimal valor = BigDecimal.ZERO;
	private int quantidade;
	private String nome;
	
	public ItemPedido(String nome, BigDecimal valor, int quantidade) {
		super(ItemPedido.codigoItem++);
		this.valor = valor;
		this.quantidade = quantidade;
		this.nome = nome;
	}
	
	@Override
	public int getCodigo() {
		return super.getCodigo();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}