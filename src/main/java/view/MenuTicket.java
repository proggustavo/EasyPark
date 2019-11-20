package view;

import java.util.Scanner;

import controller.ControladoraTicket;
import model.vo.TicketVO;

public class MenuTicket {

	Scanner teclado = new Scanner(System.in);

	private static final int OPCAO_MENU_EMITIR_TICKET = 1;
	private static final int OPCAO_MENU_PAGAR_TICKET = 2;
	private static final int OPCAO_MENU_VALIDAR_TICKET = 3;
	private static final int OPCAO_MENU_AVISO_SAIR = 9;

	public void apresentarMenuTicketUsuario() {
		
		int opcao = this.apresentarOpcoesMenuTicketUsuario();
		while (opcao != 9) {
			switch (opcao) {
				case OPCAO_MENU_EMITIR_TICKET: {
					this.emitirTicket();
					break;
				}
				case OPCAO_MENU_PAGAR_TICKET: {
					this.pagarTicket();
					break;
				}
				case OPCAO_MENU_VALIDAR_TICKET: {
					this.validarTicket();
					break;
				}
				default: {
					System.out.println("Opção inválida!");
					break;
				}

			}
			
			opcao = this.apresentarOpcoesMenuTicketUsuario();

		}

	}
	
	
	private int apresentarOpcoesMenuTicketUsuario() {
		System.out.println("Sistema Estacionamento - Menu Usuário");
		System.out.println(OPCAO_MENU_EMITIR_TICKET + " - Menu Emitir Ticket");
		System.out.println(OPCAO_MENU_PAGAR_TICKET + " - Menu pagar Ticket");
		System.out.println(OPCAO_MENU_VALIDAR_TICKET + " - Menu validar Ticket");
		System.out.println(OPCAO_MENU_AVISO_SAIR + "- Voltar");
		return Integer.parseInt(teclado.nextLine());
	}
	
	
	public void apresentarMenuTicketAdmin() {

		int opcao = this.apresentarOpcoesMenuTicketAdmin();
		while (opcao != 9) {
			switch (opcao) {
				case OPCAO_MENU_EMITIR_TICKET: {
					this.emitirTicket();
					break;
				}
				case OPCAO_MENU_PAGAR_TICKET: {
					this.pagarTicket();
					break;
				}
				case OPCAO_MENU_VALIDAR_TICKET: {
					break;
				}
				default: {
					System.out.println("Opção inválida!");
					break;
				}

			}
			
		//	opcao = this.apresentarOpcoesMenuUsuario();

		}

	}
	


	private int apresentarOpcoesMenuTicketAdmin() {
		// TODO Auto-generated method stub
		return 0;
	}


	private void emitirTicket() {
		TicketVO ticketVO = new TicketVO();
		System.out.print("Informe o tipo de vaga (Normal ou Especial): ");
		ticketVO.setTipo(teclado.nextLine());
		
		ControladoraTicket controladoraTicket = new ControladoraTicket();
		controladoraTicket.emitirTicket(ticketVO);
		
	}
	
	private void pagarTicket() {
		TicketVO ticketVO = new TicketVO();
		System.out.println("Informe o número da vaga: ");
		ticketVO.setIdVaga(Integer.parseInt(teclado.nextLine()));
		
		ControladoraTicket controladoraTicket = new ControladoraTicket();
		controladoraTicket.pagarTicket(ticketVO);
		
	}
	
	private void validarTicket() {
		
		
	}







	
	

}
