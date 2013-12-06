package Logica;
import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;


public class Tip implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idTip;
	private String descripcionTip;
	private String dirImagen;
	private String tipoTip;
	public Tip(int idTip, String tipoTip,String descripcionTip, String dirImagen) {
		super();
		this.idTip = idTip;
		this.tipoTip = tipoTip;
		this.descripcionTip = descripcionTip;
		this.dirImagen = dirImagen;
	}

	public int getIdTip() {
		return idTip;
	}
	public String getDescripcionTip() {
		return descripcionTip;
	}
	
	public String getTipoTip() {
		return tipoTip;
	}
	public Image getImagenTip() {
		return new ImageIcon(getClass().getResource(dirImagen)).getImage();
	}
	@Override
	public String toString() {
		return idTip + "-"
				+tipoTip + "\n" + descripcionTip ;
	}
}
