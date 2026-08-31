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
	JLabel iniciasion = new JLabel("Antes de empezar Registrate o Inicia Sesión");
	iniciasion.setBounds(235,110,400,100);
	ventana.add(iniciasion);
	JLabel titulo = new JLabel("GESTIÓN DE FIGURITAS");
	titulo.setBounds(285,25,400,100);
	ventana.add(titulo);
	JButton iniciar_sesion = new JButton ("Iniciar Sesión");
	iniciar_sesion.setBounds(375,350,150,25);
	ventana.add(iniciar_sesion);
	JButton registrarse = new JButton ("Registrarse");
	registrarse.setBounds(215,350,125,25);
	ventana.add(registrarse);
	
	}
	public void ventana2() {
		ventana.setTitle("Opciones");
		ventana.setSize(750,500);
		ventana.setLayout(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		JLabel titulo = new JLabel("ELIGE UNA OPCIÓN");
		titulo.setBounds(285,25,400,100);
		ventana.add(titulo);
		JRadioButton op1 = new JRadioButton ("¿Que figuritas tengo?", true);
		op1.setBounds(50, 125, 200, 50);
		ventana.add(op1);
		op1.addActionListener(e->{
			System.out.println("elgiste ver tus figuritas");
		});
		JRadioButton op2 = new JRadioButton ("Agregar figurita", true);
		op2.setBounds(50, 175, 200, 50);
		ventana.add(op2);
		op2.addActionListener(e->{
			System.out.println("elgiste agregar una figurita");
		});
	}
}	
