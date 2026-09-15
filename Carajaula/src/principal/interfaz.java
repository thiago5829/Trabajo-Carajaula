package principal;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import logica.usuarios;
import logica.Usuario;
import logica.figuritas;
import logica.figurita;
import java.util.ArrayList;
import java.awt.Image;
public class interfaz {
	JFrame ventana;
	usuarios listaUsuarios = new usuarios();
	figuritas listaFiguritas = new figuritas();
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
		zonausuario.setBounds(215,215,200,30);
		ventana.add(zonausuario);
		JTextField zonacontra = new JTextField();
		zonacontra.setBounds(215,275,200,30);
		ventana.add(zonacontra);
		//Boton iniciar sesion
		JButton iniciar_sesion = new JButton ("Iniciar Sesión");
		iniciar_sesion.setBounds(375,350,115,25);
		ventana.add(iniciar_sesion);
		iniciar_sesion.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				String usuario = zonausuario.getText();
				String contra = zonacontra.getText();
			//Buscar usuario y contraseña en el Array de Usuario
				Usuario u = listaUsuarios.buscarUsuario(usuario);
				if (u == null) {
					JOptionPane.showMessageDialog(iniciar_sesion, "Usuario no registrado");
				} else if (!u.getContraseña().equals(contra)) {
					JOptionPane.showMessageDialog(iniciar_sesion, "Contraseña no valida");
				} else {
				    ventana.setVisible(false);
				    ventana2(true, listaUsuarios, u);
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
					listaUsuarios.agregar_usuario(usuario, contra);
					JOptionPane.showMessageDialog(registrarse, "Usuario registrado con éxito");
		}
	});
			ventana.setVisible(true);
	}
	public void ventana2(boolean visible, usuarios listaUsuarios, Usuario usuarioActivo) {
		ventana.getContentPane().removeAll();
	    ventana.revalidate();
	    ventana.repaint();
		//Ventana
		ventana.setTitle("Opciones");
		ventana.setSize(750,500);
		ventana.setLayout(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(visible);
		//Imagen
		ImageIcon imagenOriginal = new ImageIcon(getClass().getResource("/img/AlbumMafia.png"));
		Image imagenEscalada = imagenOriginal.getImage().getScaledInstance(350, 300, Image.SCALE_SMOOTH);
		ImageIcon imagenFinal = new ImageIcon(imagenEscalada);
		JLabel etiquetaLogo = new JLabel(imagenFinal);
		etiquetaLogo.setBounds(325, 100, 350, 300);
		ventana.add(etiquetaLogo);
		//Encabezados
	    String []columnas= {"Número figurita","Estado"};
		//Titulo
		JLabel titulo = new JLabel("ELIGE UNA OPCIÓN");
		titulo.setBounds(285,25,400,100);
		ventana.add(titulo);
		//Botones
		JButton quefigurita = new JButton ("¿QUE FIGURITA TENGO?");
		quefigurita.setBounds(75,150,175,25);
		ventana.add(quefigurita);
		quefigurita.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				//Datos: se arman a partir del ArrayList de figuritas
				ArrayList<figurita> figus = listaFiguritas.getListaFiguritas();
				String [][]datos= new String[figus.size()][2];
				for (int i = 0; i < figus.size(); i++) {
					figurita f = figus.get(i);
					datos[i][0] = String.valueOf(f.getNumero_figu());
					datos[i][1] = f.isPegada() ? "Pegada" : "No pegada";
				}
				JTable tabla = new JTable(datos,columnas);
				JScrollPane panel = new JScrollPane(tabla);
				JOptionPane.showMessageDialog(quefigurita, panel);
			}
	});
		JButton agregarfigu = new JButton ("AGREGAR FIGURITA");
		agregarfigu.setBounds(75,250,175,25);
		ventana.add(agregarfigu);
		JButton quitarfigu = new JButton ("QUITAR FIGURITA");
		quitarfigu.setBounds(75,350,175,25);
		ventana.add(quitarfigu);
	}
}