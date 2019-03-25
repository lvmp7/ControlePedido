package br.com.vv.controlePedido.dataSource;

import br.com.vv.controlePedido.interfaces.DataSource;
import br.com.vv.controlePedido.model.Pedido;

public class PedidoDataSource implements DataSource{
	private DataSource datasource;
	
	/**
	 * Necessario passar um DataSource para instanciar a classe
	 * @param datasorce
	 */
	public PedidoDataSource(DataSource datasorce) {
		this.datasource = datasorce;
		listar();
	}

	public void listar() {
		datasource.listar();
		
	}

	public void incluir(Pedido pedido) {
		datasource.incluir(pedido);
	}

	public void alterar(Pedido pedido) {
		datasource.alterar(pedido);
	}

	public void excluir(int codigo) {
		datasource.excluir(codigo);		
	}

	public Pedido find(int codigo) {
		return datasource.find(codigo);
	}
}