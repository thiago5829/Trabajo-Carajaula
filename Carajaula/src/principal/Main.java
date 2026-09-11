package principal;
import java.util.Scanner;
import logica.usuarios;
public class Main {
	public static void main(String[] args) {
		usuarios listaUsuarios = new usuarios();
		listaUsuarios.agregar_usuario("Thiago", "Admin123");
		Scanner entrada = new Scanner(System.in);
		interfaz v1= new interfaz();
		v1.ventanaprincipal();
		}
	}
