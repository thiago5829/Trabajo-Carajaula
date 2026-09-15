package logica;
import logica.figurita;
import java.util.ArrayList;
public class figuritas {
		ArrayList<figurita> listaFiguritas = new ArrayList<figurita>();

		public figuritas() {
			// Carga las figuritas del álbum
			for (int i = 0; i <= 980; i++) {
				listaFiguritas.add(new figurita(i, "Figurita " + i));
			}
		}

		public ArrayList<figurita> getListaFiguritas() {
			return listaFiguritas;
		}

		// Busca una figurita por su número dentro de esta lista
		public figurita buscarFigurita(int numero) {
			for (figurita f : listaFiguritas) {
				if (f.getNumero_figu() == numero) {
					return f;
				}
			}
			return null;
		}
}