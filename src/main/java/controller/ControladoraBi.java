package controller;

import java.util.ArrayList;

import model.bo.BiBO;
import model.dto.Bi;

public class ControladoraBi {

	public ArrayList<Bi> consultarDadosVagas() {
		BiBO biBO = new BiBO();
		return biBO.consultarDadosVaga();
	}

}
