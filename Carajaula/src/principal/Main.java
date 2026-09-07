package principal;

import java.util.Scanner;

import logica.Usuario;
public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		interfaz v1= new interfaz();
		v1.ventanaprincipal();
		System.out.println("1-registrarse 2-Iniciar Sesion");
		int numero = entrada.nextInt();
		if (numero<2) {
			System.out.println("elegiste registrarte");
		}else {
			System.out.println("elegiste iniciar sesion");
		}
	}
	}
