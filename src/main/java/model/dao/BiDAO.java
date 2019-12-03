package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.dto.Bi;

public class BiDAO {
	
	public ArrayList<Bi> consultarDadosVagas() {
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		ArrayList<Bi> bi = new ArrayList<Bi>();
		
		try {
			stmt = conn.prepareStatement("SELECT * FROM VW_BI");
			
			rs = stmt.executeQuery();
						
			while(rs.next()) {
				Bi biDTO = new Bi();
				
				biDTO.setIdVaga(Integer.parseInt(rs.getString(1)));
				biDTO.setTipo(rs.getString(2));
				biDTO.setTempoEntrada(rs.getInt(3));
				biDTO.setTempoSaida(rs.getInt(4));
			
				bi.add(biDTO);
				
			}
			
			
		}catch(SQLException e) {
			System.out.println("Erro ao executar a query de consultar de tickes");
			System.out.println("Erro: " + e.getMessage());
			
			
			
		} finally {			
			Banco.closeResultSet(rs);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		return bi;
	}
	
	

}

