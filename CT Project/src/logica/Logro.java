package logica;

public class Logro {
	private int idLogro;
	private String descripcionLogro;
	private int puntajeLogro;
	private int idEjercicio;
	private boolean cumplido;
	public Logro(int idLogro, String descripcionLogro, int puntajeLogro,
			int idEjercicio) {
		super();
		this.idLogro = idLogro;
		this.descripcionLogro = descripcionLogro;
		this.puntajeLogro = puntajeLogro;
		this.idEjercicio = idEjercicio;
	}
	public int getIdLogro() {
		return idLogro;
	}
	public String getDescripcionLogro() {
		return descripcionLogro;
	}
	public int getPuntajeLogro() {
		return puntajeLogro;
	}
	public int getidEjercicio() {
		return idEjercicio;
	}
	public boolean isCumplido() {
		return cumplido;
	}
	public void setCumplido(boolean cumplido) {
		this.cumplido = cumplido;
	}
	@Override
	public String toString() {
		return idLogro + "\n"
				+ descripcionLogro + "\n>" + puntajeLogro
				+ "\n" + idEjercicio + "?" + cumplido;
	} 
}
