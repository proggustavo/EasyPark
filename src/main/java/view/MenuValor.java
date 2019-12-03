package view;

import java.util.Scanner;

import controller.ControladoraValor;
import model.vo.UsuarioVO;
import model.vo.ValorVO;

public class MenuValor {
	
	Scanner teclado = new Scanner (System.in);

	private static final int OPCAO_CONSULTAR_VALOR = 1;
	private static final int OPCAO_ATUALIZAR_VALOR = 2;
	private static final int OPCAO_SAIR = 9;

	public void apresentarMenuValor(UsuarioVO usuarioVO) {
		int opcao = this.apresentarOpcoesMenuValor();
		while (opcao != OPCAO_SAIR) {
			switch (opcao) {
				case OPCAO_CONSULTAR_VALOR: {
					this.consultarValor();
					break;
				}
				case OPCAO_ATUALIZAR_VALOR: {
					this.atualizarValor();
					break;
				}
				default: {
					System.out.println("Opção inválida!");
					;
					break;
				}
			}

			 opcao = this.apresentarOpcoesMenuValor();
		}
	}

	private void atualizarValor() {
		// TODO Auto-generated method stub
		
	}

	private void consultarValor() {
		ValorVO valor = new ValorVO();
		ControladoraValor controladoraValor = new ControladoraValor();
		valor = controladoraValor.consultarValor();
		System.out.print("\n--------- RESULTADO DA CONSULTA ----------");
		System.out.printf("\n%-15s  %-15s  \n", "Primeira Hora", "Valor por hora"); // o " - " serve para alinhar a esquerda
		
		valor.imprimir();
		
		
	}

	private int apresentarOpcoesMenuValor() {
		System.out.println("=======================================================");
		System.out.println("--             Easy Park - Menu Valor               --");
		System.out.println("=======================================================");
		System.out.println("[ " + OPCAO_CONSULTAR_VALOR + " ] - Consultar Valor");
		System.out.println("[ " + OPCAO_ATUALIZAR_VALOR + " ] - Atualizar valor");
		System.out.println("[ " + OPCAO_SAIR + " ] - Voltar");
		System.out.println("-----------------------------------------");
		System.out.print("Escolha uma opção: ");
		return Integer.parseInt(teclado.nextLine());
	}

}
