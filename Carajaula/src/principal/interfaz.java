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
import java.sql.SQLException;

public class interfaz {
	JFrame ventana;
	usuarios listaUsuarios = new usuarios();

	public interfaz() {
		ventana = new JFrame();
	}

	public void ventanaprincipal(boolean visible) {
		ventana.getContentPane().removeAll();
		ventana.revalidate();
		ventana.repaint();
		// Ventana
		ventana.setTitle("Gestion de figuritas");
		ventana.setSize(750, 500);
		ventana.setLayout(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		// Imagen
		ImageIcon imagenOriginal = new ImageIcon(getClass().getResource("/img/logoCara.png"));
		Image imagenEscalada = imagenOriginal.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
		ImageIcon imagenFinal = new ImageIcon(imagenEscalada);
		JLabel etiquetaLogo = new JLabel(imagenFinal);
		etiquetaLogo.setBounds(305, 50, 75, 75);
		ventana.add(etiquetaLogo);
		// Titulo
		JLabel iniciasion = new JLabel("Antes de empezar Registrate o Inicia Sesión");
		iniciasion.setBounds(225, 125, 270, 20);
		ventana.add(iniciasion);
		JLabel titulo = new JLabel("GESTIÓN DE FIGURITAS");
		titulo.setBounds(285, 25, 150, 20);
		ventana.add(titulo);
		// Subtitulo
		JLabel UsuarioText = new JLabel("Usuario:");
		UsuarioText.setBounds(217, 189, 100, 20);
		ventana.add(UsuarioText);
		JLabel ContraText = new JLabel("Contraseña:");
		ContraText.setBounds(217, 250, 100, 20);
		ventana.add(ContraText);
		// Campos de texto
		JTextField zonausuario = new JTextField();
		zonausuario.setBounds(215, 215, 200, 30);
		ventana.add(zonausuario);
		JTextField zonacontra = new JTextField();
		zonacontra.setBounds(215, 275, 200, 30);
		ventana.add(zonacontra);
		// Boton iniciar sesion
		JButton iniciar_sesion = new JButton("Iniciar Sesión");
		iniciar_sesion.setBounds(375, 350, 115, 25);
		ventana.add(iniciar_sesion);
		iniciar_sesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = zonausuario.getText();
				String contra = zonacontra.getText();
				// Buscar usuario y contraseña en la base
				Usuario u;
				try {
					u = listaUsuarios.buscarUsuario(usuario);
				} catch (SQLException ex) {
					errorBD(iniciar_sesion, ex);
					return;
				}
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
		// Boton registro
		JButton registrarse = new JButton("Registrarse");
		registrarse.setBounds(215, 350, 110, 25);
		ventana.add(registrarse);
		registrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = zonausuario.getText();
				String contra = zonacontra.getText();
				if (contra.length() < 8) {
					JOptionPane.showMessageDialog(registrarse, "La contraseña debe tener al menos 8 caracteres");
					return;
				}
				if (usuario.trim().isEmpty()) {
					JOptionPane.showMessageDialog(registrarse, "Ingresá un nombre de usuario");
					return;
				}
				try {
					if (listaUsuarios.agregar_usuario(usuario, contra)) {
						JOptionPane.showMessageDialog(registrarse, "Usuario registrado con éxito");
					} else {
						JOptionPane.showMessageDialog(registrarse, "Ese usuario ya existe");
					}
				} catch (SQLException ex) {
					errorBD(registrarse, ex);
				}
			}
		});
		ventana.setVisible(visible);
	}

	public void ventana2(boolean visible, usuarios listaUsuarios, Usuario usuarioActivo) {
		ventana.getContentPane().removeAll();
		ventana.revalidate();
		ventana.repaint();
		// Ventana
		ventana.setTitle("Opciones");
		ventana.setSize(750, 500);
		ventana.setLayout(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(visible);
		// Imagen
		ImageIcon imagenOriginal = new ImageIcon(getClass().getResource("/img/AlbumMafia.png"));
		Image imagenEscalada = imagenOriginal.getImage().getScaledInstance(350, 300, Image.SCALE_SMOOTH);
		ImageIcon imagenFinal = new ImageIcon(imagenEscalada);
		JLabel etiquetaLogo = new JLabel(imagenFinal);
		etiquetaLogo.setBounds(325, 100, 350, 300);
		ventana.add(etiquetaLogo);
		// Encabezados
		String[] columnas = { "Número figurita", "Estado" };
		// Titulo
		JLabel titulo = new JLabel("ELIGE UNA OPCIÓN");
		titulo.setBounds(285, 25, 400, 100);
		ventana.add(titulo);
		// Botones
		JButton quefigurita = new JButton("¿QUE FIGURITA TENGO?");
		quefigurita.setBounds(75, 150, 175, 25);
		ventana.add(quefigurita);
		quefigurita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<figurita> figus = usuarioActivo.getMisFiguritas().getListaFiguritas();
				String[][] datos = new String[figus.size()][2];
				for (int i = 0; i < figus.size(); i++) {
					figurita f = figus.get(i);
					datos[i][0] = String.valueOf(f.getNumero_figu());
					datos[i][1] = f.isPegada() ? "Pegada" : "No pegada";
				}
				JTable tabla = new JTable(datos, columnas);
				JScrollPane panel = new JScrollPane(tabla);
				JOptionPane.showMessageDialog(quefigurita, panel);
			}
		});
		JButton agregarfigu = new JButton("AGREGAR FIGURITA");
		agregarfigu.setBounds(75, 250, 175, 25);
		ventana.add(agregarfigu);
		agregarfigu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = JOptionPane.showInputDialog(agregarfigu, "Número de figurita que pegaste:");
				if (input == null) return; // el usuario canceló
				try {
					int numero = Integer.parseInt(input.trim());
					if (!listaUsuarios.marcarPegada(usuarioActivo, numero, true)) {
						JOptionPane.showMessageDialog(agregarfigu, "No existe la figurita " + numero);
					} else {
						JOptionPane.showMessageDialog(agregarfigu, "Figurita " + numero + " marcada pegada");
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(agregarfigu, "Ingresá un número válido");
				} catch (SQLException ex) {
					errorBD(agregarfigu, ex);
				}
			}
		});
		JButton quitarfigu = new JButton("QUITAR FIGURITA");
		quitarfigu.setBounds(75, 350, 175, 25);
		ventana.add(quitarfigu);
		quitarfigu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = JOptionPane.showInputDialog(quitarfigu, "Número de figurita a quitar:");
				if (input == null) return; // el usuario canceló
				try {
					int numero = Integer.parseInt(input.trim());
					if (!listaUsuarios.marcarPegada(usuarioActivo, numero, false)) {
						JOptionPane.showMessageDialog(quitarfigu, "No existe la figurita " + numero);
					} else {
						JOptionPane.showMessageDialog(quitarfigu, "Figurita " + numero + " marcada como no pegada");
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(quitarfigu, "Ingresá un número válido");
				} catch (SQLException ex) {
					errorBD(quitarfigu, ex);
				}
			}
		});
		JButton cerrarsesion = new JButton("Cerrar Sesión");
		cerrarsesion.setBounds(600, 400, 120, 25);
		ventana.add(cerrarsesion);
		cerrarsesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.setVisible(false);
				ventanaprincipal(true);
			}
		});
	}

	// Mensaje cuando falla la conexión o una consulta
	private void errorBD(java.awt.Component padre, SQLException ex) {
		ex.printStackTrace();
		JOptionPane.showMessageDialog(padre, "No se pudo acceder a la base de datos.\n¿Está prendido MySQL en UniServerZ?\n\n" + ex.getMessage());
	}
}