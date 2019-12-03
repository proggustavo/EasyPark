package model.bo;

import java.util.ArrayList;

import model.dao.UsuarioDAO;
import model.vo.UsuarioVO;

public class UsuarioBO {

	public UsuarioVO recuperarUsuarioBO(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		return usuarioDAO.recuperarUsuarioDAO(usuarioVO);
	}

	public void cadastrarUsuarioBO(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		if(usuarioDAO.existeLoginUsuarioDAO(usuarioVO.getLogin())) {
			System.out.println("\nUsuário já cadastrado.");
		}else {
			int resultado = usuarioDAO.cadastrarUsuarioDAO(usuarioVO);
			if(resultado == 1) {
				System.out.println("\nUsuário cadastrado com sucesso!");
			}else {
				System.out.println("\nNão foi possível cadastrar o Usuário.");
			}
		}
		
	}

	public ArrayList<UsuarioVO> consultarTodosUsuariosBO() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		ArrayList<UsuarioVO> listaUsuarioVO = usuarioDAO.consultarTodosUsuariosDAO();
		if(listaUsuarioVO.isEmpty()) {
			System.out.println("\nLista de Usuários está vazia.");
		}
		
		return listaUsuarioVO;
	}

	public UsuarioVO consultarUsuarioBO(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		UsuarioVO usuario = usuarioDAO.consultarUsuarioDAO(usuarioVO);
		
		if(usuario == null) {
			System.out.println("\nUsuário não localizado.");
		}
		
		return usuario;
	}

	public void atualizarUsuarioBO(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		int resultado = usuarioDAO.atualizarUsuarioDAO(usuarioVO);
		if(resultado == 1) {
			System.out.println("Usuário atualizado com sucesso!");
		}else {
			System.out.println("Usuário não atualizado");
		}
	}

	public void excluirUsuarioBO(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		int resultado = usuarioDAO.excluirUsuarioDAO(usuarioVO);
		if(resultado == 1) {
			System.out.println("Usuário excluído com sucesso!");
		}else {
			System.out.println("Usuário não excluído");
		}
	}

}
