package model.bo;

import model.dao.ValorDAO;
import model.vo.ValorVO;

public class ValorBO {

	public ValorVO consultarValor() {
		ValorDAO valorDAO = new ValorDAO();
		return valorDAO.consultarValor();
	}

}
