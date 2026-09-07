package principal;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import logica.usuarios;
import java.awt.Image;
public class interfaz {
	JFrame ventana;
	public interfaz() {
		ventana = new JFrame();
	}
	public void ventanaprincipal() {
		//Ventana
		ventana.setTitle("Gestion de figuritas");
		ventana.setSize(750,500);
		ventana.setLayout(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		//Imagen
		ImageIcon imagenOriginal = new ImageIcon(getClass().getResource("/img/logoCara.png"));
		Image imagenEscalada = imagenOriginal.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
		ImageIcon imagenFinal = new ImageIcon(imagenEscalada);
		JLabel etiquetaLogo = new JLabel(imagenFinal);
		etiquetaLogo.setBounds(305, 50, 75, 75);
		ventana.add(etiquetaLogo);
		//Titulo
		JLabel iniciasion = new JLabel("Antes de empezar Registrate o Inicia Sesión");
		iniciasion.setBounds(225,125,270,20);
		ventana.add(iniciasion);
		JLabel titulo = new JLabel("GESTIÓN DE FIGURITAS");
		titulo.setBounds(285,25,150,20);
		ventana.add(titulo);
		//subtitulo 
		JLabel UsuarioText = new JLabel ("Usuario:");
		UsuarioText.setBounds(217, 189, 100, 20);
		ventana.add(UsuarioText);
		JLabel ContraText = new JLabel ("Contraseña:");
		ContraText.setBounds(217, 250, 100, 20);
		ventana.add(ContraText);
		//Campo de texto Usuario
		JTextField zonausuario = new JTextField();
		zonausuario.setBounds(215,215,150,30);
		ventana.add(zonausuario);
		JTextField zonacontra = new JTextField();
		zonacontra.setBounds(215,275,150,30);
		ventana.add(zonacontra);
		//Boton iniciar sesion
		JButton iniciar_sesion = new JButton ("Iniciar Sesión");
		iniciar_sesion.setBounds(375,350,115,25);
		ventana.add(iniciar_sesion);
		iniciar_sesion.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				String usuario = zonausuario.getText();
				String contra = zonacontra.getText();
				System.out.println("El usuario es: "+ usuario);
				System.out.println("La contra es: "+ contra);
				if (usuario.equals("Juan")) {
					if (contra.equals("pepito123")){
						ventana.setVisible(false);
						interfaz nuevaVentana = new interfaz();
						nuevaVentana.ventana2(true);
					}else {
						JOptionPane.showMessageDialog(iniciar_sesion, "Contraseña no valida");
					}
				}else {
					JOptionPane.showMessageDialog(iniciar_sesion, "Usuario no registrado");
				}
		}
	});
		//Boton registro
			JButton registrarse = new JButton ("Registrarse");
			registrarse.setBounds(215,350,110,25);
			ventana.add(registrarse);
			registrarse.addActionListener(new ActionListener() {
				public void actionPerformed (ActionEvent e) {
					String usuario = zonausuario.getText();
					String contra = zonacontra.getText();
					System.out.println("El usuario es: "+ usuario);
					System.out.println("La contra es: "+ contra);
				//if
		}
	});
			ventana.setVisible(true);
	}
	public void ventana2(boolean visible){
		//Ventana
		ventana.setTitle("Opciones");
		ventana.setSize(750,500);
		ventana.setLayout(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(visible);
		//Titulo
		JLabel titulo = new JLabel("ELIGE UNA OPCIÓN");
		titulo.setBounds(285,25,400,100);
		ventana.add(titulo);
		//Botones
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
