package br.com.vv.controlePedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import br.com.vv.controlePedido.dataSource.PedidoDataSource;
import br.com.vv.controlePedido.dataSource.PedidoFileDataSourceImpl;
import br.com.vv.controlePedido.dataSource.PedidoMemoryDataSourceImpl;
import br.com.vv.controlePedido.model.ItemPedido;
import br.com.vv.controlePedido.model.Pedido;

public class Menu {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		PedidoDataSource dataSource;
		
		System.out.println("Digite \"m\" para salvar em Memoria ");
		System.out.println("ou pressione \"a\" para continuar salvando em Arquivo ");
		
		if (s.next().toLowerCase().equals("m") ) { 
			System.out.println("Salvando em Memoria");
			System.out.println("");
			dataSource = new PedidoDataSource( new PedidoMemoryDataSourceImpl() );
		}
		else {
			System.out.println("Salvando em arquivo");
			System.out.println("");
			dataSource = new PedidoDataSource( new PedidoFileDataSourceImpl() );
		}
		s.reset();
		
		int opc = -1;		

		do {
			MontarConsole.showMenu();
			System.out.print("Digite um número do menu: ");
			
			try{
				opc = s.nextInt();
				validaOpcao(opc, dataSource);
			}catch (InputMismatchException e) {
				System.out.print("Favor entrar com um NUMERO valido");
				System.out.println();
			}
		}while(opc != 0);
		s.close();
	}
	
	private static void validaOpcao(int key, PedidoDataSource dataSource) {
		Scanner s = new Scanner(System.in);
		
		switch (key) {
		case 1:
			dataSource.listar();
			break;
		case 2:
			
			dataSource.incluir(criaPedido());
			break;
		case 3:
			System.out.println("Digite o codigo do pedido que deseja alterar: ");			
			int codigo = s.nextInt();
			Pedido p = dataSource.find(codigo);
			
			if(p == null) {
				System.out.println("Pedido não encontrado");
			}else {
				MontarConsole.showAlteraPedido();			
				p.setDataHoraEdicao(LocalDateTime.now());
				dataSource.alterar(alteraDadosPedido(s.nextInt(), p));
			}
			break;
		case 4:
			System.out.println("Digite o codigo do pedido que deseja excluir: ");
			dataSource.excluir(s.nextInt());
			break;
		case 0:
			System.out.println("saindo do sistema");
			System.out.println("logout");
			break;

		default:
			System.out.println("Opçãoo inválida!");
			System.out.println("Favor inserir um numero válido");
			System.out.println();
			break;
		}
	}
	
	private static Pedido criaPedido() {
		Scanner s = new Scanner(System.in);
		System.out.println();
		System.out.print("Digite o nome do cliente: ");
		String cliente = s.nextLine();
		System.out.print("Digite o nome da loja: ");
		String loja = s.nextLine();

		Pedido p = new Pedido(cliente, loja);

		int opc = 0;
		do {
			try {
				System.out.println("Informar dados do item: ");
				p.adiciona(criaItem());
			} catch (Exception e) {

			}
			System.out.println("Deseja adicionar mais um item?");
			System.out.println("1. SIM ou 0. NÃO");
			
			opc = s.nextInt();
		} while (opc == 1);		
		return p;
	}
	
	private static ItemPedido criaItem() {
		Scanner s = new Scanner(System.in);
		ItemPedido item = null;
		try {
			System.out.print("Digite o nome do item: ");
			String nomeItem = s.nextLine();
			System.out.print("Digite o valor: ");
			BigDecimal valorItem = BigDecimal.valueOf( s.nextDouble() );
			System.out.print("Digite a quantidade: ");
			int quantItem = s.nextInt();
			
			item = new ItemPedido(nomeItem, valorItem, quantItem);
		}catch(Exception e){
			e.printStackTrace();
		}		
		return item;
	}
	
	private static Pedido alteraDadosPedido(int opcao, Pedido pedido) {
		Scanner s = new Scanner(System.in);
		switch (opcao) {
		case 1:
			System.out.println("Digite o nome do cliente");
			pedido.setNomeCliente(s.nextLine());
			return pedido;
			
		case 2:
			System.out.println("Digite o nome da Filial");
			pedido.setNomeFilial(s.nextLine());
			return pedido;
		case 3:
			alteraDadosItem(pedido);
			return pedido;
			
		case 4:
			pedido.adiciona(criaItem());		
			return pedido;
		
		case 5:
			System.out.println("Digite o codigo do item");
			int codigo = s.nextInt();
			removeItem(codigo, pedido);		
			return pedido;
			
		default:
			System.out.println("Opçãoo Inválida");
			return pedido;
		}
	}
	
	private static void alteraDadosItem(Pedido pedido) {
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o codigo do item");
		
		ItemPedido item = pedido.getItem(s.nextInt());
		if(item != null) {
			System.out.println("");
			
			MontarConsole.showAlteraItem();
			
			switch (s.nextInt()) {
			case 1:
				System.out.println("Digite o nome do Item");
				item.setNome(s.nextLine());
				break;
				
			case 2:
				System.out.println("Digite o valor");
				item.setValor(BigDecimal.valueOf(s.nextDouble()) );
				break;
			case 3:
				System.out.println("Digite a quantidade");
				item.setQuantidade(s.nextInt());		
				break;
				
			default:
				System.out.println("Opçãoo Inválida");
				break;
			}

		}else {
			System.out.println("Item não encontrado");
		}
	}

	private static void removeItem(int codigo, Pedido pedido) {
		List<ItemPedido> itens = pedido.getItens();
		for (int i = 0; i < itens.size(); i++) {
			if(codigo == itens.get(i).getCodigo()) {
				itens.remove(i);
				break;
			}
		}
	}
}