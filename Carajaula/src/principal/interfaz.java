package principal;
import javax.swing.*;
public class interfaz {
	JFrame ventana;
	public interfaz() {
		ventana = new JFrame();
	}
	public void ventanaprincipal() {
		ventana.setTitle("Ingresar");
		ventana.setSize(750,500);
		ventana.setLayout(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}
}
