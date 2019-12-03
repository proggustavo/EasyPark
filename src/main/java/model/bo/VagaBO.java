package model.bo;

import java.util.ArrayList;

import model.dao.TicketDAO;
import model.dao.VagaDAO;
import model.vo.TipoVagaVO;
import model.vo.VagaVO;


public class VagaBO {

	public ArrayList<TipoVagaVO> consultarTipoVagas() {
		VagaDAO vagaDAO = new VagaDAO();
		return vagaDAO.consultarTipoVagas();
		
	}

	public int cadastrarVaga(VagaVO vagaVO) {
		VagaDAO vagaDAO = new VagaDAO();
		return vagaDAO.cadastrarVaga(vagaVO);
	}

	public ArrayList<VagaVO> consultarVagas() {
		VagaDAO vagaDAO = new VagaDAO();
		return vagaDAO.consultarVagas();
	}
	
	public VagaVO consultarVagaEspecifica(VagaVO vagaVO) {
		VagaDAO vagaDAO = new VagaDAO();
		return vagaDAO.consultarVagaEspecifica(vagaVO);
	}

	public void atualizarVaga(VagaVO vagaVO) {
		VagaDAO vagaDAO = new VagaDAO();
		if(vagaDAO.existeVaga(vagaVO.getIdVaga())) {
			int resultado = vagaDAO.atualizarVagaDAO(vagaVO);
				if(resultado == 1){
					System.out.println("\nVaga atualizada com Sucesso");
				}else {
					System.out.println("\nNão foi possível atualizar a Vaga");
				}
		}else {
			System.out.println("\nA vaga não existe na base de dados");
		}
	}

	public void excluirVaga(VagaVO vagaVO) {
		VagaDAO vagaDAO = new VagaDAO();
		if(vagaDAO.existeVaga(vagaVO.getIdVaga())){
			int resultado = vagaDAO.excluirVaga(vagaVO);
				if(resultado == 1) {
					System.out.println("\nVaga excluída com Sucesso!");
				}else {
					System.out.println("\nNão foi possível excluir a vaga.");
				}
		}else {
			System.out.println("\nA vaga não existe na base de dados");
		}
		
		
	}

	public void desocuparVaga(VagaVO vagaVO) {
		VagaDAO vagaDAO = new VagaDAO();
		vagaDAO.desocuparVaga(vagaVO);
		
	}

	public void ocuparVaga(VagaVO vagaVO) {
		VagaDAO vagaDAO = new VagaDAO();
		vagaDAO.ocuparVaga(vagaVO);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
