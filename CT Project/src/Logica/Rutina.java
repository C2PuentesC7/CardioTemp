package Logica;
import java.io.Serializable;
import java.util.ArrayList;


public class Rutina implements Serializable{
	private ArrayList<Ejercicio> ejercicios;
	private boolean[] diaAlarma;
	private int[] horaAlarma; 
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
	public boolean[] getDiaAlarma() {
		return diaAlarma;
	}
	public void setDiaAlarma(boolean[] diaAlarma) {
		this.diaAlarma = diaAlarma;
	}
	
	public int[] getHoraAlarma() {
		return horaAlarma;
	}
	public void setHoraAlarma(int[] horaAlarma) {
		this.horaAlarma = horaAlarma;
	}
	public Rutina(int idRutina, ArrayList<Ejercicio> lista) {
		super();
		diaAlarma = new boolean[7];
		horaAlarma = new int[2];
		this.idRutina = idRutina;
		this.ejercicios = lista;
	}
	public void agregarEjercicio(Ejercicio ejercicio){
		ejercicios.add(ejercicio);
	}
	public Ejercicio buscarEjercicio(int idEjercicio){
		for (int i = 0; i < ejercicios.size(); i++)
			if (((Ejercicio) ejercicios.get(i)).getIdEjercicio() == idEjercicio)
				return ((Ejercicio) ejercicios.get(i));
		return null;
	}
	public void removerEjercicio (int idEjercicio){
		Ejercicio ejercicio = buscarEjercicio(idEjercicio);
		if (ejercicio != null)
			ejercicios.remove(ejercicio);
	}
	public void setLista(ArrayList<Ejercicio> lista){
		ejercicios = lista;
	}
	public String toString() {
		return "Rutina " + idRutina + "\nNivel: " + nivel + "\nEjercicios: " + listaEjercicios();
	}
	public String listaEjercicios(){
		String ejs = "";
		for (int i = 0; i < ejercicios.size(); i++) {
			ejs+=ejercicios.get(i).getNombreEjercicio()+"\n";
		}
		return ejs;
		
	}
	public Ejercicio[] listarEjercicios() {
		Object[] lista = ejercicios.toArray();
		Ejercicio[] ejercicios = new Ejercicio[lista.length];
		for (int i = 0; i < ejercicios.length; i++)
			ejercicios[i] = (Ejercicio) lista[i];
		return ejercicios;
	}
	
}
