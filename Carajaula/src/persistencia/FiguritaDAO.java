package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FiguritaDAO {

	// pegada = true -> la guarda; false -> la quita
	public void setPegada(String usuario, int numero, boolean pegada) throws SQLException {
		String sql = pegada
				? "INSERT IGNORE INTO usuario_figurita (usuario, numero) VALUES (?, ?)"
				: "DELETE FROM usuario_figurita WHERE usuario = ? AND numero = ?";
		try (Connection con = Conexion.conectar();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, usuario);
			ps.setInt(2, numero);
			ps.executeUpdate();
		}
	}
}