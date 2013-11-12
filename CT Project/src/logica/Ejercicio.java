package logica;
import java.awt.Image;


public class Ejercicio {
	
	private int idEjercicio;
	private String nombreEjercicio;
	private String descripcionEjercicio;
	private int puntajeBase;
	private Image imagenEjercicio;
	public Ejercicio(int idEjercicio, String nombreEjercicio,
		   String descripcionEjercicio, int puntajeBase, Image imagenEjercicio) {
		super();
		this.idEjercicio = idEjercicio;
		this.nombreEjercicio = nombreEjercicio;
		this.descripcionEjercicio = descripcionEjercicio;
		this.puntajeBase = puntajeBase;
		this.imagenEjercicio = imagenEjercicio;
	}
	
	public int getIdEjercicio() {
		return idEjercicio;
	}
	
	public String getNombreEjercicio() {
		return nombreEjercicio;
	}
	
	public String getDescripcionEjercicio() {
		return descripcionEjercicio;
	}
	
	public int getPuntajeBase() {
		return puntajeBase;
	}
	
	public Image getImagenEjercicio() {
		return imagenEjercicio;
	}
	
	@Override
	public String toString() {
		return idEjercicio + "-"
				+ nombreEjercicio + "\n"
				+ descripcionEjercicio + "\n>" + puntajeBase;
	}
}
