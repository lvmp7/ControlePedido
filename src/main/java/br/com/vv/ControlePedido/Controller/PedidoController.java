package br.com.vv.ControlePedido.Controller;

import br.com.vv.ControlePedido.Service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PedidoController {
    @Autowired
    PedidoService pedidoService;

    public void listar(){
        pedidoService.listar();
    }

    public void inserir(){
        pedidoService.incluir();
    }

    public void editar(){
        pedidoService.editar();
    }

    public void excluir(){
        pedidoService.excluir();
    }
}
