package br.com.vv.controlePedido;

import java.util.ArrayList;
import java.util.List;

import br.com.vv.controlePedido.model.MontarConsole;
import br.com.vv.controlePedido.model.Pedido;
import br.vv.com.controlePedido.interfaces.DataSource;

//base de dados em memoria
public class PedidoMemoryDataSource implements DataSource {
	private List<Pedido> pedidos = new ArrayList<Pedido>();

	public void listar() {
		if (pedidos.isEmpty())
			System.out.println("Não pedidos a serem listados");
		else {
			for (Pedido pedido : pedidos) {
				MontarConsole.showLista(pedido);
			}
		}
	}

	public void incluir(Pedido pedido) {
		pedidos.add(pedido);
		System.out.println("Pedido criado com sucesso ");
	}

	public void alterar(int codigo, Pedido pedido) {
		for (int i = 0; i < pedidos.size(); i++) {
			if (pedidos.get(i).getCodigo() == codigo){
				pedidos.add(i, pedido);
			}
		}
	}

	public void excluir(int codigo) {
		for (int i = 0; i < pedidos.size(); i++) {
			if(codigo == pedidos.get(i).getCodigo()) {
				pedidos.remove(i);
				break;
			}
		}
	}

	public Pedido find(int codigo) {
		for (Pedido pedido : pedidos) {
			if (pedido.getCodigo() == codigo) 
				return pedido; 
		}
		return null;
	}	
}