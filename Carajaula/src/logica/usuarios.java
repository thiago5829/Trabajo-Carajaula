package logica;

import java.sql.SQLException;

import persistencia.FiguritaDAO;
import persistencia.UsuarioDAO;

public class usuarios {
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private FiguritaDAO figuritaDAO = new FiguritaDAO();

	// Registra el usuario en la base. Devuelve false si ya existe.
	public boolean agregar_usuario(String usuario, String contra) throws SQLException {
		return usuarioDAO.insertar(usuario, contra);
	}

	// Busca el usuario en la base (con sus figuritas).
	public Usuario buscarUsuario(String usuario) throws SQLException {
		return usuarioDAO.buscar(usuario);
	}

	public boolean validarLogin(String usuario, String contra) throws SQLException {
		Usuario u = buscarUsuario(usuario);
		if (u == null) {
			return false;
		}
		return u.getContraseña().equals(contra);
	}

	// Pega o quita una figurita: actualiza la base y la lista en memoria.
	// Devuelve false si la figurita no existe en el álbum.
	public boolean marcarPegada(Usuario u, int numero, boolean pegada) throws SQLException {
		figurita f = u.getMisFiguritas().buscarFigurita(numero);
		if (f == null) {
			return false;
		}
		figuritaDAO.setPegada(u.getUsuarios(), numero, pegada);
		f.setPegada(pegada);
		return true;
	}
}