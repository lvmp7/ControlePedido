package br.com.vv.controlePedido.model;

public class MontarConsole {

	public static void showMenu() {
		System.out.println();
		System.out.println("##### MENU PEDIDOS #####");
		System.out.println("1. LISTAR PEDIDOS");
		System.out.println("2. INCLUIR PEDIDO");
		System.out.println("3. ALTERAR PEDIDO");
		System.out.println("4. EXCLUIR PEDIDO");
		System.out.println("0. SAIR DO SISTEMA");
		System.out.println();

		System.out.flush();
	}

	public static void showLista(Pedido pedido) {
		StringBuilder str = new StringBuilder();
		str.append("\n");
		str.append("Pedido: \n");
		str.append("Codigo: " + pedido.getCodigo() + "\n");
		str.append("Cliente: " + pedido.getNomeCliente() + "\n");
		str.append("Filial: " + pedido.getNomeFilial() + "\n");
		str.append("Itens: \n");

		for (ItemPedido item : pedido.getItens()) {
			str.append("\t");
			str.append("Codigo: "+item.getCodigo()+ ", Nome: " + item.getNome() + ", Valor: R$" + item.getValor() + ", Quantidade: "
					+ item.getQuantidade());
			str.append("\n");
		}
		str.append("Total: R$" + pedido.getValor() + "\n");
		System.out.println(str.toString());
	}
	
	public static void showAlteraPedido() {
		StringBuilder str = new StringBuilder();
		str.append("\n");
		str.append("Informe o que será alterado \n");
		str.append("1. Cliente \n");
		str.append("2. Filial \n");
		str.append("3. Editar um itens \n");
		str.append("4. Adicionar um item \n");
		str.append("5. Remove um item \n");
		
		System.out.println(str.toString());
	}
	
	public static void showAlteraItem() {
		StringBuilder str = new StringBuilder();
		str.append("\n");
		str.append("Informe o que será alterado \n");
		str.append("1. Nome \n");
		str.append("2. Valor \n");
		str.append("3. Quantidade \n");
		
		System.out.println(str.toString());
	}
	
}