package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.UIManager;

import java.awt.GridLayout;

import javax.swing.SwingConstants;

import Logica.Ejercicio;
import Logica.Gestion;

import java.awt.Font;
import java.awt.Color;

public class FrmCronometro extends JFrame {
	private JLabel lblNombre;
	private Ejercicio[] ejercicios;
	private ThrTiempo thrTiempo;
	private int contador;
	private Eventos eventos;
	private int nivel;
	private JLabel lblTiempo;
	public FrmCronometro(Ejercicio[] ejercicios, Eventos eventos, int nivel) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		setBounds(100, 100, 250, 400);
		JPanel panel = new JPanel();
		panel.setBorder(null);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		lblNombre = new JLabel("Nombre Ejercicio");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setBounds(0, 2, 234, 40);
		lblNombre.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNombre);
		lblTiempo = new JLabel("00:00");
		lblTiempo.setForeground(new Color(255, 255, 255));
		lblTiempo.setBounds(0, 64, 234, 40);
		lblTiempo.setFont(new Font("LCD", Font.PLAIN, 25));
		lblTiempo.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblTiempo);
		JLabel lblTotal = new JLabel("00:00");
		lblTotal.setForeground(new Color(255, 255, 255));
		lblTotal.setBounds(0, 139, 234, 40);
		lblTotal.setFont(new Font("LCD", Font.PLAIN, 25));
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblTotal);

		JButton btnIniciarEjercicio = new JButton("Iniciar Ejercicio");
		btnIniciarEjercicio.setBackground(new Color(255, 255, 255));
		btnIniciarEjercicio.setBounds(0, 244, 234, 40);
		btnIniciarEjercicio.setFont(new Font("Agency FB", Font.ITALIC, 23));
		btnIniciarEjercicio.addActionListener(eventos);
		
		JButton btnInfografia  = new JButton("Infografia");
		btnInfografia.setBackground(new Color(255, 255, 255));
		btnInfografia.setBounds(0, 204, 234, 40);
		btnInfografia.setFont(new Font("Agency FB", Font.ITALIC, 23));
		btnInfografia.addActionListener(eventos);
		panel.add(btnInfografia);
		panel.add(btnIniciarEjercicio);
		
		JButton btnFinalizarEjercicio = new JButton("Finalizar Ejercicio");
		btnFinalizarEjercicio.setBackground(new Color(255, 255, 255));
		btnFinalizarEjercicio.setBounds(0, 285, 234, 40);
		btnFinalizarEjercicio.setFont(new Font("Agency FB", Font.ITALIC, 23));
		btnFinalizarEjercicio.addActionListener(eventos);
		panel.add(btnFinalizarEjercicio);
		
		JLabel lblTiempoParcial = new JLabel("Tiempo Parcial:");
		lblTiempoParcial.setHorizontalAlignment(SwingConstants.CENTER);
		lblTiempoParcial.setFont(new Font("Agency FB", Font.PLAIN, 20));
		lblTiempoParcial.setForeground(new Color(255, 255, 255));
		lblTiempoParcial.setBounds(0, 40, 234, 24);
		panel.add(lblTiempoParcial);
		
		JLabel lblTiempoTotal = new JLabel("Tiempo Total:");
		lblTiempoTotal.setForeground(new Color(255, 255, 255));
		lblTiempoTotal.setFont(new Font("Agency FB", Font.PLAIN, 20));
		lblTiempoTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTiempoTotal.setBounds(0, 114, 234, 24);
		panel.add(lblTiempoTotal);
		
		JLabel lblFondo = new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Framefondo.png")));
		lblFondo.setBounds(0, 0, 250, 400);
		panel.add(lblFondo);
		JButton btnTerminar = new JButton("Finalizar Rutina");
		btnTerminar.setBackground(new Color(255, 255, 255));
		btnTerminar.setFont(new Font("Agency FB", Font.ITALIC, 23));
		btnTerminar.addActionListener(eventos);
		getContentPane().add(btnTerminar, BorderLayout.SOUTH);

		this.ejercicios = ejercicios;
		this.eventos = eventos;
		this.nivel = nivel;
		thrTiempo = new ThrTiempo(lblTiempo, lblTotal);
		
		
		
		
		thrTiempo.start();
		siguienteEjercicio();
		setVisible(true);
	}
	public void siguienteEjercicio() {
		int tiempo = thrTiempo.reiniciarParcial();
		lblTiempo.setText("00:00");
		if (contador > 0)
			eventos.crearHistorial(ejercicios[contador-1], tiempo, nivel);
		if (contador == ejercicios.length)
			eventos.cerrarVentanas();
		if (contador < ejercicios.length){
			lblNombre.setText(ejercicios[contador].getNombreEjercicio());
			//lblDescripcion.setText(ejercicios[contador].getDescripcionEjercicio());
			thrTiempo.continuar(false);
			contador++;
		}
	}
	public ThrTiempo getThrTiempo() {
		return thrTiempo;
	}
	public int getIdEjercicio() {
		return ejercicios[contador-1].getIdEjercicio();
	}
}
