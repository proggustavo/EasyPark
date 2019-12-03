package model.bo;

import java.util.ArrayList;

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

	public void validarVaga(TicketVO ticketVO) {
		TicketDAO ticketDAO = new TicketDAO();
		ticketDAO.validarVaga(ticketVO);
		
	}

	public ArrayList<TicketVO> consultarTickets() {
		TicketDAO TicketDAO = new TicketDAO();
		return TicketDAO.consultarTickets();
	}

	public TicketVO consultarTicketEspecifico(TicketVO ticketVO) {
		TicketDAO ticketDAO = new TicketDAO();
		return ticketDAO.consultarTicketEspecifico(ticketVO);
		
		
	}

	
	

}
