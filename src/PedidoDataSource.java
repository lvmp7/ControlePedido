import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.ItemPedido;
import model.Pedido;

//base de dados em memoria
public class PedidoDataSource {
	private List<Pedido> pedidos = new ArrayList<Pedido>();
	
	public void lista() {
		StringBuilder str = new StringBuilder();
		
		if(pedidos.isEmpty())
			System.out.println("Não há pedidos a serem listados");
		else {
			for (Pedido pedido : pedidos) {
				str.append("Itens:");
				str.append("\t\n");
				str.append("Codigo: " + pedido.getCodigo() +"\n");
				str.append("Cliente: " +pedido.getNomeCliente() +"\n");
				str.append("Filial" +pedido.getNomeFilial()+"\n");
				str.append("Itens:" +pedido.getItens());
				
				str.append("Total: " +pedido.getValor()+"\n");
				
				
				
			}
						
		}
	}
	
	public void inclui() {
		criaPedido();
	}
	
	public void altera() {
		
	}
	
	public void exclui() {
		
	}
	
	private Pedido criaPedido() {
		Scanner s = new Scanner(System.in);
		
		System.out.print("Digite o nome do cliente: ");
		String cliente = s.next();
		System.out.print("Digite o nome da loja: ");
		String loja = s.next();
		
		Pedido p = new Pedido(cliente, loja);
		
		int opc = 0;
		do {
			System.out.print("Informar dados do item: ");
			p.adiciona(criaItem());
			
			try {
				
				System.out.println("1. SIM");
				opc = s.nextInt();
			} catch (Exception e) {
				
			}finally {
				s.close();
			}
			System.out.print("Deseja adicionar mais um item? ");
		}while(opc==1);
		
		return p;
	}
	
	private ItemPedido criaItem(){
		Scanner s = new Scanner(System.in);
		ItemPedido item;
		try {
			System.out.print("Digite o nome do item: ");
			String nomeItem = s.next();
			System.out.print("Digite o valor: ");
			double valorItem = s.nextDouble();
			System.out.print("Digite a quantidade: ");
			int quantItem = s.nextInt();
			
			item = new ItemPedido(nomeItem, valorItem, quantItem);
		} finally {
			s.close();
		}

		return item;
	}
	
}
