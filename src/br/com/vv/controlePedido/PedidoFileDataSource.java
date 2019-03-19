package br.com.vv.controlePedido;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

import br.com.vv.controlePedido.interfaces.PedidoDataSource;
import br.com.vv.controlePedido.model.Pedido;

public class PedidoFileDataSource implements PedidoDataSource {

	private List<File> files;
	
	/**
	 * lista de pedidos
	 */
	public void listar(){
		// TODO Auto-generated method stub
		files = (List<File>) FileUtils.listFiles(new File("pedidos"), TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}
	}
	/**
	 * inclui um pedido
	 * @param pedido
	 */
	public void incluir(Pedido pedido) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Altera um Pedido
	 * @param pedido
	 * Pedido para ser alterado
	 */
	public void alterar(Pedido pedido) {
		// TODO Auto-generated method stub

	}
	/**
	 * Exclui um pedido
	 * @param codigo
	 * pedido que será excluido
	 */
	public void excluir(int codigo) {
		// TODO Auto-generated method stub

	}
	/**
	 * Retorna um pedido 
	 * @param codigo
	 * codigo do pedido pesquisado
	 * @return
	 * Retorna o Pedido que continha o codigo pesquisado
	 */
	public Pedido find(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}
}
