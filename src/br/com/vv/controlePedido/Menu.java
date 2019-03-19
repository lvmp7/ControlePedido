package br.com.vv.controlePedido;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.vv.controlePedido.model.MontarConsole;

public class Menu {
	
	public static void main(String[] args) {
		int opc = -1;
		PedidoDataSource pedidoDAO = new PedidoDataSource();
		Scanner s = new Scanner(System.in);

		do {
			MontarConsole.showMenu();
			System.out.print("Digite um número do menu: ");
			
			try{
				opc = s.nextInt();
				validaOpcao(opc,pedidoDAO);
			}catch (InputMismatchException e) {
				System.out.print("Favor entrar com um NUMERO valido");
				System.out.println();
			}
		}while(opc != 0);
		s.close();
	}
	
	public static void validaOpcao(int key, PedidoDataSource dao) {
		Scanner s = new Scanner(System.in);
		
		switch (key) {
		case 1:
			dao.listar();
			break;
		case 2:
			dao.incluir();
			break;
		case 3:
			System.out.println("Digite o codigo do pedido que deseja alterar: ");			
			dao.alterar(s.nextInt());
			break;
		case 4:
			System.out.println("Digite o codigo do pedido que deseja excluir: ");
			dao.excluir(s.nextInt());
			break;
		case 0:
			System.out.println("saindo do sistema");
			System.out.println("logout");
			break;

		default:
			System.out.println("Opção inválida!");
			System.out.println("Favor inserir um numero válido");
			System.out.println();
			break;
		}
	}
}