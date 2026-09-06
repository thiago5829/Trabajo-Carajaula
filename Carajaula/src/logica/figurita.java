package logica;
public class figurita {
	private int numero_figu;
	private String sele;
	private boolean pegada;
	
	public figurita (int numf, String selec) {
		this.pegada=false;
		this.numero_figu=numf;
		this.sele=selec;
	}
	
	public boolean isPegada() {
		return pegada;
	}

	public void setPegada(boolean pegada) {
		this.pegada = pegada;
	}

	public int getNumero_figu() {
		return numero_figu;
	}

	public void setNumero_figu(int numero_figu) {
		this.numero_figu = numero_figu;
	}

	public String getSele() {
		return sele;
	}

	public void setSele(String sele) {
		this.sele = sele;
	}
	
	}
	
