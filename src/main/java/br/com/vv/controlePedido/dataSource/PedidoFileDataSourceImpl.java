package br.com.vv.controlePedido.dataSource;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import br.com.vv.controlePedido.MontarConsole;
import br.com.vv.controlePedido.interfaces.DataSource;
import br.com.vv.controlePedido.model.Pedido;

public class PedidoFileDataSourceImpl implements DataSource {
	private List<Pedido> pedidos;
	/**
	 * lista pedidos
	 */
	public void listar(){
		pedidos = carregaLista();
		if(!pedidos.isEmpty())
			for (Pedido pedido : pedidos) {
				MontarConsole.showLista(pedido);;
			}
	}
	/**
	 * inclui um pedido
	 * @param pedido
	 */
	public void incluir(Pedido pedido) {
		pedidos.add(pedido);
		save();
	}
	
	/**
	 * Altera um Pedido
	 * @param pedido
	 * Pedido para ser alterado
	 */
	public void alterar(Pedido pedido) {
		for (int i = 0; i < pedidos.size(); i++) {
			if (pedidos.get(i).equals(pedido)) {
				pedidos.add(i,pedido);
				break;
			}
		}
		save();
	}
	/**
	 * Exclui um pedido
	 * @param codigo
	 * pedido que será excluido
	 */
	public void excluir(int codigo) {
		for (int i = 0; i < pedidos.size(); i++) {
			if(pedidos.get(i).getCodigo() == codigo) {
				pedidos.remove(i);
			}
		}
		save();
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
			if (pedido.getCodigo() == codigo) {
				return pedido;
			}
		}
		return null;
	}
	
	private List<Pedido> carregaLista(){
		FileUtils.getFile("pedidos");
		
		try {
			ObjectInputStream o = new ObjectInputStream(FileUtils.openInputStream(new File("pedidos")));
			return (List<Pedido>) o.readObject();
		} catch (IOException e) {
			System.out.println("Arquivo pedidos não foi encontrado");
			return new ArrayList<Pedido>();
			//e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private void save() {
		try {
			File arquivo = new File("pedidos");			
			ObjectOutputStream o = new ObjectOutputStream(FileUtils.openOutputStream(arquivo));
			o.writeObject(pedidos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
