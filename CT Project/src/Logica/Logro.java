package Logica;

import java.io.Serializable;

public class Logro implements Serializable{
	private int idLogro;
	private String descripcionLogro;
	private int puntajeLogro;
	private Ejercicio ejercicio;
	private boolean cumplido;
	public Logro(int idLogro, String descripcionLogro, int puntajeLogro, Ejercicio ejercicio) {
		super();
		this.idLogro = idLogro;
		this.descripcionLogro = descripcionLogro;
		this.puntajeLogro = puntajeLogro;
		this.ejercicio = ejercicio;
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
	public Ejercicio getEjercicio() {
		return ejercicio;
	}
	public boolean isCumplido() {
		return cumplido;
	}
	public void setCumplido(boolean cumplido) {
		this.cumplido = cumplido;
	}
	@Override
	public String toString() {
		return ""+ descripcionLogro + " > " + puntajeLogro + " Eje: " + ejercicio;
	} 
}
