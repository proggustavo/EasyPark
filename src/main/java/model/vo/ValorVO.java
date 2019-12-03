package model.vo;

public class ValorVO {
	private double valorPrimeiraHora;
	private double valorHora;
	
	public ValorVO(double valorPrimeiraHora, double valorHora) {
		super();
		this.valorPrimeiraHora = valorPrimeiraHora;
		this.valorHora = valorHora;
	}
	public ValorVO() {
		super();
		
	}
	public double getValorPrimeiraHora() {
		return valorPrimeiraHora;
	}
	public void setValorPrimeiraHora(double valorPrimeiraHora) {
		this.valorPrimeiraHora = valorPrimeiraHora;
	}
	public double getValorHora() {
		return valorHora;
	}
	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}
	public void imprimir() {
		System.out.printf("%-16s %-12s \n",
						+ this.getValorPrimeiraHora(),
						this.getValorHora());
		
	}
	
	
	
	
	
}
