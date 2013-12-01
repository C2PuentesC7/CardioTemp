package Logica;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Persistencia.Archivos;

public class Gestion {
	private ArrayList<Ejercicio> ejercicios;
	private ArrayList<Rutina> rutinas;
	private ArrayList<Historial> historials;
	private ArrayList<Logro> logros;
	private ArrayList<Tip> tips;

	
	public Gestion(boolean b) {
		//valoresPorDefecto();
		
		ArrayList<Object> lista = Archivos.cargarDatos();
		ejercicios = (ArrayList<Ejercicio>) lista.get(0);
		logros = (ArrayList<Logro>) lista.get(1);
		tips = (ArrayList<Tip>) lista.get(2);
		rutinas = (ArrayList<Rutina>) lista.get(3);
		historials = (ArrayList<Historial>) lista.get(4); 
	
	}

	private void valoresPorDefecto() {
		ejercicios = new ArrayList<Ejercicio>();
		ejercicios.add(new Ejercicio(0, "Caminata", "Hagamos de cuenta que caminar es la acción de poner un pie frente al otro, de manera de que el Ser humano, animal o cosa que tenga pies o patas, pueda movilizarse de un determinado lugar a otro", 1, new ImageIcon(getClass().getResource("/Imagenes/Ej0.jpg"))));
		ejercicios.add(new Ejercicio(1, "Abdominales", "Dolor", 5, new ImageIcon(getClass().getResource("/Imagenes/Ej1.jpg"))));
		ejercicios.add(new Ejercicio(2, "Flexiones", "Aaahh un hombre lagarto...", 4, new ImageIcon(getClass().getResource("/Imagenes/Ej2.jpg"))));
		ejercicios.add(new Ejercicio(3, "Correr", "Como caminar pero con turbo", 2, new ImageIcon(getClass().getResource("/Imagenes/Ej3.jpg"))));
		ejercicios.add(new Ejercicio(4, "Levantar pesas", "Si si, las esposas de los peces", 3,new ImageIcon(getClass().getResource( "/Imagenes/Ej4.jpg"))));

		logros = new ArrayList<Logro>();
		logros.add(new Logro(0, "Un dia normal", 10, (Ejercicio) ejercicios.get(0)));
		logros.add(new Logro(1, "hey, sin marcahas", 20, (Ejercicio) ejercicios.get(0)));
		logros.add(new Logro(2, "ay si, ay si, ahora se cree fortachon", 30, (Ejercicio) ejercicios.get(3)));
		logros.add(new Logro(3, "Montolla come chitos al lado", 40, (Ejercicio) ejercicios.get(1)));
		logros.add(new Logro(4, "Hombre elastico, cada dia mas cerca", 50, (Ejercicio) ejercicios.get(4)));
		logros.add(new Logro(5, "Mira mis chocolatinas", 60, (Ejercicio) ejercicios.get(2)));

		tips = new ArrayList<Tip>();
		tips.add(new Tip(0, "Ojo, los chiflones estan al asecho", new ImageIcon(getClass().getResource( "/Imagenes/Tp0.jpg")), 0));
		tips.add(new Tip(1, "Las Zanahorias son buenas para tu vision laser", new ImageIcon(getClass().getResource( "/Imagenes/Tp1.jpg")), 1));
		tips.add(new Tip(2, "Se a demostrado cientificamente que comer quita el hambre", new ImageIcon(getClass().getResource( "/Imagenes/Tp2.jpg")), 1));
		tips.add(new Tip(3, "Ir a mirar la nevera para ver que hay de comer no cuenta como ejercicio", new ImageIcon(getClass().getResource( "/Imagenes/Tp3.jpg")), 2));

		rutinas = new ArrayList<Rutina>();
		ArrayList<Ejercicio> lista = new ArrayList<Ejercicio>();
		lista.add(ejercicios.get(0));
		lista.add(ejercicios.get(2));
		lista.add(ejercicios.get(4));
		rutinas.add(new Rutina(0, lista));
		lista = new ArrayList<Ejercicio>();
		lista.add(ejercicios.get(1));
		lista.add(ejercicios.get(3));
		lista.add(ejercicios.get(1));
		rutinas.add(new Rutina(1, lista));
		((Rutina) rutinas.get(0)).setDiaAlarma(new boolean[]{false,false,true,false,false,false,false});
		((Rutina) rutinas.get(0)).setHoraAlarma(new int []{15,10});
		historials = new ArrayList<Historial>();

		ArrayList<Ejercicio> l= new ArrayList<Ejercicio>();
		for (int i = 0; i < ejercicios.size(); i++) 
			l.add(ejercicios.get(i));
	}

	public void descargarListas() {
		ArrayList<Object> lista = new ArrayList<Object>();
		lista.add(ejercicios);
		lista.add(logros);
		lista.add(tips);
		lista.add(rutinas);
		lista.add(historials);
		Archivos.descargarDatos(lista);
	}

	// Gestion Ejercicio
	// Solo lectura Us

	public Ejercicio buscarEjercicio(int idEjercicio){
		for (int i = 0; i < ejercicios.size(); i++)
			if (((Ejercicio) ejercicios.get(i)).getIdEjercicio() == idEjercicio)
				return (Ejercicio) ejercicios.get(i);
		return null;
	}

	// Gestion Rutina
	// Expandir Gestion Us


	public void editarAlarma(int idRutina, boolean[] diaAlarma, int[] horaAlarma){
		for (int i = 0; i < rutinas.size(); i++) 
			if (((Rutina) rutinas.get(i)).getIdRutina() == idRutina){
				((Rutina) rutinas.get(i)).setDiaAlarma(diaAlarma);
				((Rutina) rutinas.get(i)).setHoraAlarma(horaAlarma);
			}
	}
	public void removerAlarma (int idRutina){
		for (int i = 0; i < rutinas.size(); i++)
			if (((Rutina) rutinas.get(i)).getIdRutina() == idRutina)
				((Rutina) rutinas.get(i)).setDiaAlarma(new boolean[7]);
	}

	// Gestion Historiales
	// Gestion Completa Si

	// Registrar eventos Us
	public Logro addHistorial(Historial historial){
		historials.add(historial);
		for (int i = 0; i < logros.size(); i++)
			if (historial.getEjercicio().getIdEjercicio() == ((Logro) logros.get(i)).getEjercicio().getIdEjercicio() 
			&& historial.getPuntajeHistorial() > ((Logro) logros.get(i)).getPuntajeLogro()){
				((Logro) logros.get(i)).setCumplido(true);
				return ((Logro) logros.get(i));
			}
		return null;
	}
	// Consultar registros --> Logros
	public Historial buscarHistorial(Date fechaHistorial){
		for (int i = 0; i < historials.size(); i++) 
			if (((Historial) historials.get(i)).getFechahistorial().compareTo(fechaHistorial) == 0)
				return (Historial) historials.get(i);
		return null;
	}
	// Liberar Espacio 
	public void removerHistorial (Date fechaHistorial){
		Historial historial = buscarHistorial(fechaHistorial);
		if (historial != null)
			historials.remove(historial);
	}

	// Gestion Logros
	// Solo lectura Us-Si

	public Logro buscarLogro(int idLogro){
		for (int i = 0; i < logros.size(); i++) 
			if (((Logro) logros.get(i)).getIdLogro() == idLogro)
				return ((Logro) logros.get(i));
		return null;
	}

	public Tip buscarTip(int idTip){
		for (int i = 0; i < tips.size(); i++)
			if (((Tip) tips.get(i)).getIdTip() == idTip)
				return ((Tip) tips.get(i));
		return null;
	}

	public Tip[] listarTips() {
		Object[] lista = tips.toArray();
		Tip[] tips = new Tip[lista.length];
		for (int i = 0; i < tips.length; i++)
			tips[i] = (Tip) lista[i];
		return tips;
	}

	public Rutina[] listarRutinas() {
		Object[] lista = rutinas.toArray();
		Rutina[] rutinas = new Rutina[lista.length];
		for (int i = 0; i < rutinas.length; i++)
			rutinas[i] = (Rutina) lista[i];
		return rutinas;
	}

	public String getHistorial() {
		return historials.toString();
	}

	public Historial[] listarHistorial() {
		Object[] lista = historials.toArray();
		Historial[] historials = new Historial[lista.length];
		for (int i = 0; i < historials.length; i++)
			historials[i] = (Historial) lista[i];
		return historials;
	}

	public void removerHistorial() {
		historials = new ArrayList<Historial>();
		for (int i = 0; i < logros.size(); i++) 
			((Logro) logros.get(i)).setCumplido(false);
	}

	public Logro[] listarLogros() {
		Object[] lista = logros.toArray();
		Logro[] logros = new Logro[lista.length];
		for (int i = 0; i < logros.length; i++)
			logros[i] = (Logro) lista[i];
		return logros;
	}

	public void removerRutina(int idRutina) {
		rutinas.remove(idRutina);
	}

	public void editarNivel(int idRutina, int nivel) {
		((Rutina) rutinas.get(idRutina)).setNivel(nivel);
	}

	public void editarListaEjercicios(int idRutina,ArrayList<Ejercicio> ejercicios) {
		((Rutina) rutinas.get(idRutina)).setLista(ejercicios);
	}

	public Ejercicio[] listarEjercicios(int idRutina) {
		return ((Rutina) rutinas.get(idRutina)).listarEjercicios();
	}

	public Ejercicio[] listarEjercicios() {
		Object[] lista = ejercicios.toArray();
		Ejercicio[] ejercicios = new Ejercicio[lista.length];
		for (int i = 0; i < ejercicios.length; i++)
			ejercicios[i] = (Ejercicio) lista[i];
		return ejercicios;
	}

	public Rutina getRutina(int idRutina) {
		for (int i = 0; i < rutinas.size(); i++) 
			if (((Rutina) rutinas.get(i)).getIdRutina() == idRutina)
				return (Rutina) rutinas.get(i);
		return null;
	}

	public Tip tipEjercicio(int idEjercicio) {
		ArrayList<Tip> lista = new ArrayList<Tip>();
		for (int i = 0; i < tips.size(); i++)
			if (((Tip) tips.get(i)).getidEjercicio() == idEjercicio)
				lista.add(tips.get(i));
		return (Tip) lista.get((int) (Math.random()*lista.size()));
	}

	public void addRutina() {
		rutinas.add(new Rutina(rutinas.size(), new ArrayList<Ejercicio>()));
	}
}
