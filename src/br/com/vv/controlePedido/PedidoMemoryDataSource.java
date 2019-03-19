package br.com.vv.controlePedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.vv.controlePedido.model.ItemPedido;
import br.com.vv.controlePedido.model.MontarConsole;
import br.com.vv.controlePedido.model.Pedido;

//base de dados em memoria
public class PedidoDataSource {
	private List<Pedido> pedidos = new ArrayList<Pedido>();

	public void listar() {
		if (pedidos.isEmpty())
			System.out.println("Não há pedidos a serem listados");
		else {
			for (Pedido pedido : pedidos) {
				MontarConsole.showLista(pedido);
			}
		}
	}

	public void incluir() {
		pedidos.add(criaPedido());
		System.out.println("Pedido criado com sucesso ");
	}

	public void alterar(int codigo) {
		Pedido p = find(codigo);
		Scanner s = new Scanner(System.in);
		if(p == null) {
			System.out.println("Pedido não encontrado");
		}else {
			MontarConsole.showAlteraPedido();
			alteraDadosPedido(s.nextInt(), p);
			
			p.setDataHoraEdicao(LocalDateTime.now());
		}
	}

	public void excluir(int codigo) {
		for (int i = 0; i < pedidos.size(); i++) {
			if(codigo == pedidos.get(i).getCodigo()) {
				pedidos.remove(i);
				break;
			}
		}
	}

	private Pedido criaPedido() {
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

	private ItemPedido criaItem() {
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
	
	private Pedido find(int codigo) {
		for (Pedido pedido : pedidos) {
			if (pedido.getCodigo() == codigo) 
				return pedido; 
		}
		return null;
	}
	
	private ItemPedido find(Pedido pedido, int codigoItem) {
		for (ItemPedido item : pedido.getItens()) {
			if (item.getCodigo() == codigoItem) 
				return item; 
		}
		return null;
	}
	
	private void alteraDadosPedido(int opcao, Pedido pedido) {
		Scanner s = new Scanner(System.in);
		switch (opcao) {
		case 1:
			System.out.println("Digite o nome do cliente");
			pedido.setNomeCliente(s.nextLine());
			break;
			
		case 2:
			System.out.println("Digite o nome da Filial");
			pedido.setNomeFilial(s.nextLine());
			break;
		case 3:
			alteraDadosItem(pedido);
			break;
			
		case 4:
			pedido.adiciona(criaItem());		
			break;
		
		case 5:
			System.out.println("Digite o codigo do item");
			int codigo = s.nextInt();
			removeItem(codigo, pedido);		
			break;
			
		default:
			System.out.println("Opção Inválida");
			break;
		}
	}
	
	private void alteraDadosItem(Pedido pedido) {
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o codigo do item");
		
		ItemPedido item = find(pedido, s.nextInt());
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
			System.out.println("Opção Inválida");
			break;
		}
	}

	private void removeItem(int codigo, Pedido pedido) {
		List<ItemPedido> itens = pedido.getItens();
		for (int i = 0; i < itens.size(); i++) {
			if(codigo == itens.get(i).getCodigo()) {
				itens.remove(i);
				break;
			}
		}
		
	}
	

}