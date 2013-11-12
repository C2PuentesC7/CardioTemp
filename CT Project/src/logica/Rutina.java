package logica;
import java.sql.Date;
import java.util.ArrayList;


public class Rutina {
	private ArrayList<Ejercicio> ejercicios;
	private Date tiempoAlarma;
	private int idRutina;
	private int nivel;

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getIdRutina() {
		return idRutina;
	}

	public Date getTiempoAlarma() {
		return tiempoAlarma;
	}

	public void setTiempoAlarma(Date tiempoAlarma) {
		this.tiempoAlarma = tiempoAlarma;
	}

	public Rutina(int idRutina, ArrayList<Ejercicio> ejercicios) {
		super();
		tiempoAlarma = null;
		this.idRutina = idRutina;
		this.ejercicios = ejercicios;
	}

	public void agregarEjercicio(Ejercicio ejercicio){
		ejercicios.add(ejercicio);
	}

	public Ejercicio buscarEjercicio(int idEjercicio){
		for (Ejercicio ejercicio : ejercicios)
			if (ejercicio.getIdEjercicio() == idEjercicio)
				return ejercicio;
		return null;
	}

	public void removerEjercicio (int idEjercicio){
		Ejercicio ejercicio = buscarEjercicio(idEjercicio);
		if (ejercicio != null)
			ejercicios.remove(ejercicio);
	}

	public void setLista(Ejercicio[] lista){
		ejercicios = new ArrayList<Ejercicio>();
		for (int i = 0; i < lista.length; i++)
			ejercicios.add(lista[i]);
	}

	@Override
	public String toString() {
		return "Rut" + idRutina + ">" + " Nvl " + nivel + " N° Eje. " + ejercicios.size();
	}

	public Ejercicio[] listarEjercicios() {
		return ejercicios.toArray(new Ejercicio[0]);
	}

}
