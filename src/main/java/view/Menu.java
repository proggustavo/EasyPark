package view;

import java.util.Scanner;
import model.vo.UsuarioVO;

public class Menu {
	
	Scanner teclado = new Scanner(System.in);
	
	private static final int OPCAO_MENU_TICKET = 1;
	private static final int OPCAO_MENU_VAGA = 2;
	private static final int OPCAO_MENU_USUARIO = 3;
	private static final int OPCAO_MENU_VALOR = 4;
	private static final int OPCAO_MENU_BI = 5;
	private static final int OPCAO_MENU_SAIR = 9;
	
	private static final int ADMIN = 1;
	
	
	
	public void apresentarMenu(UsuarioVO usuarioVO) {
		int opcao = this.apresentarOpcoesMenu(usuarioVO.getTipo());
			while(opcao != OPCAO_MENU_SAIR ) {
				switch(opcao) {
					case OPCAO_MENU_TICKET:{
						MenuTicket menuTicket = new MenuTicket();
						menuTicket.apresentarMenuTicket(usuarioVO);
						break;
					}
					case OPCAO_MENU_VAGA: {
						MenuVaga menuVaga = new MenuVaga();
						menuVaga.apresentarMenuVaga(usuarioVO);
						break;
					}
					
					case OPCAO_MENU_USUARIO:{
						MenuUsuario menuUsuario = new MenuUsuario();
						menuUsuario.apresentarMenuUsuario(usuarioVO);
						break;
					}
					case OPCAO_MENU_VALOR: {
						MenuValor menuValor = new MenuValor();
						menuValor.apresentarMenuValor(usuarioVO);
					}
					case OPCAO_MENU_BI: {
						MenuBI menuBI = new MenuBI();
						menuBI.apresentarMenu();
						break;
					}
					default : {
						System.out.println("Opção inválida!");
						break;
					}
								
				}
				
				opcao = this.apresentarOpcoesMenu(usuarioVO.getTipo());
			}
			
	}
	
	
	
	private int apresentarOpcoesMenu(int tipoUsuario) {
		System.out.println("=======================================================");
		System.out.println("--            Easy Park - Menu Principal             --");
		System.out.println("=======================================================");
		System.out.println("\n Opções: ");
		System.out.println("[ " + OPCAO_MENU_TICKET + " ] - Menu de Ticket");
		if(tipoUsuario == ADMIN) {
		System.out.println("[ " + OPCAO_MENU_VAGA + " ] - Menu Vaga");
		System.out.println("[ " + OPCAO_MENU_USUARIO + " ] - Menu Usuario");
		System.out.println("[ " + OPCAO_MENU_VALOR + " ] - Menu Valor");
		}
		System.out.println("[ " + OPCAO_MENU_BI + " ] - Menu BI");
		System.out.println("[ " + OPCAO_MENU_SAIR + " ] - Sair");
		System.out.println();
		System.out.print("\nDigite uma opção: ");
		return Integer.parseInt(teclado.nextLine());
	}
	

}
