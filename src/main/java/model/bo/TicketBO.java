package model.bo;

import model.dao.TicketDAO;
import model.vo.TicketVO;

public class TicketBO {

	public void emitirTicket(TicketVO ticketVO) {
		TicketDAO ticketDAO = new TicketDAO();
		int resultado = ticketDAO.emitirTicket(ticketVO); 
		
	}
	

}
