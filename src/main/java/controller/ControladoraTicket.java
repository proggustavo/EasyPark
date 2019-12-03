package controller;

import java.util.ArrayList;

import model.bo.TicketBO;
import model.vo.TicketVO;

public class ControladoraTicket {

	public void emitirTicket(TicketVO ticketVO) {
		TicketBO ticketBO = new TicketBO();
		ticketBO.emitirTicket(ticketVO);
		
	}

	public void pagarTicket(TicketVO ticketVO) {
		TicketBO ticketBO = new TicketBO();
		ticketBO.pagarTicket(ticketVO);
		
	}

	public void desocuparVaga(TicketVO ticketVO) {
		TicketBO ticketBO = new TicketBO();
		ticketBO.desocuparVaga(ticketVO);
		
	}

	

	public void validarTicket(TicketVO ticketVO) {
		TicketBO ticketBO = new TicketBO();
		ticketBO.validarVaga(ticketVO);
	}

	public ArrayList<TicketVO> consultarTicket() {
		TicketBO ticketBO = new TicketBO();
		return ticketBO.consultarTickets();
		
	}

	public TicketVO consultarTicketEspecifico(TicketVO ticketVO) {
		TicketBO ticketBO = new TicketBO();
		return ticketBO.consultarTicketEspecifico(ticketVO);
		
		
		
	}

	

}
