package GUI;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.ImageIcon;
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
	private FrameEdicionRutina fer;
	private FrmPrincipal fp;

	public Eventos (FrmPrincipal fp){
		this.fp = fp;
		gestion = new Gestion(true);
	}

	public void actionPerformed(ActionEvent evento) {

		System.out.println(evento.getActionCommand());
		if (evento.getActionCommand().equals("Realizar Rutina")){
			frr = new FrmRealizarRutina(gestion.listarRutinas(),fp, this);
			fp.setVisible(false);
		}
		if (evento.getActionCommand().equals("Gestionar Rutinas")){
			fgr = new FrmGestionarRutina(gestion.listarRutinas(),fp, this);
			fp.setVisible(false);
		}
		if (evento.getActionCommand().equals("Ver Tip")){
			mostrarTip(gestion.listarTips());
		}
		if (evento.getActionCommand().equals("Lista de Logros")){
			fll = new FrmListaLogros(gestion.listarLogros(),fp, this);
			fp.setVisible(false);
		}
		if (evento.getActionCommand().equals("Ver Historial")){
			fh = new FrmHistorial(gestion.listarHistorial(),fp, this);
			fp.setVisible(false);
		}
		if (evento.getActionCommand().indexOf("Realizar Rutina ") !=-1){
			realizarRutina(evento.getActionCommand());
		}
		if (evento.getActionCommand().equals("Finalizar Ejercicio")){
			fc.siguienteEjercicio();
		}
		if (evento.getActionCommand().equals("Iniciar Ejercicio")){
			fc.getThrTiempo().continuar(true);
		}
		if (evento.getActionCommand().equals("Pausa")) {
			fc.pausar();
		}
		if (evento.getActionCommand().equals("Borrar")){
			fh.getInternalFrame().setVisible(true);
			fh.getBtnBorrar().setEnabled(false);
			fh.getBtnVolver().setEnabled(false);
		}
		if (evento.getActionCommand().indexOf("Editar Rutina ") !=-1){
			editarRutina(evento.getActionCommand());
		}
		if (evento.getActionCommand().equals("Guardar")){
			editarListaEjercicios(fle.getIdRutina(), fle.getListaEjercicios());
		}
		if (evento.getActionCommand().equals("Programar")){
			editarAlarma(fda.getIdRutina(), fda.getDiaAlarma(), fda.getHoraAlarma());

		}
		if (evento.getActionCommand().equals("Agregar")){
			agregarRutina();
		}
		if (evento.getActionCommand().equals("Info")){
			mostrarInfografia(fc.getIdEjercicio());
		}
		if (evento.getActionCommand().equals("Ok")) {
			int n= Integer.valueOf(fer.getLabelNumero().getText());
			if (fer.getBtnEliminar().isSelected()) {
				//eliminarRutina(n);
				fer.getBtnEditarAlarma().setEnabled(false);
				fer.getBtnEditarListaEjercicios().setEnabled(false);
				fer.getBtnEditarNivel().setEnabled(false);
				fer.getBtnEliminar().setEnabled(false);
				fer.getBtnVolver().setEnabled(false);
				fer.getBtnOk().setEnabled(false);
				fer.getInternalFrame().setVisible(false);
				fer.getInternalFrame().add(fer.getRdbtnSi());
				fer.getInternalFrame().add(fer.getRdbtnNo());
				fer.getInternalFrame().remove(fer.getBtnListo());
				fer.getInternalFrame().remove(fer.getTxtNivel());

				fer.getLblInfo().setText("Eliminar la rutina "+fer.getLabelNumero().getText()+"?");
				fer.getInternalFrame().setVisible(true);


			}else if (fer.getBtnEditarAlarma().isSelected()) {

				fer.getInternalFrame().setVisible(false);
				fda = new FrmDiaAlarma(n,fer, this);
				fer.setVisible(false);

			}else if (fer.getBtnEditarListaEjercicios().isSelected()) {
				fer.getInternalFrame().setVisible(false);
				fle = new FrmListaEjercicios(n, gestion.listarEjercicios(n),fer, this);
				fer.setVisible(false);
			}else if (fer.getBtnEditarNivel().isSelected()) {
				fer.getBtnVolver().setEnabled(false);
				fer.getBtnOk().setEnabled(false);
				fer.getBtnEditarAlarma().setEnabled(false);
				fer.getBtnEditarListaEjercicios().setEnabled(false);
				fer.getBtnEditarNivel().setEnabled(false);
				fer.getBtnEliminar().setEnabled(false);
				fer.getInternalFrame().setVisible(false);
				fer.getInternalFrame().remove(fer.getRdbtnSi());
				fer.getInternalFrame().remove(fer.getRdbtnNo());
				fer.getInternalFrame().add(fer.getBtnListo());
				fer.getInternalFrame().add(fer.getTxtNivel());
				fer.getLblInfo().setText("Digite el nuevo nivel");
				fer.getInternalFrame().setVisible(true);


			}
		}
		if (evento.getActionCommand().equalsIgnoreCase("Si")) {

			if(fer != null){
				int n= Integer.valueOf(fer.getLabelNumero().getText());
				eliminarRutina(n);
				fer.getInternalFrame().setVisible(false);
				fer.getBtnVolver().setEnabled(true);
				fer.getBtnEditarAlarma().setEnabled(true);
				fer.getBtnEditarListaEjercicios().setEnabled(true);
				fer.getBtnEditarNivel().setEnabled(true);
				fer.getBtnEliminar().setEnabled(true);
				fer.getBtnOk().setEnabled(true);
			}else if(fh != null){
				fh.getInternalFrame().setVisible(false);
				fh.getBtnBorrar().setEnabled(true);
				fh.getBtnVolver().setEnabled(true);
				borrarHistorial();
				
			}
		}
		if (evento.getActionCommand().equalsIgnoreCase("No")) {
			if(fer != null){
			fer.getInternalFrame().setVisible(false);

			fer.getBtnVolver().setEnabled(true);
			fer.getBtnOk().setEnabled(true);
			fer.getBtnEditarAlarma().setEnabled(true);
			fer.getBtnEditarListaEjercicios().setEnabled(true);
			fer.getBtnEditarNivel().setEnabled(true);
			fer.getBtnEliminar().setEnabled(true);
			}else if(fh != null){
				fh.getInternalFrame().setVisible(false);
				fh.getBtnBorrar().setEnabled(true);
				fh.getBtnVolver().setEnabled(true);
			}
		}
		if(evento.getActionCommand().equals("Listo")){
			int n= Integer.valueOf(fer.getLabelNumero().getText());
			int nivel = Integer.valueOf(fer.getTxtNivel().getText());
			editarNivel(n,nivel);
			fer.getInternalFrame().setVisible(false);
			fer.getBtnVolver().setEnabled(true);
			fer.getBtnOk().setEnabled(true);
			fer.getBtnEditarAlarma().setEnabled(true);
			fer.getBtnEditarListaEjercicios().setEnabled(true);
			fer.getBtnEditarNivel().setEnabled(true);
			fer.getBtnEliminar().setEnabled(true);

		}
		gestion.descargarListas();
	}

	private void mostrarInfografia(int idEjercicio) {
		Ejercicio ejercicio = gestion.listarEjercicios()[idEjercicio];
		fInfo = new FrameInfo(null,fc);
		fInfo.getLblTipo().setText(ejercicio.getNombreEjercicio());
		fInfo.getLblImagen().setIcon(new ImageIcon(escalarImagen(ejercicio.getImagenEjercicio(), 200, 200)));
		fInfo.getTxtrDescripcion().setText(ejercicio.getDescripcionEjercicio());
		fInfo.setVisible(true);
		fc.setVisible(false);
	}

	private void mostrarTip(Tip[] lista) {
		int id = (int) (Math.random()*lista.length);
		fInfo = new FrameInfo(fp,null);
		fInfo.getLblTipo().setText(lista[id].getTipoTip());
		fInfo.getLblImagen().setIcon(new ImageIcon(escalarImagen(lista[id].getImagenTip(), 224,94)));
		fInfo.getTxtrDescripcion().setText(lista[id].getDescripcionTip());
		fInfo.setVisible(true);
		fp.setVisible(false);
	}

	private void agregarRutina() {
		if(gestion.addRutina()){
			fgr.setVisible(false);
			fgr = new FrmGestionarRutina(gestion.listarRutinas(), fp, this);
			fgr.getLblConfirmacion().setForeground(Color.GREEN);
			fgr.getLblConfirmacion().setText("Rutina agregada correctamente");
		}else{
			fgr.setVisible(false);
			fgr = new FrmGestionarRutina(gestion.listarRutinas(), fp, this);
			fgr.getLblConfirmacion().setForeground(Color.RED);
			fgr.getLblConfirmacion().setText("No se permite añadir mas de 21 rutinas");
		}

	}

	private void editarRutina(String texto) {
		int n = Integer.parseInt(texto.substring(14));
		fer = new FrameEdicionRutina(this,fgr);
		fer.getLabelNumero().setText(""+n);
		fgr.setVisible(false);


	}

	private void editarAlarma(int idRutina, boolean[] diaAlarma, int[] horaAlarma) {
		gestion.editarAlarma(idRutina, diaAlarma, horaAlarma);
	}

	public void editarListaEjercicios(int idRutina, ArrayList<Ejercicio> ejercicios) {
		gestion.editarListaEjercicios(idRutina, ejercicios);
	}

	private void editarNivel(int n, int nivel) {		
		gestion.editarNivel(n, nivel);
	}

	private void eliminarRutina(int n) {
		//	if (JOptionPane.showConfirmDialog(null, "Seguro que quiere borrar la rutina "+n+"?") == 0){

		Rutina aux= gestion.getRutina(n);
		gestion.removerRutina(aux);
		fgr.setVisible(false);
		fgr = new FrmGestionarRutina(gestion.listarRutinas(), fp, this);

		//}
	}

	private void borrarHistorial() {
		//if (JOptionPane.showConfirmDialog(null, "Seguro que quiere borrar el Historial?, los logros estan incluidos") == 0){
			gestion.removerHistorial();
			fh.setVisible(false);
			fh = new FrmHistorial(gestion.listarHistorial(), fp, this);
		//}
	}



	private void realizarRutina(String texto) {
		int n = Integer.parseInt(texto.substring(16));
		if (gestion.listarRutinas()[n].listarEjercicios().length > 0) {
			frr.getLblRutinaVacia().setText("");
			fc = new FrmCronometro (gestion.listarRutinas()[n].listarEjercicios(), this, gestion.listarRutinas()[n].getNivel(),frr);
			fc.setVisible(true);
			frr.setVisible(false);
		}else{
			frr.getLblRutinaVacia().setText("La rutina esta vacía, agregue ejercicios");
		}

	}

	public void crearHistorial(Ejercicio ejercicio, int tiempo, int nivel) {
		Logro logro = gestion.addHistorial(new Historial(formatearFecha(), tiempo, tiempo*(nivel+1)/10, ejercicio));
		if (logro !=null)
			fc.getLblLogroCumplido().setText("¡¡¡Nuevo logro desbloqueado!!!");
		System.out.println(gestion.getHistorial());
	}

	public Gestion getGestion() {
		return gestion;
	}

	public Ejercicio[] listarEjercicios() {
		return gestion.listarEjercicios();
	}

	public Image escalarImagen(Image imagen, int largo, int alto){
		BufferedImage resizedImg = new BufferedImage(largo, alto, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = resizedImg.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(imagen, 0, 0, largo, alto, null);
		g2.dispose();
		return resizedImg;
	}
	public static String formatearFecha(){
		Calendar fecha= Calendar.getInstance();
		String[] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};


		return fecha.get(Calendar.DAY_OF_MONTH)+" de "+meses[fecha.get(Calendar.MONTH)]+" del "+fecha.get(Calendar.YEAR);
	}
}
