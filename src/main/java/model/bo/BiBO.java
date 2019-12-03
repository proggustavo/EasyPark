package model.bo;

import java.util.ArrayList;

import model.dao.BiDAO;
import model.dto.Bi;

public class BiBO {

	public ArrayList<Bi> consultarDadosVaga() {
		BiDAO biDAO = new BiDAO();
		return biDAO.consultarDadosVagas();
		
	}

}
