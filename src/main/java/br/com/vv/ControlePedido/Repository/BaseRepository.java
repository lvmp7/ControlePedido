package br.com.vv.ControlePedido.Repository;

import br.com.vv.ControlePedido.DataSource.DataSource;
import br.com.vv.ControlePedido.MontadorConsole;
import br.com.vv.ControlePedido.modelo.ItemPedido;
import br.com.vv.ControlePedido.modelo.Pedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseRepository implements DataSource {
    protected List<Pedido> pedidos = new ArrayList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public void listar() {
        if (pedidos.isEmpty()) {
            System.out.println("NÃ£o hÃ¡ pedidos para serem listados");
        } else {
            for (Pedido pedido : pedidos) {
                MontadorConsole.montaMensagem(pedido);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void incluir() {
        Pedido pedido = new Pedido();
        pedido.setDataHoraInclusao(LocalDateTime.now());
        Scanner scanner = new Scanner(System.in);
        System.out.println("##### INCLUINDO PEDIDO ######");
        System.out.println("Digite o CÃ³digo: ");
        pedido.setCodigo(scanner.nextLine());
        System.out.println("Digite o nome do cliente: ");
        pedido.setNomeCliente(scanner.nextLine());
        System.out.println("Digite o nome da Filial: ");
        pedido.setNomeFilial(scanner.nextLine());

        System.out.println(
                "Digite os itens separando por ',' (virgula) os campos (codigo,valor,quantidade,nome) e ';' os itens. "
                        + "\n Exemplo: 1111,100,1,FERRO DE PASSAR;2222,300,3,CELULAR");
        System.out.println(":");
        String itens = scanner.nextLine();
        String itensSplit[] = itens.split(";");
        for (String item : itensSplit) {
            String itemColunas[] = item.split(",");
            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setCodigo(itemColunas[0]);
            itemPedido.setValor(BigDecimal.valueOf(Double.valueOf(itemColunas[1])));
            itemPedido.setQuantidade(Integer.valueOf(itemColunas[2]));
            itemPedido.setNome(itemColunas[3]);
            pedido.getItens().add(itemPedido);
        }

        pedidos.add(pedido);
        System.out.println("Pedido " + pedido.getCodigo() + " incluido com sucesso");

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void editar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o cÃ³digo do pedido a ser editado: ");
        String codigo = scanner.nextLine();
        Pedido pedidoParaEditar = new Pedido();
        pedidoParaEditar.setCodigo(codigo);
        int index = pedidos.indexOf(pedidoParaEditar);
        if (index == -1) {
            System.out.println("Pedido nÃ£o encontrado");
        } else {
            pedidoParaEditar = pedidos.get(index);
            pedidoParaEditar.setDataHoraEdicao(LocalDateTime.now());
            System.out.println("##### EDITANDO PEDIDO ######");
            System.out.println("Digite o nome do cliente (Deixe vazio para nÃ£o alterar): ");
            String nomeCliente = scanner.nextLine();
            if (!nomeCliente.isEmpty()) {
                pedidoParaEditar.setNomeCliente(nomeCliente);
            }

            System.out.println("Digite o nome da filial (Deixe vazio para nÃ£o alterar): ");
            String nomeFilial = scanner.nextLine();
            if (!nomeFilial.isEmpty()) {
                pedidoParaEditar.setNomeFilial(nomeFilial);
            }

            System.out.println(
                    "Digite os itens separando por ',' (virgula) os campos (codigo,valor,quantidade,nome) e ';' os itens. "
                            + "\n Exemplo: 1111,100,1,FERRO DE PASSAR;2222,300,3,CELULAR");
            System.out.println(":");
            String itens = scanner.nextLine();
            if (!itens.isEmpty()) {
                String itensSplit[] = itens.split(";");
                for (String item : itensSplit) {
                    String itemColunas[] = item.split(",");
                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setCodigo(itemColunas[0]);
                    itemPedido.setValor(BigDecimal.valueOf(Double.valueOf(itemColunas[1])));
                    itemPedido.setQuantidade(Integer.valueOf(itemColunas[2]));
                    itemPedido.setNome(itemColunas[3]);
                    pedidoParaEditar.getItens().add(itemPedido);
                }
            }
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void excluir() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o cÃ³digo do pedido a ser removido: ");
        String codigo = scanner.nextLine();
        Pedido pedidoParaRemover = new Pedido();
        pedidoParaRemover.setCodigo(codigo);
        int index = pedidos.indexOf(pedidoParaRemover);
        if (index == -1) {
            System.out.println("Pedido nÃ£o encontrado");
        } else {
            pedidos.remove(index);
            System.out.println("Pedido removido com sucesso");
        }
    }

    private String montarItens(Pedido pedido) {
        StringBuilder str = new StringBuilder();
        for (ItemPedido it : pedido.getItens()) {
            str.append("\t" + it.toString() + "\n");
        }

        return str.toString();
    }
}