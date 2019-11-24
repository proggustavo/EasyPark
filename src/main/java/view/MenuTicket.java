package view;

import java.util.Scanner;

import controller.ControladoraTicket;
import model.vo.TicketVO;

public class MenuTicket {

	Scanner teclado = new Scanner(System.in);

	private static final int OPCAO_MENU_EMITIR_TICKET = 1;
	private static final int OPCAO_MENU_OCUPAR_VAGA = 2;
	private static final int OPCAO_MENU_PAGAR_TICKET = 3;
	private static final int OPCAO_MENU_DESOCUPAR_VAGA = 4;
	private static final int OPCAO_MENU_VALIDAR_TICKET = 5;
	private static final int OPCAO_MENU_CONSULTAR_VAGAS = 6;
	private static final int OPCAO_MENU_CONSULTAR_TICKETS = 7;
	private static final int OPCAO_MENU_AVISO_SAIR = 9;

	public void apresentarMenuTicket() {
		
		int opcao = this.apresentarOpcoesMenuTicketUsuario();
		while (opcao != 9) {
			switch (opcao) {
				case OPCAO_MENU_EMITIR_TICKET: {
					this.emitirTicket();
					break;
				}
				case OPCAO_MENU_OCUPAR_VAGA: {
					this.ocuparVaga();
					break;
				}
				case OPCAO_MENU_PAGAR_TICKET: {
					this.pagarTicket();
					break;
				}
				case OPCAO_MENU_DESOCUPAR_VAGA: {
					this.desocuparVaga();
					break;
				}
				case OPCAO_MENU_VALIDAR_TICKET: {
					this.validarTicket();
					break;
				}
				case OPCAO_MENU_CONSULTAR_VAGAS: {
					this.consultarVagas();
					break;
				}
				case OPCAO_MENU_CONSULTAR_TICKETS: {
					this.consultarTickets();
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
	
	
	private void consultarVagas() {
		TicketVO ticketVO = new TicketVO();
		
		ControladoraTicket controladoraTicket = new ControladoraTicket();
		controladoraTicket.consultarVagas(ticketVO);
		
	}


	private void consultarTickets() {
		// TODO Auto-generated method stub
		
	}


	private void desocuparVaga() {
		TicketVO ticketVO = new TicketVO();
		System.out.print("Informe o número da vaga: ");
		ticketVO.setIdVaga(Integer.parseInt(teclado.nextLine()));
		
		ControladoraTicket controladoraTicket = new ControladoraTicket();
		controladoraTicket.desocuparVaga(ticketVO);
		
	}


	private void ocuparVaga() {
		TicketVO ticketVO = new TicketVO();
		System.out.print("Informe o número da vaga: ");
		ticketVO.setIdVaga(Integer.parseInt(teclado.nextLine()));
		
		ControladoraTicket controladoraTicket = new ControladoraTicket();
		controladoraTicket.ocuparVaga(ticketVO);
		
	}


	private int apresentarOpcoesMenuTicketUsuario() {
		System.out.println("-----------------------------------------");
		System.out.println("- Sistema Estacionamento - Menu Usuário -");
		System.out.println("-----------------------------------------");
		System.out.println(OPCAO_MENU_EMITIR_TICKET + " - Emitir Ticket");
		System.out.println(OPCAO_MENU_OCUPAR_VAGA + " - Ocupar vaga");
		System.out.println(OPCAO_MENU_PAGAR_TICKET + " - Pagar Ticket");
		System.out.println(OPCAO_MENU_DESOCUPAR_VAGA + " - Desocupar vaga");
		System.out.println(OPCAO_MENU_VALIDAR_TICKET + " - Validar Ticket");
		System.out.println(OPCAO_MENU_AVISO_SAIR + " - Voltar");
		System.out.println("-----------------------------------------");
		System.out.print("Escolha uma opção: ");
		return Integer.parseInt(teclado.nextLine());
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
		System.out.println("Informe o número da vaga para pagar: ");
		ticketVO.setIdVaga(Integer.parseInt(teclado.nextLine()));
		
		ControladoraTicket controladoraTicket = new ControladoraTicket();
		controladoraTicket.pagarTicket(ticketVO);
		
	}
	
	private void validarTicket() {
		TicketVO ticketVO = new TicketVO();
		System.out.println("Informe o número da vaga para validar: ");
		ticketVO.setIdVaga(Integer.parseInt(teclado.nextLine()));
		
		ControladoraTicket controladoraTicket = new ControladoraTicket();
		controladoraTicket.validarTicket(ticketVO);
		
	}







	
	

}
