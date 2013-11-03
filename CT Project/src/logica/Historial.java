package logica;
import java.util.Date;

public class Historial {
	private Date fechahistorial;
	private int tiempoHistorrial;
	private int puntajeHistorial;
	private int idEjercicio;
	public Historial(Date fechahistorial, int tiempo, int puntajeHistorial,
			int idEjercicio) {
		super();
		this.fechahistorial = fechahistorial;
		this.tiempoHistorrial = tiempo;
		this.puntajeHistorial = puntajeHistorial;
		this.idEjercicio = idEjercicio;
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
	public int getIdEjercicio() {
		return idEjercicio;
	}
	@Override
	public String toString() {
		return fechahistorial 
				+ ">" + tiempoHistorrial + "s >"
				+ puntajeHistorial + " Ejer: " + idEjercicio;
	}

}
