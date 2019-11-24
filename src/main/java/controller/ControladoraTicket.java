package controller;

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

	public void ocuparVaga(TicketVO ticketVO) {
		TicketBO ticketBO = new TicketBO();
		ticketBO.ocuparVaga(ticketVO);
		
	}

	public void validarTicket(TicketVO ticketVO) {
		TicketBO ticketBO = new TicketBO();
		ticketBO.validarVaga(ticketVO);
	}

}
