package GUI;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Logica.Ejercicio;
import Logica.Gestion;
import Logica.Historial;
import Logica.Logro;
import Logica.Rutina;
import Logica.Tip;

public class Eventos implements ActionListener{

	private Gestion gestion;
	private FrmRealizarRutina frr;
	private FrmGestionarRutina fgr;
	private FrmListaLogros fll;
	private FrmHistorial fh;
	private FrmCronometro fc;
	private FrmListaEjercicios fle;
	private FrmDiaAlarma fda;
	private FrameInfo fInfo;

	public Eventos (){
		gestion = new Gestion(true);
	}

	public void actionPerformed(ActionEvent evento) {
		System.out.println(evento.getActionCommand());
		if (evento.getActionCommand().equals("Realizar Rutina"))
			frr = new FrmRealizarRutina(gestion.listarRutinas(), this);
		if (evento.getActionCommand().equals("Gestionar Rutinas"))
			fgr = new FrmGestionarRutina(gestion.listarRutinas(), this);
		if (evento.getActionCommand().equals("Ver Tip"))
			mostrarTip(gestion.listarTips());
		if (evento.getActionCommand().equals("Lista de Logros"))
			fll = new FrmListaLogros(gestion.listarLogros(), this);
		if (evento.getActionCommand().equals("Ver Historial"))
			fh = new FrmHistorial(gestion.listarHistorial(), this);
		if (evento.getActionCommand().equals("Volver"))
			cerrarVentanas();
		if (evento.getActionCommand().indexOf("Realizar Rutina ") !=-1)
			realizarRutina(evento.getActionCommand());
		if (evento.getActionCommand().equals("Finalizar Ejercicio"))
			fc.siguienteEjercicio();
		if (evento.getActionCommand().equals("Iniciar Ejercicio"))
			fc.getThrTiempo().continuar(true);
		if (evento.getActionCommand().equals("Finalizar Rutina"))
			cerrarVentanas();
		if (evento.getActionCommand().equals("Borrar"))
			borrarHistorial();
		if (evento.getActionCommand().indexOf("Editar Rutina ") !=-1)
			editarRutina(evento.getActionCommand());
		if (evento.getActionCommand().equals("Guardar"))
			editarListaEjercicios(fle.getIdRutina(), fle.getListaEjercicios());
		if (evento.getActionCommand().equals("Programar"))
			editarAlarma(fda.getIdRutina(), fda.getDiaAlarma(), fda.getHoraAlarma());
		if (evento.getActionCommand().equals("Tip"))
			tipEjercicio(fc.getIdEjercicio());
		if (evento.getActionCommand().equals("Agregar"))
			agregarRutina();
		if (evento.getActionCommand().equals("Infografia"))
			mostrarInfografia(fc.getIdEjercicio());
		gestion.descargarListas();
	}

	private void mostrarInfografia(int idEjercicio) {
		Ejercicio ejercicio = gestion.listarEjercicios()[idEjercicio];
		//JOptionPane.showMessageDialog(null, ejercicio.getDescripcionEjercicio(), ejercicio.getNombreEjercicio(), JOptionPane.PLAIN_MESSAGE, new ImageIcon(escalarImagen(ejercicio.getImagenEjercicio(), 200, 200)));
		fInfo = new FrameInfo();
		fInfo.getLblTipo().setText("Ejercicio");
		fInfo.getLblImagen().setIcon(new ImageIcon(escalarImagen(ejercicio.getImagenEjercicio(), 200, 200)));
		fInfo.getTxtrDescripcion().setText(ejercicio.getDescripcionEjercicio());
		fInfo.setVisible(true);
	}

	private void mostrarTip(Tip[] lista) {
		int id = (int) (Math.random()*lista.length);
		//JOptionPane.showMessageDialog(null, lista[id], "Tip "+id, JOptionPane.PLAIN_MESSAGE, new ImageIcon(escalarImagen(lista[id].getImagenTip(), 100, 100)));
		fInfo = new FrameInfo();
		fInfo.getLblTipo().setText("Tip");
		fInfo.getLblImagen().setIcon(new ImageIcon(escalarImagen(lista[id].getImagenTip(), 100, 100)));
		fInfo.getTxtrDescripcion().setText(lista[id].getDescripcionTip());
		fInfo.setVisible(true);
	}

	private void agregarRutina() {
		gestion.addRutina();
		cerrarVentanas();
		fgr = new FrmGestionarRutina(gestion.listarRutinas(), this);
	}

	private void tipEjercicio(int idEjercicio) {
		Tip tip = gestion.tipEjercicio(idEjercicio);
		if (tip != null)
		JOptionPane.showMessageDialog(null, tip, "Tip "+ tip.getIdTip(), JOptionPane.PLAIN_MESSAGE, new ImageIcon(escalarImagen(tip.getImagenTip(), 100, 100)));
	}

	private void editarRutina(String texto) {
		int n = Integer.parseInt(texto.substring(14));
		Object[] opciones = {"Eliminar","Editar Nivel","Editar Lista Ejercicios","Editar Alarma"};
		String opcion = (String) JOptionPane.showInputDialog(null,gestion.listarRutinas()[n],"Opciones",JOptionPane.PLAIN_MESSAGE, null, opciones ,"Eliminar");
		if (opcion.equals("Eliminar"))
			eliminarRutina(n);
		if (opcion.equals("Editar Nivel"))
			editarNivel(n);
		if (opcion.equals("Editar Lista Ejercicios"))
			fle = new FrmListaEjercicios(n, gestion.listarEjercicios(n), this);
		if (opcion.equals("Editar Alarma"))
			fda = new FrmDiaAlarma(n, this);
	}

	private void editarAlarma(int idRutina, boolean[] diaAlarma, int[] horaAlarma) {
		gestion.editarAlarma(idRutina, diaAlarma, horaAlarma);
	}

	public void editarListaEjercicios(int idRutina, ArrayList<Ejercicio> ejercicios) {
		gestion.editarListaEjercicios(idRutina, ejercicios);
	}

	private void editarNivel(int n) {
		int nivel = Integer.parseInt(JOptionPane.showInputDialog("Digite el nuevo nivel"));
		gestion.editarNivel(n, nivel);
	}

	private void eliminarRutina(int n) {
		if (JOptionPane.showConfirmDialog(null, "Seguro que quiere borrar la rutina "+n+"?") == 0){
			gestion.removerRutina(n);
			cerrarVentanas();
			fgr = new FrmGestionarRutina(gestion.listarRutinas(), this);
		}
	}

	private void borrarHistorial() {
		if (JOptionPane.showConfirmDialog(null, "Seguro que quiere borrar el Historial?, los logros estan incluidos") == 0){
			gestion.removerHistorial();
			cerrarVentanas();
			fh = new FrmHistorial(gestion.listarHistorial(), this);
		}
	}

	public void cerrarVentanas() {
		if(frr != null)
			frr.dispose();
		if(fgr != null)
			fgr.dispose();
		if(fll != null)
			fll.dispose();
		if(fh != null)
			fh.dispose();
		if(fc != null)
			fc.dispose();
		if (fle != null)
			fle.dispose();
		if (fda != null)
			fda.dispose();
		if(fInfo != null)
			fInfo.dispose();
	}

	private void realizarRutina(String texto) {
		int n = Integer.parseInt(texto.substring(16));
		fc = new FrmCronometro (gestion.listarRutinas()[n].listarEjercicios(), this, gestion.listarRutinas()[n].getNivel());
	}

	public void crearHistorial(Ejercicio ejercicio, int tiempo, int nivel) {
	Logro logro = gestion.addHistorial(new Historial(new Date(), tiempo, tiempo*(nivel+1)/10, ejercicio));
		if (logro !=null)
			JOptionPane.showMessageDialog(null, "logro alcanzadado\n"+logro);
		System.out.println(gestion.getHistorial());
	}

	public Gestion getGestion() {
		return gestion;
	}

	public Ejercicio[] listarEjercicios() {
		return gestion.listarEjercicios();
	}
	
	private Image escalarImagen(Image imagen, int largo, int alto){
        BufferedImage resizedImg = new BufferedImage(largo, alto, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(imagen, 0, 0, largo, alto, null);
        g2.dispose();
        return resizedImg;
    }
}
