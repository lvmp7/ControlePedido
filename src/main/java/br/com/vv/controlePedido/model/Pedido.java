package br.com.vv.controlePedido.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Pedido extends Base {
	private static int contadorPedido = 1;
	private String nomeCliente;
	private String nomeFilial;
	private List<ItemPedido> itens = new ArrayList<ItemPedido>();
	
	/**
	 * Necessário o Nome do Cliente e Filial para instanciar um Pedido
	 *  
	 * @param nomeCliente
	 * @param nomeFilial
	 */
	public Pedido(String nomeCliente, String nomeFilial) {
		super(Pedido.contadorPedido++);
		this.nomeCliente = nomeCliente;
		this.nomeFilial = nomeFilial;
	}
	
	/**
	 * Retorna o nome do cliente
	 * @return
	 */
	public String getNomeCliente() {
		return nomeCliente;
	}
	/**
	 * atribui um nome ao cliente
	 * @param nomeCliente
	 * String que atribui o nome ao cliente 
	 */
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	/**
	 * Retorna a Filial
	 * @return
	 */
	public String getNomeFilial() {
		return nomeFilial;
	}
	/**
	 * Atribui um nome a filial
	 * @param nomeFilial
	 */
	public void setNomeFilial(String nomeFilial) {
		this.nomeFilial = nomeFilial;
	}
	/**
	 * Retorna o Valor do pedido
	 * @return
	 */
	public BigDecimal getValor() {
		BigDecimal aux = BigDecimal.ZERO;
		
		for (ItemPedido item : itens) {
			aux = aux.add(
					item.getValor().multiply(new BigDecimal(item.getQuantidade()))
			);
		}
		return aux;
	}
	/**
	 * retona a lista de itens do pedido
	 * @return
	 */
	public List<ItemPedido> getItens() {
		return itens;
	}
	/**
	 * Adiciona um item a lista do pedido
	 * @param item
	 */
	public void adiciona(ItemPedido item) {
		itens.add(item);
	}
	/**
	 * retorna o item que contém o codigo informado
	 * @param codigo
	 * @return
	 */
	public ItemPedido getItem(int codigo) {
		for (ItemPedido itemPedido : itens) {
			if(itemPedido.getCodigo() == codigo) {
				return itemPedido;
			}
		}
		return null;
	}
	
	/**
	 * remove o item do pedido
	 * @param item
	 */
	public void remove(ItemPedido item) {
		itens.remove(item);
	}
}