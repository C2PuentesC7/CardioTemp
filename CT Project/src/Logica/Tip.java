package Logica;
import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;


public class Tip implements Serializable{
	private int idTip;
	private String descripcionTip;
	private ImageIcon imagen;
	private int idEjercicio;

	public Tip(int idTip, String descripcionTip, ImageIcon imagen,
			int idEjercicio) {
		super();
		this.idTip = idTip;
		this.descripcionTip = descripcionTip;
		this.imagen = imagen;
		this.idEjercicio = idEjercicio;
	}

	public int getidEjercicio() {
		return idEjercicio;
	}

	public int getIdTip() {
		return idTip;
	}
	public String getDescripcionTip() {
		return descripcionTip;
	}
	public Image getImagenTip() {
		return imagen.getImage();
	}
	@Override
	public String toString() {
		return idTip + "-"
				+ "\n" + descripcionTip ;
	}
}
