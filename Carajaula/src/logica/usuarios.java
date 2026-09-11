package logica;
import logica.Usuario;
import java.util.ArrayList;
public class usuarios {
	ArrayList<Usuario> Usuarios = new ArrayList<Usuario>();

	public void agregar_usuario(String usuario, String contra ) {
		Usuarios.add(new Usuario(usuario, contra));
	}

	// Busca el usuario en la lista
	public Usuario buscarUsuario(String usuario) {
		for (int i = 0; i < Usuarios.size(); i++) {
			if (Usuarios.get(i).getUsuarios().equals(usuario)) {
				return Usuarios.get(i);
			}
		}
		return null;
	}

	// Revisa si el usuario existe y si la contraseña coincide con la registrada
	public boolean validarLogin(String usuario, String contra) {
		Usuario u = buscarUsuario(usuario);
		if (u == null) {
			return false;
		}
		return u.getContraseña().equals(contra);
	}
}
