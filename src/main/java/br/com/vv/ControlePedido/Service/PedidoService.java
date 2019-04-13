package br.com.vv.ControlePedido.Service;

import br.com.vv.ControlePedido.DataSource.DataSource;

public class PedidoService {

    private DataSource dataSource;

    public PedidoService(DataSource dataSource){
        this.dataSource = dataSource;
    }
    /**
     * Lista de pedidos e seus itens
     */
    public void listar() {
        dataSource.listar();
    }

    /**
     * Inclui pedido
     */
    public void incluir() {
        dataSource.incluir();
    }

    /**
     * Edita um Pedido
     */
    public void editar() {
        dataSource.editar();
    }

    /**
     * Exclui um pedido
     */
    public void excluir() {
        dataSource.excluir();
    }

}
