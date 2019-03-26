package br.com.vv.controlePedido.dataSource;

import br.com.vv.controlePedido.interfaces.DataSource;
import br.com.vv.controlePedido.model.Pedido;

public class PedidoDataSource {
	DataSource dataSource;
	/**
	 * Para instanciar a classe, necessário injetar um DataSource para que as opeções sejam possíveis
	 * @param dataSource
	 * Data Source responsavel pelas tarefas com a base de dados
	 */
	public PedidoDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	/**
	 * lista os pedidos que constam na base
	 */
	public void listar() {
		dataSource.listar();
	}
	/**
	 * inclui o pedido na base
	 * @param pedido
	 * Pedido encaminhado para inserir na base
	 */
	public void incluir(Pedido pedido) {
		dataSource.incluir(pedido);
	}
	
	/**
	 * Faz a pesquisa de um pedido a base, a partir do seu codigo
	 * @param codigo
	 * codigo encaminhado para busca
	 * @return
	 * retorno o pedido pesquisado
	 */
	public Pedido find(int codigo) {
		return dataSource.find(codigo);
	}
	/**
	 * Altera o pedido na base de dados
	 * @param pedido
	 * pedido alterado para inserir na base
	 */
	public void alterar(Pedido pedido) {
		dataSource.alterar(pedido);
	}
	/**
	 * Exclui o pedido com o codigo informado
	 * @param codigo
	 * codigo do pedido que será excluido
	 */
	public void excluir(int codigo) {
		dataSource.excluir(codigo);
	}
	
}
