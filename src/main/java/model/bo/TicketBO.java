package model.bo;

import model.dao.TicketDAO;
import model.vo.TicketVO;

public class TicketBO {

	public void emitirTicket(TicketVO ticketVO) {
		TicketDAO ticketDAO = new TicketDAO();
		int resultado = ticketDAO.emitirTicket(ticketVO); 
		
	}

	public void pagarTicket(TicketVO ticketVO) {
		TicketDAO ticketDAO = new TicketDAO();
		ticketDAO.pagarTicket(ticketVO);
		
	}

	public void desocuparVaga(TicketVO ticketVO) {
		TicketDAO ticketDAO = new TicketDAO();
		ticketDAO.desocuparVaga(ticketVO);
		
	}

	public void ocuparVaga(TicketVO ticketVO) {
		TicketDAO ticketDAO = new TicketDAO();
		ticketDAO.ocuparVaga(ticketVO);
		
	}

	public void validarVaga(TicketVO ticketVO) {
		TicketDAO ticketDAO = new TicketDAO();
		ticketDAO.validarVaga(ticketVO);
		
	}
	

}
