package view;

import java.util.Scanner;
import model.vo.UsuarioVO;

public class MenuLogin {

	Scanner teclado = new Scanner(System.in);

	private static final int OPCAO_LOGIN = 1;
	private static final int OPCAO_CADASTRAR_LOGIN = 2;
	private static final int OPCAO_MENU_SAIR = 9;

	public void apresentarMenuLogin() {

		int opcao = this.apresentarOpcoesMenu();

		while (opcao != OPCAO_MENU_SAIR) {
			switch (opcao) {
			case OPCAO_LOGIN: {
				this.realizarLogin();
				break;
			}
			case OPCAO_CADASTRAR_LOGIN: {
				opcao = OPCAO_MENU_SAIR;
				this.criarNovoUsuario();
				break;
			}
			default: {
				System.out.println("Opção Inválida. ");
			}
			}
			
			 opcao = this.apresentarOpcoesMenu();

		}

	}

	private int apresentarOpcoesMenu() {

		System.out.println("=======================================================");
		System.out.println("--                    Easy Park                      --");
		System.out.println("=======================================================");
		System.out.print("[ " + OPCAO_LOGIN + " ] - Realizar Login        ");
		System.out.println("[ " + OPCAO_CADASTRAR_LOGIN + " ] - Cadastrar Usuário");
		System.out.println("[ " + OPCAO_MENU_SAIR + " ] Sair");
		System.out.print("\nEscolha uma opção: ");
		return Integer.parseInt(teclado.nextLine());

	}

	private void criarNovoUsuario() {
		MenuUsuario menuUsuario = new MenuUsuario();
		menuUsuario.cadastrarNovoUsuario();

	}

	private void realizarLogin() {
		MenuUsuario menuUsuario = new MenuUsuario();
		UsuarioVO usuarioVO = menuUsuario.recuperarUsuario();

		if (usuarioVO.getIdUsuario() != 0) {
			Menu menu = new Menu();
			menu.apresentarMenu(usuarioVO);

		} else {
			System.out.println("Login ou senha incorretos.\n");
		}

	}
	
	
	

}
