package br.com.vv.controlePedido.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Pedido extends Base {
	private static int contadorPedido = 1;
	private String nomeCliente;
	private String nomeFilial;
	private List<ItemPedido> itens = new ArrayList<ItemPedido>();
	
	public Pedido(String nomeCliente, String nomeFilial) {
		super(Pedido.contadorPedido++);
		this.nomeCliente = nomeCliente;
		this.nomeFilial = nomeFilial;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	public String getNomeFilial() {
		return nomeFilial;
	}
	
	public void setNomeFilial(String nomeFilial) {
		this.nomeFilial = nomeFilial;
	}
	
	public BigDecimal getValor() {
		BigDecimal aux = BigDecimal.ZERO;
		
		for (ItemPedido item : itens) {
			aux = aux.add(
					item.getValor().multiply(new BigDecimal(item.getQuantidade()))
			);
		}
		return aux;
	}
	
	public List<ItemPedido> getItens() {
		return itens;
	}
	
	public void adiciona(ItemPedido item) {
		itens.add(item);
	}
	
	public ItemPedido getItem(int codigo) {
		for (ItemPedido itemPedido : itens) {
			if(itemPedido.getCodigo() == codigo) {
				return itemPedido;
			}
		}
		return null;
	}
	
	public void remove(ItemPedido item) {
		itens.remove(item);
	}
}