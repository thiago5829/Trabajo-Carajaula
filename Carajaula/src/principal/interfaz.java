package principal;
import javax.swing.*;
public class interfaz {
	JFrame ventana;
	
	public interfaz() {
		ventana = new JFrame();
	}
	public void ventanaprincipal() {
		ventana.setTitle("Gestion de figuritas");
		ventana.setSize(750,500);
		ventana.setLayout(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	JLabel titulo = new JLabel("Antes de empezar Registrate o Inicia Sesión");
	titulo.setBounds(235,50,400,100);
	ventana.add(titulo);
	JButton iniciar_sesion = new JButton ("Iniciar Sesión");
	iniciar_sesion.setBounds(375,250,150,25);
	ventana.add(iniciar_sesion);
	JButton registrarse = new JButton ("Registrarse");
	registrarse.setBounds(215,250,125,25);
	ventana.add(registrarse);
	}
}	
