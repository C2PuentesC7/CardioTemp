package Logica;
import java.io.Serializable;
import java.util.Date;

public class Historial implements Serializable{
	private String fechahistorial;
	private int tiempoHistorrial;
	private int puntajeHistorial;
	private Ejercicio ejercicio;
	public Historial(String fechahistorial, int tiempo, int puntajeHistorial,
			Ejercicio ejercicio) {
		super();
		this.fechahistorial = fechahistorial;
		this.tiempoHistorrial = tiempo;
		this.puntajeHistorial = puntajeHistorial;
		this.ejercicio = ejercicio;
	}
	public String getFechahistorial() {
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
		return "\n   "+fechahistorial
				+ "\n   Duración ejercicio: " + tiempoHistorrial + "\n   Puntaje: "
				+ puntajeHistorial + "\n   Ejercicio: " + ejercicio.getNombreEjercicio();
	}

}
