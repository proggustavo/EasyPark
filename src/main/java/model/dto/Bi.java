package model.dto;

public class Bi {
	private int idVaga;
	private String tipo;
	private int tempoEntrada;
	private int tempoSaida;
	
	
	
	
	
	public Bi(int idVaga, String tipo, int tempoEntrada, int tempoSaida) {
		super();
		this.idVaga = idVaga;
		this.tipo = tipo;
		this.tempoEntrada = tempoEntrada;
		this.tempoSaida = tempoSaida;
	}





	public Bi() {
		super();
		// TODO Auto-generated constructor stub
	}





	public int getIdVaga() {
		return idVaga;
	}





	public void setIdVaga(int idVaga) {
		this.idVaga = idVaga;
	}





	public String getTipo() {
		return tipo;
	}





	public void setTipo(String tipo) {
		this.tipo = tipo;
	}





	public int getTempoEntrada() {
		return tempoEntrada;
	}





	public void setTempoEntrada(int tempoEntrada) {
		this.tempoEntrada = tempoEntrada;
	}





	public int getTempoSaida() {
		return tempoSaida;
	}





	public void setTempoSaida(int tempoSaida) {
		this.tempoSaida = tempoSaida;
	}





	public void imprimir() {
		System.out.printf("%-10s %-14s %-35s %-15s \n",
				+ this.getIdVaga(),
				this.getTipo(),
				this.getTempoEntrada(),
				this.getTempoSaida());
		
	}
		
	


}
