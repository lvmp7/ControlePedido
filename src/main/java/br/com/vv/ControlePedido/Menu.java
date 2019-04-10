package br.com.vv.ControlePedido;

import br.com.vv.ControlePedido.DataSource.DataSource;
import br.com.vv.ControlePedido.Repository.FileRepository;
import br.com.vv.ControlePedido.Repository.MemoryRepository;
import br.com.vv.ControlePedido.Service.PedidoService;

import java.util.Scanner;

public class Menu {

    PedidoService pedidoService;

    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        PedidoService ds = new PedidoService(configurarDataSource());
        int opcao = -1;
        do {
            System.out.println("\n\n");
            System.out.println(montarMenu());
            System.out.print("Escolha a opÃ§Ã£o desejada: ");
            opcao = Integer.valueOf(scanner.next());
            chamaMetodoPorOpcao(opcao, ds);
        } while (opcao != 5);
    }

    private static void chamaMetodoPorOpcao(int opcao, PedidoService pedidoService) {
        switch (opcao) {
            case 1:
                pedidoService.listar();
                break;
            case 2:
                pedidoService.incluir();
                break;
            case 3:
                pedidoService.editar();
                break;
            case 4:
                pedidoService.excluir();
                break;
            case 5:
                System.out.println("Fechando programa...");
                break;
            default:
                System.out.println("OpÃ§Ã£o invÃ¡lida");
        }
    }

    private static String montarMenu() {
        StringBuilder str = new StringBuilder();
        str.append("####### PEDIDOS #########");
        str.append("\n");
        str.append("1. Listar");
        str.append("\n");
        str.append("2. Adicionar");
        str.append("\n");
        str.append("3. Editar");
        str.append("\n");
        str.append("4. Excluir");
        str.append("\n");
        str.append("\n");
        str.append("5. Sair");

        return str.toString();
    }

    private static DataSource configurarDataSource() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Usar Base em Memoria (M) ou Arquivo (A) ?");
        String opcaoDS = scanner.next();
        DataSource ds = null;
        if ("A".equalsIgnoreCase(opcaoDS)) {
            System.out.println("Usando Base em Arquivo");
            return new FileRepository();
        } else if ("M".equalsIgnoreCase(opcaoDS)) {
            System.out.println("Usando Base em Memoria");
            return new MemoryRepository();
        }else {
            System.err.println("Opcao invalida , digite M ou A");
            return null;
        }
    }
}
