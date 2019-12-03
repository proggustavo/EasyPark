package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.ControladoraUsuario;
import model.vo.UsuarioVO;

public class MenuUsuario {
	
	Scanner teclado = new Scanner(System.in);
	
	private static final int OPCAO_MENU_CONSULTAR_USUARIO = 1;
	private static final int OPCAO_MENU_CADASTRAR_USUARIO = 2;
	private static final int OPCAO_MENU_ATUALIZAR_USUARIO = 3;
	private static final int OPCAO_MENU_EXCLUIR_USUARIO = 4;
	private static final int OPCAO_MENU_USUARIO_SAIR = 9;
	
	private static final int OPCAO_MENU_CONSULTAR_TODOS_USUARIO = 1;
	private static final int OPCAO_MENU_CONSULTAR_UM_USUARIO = 2;
	private static final int OPCAO_MENU_CONSULTAR_USUARIO_SAIR = 9;


	public void apresentarMenuUsuario(UsuarioVO usuarioVO) {
		int opcao = this.apresentarOpcoesMenu();
		
		while(opcao != OPCAO_MENU_USUARIO_SAIR ) {
			switch(opcao) {
				case OPCAO_MENU_CONSULTAR_USUARIO: {
					this.consultarUsuario();
					break;
				}
				case OPCAO_MENU_CADASTRAR_USUARIO: {
					this.cadastrarNovoUsuario();
					break;
				}
				case OPCAO_MENU_ATUALIZAR_USUARIO: {
					this.atualizarUsuario();
					break;
				}
				case OPCAO_MENU_EXCLUIR_USUARIO: {
					this.excluirUsuario();
					break;
					
				}
				default: {
					System.out.println("Opção inválida!");
					break;
				}
			
			}
			
			opcao = this.apresentarOpcoesMenu();
			
		}
		
	}
	

	public UsuarioVO recuperarUsuario() {
		UsuarioVO usuarioVO = new UsuarioVO();
		System.out.println("=======================================================");
		System.out.println("--         Menu Estacionamento  -  Login             --");
		System.out.println("=======================================================");
		System.out.print("Digite o Login: ");
		usuarioVO.setLogin(teclado.nextLine());
		System.out.print("Digite a senha: ");
		usuarioVO.setSenha(teclado.nextLine());
		
		ControladoraUsuario controladoraUsuario = new ControladoraUsuario();
		return controladoraUsuario.recuperarUsuarioController(usuarioVO);
		
	}

	private void atualizarUsuario() {
		UsuarioVO usuarioVO = new UsuarioVO();
		
		System.out.println("=======================================================");
		System.out.println("--    Menu Estacionamento  -  Atualizar Usuário      --");
		System.out.println("=======================================================");
		System.out.print("Informe o id do usuário que deseja atualizar: ");
		usuarioVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
		System.out.print("Infome o novo login: ");
		usuarioVO.setLogin(teclado.nextLine().trim());
		System.out.print("Informe a nova senha: ");
		usuarioVO.setSenha(teclado.nextLine().trim());
		System.out.print("Informe o novo Tipo: ");
		usuarioVO.setTipo(Integer.parseInt(teclado.nextLine()));
		
		
		ControladoraUsuario controladoraUsuario = new ControladoraUsuario();
		controladoraUsuario.atualizarUsuarioController(usuarioVO);
		
	}

	private void excluirUsuario() {
		UsuarioVO usuarioVO = new UsuarioVO();
		System.out.println("=======================================================");
		System.out.println("--    Menu Estacionamento  -  Excluir Usuário        --");
		System.out.println("=======================================================");
		System.out.print("\nInforme o código do usuário: ");
		usuarioVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
		
		ControladoraUsuario controladoraUsuario = new ControladoraUsuario();
		controladoraUsuario.excluirUsuarioController(usuarioVO);
		
	}

	private void consultarUsuario() {

		ControladoraUsuario controladoraUsuario = new ControladoraUsuario();
		
		int opcao = this.apresentarOpcoesConsulta();
			while(opcao != OPCAO_MENU_CONSULTAR_USUARIO_SAIR) {
					switch(opcao) {
						case OPCAO_MENU_CONSULTAR_TODOS_USUARIO: {
							opcao = OPCAO_MENU_CONSULTAR_USUARIO_SAIR;
							ArrayList<UsuarioVO> listaUsuariosVO = controladoraUsuario.consultarTodosUsuariosController();
							
							System.out.print("\n=======================================================");
							System.out.printf("\n%-9s  %-10s  %-15s  \n", "ID", "LOGIN", "TIPO"); // o " - " serve para alinhar a esquerda
							for(int i =0; i < listaUsuariosVO.size(); i ++) {
								listaUsuariosVO.get(i).imprimir(); // o get indica a posição 
							}
							
							break;
						}
						case OPCAO_MENU_CONSULTAR_UM_USUARIO:{
							opcao = OPCAO_MENU_CONSULTAR_USUARIO_SAIR;
							UsuarioVO usuarioVO = new UsuarioVO();
							System.out.print("\nInforme o código do usuário: ");
							usuarioVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
							
							UsuarioVO usuario = controladoraUsuario.consultarUsuarioController(usuarioVO);
							
							System.out.print("\n=======================================================");
							System.out.printf("\n%-9s  %-10s  %-15s  \n", "ID", "LOGIN", "TIPO"); // o " - " serve para alinhar a esquerda
							
							usuario.imprimir();
							
							break;
						}
						default:{
							System.out.println("Opção inválida!");
						}
					}
							opcao = this.apresentarOpcoesConsulta();
							
			}
		
	}

	private int apresentarOpcoesConsulta() {
		System.out.println("=======================================================");
		System.out.println("--            Easy Park - Consultar Usuario          --");
		System.out.println("=======================================================");
		System.out.println(OPCAO_MENU_CONSULTAR_TODOS_USUARIO + " - Consultar todos os usuários");
		System.out.println(OPCAO_MENU_CONSULTAR_UM_USUARIO + "- Consultar um usuário específico");
		System.out.println(OPCAO_MENU_CONSULTAR_USUARIO_SAIR + "- Voltar ");
		System.out.println("-------------------------------------------------------");
		System.out.print("\n Digite a opção: ");
		return Integer.parseInt(teclado.nextLine());
		
		
	}

	private int apresentarOpcoesMenu() {
		System.out.println("=======================================================");
		System.out.println("--               Easy Park - Usuário                 --");
		System.out.println("=======================================================");
		System.out.println(OPCAO_MENU_CONSULTAR_USUARIO + " - Menu consultar usuário");
		System.out.println(OPCAO_MENU_CADASTRAR_USUARIO + " - Menu de cadastrar usuário");
		System.out.println(OPCAO_MENU_ATUALIZAR_USUARIO + " - Menu atualizar usuário");
		System.out.println(OPCAO_MENU_EXCLUIR_USUARIO + " - Menu excluir usuário");
		System.out.println(OPCAO_MENU_USUARIO_SAIR + " - Voltar");
		System.out.println("------------------------------------------------------");
		System.out.print("\nDigite uma opção: ");
		return Integer.parseInt(teclado.nextLine());
	}

	public void cadastrarNovoUsuario() {
		UsuarioVO usuarioVO = new UsuarioVO();
		
		System.out.println("=======================================================");
		System.out.println("--    Menu Estacionamento   - Cadastrar Usuário      --");
		System.out.println("=======================================================");
		
		System.out.println("Cadastre o login: ");
		usuarioVO.setLogin(teclado.nextLine().trim());
		System.out.println("Cadastre a senha: ");
		usuarioVO.setSenha(teclado.nextLine().trim());
		usuarioVO.setTipo(0);
		
		ControladoraUsuario controladoraUsuario = new ControladoraUsuario();
		controladoraUsuario.cadastrarUsuarioController(usuarioVO);
		
		
	}
	
	

}
