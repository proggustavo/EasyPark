package controller;

import java.util.ArrayList;

import model.bo.VagaBO;
import model.vo.TipoVagaVO;
import model.vo.VagaVO;


public class ControladoraVaga {

	public ArrayList<TipoVagaVO> consultarTipoVagas() {
		VagaBO vagaBO = new VagaBO();
		return vagaBO.consultarTipoVagas();
	}

	public int cadastrarVagaController(VagaVO vagaVO) {
		VagaBO vagaBO = new VagaBO();
		return vagaBO.cadastrarVaga(vagaVO);
	}

	public ArrayList<VagaVO> consultarVagas() {
		VagaBO vagaBO = new VagaBO();
		return vagaBO.consultarVagas();
	}

	public VagaVO consultarVagaEspecifica(VagaVO vagaVO) {
		VagaBO vagaBO = new VagaBO();
		return vagaBO.consultarVagaEspecifica(vagaVO);
	}

	public void atualizarVaga(VagaVO vagaVO) {
		VagaBO vagaBO = new VagaBO();
		vagaBO.atualizarVaga(vagaVO);

	}

	public void excluirUsuarioController(VagaVO vagaVO) {
		VagaBO vagaBO = new VagaBO();
		vagaBO.excluirVaga(vagaVO);
		
	}

	public void desocuparVagaController(VagaVO vagaVO) {
		VagaBO vagaBO = new VagaBO();
		vagaBO.desocuparVaga(vagaVO);
		
	}

	public void ocuparVagaController(VagaVO vagaVO) {
		VagaBO vagaBO = new VagaBO();
		vagaBO.ocuparVaga(vagaVO);
		
	}

}
