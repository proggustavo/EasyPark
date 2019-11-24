package view;

import java.util.Scanner;

public class MenuEstacionamento {
	
	Scanner teclado = new Scanner(System.in);
	
	private static final int OPCAO_MENU_ADMINISTRADOR = 1;
	private static final int OPCAO_MENU_USUARIO = 2;
	private static final int OPCAO_MENU_SAIR = 9;

	
	public void apresentarMenu() {
		
		int opcao = this.apresentarOpcoesMenu();
			while(opcao != OPCAO_MENU_SAIR ) {
				switch(opcao) {
				case OPCAO_MENU_ADMINISTRADOR:{
					MenuTicket menuTicket= new MenuTicket();
				//	menuTicket.apresentarMenuTicketAdmin();
					break;
				}
				case OPCAO_MENU_USUARIO:{
					MenuTicket menuTicket= new MenuTicket();
				//	menuTicket.apresentarMenuTicketUsuario();
					break;
				}
				default : {
					System.out.println("Opção inválida!");
					break;
				}
								
				}
				
			opcao = this.apresentarOpcoesMenu();
			
		}
	}


	private int apresentarOpcoesMenu() {
		System.out.println("\nSistema Estacionamento - Menu Principal");
		System.out.println("\n Opções: ");
		System.out.println(OPCAO_MENU_ADMINISTRADOR + " - Acesso Administrador");
		System.out.println(OPCAO_MENU_USUARIO + " - Acesso Usuários");
		System.out.println(OPCAO_MENU_SAIR + " - Sair");
		System.out.print("\nDigite uma opção: ");
		return Integer.parseInt(teclado.nextLine());
		
	}
}
