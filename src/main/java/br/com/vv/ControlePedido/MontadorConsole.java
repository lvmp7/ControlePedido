package br.com.vv.ControlePedido;

import br.com.vv.ControlePedido.modelo.ItemPedido;
import br.com.vv.ControlePedido.modelo.Pedido;

public class MontadorConsole {
    /**
     * Imprime o pedido na tela do usuario
     * @param pedido
     */

    public static void montaMensagem(Pedido pedido) {
        StringBuilder str = new StringBuilder();
        str.append("----------------------------------");
        str.append("\n");
        str.append("Pedido " + pedido.getCodigo() + "\n");
        str.append("Data/Hora InclusÃ£o: " + pedido.getDataHoraInclusao() + "\n");
        str.append("Data/Hora EdiÃ§Ã£o: " + pedido.getDataHoraEdicao() + "\n");
        str.append("Cliente: " + pedido.getNomeCliente() + "\n");
        str.append("Filial: " + pedido.getNomeFilial() + "\n");
        str.append("Valor: " + pedido.getValor() + "\n");
        str.append(montarItens(pedido) + "\n");
        str.append("\n");
        str.append("----------------------------------");
        str.append("\n");

        System.out.println(str.toString());
    }

    private static String montarItens(Pedido pedido) {
        StringBuilder str = new StringBuilder();
        for (ItemPedido it : pedido.getItens()) {
            str.append("\t" + it.toString() + "\n");
        }

        return str.toString();
    }
}
