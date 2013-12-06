package Logica;
import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;
public class Ejercicio implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idEjercicio;
	private String nombreEjercicio;
	private String descripcionEjercicio;
	private int puntajeBase;
	private String dirImagen;
	public Ejercicio(int idEjercicio, String nombreEjercicio,
			String descripcionEjercicio, int puntajeBase, String dirImagen) {
		super();
		this.idEjercicio = idEjercicio;
		this.nombreEjercicio = nombreEjercicio;
		this.descripcionEjercicio = descripcionEjercicio;
		this.puntajeBase = puntajeBase;
		this.dirImagen = dirImagen;
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
		return new ImageIcon(getClass().getResource(dirImagen)).getImage();
	}
	@Override
	public String toString() {
		return idEjercicio + "-"
				+ nombreEjercicio;
	}
}
