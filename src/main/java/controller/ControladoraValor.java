package controller;

import model.bo.ValorBO;
import model.vo.ValorVO;

public class ControladoraValor {

	public ValorVO consultarValor() {
		ValorBO valorBO = new ValorBO();
		return valorBO.consultarValor();
	}

}
