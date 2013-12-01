package Logica;
import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;
public class Ejercicio implements Serializable{
	
	private int idEjercicio;
	private String nombreEjercicio;
	private String descripcionEjercicio;
	private int puntajeBase;
	private ImageIcon imagen;
	public Ejercicio(int idEjercicio, String nombreEjercicio,
			String descripcionEjercicio, int puntajeBase, ImageIcon imagen) {
		super();
		this.idEjercicio = idEjercicio;
		this.nombreEjercicio = nombreEjercicio;
		this.descripcionEjercicio = descripcionEjercicio;
		this.puntajeBase = puntajeBase;
		this.imagen = imagen;
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
		return imagen.getImage();
	}
	@Override
	public String toString() {
		return idEjercicio + "-"
				+ nombreEjercicio;
	}
}
