package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import logica.Usuario;
import logica.figurita;

public class UsuarioDAO {

	// Devuelve el usuario con sus figuritas pegadas, o null si no existe
	public Usuario buscar(String nombre) throws SQLException {
		String sql = "SELECT nombre, contrasena FROM usuarios WHERE nombre = ?";
		try (Connection con = Conexion.conectar();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, nombre);
			try (ResultSet rs = ps.executeQuery()) {
				if (!rs.next()) {
					return null;
				}
				Usuario u = new Usuario(rs.getString("nombre"), rs.getString("contrasena"));
				cargarPegadas(con, u);
				return u;
			}
		}
	}

	// Inserta un usuario nuevo. Devuelve false si ya existía.
	public boolean insertar(String nombre, String contra) throws SQLException {
		String sql = "INSERT INTO usuarios (nombre, contrasena) VALUES (?, ?)";
		try (Connection con = Conexion.conectar();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, nombre);
			ps.setString(2, contra);
			ps.executeUpdate();
			return true;
		} catch (SQLIntegrityConstraintViolationException e) {
			return false; // ya existe
		}
	}

	// Marca como pegadas las figuritas que el usuario tiene guardadas
	private void cargarPegadas(Connection con, Usuario u) throws SQLException {
		String sql = "SELECT numero FROM usuario_figurita WHERE usuario = ?";
		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, u.getUsuarios());
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					figurita f = u.getMisFiguritas().buscarFigurita(rs.getInt("numero"));
					if (f != null) {
						f.setPegada(true);
					}
				}
			}
		}
	}
}