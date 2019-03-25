package br.com.vv.controlePedido;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

import br.com.vv.controlePedido.interfaces.PedidoDataSource;
import br.com.vv.controlePedido.model.MontarConsole;
import br.com.vv.controlePedido.model.Pedido;

public class PedidoFileDataSource implements PedidoDataSource {
	private List<Pedido> pedidos;
	private List<File> files;
	
	public PedidoFileDataSource() {
		// TODO Auto-generated constructor stub
		files = (List<File>) FileUtils.listFiles(new File("pedidos"), TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
		for (File file : files) {
			convert(file);
			System.out.println(file.getAbsolutePath());
		}
	}
	
	/**
	 * lista de pedidos
	 */
	public void listar(){		
		for (Pedido pedido : pedidos) {
			MontarConsole.showLista(pedido);
		}
	}
	/**
	 * inclui um pedido
	 * @param pedido
	 */
	public void incluir(Pedido pedido) {
		// TODO Auto-generated method stub
		
		try {
			ObjectOutputStream o = new ObjectOutputStream(FileUtils.openOutputStream(new File("pedidos\\"+pedido.getCodigo())));
			o.writeObject(pedido);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	private Pedido convert(File file) {
		Pedido p;
		try {
			ObjectInputStream o = new ObjectInputStream(FileUtils.openInputStream(file));
			p = (Pedido) o.readObject();
			return p;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
