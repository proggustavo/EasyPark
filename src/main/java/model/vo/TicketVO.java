package model.vo;

public class TicketVO {
	private int idTicket;
	private int idVaga;
	private String dtEmissao;
	private String dtEntrada;
	private String dtPagamento;
	private String dtSaida;
	private String dtFinalizado;
	private double valor;
	private String tipo;
	
	
	public TicketVO(int idTicket, int idVaga, String dtEmissao, String dtEntrada, String dtPagamento, String dtSaida,
			String dtFinalizado, double valor, String tipo) {
		super();
		this.idTicket = idTicket;
		this.idVaga = idVaga;
		this.dtEmissao = dtEmissao;
		this.dtEntrada = dtEntrada;
		this.dtPagamento = dtPagamento;
		this.dtSaida = dtSaida;
		this.dtFinalizado = dtFinalizado;
		this.valor = valor;
		this.tipo = tipo;
	}
	
	public TicketVO() {
		super();
		
	}
	
	public int getIdTicket() {
		return idTicket;
	}
	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}
	public int getIdVaga() {
		return idVaga;
	}
	public void setIdVaga(int idVaga) {
		this.idVaga = idVaga;
	}
	public String getDtEmissao() {
		return dtEmissao;
	}
	public void setDtEmissao(String dtEmissao) {
		this.dtEmissao = dtEmissao;
	}
	public String getDtEntrada() {
		return dtEntrada;
	}
	public void setDtEntrada(String dtEntrada) {
		this.dtEntrada = dtEntrada;
	}
	public String getDtPagamento() {
		return dtPagamento;
	}
	public void setDtPagamento(String dtPagamento) {
		this.dtPagamento = dtPagamento;
	}
	public String getDtSaida() {
		return dtSaida;
	}
	public void setDtSaida(String dtSaida) {
		this.dtSaida = dtSaida;
	}
	public String getDtFinalizado() {
		return dtFinalizado;
	}
	public void setDtFinalizado(String dtFinalizado) {
		this.dtFinalizado = dtFinalizado;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void emitirTicket() {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
}
