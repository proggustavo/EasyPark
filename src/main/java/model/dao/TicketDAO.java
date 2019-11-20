package model.dao;

import model.vo.TicketVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketDAO {

	public int emitirTicket(TicketVO ticketVO) {
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = null;
		int resultado = 0;
		

		try {
			
			stmt = conn.prepareStatement("SELECT EMITIRTICKET(?)");
			stmt.setString(1, ticketVO.getTipo().toUpperCase());
				
			
			// apesar de fazer um insert utilizamos o update pois ele funciona para delete, insert e update
			resultado = stmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("Erro ao executar a query de cadastro de Usuário");
			System.out.println("Erro: " + e.getMessage());
			
			
			
		} finally {			
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
			
		}
		
		return resultado;
		
		
		
	}

	public void pagarTicket(TicketVO ticketVO) {
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = null;
		
		
		
		
	}
	
	

}
