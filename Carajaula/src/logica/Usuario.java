package logica;

public class Usuario {
	private String nomusuarios;
	private String contraseña;
	public Usuario (String user, String contra) {
		this.nomusuarios=user;
		this.contraseña=contra;
	}
	public String getUsuarios() {
		return nomusuarios;
	}
	public void setUsuarios(String usuarios) {
		this.nomusuarios = usuarios;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
}
