package logica;
import logica.figurita;
import java.util.ArrayList;
public class figuritas {
		ArrayList<figurita> listaFiguritas = new ArrayList<figurita>();

		public figuritas() {
			// Carga las figuritas del álbum (de la 0 a la 980), todas sin pegar al inicio
			for (int i = 0; i <= 980; i++) {
				listaFiguritas.add(new figurita(i, "Figurita " + i));
			}
		}

		public ArrayList<figurita> getListaFiguritas() {
			return listaFiguritas;
		}
}