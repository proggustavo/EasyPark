package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.ControladoraTicket;
import controller.ControladoraVaga;
import model.vo.TicketVO;
import model.vo.TipoVagaVO;
import model.vo.UsuarioVO;
import model.vo.VagaVO;

public class MenuTicket {

	Scanner teclado = new Scanner(System.in);

	private static final int OPCAO_MENU_EMITIR_TICKET = 1;
	private static final int OPCAO_MENU_VALIDAR_TICKET = 2;
	private static final int OPCAO_MENU_PAGAR_TICKET = 3;
	private static final int OPCAO_MENU_CONSULTAR_TICKETS = 4;

	private static final int OPCAO_MENU_CONSULTAR_TICKETS_TODOS = 1;
	private static final int OPCAO_MENU_CONSULTAR_TICKETS_ESPECIFICO = 2;

	private static final int OPCAO_MENU_TICKET_SAIR = 9;

	public void apresentarMenuTicket(UsuarioVO usuarioVO) {

		int opcao = this.apresentarOpcoesMenuTicketUsuario();
		while (opcao != OPCAO_MENU_TICKET_SAIR) {
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

	private void consultarTickets() {
		ControladoraTicket controladoraTicket = new ControladoraTicket();
		
		int opcao = this.apresentarOpcoesMenuTicketConsultar();

		while (opcao != OPCAO_MENU_TICKET_SAIR) {
			switch (opcao) {
				case OPCAO_MENU_CONSULTAR_TICKETS_TODOS: {
					ArrayList<TicketVO> tickets = controladoraTicket.consultarTicket();
					
					System.out.println("=======================================================");
					System.out.println("--              Easy Park - Consultar Vaga           --");
					System.out.println("=======================================================");
					System.out.printf("\n%-9s  %-14s  %-24s  %-24s %-25s %-25s %-25s %-15s\n", "IDTICKET", "IDVAGA", "EMISSAO", "ENTRADA NA VAGA", "PAGAMENTO", "SAIDA DA VAGA", "FINALIZADO", "VALOR");
						for (int i = 0; i < tickets.size(); i++) {
		
							tickets.get(i).imprimir();
						
						}
					break;
				}
				case OPCAO_MENU_CONSULTAR_TICKETS_ESPECIFICO: {
					TicketVO ticketVO = new TicketVO();
					
					System.out.print("Informe o código do Ticket: ");
					ticketVO.setIdTicket(Integer.parseInt(teclado.nextLine()));
	
					TicketVO ticket = controladoraTicket.consultarTicketEspecifico(ticketVO);
	
					System.out.printf("\n%-9s  %-14s  %-24s  %-24s %-25s %-25s %-25s %-15s\n", "IDTICKET", "IDVAGA", "EMISSAO", "ENTRADA NA VAGA", "PAGAMENTO", "SAIDA DA VAGA", "FINALIZADO", "VALOR");
					ticket.imprimir();
					
					break;
				}
				default: {
					System.out.println("Opção inválida!");
	
					break;
				}
			}

			opcao = this.apresentarOpcoesMenuTicketConsultar();

		}

	}

	private int apresentarOpcoesMenuTicketConsultar() {

		System.out.println("=======================================================");
		System.out.println("--             Easy Park - Menu Ticket               --");
		System.out.println("=======================================================");
		System.out.println("[ " + OPCAO_MENU_CONSULTAR_TICKETS_TODOS + " ] - Consultar Todos os Tickets");
		System.out.println("[ " + OPCAO_MENU_CONSULTAR_TICKETS_ESPECIFICO + " ] - Consultar Ticket Específico");
		System.out.println("[ " +OPCAO_MENU_TICKET_SAIR + " ] - Voltar");
		System.out.println("-------------------------------------------------------");
		System.out.print("Escolha uma opção: ");
		return Integer.parseInt(teclado.nextLine());
	}

	private int apresentarOpcoesMenuTicketUsuario() {
		System.out.println("=======================================================");
		System.out.println("--             Easy Park - Menu Ticket               --");
		System.out.println("=======================================================");
		System.out.println("[ " + OPCAO_MENU_EMITIR_TICKET + " ] - Emitir Ticket");
		System.out.println("[ " + OPCAO_MENU_VALIDAR_TICKET + " ] - Validar Ticket");
		System.out.println("[ " + OPCAO_MENU_PAGAR_TICKET + " ] - Pagar Ticket");
		System.out.println("[ " + OPCAO_MENU_CONSULTAR_TICKETS + " ] - Consultar Ticket");
		System.out.println("[ " + OPCAO_MENU_TICKET_SAIR + " ] - Voltar");
		System.out.println("-----------------------------------------");
		System.out.print("Escolha uma opção: ");
		return Integer.parseInt(teclado.nextLine());
	}

	private void emitirTicket() {

		TicketVO ticketVO = new TicketVO();

		System.out.println("---------------------------------------------");
		System.out.println("--->>          VAGAS DISPONÍVEIS        <<---");
		System.out.println("---------------------------------------------");
		ControladoraVaga controladoraVaga = new ControladoraVaga();
		ArrayList<TipoVagaVO> vagas = controladoraVaga.consultarTipoVagas();
		for (int i = 0; i < vagas.size(); i++) {
			System.out.println(vagas.get(i).getTipo() + " - " + vagas.get(i).getQuantidade());
		}

		System.out.println("-----------------------------------------------");
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
