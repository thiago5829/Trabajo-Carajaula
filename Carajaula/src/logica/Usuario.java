package logica;

public class Usuario {
	private char nomusuarios;
	private char contraseña;
	public Usuario (char user, char contra) {
		this.nomusuarios=user;
		this.contraseña=contra;
	}
	public char getUsuarios() {
		return nomusuarios;
	}
	public void setUsuarios(char usuarios) {
		this.nomusuarios = usuarios;
	}
	public char getContraseña() {
		return contraseña;
	}
	public void setContraseña(char contraseña) {
		this.contraseña = contraseña;
	}
	
}
