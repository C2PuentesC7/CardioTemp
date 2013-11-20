package logica;
import java.awt.GraphicsConfiguration;
import java.sql.Date;
import java.util.ArrayList;

public class Gestion {
	private ArrayList<Ejercicio> ejercicios;
	private ArrayList<Rutina> rutinas;
	private ArrayList<Historial> historials;
	private ArrayList<Logro> logros;
	private ArrayList<Tip> tips;

	public Gestion(boolean b) {
		ejercicios = new ArrayList<Ejercicio>();
		ejercicios.add(new Ejercicio(0, "Caminata", "Hagamos de cuenta que caminar es la acción de poner un pie frente al otro, de manera de que el Ser humano, animal o cosa que tenga pies o patas, pueda movilizarse de un determinado lugar a otro", 1, null));
		ejercicios.add(new Ejercicio(1, "Abdominales", "Dolor", 5, null));
		ejercicios.add(new Ejercicio(2, "Flexiones", "Aaahh un hombre lagarto...", 4, null));
		ejercicios.add(new Ejercicio(3, "Correr", "Como caminar pero con turbo", 2, null));
		ejercicios.add(new Ejercicio(4, "Levantar pesas", "Si si, las esposas de los peces", 3, null));
		
		logros = new ArrayList<Logro>();
		logros.add(new Logro(0, "Un dia normal", 10, 0));
		logros.add(new Logro(1, "hey, sin marcahas", 20, 0));
		logros.add(new Logro(2, "ay si, ay si, ahora se cree fortachon", 30, 3));
		logros.add(new Logro(3, "Montolla come chitos al lado", 40, 2));
		logros.add(new Logro(4, "Hombre elastico, cada dia mas cerca", 50, 4));
		logros.add(new Logro(5, "Mira mis chocolatinas", 60, 5));
		
		tips = new ArrayList<Tip>();
		tips.add(new Tip(0, "Ojo, los chiflones estan al asecho", null, 0));
		tips.add(new Tip(1, "Las Zanahorias son buenas para tu vision laser", null, 1));
		tips.add(new Tip(2, "Se a demostrado cientificamente que comer quita el hambre", null, 1));
		tips.add(new Tip(3, "Ir a mirar la nevera para ver que hay de comer no cuenta como ejercicio", null, 2));
		
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
		
		historials = new ArrayList<Historial>();
	}

// Gestion Ejercicio
	// Solo lectura Us

	public Ejercicio buscarEjercicio(int idEjercicio){
		for (Ejercicio ejercicio : ejercicios)
			if (ejercicio.getIdEjercicio() == idEjercicio)
				return ejercicio;
				return null;
	}

	// Gestion Rutina
	// Expandir Gestion Us


	public void editarAlarma(int idRutina, Date alarma){
		for (Rutina elemento : rutinas)
			if (elemento.getIdRutina() == idRutina)
				elemento.setTiempoAlarma(alarma);
	}
	public void removerAlarma (int idRutina){
		for (Rutina elemento : rutinas)
			if (elemento.getIdRutina() == idRutina)
				elemento.setTiempoAlarma(null);
	}

	// Gestion Historiales
	// Gestion Completa Si

	// Registrar eventos Us
	public void agregarHistorial(Historial historial){
		historials.add(historial);
		for (Logro logro : logros)
			if (historial.getIdEjercicio() == logro.getidEjercicio() && historial.getPuntajeHistorial() > logro.getPuntajeLogro())
				logro.setCumplido(true);
	}
	// Consultar registros --> Logros
	public Historial buscarHistorial(Date fechaHistorial){
		for (Historial historial : historials)
			if (historial.getFechahistorial().compareTo(fechaHistorial) == 0)
				return historial;
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
		for (Logro logro : logros)
			if (logro.getIdLogro() == idLogro)
				return logro;
				return null;
	}

	public Tip buscarTip(int idTip){
		for (Tip tip : tips)
			if (tip.getIdTip() == idTip)
				return tip;
				return null;
	}

	public Tip[] listarTips() {
		return tips.toArray(new Tip[0]);
	}

	public Rutina[] listarRutinas() {
		return rutinas.toArray(new Rutina[0]);
	}

	public String getHistorial() {
		return historials.toString();
	}

	public Historial[] listarHistorial() {
		return historials.toArray(new Historial[0]);
	}

	public void removerHistorial() {
		historials = new ArrayList<Historial>();
		for (Logro logro : logros)
			logro.setCumplido(false);
	}
}
