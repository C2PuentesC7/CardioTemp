package Logica;
import java.io.Serializable;
import java.util.Date;

public class Historial implements Serializable{
	private Date fechahistorial;
	private int tiempoHistorrial;
	private int puntajeHistorial;
	private Ejercicio ejercicio;
	public Historial(Date fechahistorial, int tiempo, int puntajeHistorial,
			Ejercicio ejercicio) {
		super();
		this.fechahistorial = fechahistorial;
		this.tiempoHistorrial = tiempo;
		this.puntajeHistorial = puntajeHistorial;
		this.ejercicio = ejercicio;
	}
	public Date getFechahistorial() {
		return fechahistorial;
	}
	public int getTiempoHistorrial() {
		return tiempoHistorrial;
	}
	public int getPuntajeHistorial() {
		return puntajeHistorial;
	}
	public Ejercicio getEjercicio() {
		return ejercicio;
	}
	@Override
	public String toString() {
		return fechahistorial 
				+ ">" + tiempoHistorrial + "s >"
				+ puntajeHistorial + " Ejer: " + ejercicio;
	}

}
