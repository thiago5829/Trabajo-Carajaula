package principal;

import java.util.Scanner;

import logica.Usuario;
public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		interfaz v1= new interfaz();
		interfaz v2= new interfaz();
		v1.ventanaprincipal();
		v2.ventana2();
		System.out.println("1-registrarse 2-Iniciar Sesion");
		int numero = entrada.nextInt();
		if (numero<2) {
			System.out.println("elegiste registrarte");
		}else {
			System.out.println("elegiste iniciar sesion");
		}
	}
	}
