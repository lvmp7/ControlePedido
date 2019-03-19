package br.com.vv.controlePedido.interfaces;

import br.com.vv.controlePedido.model.Pedido;

/**
 * interface responsável por definir os metodos de um datasource
 * @author Luiz Vinícius
 *
 */
public interface PedidoDataSource {
	/**
	 * lista de pedidos
	 */
	public abstract void listar();
	
	/**
	 * inclui um pedido
	 * @param pedido
	 */
	public abstract void incluir(Pedido pedido);
	/**
	 * Altera um Pedido
	 * @param pedido
	 * Pedido para ser alterado
	 */
	public abstract void alterar(Pedido pedido);
	/**
	 * Exclui um pedido
	 * @param codigo
	 * pedido que será excluido
	 */
	public abstract void excluir(int codigo);
	/**
	 * Retorna um pedido 
	 * @param codigo
	 * codigo do pedido pesquisado
	 * @return
	 * Retorna o Pedido que continha o codigo pesquisado
	 */
	public abstract Pedido find(int codigo);
}
