package GUI;

import java.awt.EventQueue;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JLabel;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.Color;

public class FrmPrincipal extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Eventos eventos;
	private JButton btnCerrar;
	//private JButton btnRestaurar;
	/**
	 * Launch the application.
	 */
	

	public FrmPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 400);
		setUndecorated(true);
		setIconImage(new ImageIcon(FrmPrincipal.class.getResource("/Imagenes/icono.png")).getImage());
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		setResizable(false);
		eventos = new Eventos(this);
		ThrAlarma thrAlarma = new ThrAlarma(eventos.getGestion().listarRutinas()); 
		thrAlarma.start();
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 250,400);
		panel.setBackground(new Color(0, 153, 255));
		panel.setBorder(null);
		getContentPane().add(panel);

		JLabel label = new JLabel("Cardio Temp");
		label.setForeground(new Color(0, 204, 153));
		label.setBounds(0, 11, 250, 58);
		label.setBackground(new Color(255, 255, 255));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Agency FB", Font.PLAIN, 50));
		panel.add(label);

		JButton btnRealizarRutina = new JButton("Realizar Rutina");
		btnRealizarRutina.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Imagenes/Realizar Rutina.png")));
		btnRealizarRutina.setToolTipText("Boton para seleccionar la rutina a realizar");
		btnRealizarRutina.setBounds(0, 66, 250, 73);
		btnRealizarRutina.setForeground(new Color(0, 0, 0));
		btnRealizarRutina.setBackground(new Color(255, 255, 255));
		btnRealizarRutina.setFont(new Font("Agency FB", Font.PLAIN, 5));
		btnRealizarRutina.addActionListener(eventos);
		panel.setLayout(null);
		panel.add(btnRealizarRutina);

		JButton btnGestionarRutinas = new JButton("Gestionar Rutinas");
		btnGestionarRutinas.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Imagenes/Gestionar Rutina.png")));
		btnGestionarRutinas.setToolTipText("Boton para la edicion de rutinas");
		btnGestionarRutinas.setBounds(0, 145, 250, 63);
		btnGestionarRutinas.setBackground(new Color(255, 255, 255));
		btnGestionarRutinas.setFont(new Font("Agency FB", Font.PLAIN, 5));
		btnGestionarRutinas.addActionListener(eventos);
		panel.add(btnGestionarRutinas);

		JButton btnVerTip = new JButton("Ver Tip");
		btnVerTip.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Imagenes/Ver Tip.png")));
		btnVerTip.setToolTipText("Muestra un tip de salud o alimentaci\u00F3n de forma aleatoria");
		btnVerTip.setBounds(0, 204, 250, 63);
		btnVerTip.setBackground(new Color(255, 255, 255));
		btnVerTip.setFont(new Font("Agency FB", Font.PLAIN, 5));
		btnVerTip.addActionListener(eventos);
		panel.add(btnVerTip);

		JButton btnListaLogros = new JButton("Lista de Logros");
		btnListaLogros.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Imagenes/Lista de Logros.png")));
		btnListaLogros.setToolTipText("Muestra los logros desbloqueados y por desbloquear");
		btnListaLogros.setBounds(0, 272, 250, 58);
		btnListaLogros.setBackground(new Color(255, 255, 255));
		btnListaLogros.setFont(new Font("Agency FB", Font.PLAIN, 5));
		btnListaLogros.addActionListener(eventos);
		panel.add(btnListaLogros);

		JButton btnVerHistorial = new JButton("Ver Historial");
		btnVerHistorial.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Imagenes/Historial.png")));
		btnVerHistorial.setToolTipText("Muestra el historial de actividades realizadas");
		btnVerHistorial.setBounds(0, 341, 250, 59);
		btnVerHistorial.setBackground(new Color(255, 255, 255));
		btnVerHistorial.setFont(new Font("Agency FB", Font.PLAIN, 5));
		btnVerHistorial.addActionListener(eventos);
		panel.add(btnVerHistorial);

		btnCerrar = new JButton("");
		btnCerrar.setToolTipText("Cerrar");
		btnCerrar.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Imagenes/remove2.png")));
		btnCerrar.setBounds(226, 0, 24, 24);
		btnCerrar.addActionListener(this);
		panel.add(btnCerrar);		
		
		JLabel lblFondo = new JLabel(new ImageIcon(FrmPrincipal.class.getResource("/Imagenes/Framefondo.png")));
		lblFondo.setBounds(0, 0, 250, 400);
		panel.add(lblFondo);
		

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object boton = arg0.getSource();
		if (boton.equals(btnCerrar)) {
			System.exit(0);
		}


	}
}
