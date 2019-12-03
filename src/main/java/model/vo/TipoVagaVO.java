package model.vo;

public class TipoVagaVO {
	
	
	private String tipo;
	private int quantidade;
	
	
	public TipoVagaVO(String tipo, int quantidade) {
		super();
		this.tipo = tipo;
		this.quantidade = quantidade;
	}


	public TipoVagaVO() {
		super();
		
	}
	
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
	
	
	
	
	
	
	
	

}
