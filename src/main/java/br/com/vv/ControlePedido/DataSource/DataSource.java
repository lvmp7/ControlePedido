package br.com.vv.ControlePedido.DataSource;

public interface DataSource {
    /**
     * Retorna a lista de pedidos e seus itens
     */
    void listar();
    /**
     * Inclui pedido
     */
    void incluir();
    /**
     * Edita um Pedido
     */
    void editar();
    /**
     * Exclui um pedido
     */
    void excluir();
}
