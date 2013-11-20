package Logica;
import java.awt.Image;


public class Tip {
	private int idTip;
	private String descripcionTip;
	private Image imagenTip;
	private int idEjercicio;

	public Tip(int idTip, String descripcionTip, Image imagenTip,
			int idEjercicio) {
		super();
		this.idTip = idTip;
		this.descripcionTip = descripcionTip;
		this.imagenTip = imagenTip;
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
		return imagenTip;
	}
	@Override
	public String toString() {
		return idTip + "-"
				+ "\n" + descripcionTip ;
	}
}
