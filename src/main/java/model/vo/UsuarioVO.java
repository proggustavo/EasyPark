package model.vo;

public class UsuarioVO {
	
	private int idUsuario;
	private String login;
	private String senha;
	private int tipo;
	
	
	
	
	public UsuarioVO(int idUsuario, String login, String senha, int tipo) {
		super();
		this.idUsuario = idUsuario;
		this.login = login;
		this.senha = senha;
		this.tipo = tipo;
	}
	public UsuarioVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public void imprimir() {
		System.out.printf("%-10s %-12s %-15s\n",
						+ this.getIdUsuario(),
						this.getLogin(),
						this.getTipo());
		
	}
	
	
	
	

}
