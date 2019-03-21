package br.com.vv.controlePedido;

import java.util.ArrayList;
import java.util.List;

import br.com.vv.controlePedido.interfaces.PedidoDataSource;
import br.com.vv.controlePedido.model.MontarConsole;
import br.com.vv.controlePedido.model.Pedido;

//base de dados em memoria
public class PedidoMemoryDataSource implements PedidoDataSource {
	private List<Pedido> pedidos = new ArrayList<Pedido>();
	
	/**
	 * lista de pedidos
	 */
	public void listar() {
		if (pedidos.isEmpty())
			System.out.println("Não pedidos a serem listados");
		else {
			for (Pedido pedido : pedidos) {
				MontarConsole.showLista(pedido);
			}
		}
	}
	/**
	 * inclui um pedido
	 * @param pedido
	 */
	public void incluir(Pedido pedido) {
		pedidos.add(pedido);
		System.out.println("Pedido criado com sucesso ");
	}
	/**
	 * Altera um Pedido
	 * @param pedido
	 * Pedido para ser alterado
	 */
	public void alterar(Pedido pedido) {
		for (int i = 0; i < pedidos.size(); i++) {
			if (pedidos.get(i).getCodigo() == pedido.getCodigo()){
				pedidos.add(i, pedido);
			}
		}
	}
	/**
	 * Exclui um pedido
	 * @param codigo
	 * pedido que será excluido
	 */
	public void excluir(int codigo) {
		for (int i = 0; i < pedidos.size(); i++) {
			if(codigo == pedidos.get(i).getCodigo()) {
				pedidos.remove(i);
				break;
			}
		}
	}
	/**
	 * Retorna um pedido 
	 * @param codigo
	 * codigo do pedido pesquisado
	 * @return
	 * Retorna o Pedido que continha o codigo pesquisado
	 */
	public Pedido find(int codigo) {
		for (Pedido pedido : pedidos) {
			if (pedido.getCodigo() == codigo) 
				return pedido; 
		}
		return null;
	}	
}