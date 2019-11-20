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

}
