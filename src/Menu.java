import java.util.InputMismatchException;
import java.util.Scanner;

import model.MontarConsole;

public class Menu {
	
	public static void main(String[] args) {
		int opc = -1;
		do {
			MontarConsole.showMenu();
			Scanner s = new Scanner(System.in);
			System.out.print("Digite um número referente as opções do menu: ");
			
			try{
				opc = s.nextInt();
				validaOpcao(opc);
			}catch (InputMismatchException e) {
				System.out.print("Favor entrar com um NUMERO valido");
				System.out.println();
			}finally {
				s.close();
			}
		}while(opc != 0);
	}
	
	public static void validaOpcao(int key) {
		PedidoDataSource pedidoDAO = new PedidoDataSource();
		
		switch (key) {
		case 1:
			System.out.println("listar");
			pedidoDAO.lista();
			break;
		case 2:
			System.out.println("incluir");
			pedidoDAO.inclui();
			break;
		case 3:
			System.out.println("alterar");
			
			pedidoDAO.altera();
			break;
		case 4:
			System.out.println("excluir");
			pedidoDAO.exclui();
			break;
		case 0:
			System.out.println("saindo do sistema");
			System.out.println("logout");
			break;

		default:
			System.out.println("Opção inválida!");
			System.out.println("Favor inserir um valor válido");
			System.out.println();
			break;
		}
	}
	
	
}