package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;


import model.vo.UsuarioVO;

public class UsuarioDAO {

	public UsuarioVO recuperarUsuarioDAO(UsuarioVO usuarioVO) {
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			stmt = conn.prepareStatement("SELECT IDUSUARIO, TIPO FROM USUARIO WHERE LOGIN = ? AND SENHA = ?");
			
			stmt.setString(1, usuarioVO.getLogin());
			stmt.setString(2, usuarioVO.getSenha());
			
			rs = stmt.executeQuery();
			
			
			if(rs.next()) {
				
				usuarioVO.setIdUsuario(rs.getInt(1));
				usuarioVO.setTipo(rs.getInt(2));
				
			}
			
			
		}catch(SQLException e){
			System.out.println("Erro ao executar a query que recupera usuário" + e);
		}finally {
			Banco.closeResultSet(rs);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
			
		}
		
		
		return usuarioVO;
	}

	public boolean existeLoginUsuarioDAO(String login) {
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		
		try {
			
			stmt = conn.prepareStatement("SELECT IDUSUARIO FROM USUARIO WHERE LOGIN = ?");
			
			stmt.setString(1, login);
						
			rs = stmt.executeQuery();
			
			
			if(rs.next()) {
				return true;
			}
			
			
		}catch(SQLException e){
			System.out.println("Erro ao executar a query que recupera usuário" + e);
		}finally {
			Banco.closeResultSet(rs);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
			
		}
		
		
		
		return false;
	}

	public int cadastrarUsuarioDAO(UsuarioVO usuarioVO) {
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = null;
		int resultado = 0;
		
		
		try {
			
			stmt = conn.prepareStatement("INSERT INTO USUARIO (LOGIN, SENHA, TIPO) VALUES(?, ?, ?)");
			
			stmt.setString(1, usuarioVO.getLogin());
			stmt.setString(2, usuarioVO.getSenha());
			stmt.setInt(3, usuarioVO.getTipo());
						
			resultado = stmt.executeUpdate();
						
			
		}catch(SQLException e){
			System.out.println("Erro ao executar a query que recupera usuário" + e);
		}finally {
			
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
			
		}
		
		return resultado;
	}

	public ArrayList<UsuarioVO> consultarTodosUsuariosDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		
		ArrayList<UsuarioVO> listaUsuariosVO = new ArrayList<UsuarioVO>();
		String query = "SELECT IDUSUARIO, LOGIN, TIPO FROM USUARIO";
				
		try {
			
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				
				UsuarioVO usuario = new UsuarioVO();
				
				usuario.setIdUsuario(Integer.parseInt(resultado.getString(1)));
				usuario.setLogin(resultado.getString(2));
				usuario.setTipo(resultado.getInt(3));
				
				listaUsuariosVO.add(usuario);
			}
			
		}catch(SQLException e) {
			
			System.out.println("Erro ao consultar todos os Usuários " + e);
			
		}finally{
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return listaUsuariosVO;
	}

	public UsuarioVO consultarUsuarioDAO(UsuarioVO usuarioVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		
		
		UsuarioVO usuario = new UsuarioVO();
		
		String query = "SELECT IDUSUARIO, LOGIN, TIPO FROM USUARIO WHERE IDUSUARIO = " + usuarioVO.getIdUsuario();
				
		try {
			
			resultado = stmt.executeQuery(query);
			
			if(resultado.next()) {
					
				usuario.setIdUsuario(Integer.parseInt(resultado.getString(1)));
				usuario.setLogin(resultado.getString(2));
				usuario.setTipo(resultado.getInt(3));
				
				
			}
			
		}catch(SQLException e) {
			
			System.out.println("Erro ao consultar Usuários Específico" + e);
			
		}finally{
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return usuario;
		
	}

	public int atualizarUsuarioDAO(UsuarioVO usuarioVO) {
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = null;;
		int resultado = 0;
		
			
		try {
			
			stmt = conn.prepareStatement("UPDATE USUARIO SET LOGIN = ?, SENHA = ?, TIPO = ? WHERE IDUSUARIO = ?");
			
			stmt.setString(1, usuarioVO.getLogin());
			stmt.setString(2, usuarioVO.getSenha());
			stmt.setInt(3,usuarioVO.getTipo());
			stmt.setInt(4, usuarioVO.getIdUsuario());
			
			resultado = stmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("Erro ao executar a query de atualização de Usuário");
			System.out.println("Erro: " + e.getMessage());
			
			
			
		} finally {			
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
			
		}
		
		return resultado;
	}

	public int excluirUsuarioDAO(UsuarioVO usuarioVO) {
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = null;;
		int resultado = 0;
		
			
		try {
			
			stmt = conn.prepareStatement("DELETE FROM USUARIO WHERE IDUSUARIO = ?");
			
			stmt.setInt(1, usuarioVO.getIdUsuario());
			
			resultado = stmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("Erro ao executar A exclusão de Usuário");
			System.out.println("Erro: " + e.getMessage());
			
			
			
		} finally {			
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
			
		}
		
		return resultado;
	}

}
