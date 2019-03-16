package model;

import java.util.ArrayList;
import java.util.List;

public class Pedido extends Base {
	private static int contadorPedido = 1;
	private String nomeCliente;
	private String nomeFilial;
	private List<ItemPedido> itens = new ArrayList<ItemPedido>();

	
	public Pedido(String nomeCliente, String nomeFilial) {
		super(Pedido.contadorPedido);
		this.nomeCliente = nomeCliente;
		this.nomeFilial = nomeFilial;
		Pedido.contadorPedido++;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	
	public String getNomeFilial() {
		return nomeFilial;
	}
	
	public double getValor() {
		double aux = 0;
		/*for (ItemPedido itemPedido : itens) {
			aux +=itemPedido.getValor();
		}
		*/
		aux = itens.stream().mapToDouble(item->item.getValor()).sum();
		System.out.println(aux);
		return aux;
	}
	
	public List<ItemPedido> getItens() {
		return itens;
	}
	
	public void adiciona(ItemPedido item) {
		itens.add(item);
	}
	
	public void remove(ItemPedido item) {
		itens.remove(item);
	}
	
}
