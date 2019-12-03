package model.dao;

import model.vo.TicketVO;
import model.vo.VagaVO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
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

	public ArrayList<TicketVO> consultarTickets() {
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		ArrayList<TicketVO> tickets = new ArrayList<TicketVO>();
		
		try {
			stmt = conn.prepareStatement("SELECT IDTICKET, IDVAGA, DHEMISSAO, DHENTRADA, DHPAGAMENTO, DHSAIDA, DTFINALIZADO, VALOR FROM TICKET ORDER BY IDTICKET");
			
			rs = stmt.executeQuery();
						
			while(rs.next()) {
				TicketVO ticket = new TicketVO();
				
				ticket.setIdTicket(rs.getInt(1));
				ticket.setIdVaga(rs.getInt(2));
				ticket.setDtEmissao(rs.getString(3));
				ticket.setDtEntrada(rs.getString(4));
				ticket.setDtPagamento(rs.getString(5));
				ticket.setDtSaida(rs.getString(6));
				ticket.setDtFinalizado(rs.getString(7));
				ticket.setValor(rs.getDouble(8));
			
				tickets.add(ticket);
				
			}
			
			
		}catch(SQLException e) {
			System.out.println("Erro ao executar a query de consultar de tickes");
			System.out.println("Erro: " + e.getMessage());
			
			
			
		} finally {			
			Banco.closeConnection(conn);
			
		}
		return tickets;
	}

	public TicketVO consultarTicketEspecifico(TicketVO ticketVO) {
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		TicketVO ticket = new TicketVO();
		
		
		try {
			stmt = conn.prepareStatement("SELECT IDTICKET, IDVAGA, DHEMISSAO, DHENTRADA, DHPAGAMENTO, DHSAIDA, DTFINALIZADO, VALOR FROM TICKET WHERE IDTICKET = ?");
			
			stmt.setInt(1, ticketVO.getIdTicket());
			
			rs = stmt.executeQuery();
						
			if(rs.next()) {
				
				ticket.setIdTicket(rs.getInt(1));
				ticket.setIdVaga(rs.getInt(2));
				ticket.setDtEmissao(rs.getString(3));
				ticket.setDtEntrada(rs.getString(4));
				ticket.setDtPagamento(rs.getString(5));
				ticket.setDtSaida(rs.getString(6));
				ticket.setDtFinalizado(rs.getString(7));
				ticket.setValor(rs.getDouble(8));
			
			}
			
			
		}catch(SQLException e) {
			System.out.println("Erro ao executar a query de consultar de tickes");
			System.out.println("Erro: " + e.getMessage());
			
			
			
		} finally {			
			Banco.closeConnection(conn);
			
		}
		return ticket;
		
	}

	
	
	

}
