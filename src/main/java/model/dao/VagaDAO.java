package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import model.vo.TipoVagaVO;
import model.vo.VagaVO;



public class VagaDAO {

	public ArrayList<TipoVagaVO> consultarTipoVagas() {
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		ArrayList<TipoVagaVO> vagas = new ArrayList<TipoVagaVO>();
		
		try {
			stmt = conn.prepareStatement("SELECT TOTALVAGAS, TIPO FROM VW_VAGAS");
			
			rs = stmt.executeQuery();
						
			while(rs.next()) {
				TipoVagaVO vaga = new TipoVagaVO();
				vaga.setQuantidade(Integer.parseInt(rs.getString(1)));
				vaga.setTipo(rs.getString(2));
				
				vagas.add(vaga);
				
			}
			
			
		}catch(SQLException e) {
			System.out.println("Erro ao executar a query de cadastro de Usuário");
			System.out.println("Erro: " + e.getMessage());
			
			
			
		} finally {			
			Banco.closeConnection(conn);
			
		}
		return vagas;
		
		
	}

	public int cadastrarVaga(VagaVO vagaVO) {
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = null;
		int resultado = 0;
		

		try {
			stmt = conn.prepareStatement("INSERT INTO VAGA (DISTANCIA, TIPO) VALUES(?, ?)");
			
			stmt.setDouble(1, vagaVO.getDistancia());
			stmt.setString(2, vagaVO.getTipo());
			
			resultado = stmt.executeUpdate();
						
			
			
		}catch(SQLException e) {
			System.out.println("Erro ao executar a query de cadastro de Usuário");
			System.out.println("Erro: " + e.getMessage());
			
			
			
		} finally {			
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
			
		}
		
		
		
		return resultado;
	}

	public ArrayList<VagaVO> consultarVagas() {
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		ArrayList<VagaVO> vagas = new ArrayList<VagaVO>();
		
		try {
			stmt = conn.prepareStatement("SELECT IDVAGA, DISTANCIA, TIPO, SITUACAO FROM VAGA ORDER BY IDVAGA");
			
			rs = stmt.executeQuery();
						
			while(rs.next()) {
				VagaVO vaga = new VagaVO();
				
				vaga.setIdVaga(rs.getInt(1));
				vaga.setDistancia(rs.getDouble(2));
				vaga.setTipo(rs.getNString(3));
				vaga.setSituacao(rs.getNString(4));
				
			
				
				vagas.add(vaga);
				
			}
			
			
		}catch(SQLException e) {
			System.out.println("Erro ao executar a query de consultar de vagas");
			System.out.println("Erro: " + e.getMessage());
			
			
			
		} finally {			
			Banco.closeConnection(conn);
			
		}
		return vagas;
	}

	public VagaVO consultarVagaEspecifica(VagaVO vagaVO) {
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		
		VagaVO vaga = new VagaVO();
		
		try {
			
			
			stmt = conn.prepareStatement("SELECT IDVAGA, DISTANCIA, TIPO, SITUACAO FROM VAGA WHERE IDVAGA = ?");
			
			stmt.setInt(1, vagaVO.getIdVaga());
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				vaga.setIdVaga(rs.getInt(1));
				vaga.setDistancia(rs.getDouble(2));
				vaga.setTipo(rs.getNString(3));
				vaga.setSituacao(rs.getNString(4));
			}
			
		}catch(SQLException e){
			System.out.println("Erro ao executar a query de consultar vaga específica");
			System.out.println("Erro: " + e.getMessage());
			
		}finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
			
		}
		
		
		
		return vaga;
	}

	public boolean existeVaga(int i) {
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
				
		try {
			
			
			stmt = conn.prepareStatement("SELECT IDVAGA FROM VAGA WHERE IDVAGA = ?");
			
			stmt.setInt(1, i);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
						
				return true;
			}
			
		}catch(SQLException e){
			System.out.println("Erro ao executar a query de consultar vaga específica");
			System.out.println("Erro: " + e.getMessage());
			
		}finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
			
		}
		
		
		
		return false;
	}

	public int atualizarVagaDAO(VagaVO vagaVO) {
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = null;
		int resultado = 0;
		

		try {
			stmt = conn.prepareStatement("UPDATE VAGA SET DISTANCIA = ?, TIPO = ?, SITUACAO = ? WHERE IDVAGA = ?");
			
			stmt.setDouble(1, vagaVO.getDistancia());
			stmt.setString(2, vagaVO.getTipo());
			stmt.setString(3, vagaVO.getSituacao());
			stmt.setInt(4, vagaVO.getIdVaga());
			
			resultado = stmt.executeUpdate();
						
			
			
		}catch(SQLException e) {
			System.out.println("Erro ao executar o update de cadastro de vaga");
			System.out.println("Erro: " + e.getMessage());
			
			
			
		} finally {			
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
			
		}
		
		
		
		return resultado;
	}

	public int excluirVaga(VagaVO vagaVO) {
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = null;
		int resultado = 0;
		

		try {
			stmt = conn.prepareStatement("DELETE FROM VAGA WHERE IDVAGA = ?");
			
			stmt.setInt(1, vagaVO.getIdVaga());
			
			resultado = stmt.executeUpdate();
						
			
			
		}catch(SQLException e) {
			System.out.println("Erro ao executar o delete de Usuário");
			System.out.println("Erro: " + e.getMessage());
			
			
			
		} finally {			
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
			
		}
		
		
		
		return resultado;
	}

	public void desocuparVaga(VagaVO vagaVO) {
		Connection conn = Banco.getConnection();
		
		try {
			
		
			java.sql.CallableStatement cs = conn.prepareCall("{ ? = call DHSAIDA(?)}");
	
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setInt(2, vagaVO.getIdVaga());
			cs.execute();
			
			System.out.println(cs.getNString(1));
			
			
		}catch(SQLException e) {
			System.out.println("Erro ao executar a query de cadastro de Usuário");
			System.out.println("Erro: " + e.getMessage());
			
			
			
		} finally {			
			Banco.closeConnection(conn);
			
		}		
	}

	public void ocuparVaga(VagaVO vagaVO) {
		Connection conn = Banco.getConnection();

		try {
			
		
			java.sql.CallableStatement cs = conn.prepareCall("{ ? = call OCUPAR(?)}");
	
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setInt(2, vagaVO.getIdVaga());
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
