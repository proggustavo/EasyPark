package model.vo;

public class VagaVO {
	private int idVaga;
	private double distancia; 
	private String tipo;
	private String situacao;
	
	
	
	public VagaVO(int idVaga, double distancia, String tipo, String situacao) {
		super();
		this.idVaga = idVaga;
		this.distancia = distancia;
		this.tipo = tipo;
		this.situacao = situacao;
	}

	public VagaVO() {
		super();
		
	}
	
	public int getIdVaga() {
		return idVaga;
	}
	public void setIdVaga(int idVaga) {
		this.idVaga = idVaga;
	}
	public double getDistancia() {
		return distancia;
	}
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public void imprimir() {
		System.out.printf("%-10s %-15s %-15s %-15s\n",
				+ this.getIdVaga(),
				this.getDistancia(),
				this.getTipo(),
				this.getSituacao());
		
	}

	

}
