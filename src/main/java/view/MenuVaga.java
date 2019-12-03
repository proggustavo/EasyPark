package view;

import java.util.ArrayList;
import java.util.Scanner;
import controller.ControladoraVaga;
import model.vo.UsuarioVO;
import model.vo.VagaVO;

public class MenuVaga {

	Scanner teclado = new Scanner(System.in);

	private static final int OPCAO_MENU_VAGA_CADASTRAR = 1;
	private static final int OPCAO_MENU_VAGA_CONSULTAR = 2;
	private static final int OPCAO_MEUN_VAGA_ATUALIZAR = 3;
	private static final int OPCAO_MENU_VAGA_OCUPAR = 4;
	private static final int OPCAO_MENU_VAGA_DESOCUPAR = 5;
	private static final int OPCAO_MENU_VAGA_EXCLUIR = 6;
	
	
	private static final int OPCAO_MENU_VAGA_SAIR = 9;

	private static final int OPCAO_MENU_VAGA_CONSULTAR_TODAS = 1;
	private static final int OPCAO_MENU_VAGA_CONSULTAR_ESPECIFICO = 2;
	private static final int OPCAO_MENU_VAGA_CONSULTAR_SAIR = 9;

	public void apresentarMenuVaga(UsuarioVO usuarioVO) {

		int opcao = this.apresentarOpcoesMenuVaga(usuarioVO.getTipo());
		while (opcao != OPCAO_MENU_VAGA_SAIR) {
			switch (opcao) {
			case OPCAO_MENU_VAGA_CADASTRAR: {
				this.cadastrarVaga();
				break;
			}
			case OPCAO_MENU_VAGA_CONSULTAR: {
				this.consultarVagas();
				break;
			}

			case OPCAO_MEUN_VAGA_ATUALIZAR: {
				this.atualizarVaga();
				break;
			}
			case OPCAO_MENU_VAGA_EXCLUIR: {
				this.excluirVaga();
				break;
			}
			case OPCAO_MENU_VAGA_OCUPAR: {
				this.ocuparVaga();
				break;
			}
			case OPCAO_MENU_VAGA_DESOCUPAR: {
				this.desocuparVaga();
				break;
			}			
			default: {
				System.out.println("Opção inválida!");
				break;
			}

			}

			opcao = this.apresentarOpcoesMenuVaga(usuarioVO.getTipo());

		}

	}

	private void desocuparVaga() {
		VagaVO vagaVO = new VagaVO();
		System.out.print("Informe o número da vaga: ");
		vagaVO.setIdVaga(Integer.parseInt(teclado.nextLine()));
		
		ControladoraVaga controladoraVaga = new ControladoraVaga();
		controladoraVaga.desocuparVagaController(vagaVO);

		
	}

	private void ocuparVaga() {
		VagaVO vagaVO = new VagaVO();
		System.out.print("Informe o número da vaga: ");
		vagaVO.setIdVaga(Integer.parseInt(teclado.nextLine()));
		
		ControladoraVaga controladoraVaga = new ControladoraVaga();
		controladoraVaga.ocuparVagaController(vagaVO);
		
	}

	private int apresentarOpcoesMenuVaga(int tipo) {
		System.out.println("=======================================================");
		System.out.println("--               Easy Park - Menu Vaga               --");
		System.out.println("=======================================================");
		System.out.println("[ " + OPCAO_MENU_VAGA_CADASTRAR + " ] - Cadastrar nova Vaga");
		System.out.println("[ " + OPCAO_MENU_VAGA_CONSULTAR + " ] - Consultar Vagas");
		System.out.println("[ " + OPCAO_MEUN_VAGA_ATUALIZAR + " ] - Atualizar Vaga");
		System.out.println("[ " + OPCAO_MENU_VAGA_OCUPAR + " ] - Ocupar Vaga");
		System.out.println("[ " + OPCAO_MENU_VAGA_DESOCUPAR + " ] - Desocupar Vaga");
		System.out.println("[ " + OPCAO_MENU_VAGA_EXCLUIR + " ] - Excluir Vaga");
		System.out.println("[ " + OPCAO_MENU_VAGA_SAIR + " ] - Sair Menu vaga");
		
		System.out.print("Escolha uma opção: ");
		return Integer.parseInt(teclado.nextLine());
	}

	private void excluirVaga() {
		VagaVO vagaVO = new VagaVO();
		
		System.out.print("Informe o código da vaga que deseja excluir: ");
		vagaVO.setIdVaga(Integer.parseInt(teclado.nextLine()));
		
		ControladoraVaga controladoraVaga = new ControladoraVaga();
		controladoraVaga.excluirUsuarioController(vagaVO);

	}

	private void atualizarVaga() {
		VagaVO vagaVO = new VagaVO();
		
		System.out.println("=======================================================");
		System.out.println("--            Easy Park - Atualizar Vaga             --");
		System.out.println("=======================================================");
		
		System.out.print("\nDigite o código da vaga que deseja atualizar: ");
		vagaVO.setIdVaga(Integer.parseInt(teclado.nextLine()));
		System.out.print("\nDigite a distância da vaga: ");
		vagaVO.setDistancia(Double.parseDouble(teclado.nextLine()));
		System.out.print("\nDigite o tipo da vaga: ");
		vagaVO.setTipo(teclado.nextLine().toUpperCase().trim());
		System.out.print("\nDigite a situação: ");
		vagaVO.setSituacao(teclado.nextLine().toUpperCase().trim());
		
		ControladoraVaga controladoraVaga = new ControladoraVaga();
		controladoraVaga.atualizarVaga(vagaVO);
		
	}

	private void consultarVagas() {
		ControladoraVaga controladoraVaga = new ControladoraVaga();

		int opcao = this.apresentarOpcoesConsultaVaga();

		while (opcao != OPCAO_MENU_VAGA_CONSULTAR_SAIR) {

			switch (opcao) {
				case OPCAO_MENU_VAGA_CONSULTAR_TODAS: {
					
					ArrayList<VagaVO> vagas = controladoraVaga.consultarVagas();
	
					System.out.println("=======================================================");
					System.out.println("--              Easy Park - Consultar Vaga           --");
					System.out.println("=======================================================");
					System.out.printf("\n%-9s  %-14s  %-14s  %-15s  \n", "VAGA", "DISTÂNCIA", "TIPO", "SITUAÇÃO");
						for (int i = 0; i < vagas.size(); i++) {
		
							vagas.get(i).imprimir();
						
						}
				 break;
				}
				case OPCAO_MENU_VAGA_CONSULTAR_ESPECIFICO: {
					VagaVO vagaVO = new VagaVO();
	
					System.out.print("Informe o código da vaga: ");
					vagaVO.setIdVaga(Integer.parseInt(teclado.nextLine()));
	
					VagaVO vaga = controladoraVaga.consultarVagaEspecifica(vagaVO);
	
					System.out.printf("\n%-9s  %-14s  %-14s  %-15s  \n", "VAGA", "DISTÂNCIA", "TIPO", "SITUAÇÃO");
					vaga.imprimir();
					
					break;
				}
				default: {
	
					System.out.println("Opção inválida");
					break;
				}
			}
			
			opcao = this.apresentarOpcoesConsultaVaga(); 

		}
	}

	private int apresentarOpcoesConsultaVaga() {
		System.out.println("=======================================================");
		System.out.println("--              Easy Park - Consultar Vaga           --");
		System.out.println("=======================================================");
		System.out.println(OPCAO_MENU_VAGA_CONSULTAR_TODAS + " - Consultar todos");
		System.out.println(OPCAO_MENU_VAGA_CONSULTAR_ESPECIFICO + " - Consultar Vaga específica");
		System.out.println(OPCAO_MENU_VAGA_CONSULTAR_SAIR + " - Voltar");
		System.out.print("Escolha uma opção: ");
		return Integer.parseInt(teclado.nextLine());
	}

	private void cadastrarVaga() {
		VagaVO vagaVO = new VagaVO();

		System.out.println("=======================================================");
		System.out.println("--               Easy Park - Cadastrar Vaga          --");
		System.out.println("=======================================================");

		System.out.print("\nDigite a distância entre e vaga e a entrada do estabelecimento: ");
		vagaVO.setDistancia(Double.parseDouble(teclado.nextLine()));
		System.out.print("\nDigite o tipo de vaga (Normal ou Especial): ");
		vagaVO.setTipo(teclado.nextLine().toUpperCase());

		ControladoraVaga controladoraVaga = new ControladoraVaga();

		int resultado = controladoraVaga.cadastrarVagaController(vagaVO);
		if (resultado != 0) {
			System.out.println("Vaga cadastrada com sucesso!");
		} else {
			System.out.println("A vaga não foi cadastrada.");
		}

	}

}
