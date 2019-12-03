package view;

import java.util.ArrayList;
import java.util.Scanner;
import controller.ControladoraBi;
import model.dto.Bi;

public class MenuBI {
	
	Scanner teclado = new Scanner(System.in);
	
	public static final int OPCAO_MENU_BI_ATUALIZAR = 1;
	public static final int OPCAO_MENU_BI_SAIR = 9;

	public void apresentarMenu() {
		int opcao = this.apresentarOpcaoMenu();
		
		while(opcao != OPCAO_MENU_BI_SAIR ) {
			switch(opcao) {
				case OPCAO_MENU_BI_ATUALIZAR: {
					this.apresentarOpcaoMenu();
					break;
				}
				default: {
					System.out.println("Opção inválida!");
				break;
				}
			}
			
			opcao = this.apresentarOpcaoMenu();
		}
		
		
		
	}

	private int apresentarOpcaoMenu() {
		ControladoraBi controladoraBi = new ControladoraBi();
		
		System.out.println("=======================================================");
		System.out.println("--                  Easy Park - BI                   --");
		System.out.println("=======================================================");
		ArrayList<Bi> bi = controladoraBi.consultarDadosVagas();
		System.out.printf("\n%-10s %-14s %-34s %-14s \n", "VAGA", "TIPO " , "TEMPO MÉDIO ENTRADA NA VAGA", "TEMPO MÉDIO SAÍDA DA VAGA" );
			for(int i = 0; i < bi.size(); i ++) {
				bi.get(i).imprimir();
			}
		System.out.println("=======================================================");
		System.out.println(OPCAO_MENU_BI_ATUALIZAR + "- Atualizar");
		System.out.println(OPCAO_MENU_BI_SAIR + " - Voltar");
		System.out.print("Escolha uma opção: ");
		return Integer.parseInt(teclado.nextLine());
		
	}
	
}
