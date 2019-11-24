package model.dao;

import model.vo.TicketVO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.sql.SQLException;

public class TicketDAO {

	public int emitirTicket(TicketVO ticketVO) {
		Connection conn = Banco.getConnection();
		CallableStatement cstmt = null;
		try {
					
			 cstmt = conn.prepareCall("{ ? = call EMITIRTICKET(?)}");
	
			cstmt.registerOutParameter(1, Types.INTEGER);
			cstmt.setString(2, ticketVO.getTipo().toUpperCase());
			cstmt.execute();
						
			System.out.println(cstmt.getNString(1));
						
		}catch(SQLException e) {
			System.out.println("Erro ao executar a query de emitir ticket");
			System.out.println("Erro: " + e.getMessage());
						
		} finally {			
			Banco.closeConnection(conn);
			
		}
		return 0;
		
		
	}

	public int pagarTicket(TicketVO ticketVO) {
		Connection conn = Banco.getConnection();
		
				System.out.println("Resultado: ");
		try {
			
		
			java.sql.CallableStatement cs = conn.prepareCall("{ ? = call PAGAR(?)}");
	
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setInt(2, ticketVO.getIdVaga());
			cs.execute();
			
			System.out.println(cs.getNString(1));
			
			
		}catch(SQLException e) {
			System.out.println("Erro ao executar a query de cadastro de Usuário");
			System.out.println("Erro: " + e.getMessage());
			
			
			
		} finally {			
			Banco.closeConnection(conn);
			
		}
		return 0;
	
		
		
		
		
	}

	public void desocuparVaga(TicketVO ticketVO) {
		Connection conn = Banco.getConnection();
		
		try {
			
		
			java.sql.CallableStatement cs = conn.prepareCall("{ ? = call DHSAIDA(?)}");
	
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setInt(2, ticketVO.getIdVaga());
			cs.execute();
			
			System.out.println(cs.getNString(1));
			
			
		}catch(SQLException e) {
			System.out.println("Erro ao executar a query de cadastro de Usuário");
			System.out.println("Erro: " + e.getMessage());
			
			
			
		} finally {			
			Banco.closeConnection(conn);
			
		}		
	}

	public void ocuparVaga(TicketVO ticketVO) {
		Connection conn = Banco.getConnection();

		try {
			
		
			java.sql.CallableStatement cs = conn.prepareCall("{ ? = call OCUPAR(?)}");
	
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setInt(2, ticketVO.getIdVaga());
			cs.execute();
			
			System.out.println(cs.getNString(1));
			
			
		}catch(SQLException e) {
			System.out.println("Erro ao executar a query de cadastro de Usuário");
			System.out.println("Erro: " + e.getMessage());
			
			
			
		} finally {			
			Banco.closeConnection(conn);
			
		}
		
	}

	public void validarVaga(TicketVO ticketVO) {
		Connection conn = Banco.getConnection();
		
		try {
			
		
			java.sql.CallableStatement cs = conn.prepareCall("{ ? = call DTFINALIZADO(?)}");
	
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setInt(2, ticketVO.getIdVaga());
			cs.execute();
	
			System.out.println(cs.getNString(1));
			
			
		}catch(SQLException e) {
			System.out.println("Erro ao executar a query de cadastro de Usuário");
			System.out.println("Erro: " + e.getMessage());
			
			
			
		} finally {			
			Banco.closeConnection(conn);
			
		}
		
	}
	
	

}
