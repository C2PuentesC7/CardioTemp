package presentacion;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Date;

import javax.swing.JOptionPane;

import logica.Ejercicio;
import logica.Gestion;
import logica.Historial;

public class Eventos implements ActionListener{

	private Gestion gestion;
	private FrmRealizarRutina frr;
	private FrmGestionarRutina fgr;
	private FrmListaLogros fll;
	private FrmHistorial fh;
	private FrmCronometro fc;

	public Eventos (){
		gestion = new Gestion(true);
	}

	public void actionPerformed(ActionEvent evento) {
		System.out.println(evento.getActionCommand());
		if (evento.getActionCommand().equals("Realizar Rutina"))
			frr = new FrmRealizarRutina(gestion.listarRutinas().length, this);
		if (evento.getActionCommand().equals("Gestionar Rutinas"))
			fgr = new FrmGestionarRutina();
		if (evento.getActionCommand().equals("Ver Tip"))
			JOptionPane.showMessageDialog(null, gestion.listarTips()[(int) (Math.random()*gestion.listarTips().length)]);
		if (evento.getActionCommand().equals("Lista de Logros"))
			fll = new FrmListaLogros();
		if (evento.getActionCommand().equals("Ver Historial"))
			fh = new FrmHistorial(gestion.listarHistorial(), this);
		if (evento.getActionCommand().equals("Volver"))
			cerrarVentanas();
		if (evento.getActionCommand().indexOf("Realizar Rutina ") !=-1){
			realizarRutina(evento.getActionCommand());
		System.out.println(evento.getActionCommand());
	}
		if (evento.getActionCommand().equals("Finalizar Ejercicio"))
			fc.siguienteEjercicio();
		if (evento.getActionCommand().equals("Iniciar Ejercicio"))
			fc.getThrTiempo().continuar(true);
		if (evento.getActionCommand().equals("Finalizar Rutina"))
			cerrarVentanas();
		if (evento.getActionCommand().equals("Borrar"))
			borrarHistorial();
	}

	private void borrarHistorial() {
		if (JOptionPane.showConfirmDialog(null, "Seguro que quiere borrar el Historial?, los logros estan incluidos") == 0){
			gestion.removerHistorial();
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
	}

	private void realizarRutina(String texto) {
		int n = Integer.parseInt(texto.substring(16));
		fc = new FrmCronometro (gestion.listarRutinas()[n].listarEjercicios(), this, gestion.listarRutinas()[n].getNivel());
	}

	public void crearHistorial(int idEjercicio, int tiempo, int nivel) {
		gestion.agregarHistorial(new Historial(new Date(), tiempo, tiempo*nivel / 10, idEjercicio));
		System.out.println(gestion.getHistorial());
	}
	public Image escalarImagen(Image imagen, int largo, int alto){
        BufferedImage resizedImg = new BufferedImage(largo, alto, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(imagen, 0, 0, largo, alto, null);
        g2.dispose();
        return resizedImg;
    }
}
