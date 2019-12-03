package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.vo.ValorVO;

public class ValorDAO {

	public ValorVO consultarValor() {
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		ValorVO valor = new ValorVO();
		
		try {
			stmt = conn.prepareStatement("SELECT VALORPRIMEIRAHORA, VALORHORA FROM VALOR");
			
			rs = stmt.executeQuery();
						
			if(rs.next()) {
				
				
				valor.setValorPrimeiraHora(rs.getDouble(1));
				valor.setValorHora(rs.getDouble(2));
								
			}
			
			
		}catch(SQLException e) {
			System.out.println("Erro ao executar a query de consultar de valor");
			System.out.println("Erro: " + e.getMessage());
			
			
			
		} finally {			
			Banco.closeConnection(conn);
			
		}
		return valor;
	}

}
