package br.com.vv.controlePedido;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

import br.com.vv.controlePedido.model.Pedido;
import br.vv.com.controlePedido.interfaces.DataSource;

public class PedidoFileDataSource implements DataSource {

	private List<File> files;

	public void listar(){
		// TODO Auto-generated method stub
		files = (List<File>) FileUtils.listFiles(new File("pedidos"), TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}
	}

	public void incluir(Pedido pedido) {
		// TODO Auto-generated method stub
		
	}

	public void alterar(int codigo, Pedido pedido) {
		// TODO Auto-generated method stub

	}

	public void excluir(int codigo) {
		// TODO Auto-generated method stub

	}
}
