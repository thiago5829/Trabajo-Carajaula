package logica;

public class Usuario {
	private String nomusuarios;
	private String contraseña;
	private figuritas misFiguritas;

	public Usuario (String user, String contra) {
		this.nomusuarios=user;
		this.contraseña=contra;
		this.misFiguritas = new figuritas(); // cada usuario arranca con su propio álbum
	}

	public figuritas getMisFiguritas() {
		return misFiguritas;
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