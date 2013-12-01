package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.GridLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.border.TitledBorder;

import java.awt.Font;

import javax.swing.SwingConstants;

import Logica.Gestion;

import java.awt.Color;

public class FrmPrincipal extends JFrame implements ActionListener {

	private Eventos eventos;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		try {
			Clip sonido = AudioSystem.getClip();
			File a = new File("Intro.wav");
			sonido.open(AudioSystem.getAudioInputStream(a));
			sonido.start();
			System.out.println("Reproduciendo 10s. de sonido...");
			Thread.sleep(50000); // 50.000 milisegundos (50 segundos)
			sonido.close();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public FrmPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 400);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		setResizable(false);
		eventos = new Eventos();
		ThrAlarma thrAlarma = new ThrAlarma(eventos.getGestion().listarRutinas()); 
		thrAlarma.start();
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 250,400);
		panel.setBackground(new Color(0, 153, 255));
		panel.setBorder(null);
		getContentPane().add(panel);

		JLabel label = new JLabel("Cardio Temp");
		label.setForeground(new Color(255, 255, 255));
		label.setBounds(0, 29, 250, 33);
		label.setBackground(new Color(255, 255, 255));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Agency FB", Font.PLAIN, 35));
		panel.add(label);

		JButton btnRealizarRutina = new JButton("Realizar Rutina");
		btnRealizarRutina.setBounds(10, 73, 230, 48);
		btnRealizarRutina.setForeground(new Color(0, 0, 0));
		btnRealizarRutina.setBackground(new Color(255, 255, 255));
		btnRealizarRutina.setFont(new Font("Agency FB", Font.PLAIN, 23));
		btnRealizarRutina.addActionListener(eventos);
		panel.setLayout(null);
		panel.add(btnRealizarRutina);

		JButton btnGestionarRutinas = new JButton("Gestionar Rutinas");
		btnGestionarRutinas.setBounds(10, 132, 230, 50);
		btnGestionarRutinas.setBackground(new Color(255, 255, 255));
		btnGestionarRutinas.setFont(new Font("Agency FB", Font.PLAIN, 23));
		btnGestionarRutinas.addActionListener(eventos);
		panel.add(btnGestionarRutinas);

		JButton btnVerTip = new JButton("Ver Tip");
		btnVerTip.setBounds(10, 193, 230, 48);
		btnVerTip.setBackground(new Color(255, 255, 255));
		btnVerTip.setFont(new Font("Agency FB", Font.PLAIN, 23));
		btnVerTip.addActionListener(eventos);
		panel.add(btnVerTip);

		JButton btnListaLogros = new JButton("Lista de Logros");
		btnListaLogros.setBounds(10, 252, 230, 48);
		btnListaLogros.setBackground(new Color(255, 255, 255));
		btnListaLogros.setFont(new Font("Agency FB", Font.PLAIN, 23));
		btnListaLogros.addActionListener(eventos);
		panel.add(btnListaLogros);

		JButton btnVerHistorial = new JButton("Ver Historial");
		btnVerHistorial.setBounds(10, 311, 230, 48);
		btnVerHistorial.setBackground(new Color(255, 255, 255));
		btnVerHistorial.setFont(new Font("Agency FB", Font.PLAIN, 23));
		btnVerHistorial.addActionListener(eventos);
		panel.add(btnVerHistorial);
		
		JButton btnCerrar = new JButton("");
		btnCerrar.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Imagenes/cerrar.png")));
		btnCerrar.setBounds(219, 0, 31, 25);
		btnCerrar.addActionListener(this);
		panel.add(btnCerrar);
		
		JLabel lblFondo = new JLabel(new ImageIcon(FrmPrincipal.class.getResource("/Imagenes/fondo1.png")));
		lblFondo.setBounds(0, 0, 250, 400);
		panel.add(lblFondo);
		
		
		//JLabel lblFondoFrame = new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Framefondo.png")));
		//lblFondoFrame.setBounds(0, 0, 250, 400);
		//panel.add(lblFondoFrame);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.exit(0);
		
	}
}
