package br.com.vv.controlePedido.interfaces;

import br.com.vv.controlePedido.model.Pedido;

/**
 * interface responsável por definir os metodos de um datasource
 * @author Luiz Vinícius
 *
 */
public interface DataSource {
	/**
	 * lista de pedidos
	 */
	void listar();
	
	/**
	 * inclui um pedido
	 * @param pedido
	 */
	void incluir(Pedido pedido);
	/**
	 * Altera um Pedido
	 * @param pedido
	 * Pedido para ser alterado
	 */
	void alterar(Pedido pedido);
	/**
	 * Exclui um pedido
	 * @param codigo
	 * pedido que será excluido
	 */
	void excluir(int codigo);
	/**
	 * Retorna um pedido 
	 * @param codigo
	 * codigo do pedido pesquisado
	 * @return
	 * Retorna o Pedido que continha o codigo pesquisado
	 */
	Pedido find(int codigo);
}
