package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static final String URL = "jdbc:mysql://localhost:3306/carajaula?useSSL=false&allowPublicKeyRetrieval=true&characterEncoding=UTF-8";
	private static final String USUARIO = "root";
	private static final String CONTRASENA = "root"; // UniServerZ trae root/root por defecto

	public static Connection conectar() throws SQLException {
		return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
	}
}
