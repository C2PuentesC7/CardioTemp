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
		if (!lista.isEmpty()){
		ejercicios = (ArrayList<Ejercicio>) lista.get(0);
		logros = (ArrayList<Logro>) lista.get(1);
		tips = (ArrayList<Tip>) lista.get(2);
		rutinas = (ArrayList<Rutina>) lista.get(3);
		historials = (ArrayList<Historial>) lista.get(4); 
		}else valoresPorDefecto();
	
	}

	private void valoresPorDefecto() {
		ejercicios = new ArrayList<Ejercicio>();
		ejercicios.add(new Ejercicio(0, "Caminata enérgica", "Produce excelentes resultados, si caminas con un paso rapido podrás caminar 4.5 millas en una hora y podras quemar la misma cantidad de calorias.", 1, "/Imagenes/images.jpg"));
		ejercicios.add(new Ejercicio(1, "Flexiones", "Pongase boca a bajo y flexione los brazos casi hasta tocar el suelo y expire y vuelva a la posicion inicial inspire", 5, "/Imagenes/pectorales.jpg"));
		ejercicios.add(new Ejercicio(2, "Abdominales", "posicion acostado boca arriba, manos en la nuca flexione 90 grados hasta una posicion de estar sentado", 4, "/Imagenes/abdominales.jpg"));
		ejercicios.add(new Ejercicio(3, "Correr", "Correr quema hasta 300 calorías en 30 minutos, y lo puedes hacer en cualquier lado y no necesitas mas que unos buenos tennis.", 2, "/Imagenes/Correr.jpg"));
		ejercicios.add(new Ejercicio(4, "Levantar pesas", "Con una rutina de pesas para todo el cuerpo, con repeticiones altas y bajo peso estarás quemando grasa muscular.", 3,"/Imagenes/Pesas.jpg"));

		logros = new ArrayList<Logro>();
		logros.add(new Logro(0, "Has sobrepasado el nivel 1!!!", 10, (Ejercicio) ejercicios.get(0)));
		logros.add(new Logro(1, "Has sobrepasado el nivel 2!!!", 20, (Ejercicio) ejercicios.get(0)));
		logros.add(new Logro(2, "Has sobrepasado el nivel 3!!!", 30, (Ejercicio) ejercicios.get(3)));
		logros.add(new Logro(3, "Has sobrepasado el nivel 4!!!", 40, (Ejercicio) ejercicios.get(1)));
		logros.add(new Logro(4, "Has sobrepasado el nivel 5!!!", 50, (Ejercicio) ejercicios.get(4)));
		logros.add(new Logro(5, "Has sobrepasado el nivel 6!!!", 60, (Ejercicio) ejercicios.get(2)));

		tips = new ArrayList<Tip>();
		
		tips.add(new Tip(14, "Tip de Salud","El brócoli reduce el riesgo de cáncer", "/Imagenes/brocoli.png"));
		tips.add(new Tip(15, "Tip de Salud","Para calmar el dolor de cabeza, presione con dos dedos el puente de su nariz, debajo de la línea de las cejas", "/Imagenes/dolorcabeza.png"));
		tips.add(new Tip(16, "Tip de Salud","Manten tu mente activa resolviendo rompecabezas", "/Imagenes/rompecabezas.png"));
		tips.add(new Tip(17, "Tip de Salud","Asegurese de salir con sus amigos al menos una vez a la semana y disminuira el estrés", "/Imagenes/amigos.png"));
		tips.add(new Tip(18, "Tip de Salud","Ejercitar hasta sudar por una hora a la semana reduce el riesgo de un ataque al corazón", "/Imagenes/sudar.png"));
		tips.add(new Tip(19, "Tip de Salud","Cámbiate al té verde es anticancerígeno", "/Imagenes/te verde.png"));
		tips.add(new Tip(20, "Tip de Salud","Saltarse un tiempo de comida hace que el cuerpo entre en modo de hambre y almacene grasas", "/Imagenes/comida.png"));
		tips.add(new Tip(21, "Tip de Salud","Dormir bien disminuye el riesgo de padecer cáncer de mama", "/Imagenes/dormir.png"));
		tips.add(new Tip(22, "Tip de Salud","En vez de comer chocolate para ganar energía, come un banano, que fortalece tus huesos.", "/Imagenes/banano.png"));
		tips.add(new Tip(23, "Tip de Salud","Comer manzanas ayuda a regular el ritmo intestinal", "/Imagenes/manzana.png"));
		tips.add(new Tip(24, "Tip de Salud","El aceite de oliva ayuda a prevenir enfermedades cardiovasculares y mantiene nivelado el colesterol", "/Imagenes/aceiteoliva.png"));
		tips.add(new Tip(25, "Tip de Salud","Es mejor ejercitarse en la mañana", "/Imagenes/ejercicio.png"));
		
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


	public boolean editarAlarma(int idRutina, boolean[] diaAlarma, int[] horaAlarma){
		for (int i = 0; i < rutinas.size(); i++) {
			if (((Rutina) rutinas.get(i)).getIdRutina() == idRutina){
				((Rutina) rutinas.get(i)).setDiaAlarma(diaAlarma);
				((Rutina) rutinas.get(i)).setHoraAlarma(horaAlarma);
		}
		}
		return false;
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
			if (((Historial) historials.get(i)).getFechahistorial().equals(fechaHistorial))
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

	public void removerRutina(Rutina rutina) {
		rutinas.remove(rutina);
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
			if (rutinas.get(i).getIdRutina() == idRutina)
				return rutinas.get(i);
		return null;
	}

	public boolean addRutina() {
		if (rutinas.size() < 21) {
			rutinas.add(new Rutina(rutinas.size(), new ArrayList<Ejercicio>()));
			return true;
		}
		return false;
		
	}
}
