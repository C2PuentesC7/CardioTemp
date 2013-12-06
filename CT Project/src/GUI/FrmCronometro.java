package GUI;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import Logica.Ejercicio;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmCronometro extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblNombre;
	private Ejercicio[] ejercicios;
	private ThrTiempo thrTiempo;
	private int contador;
	private Eventos eventos;
	private int nivel;
	private JLabel lblTiempo;
	private JLabel lblLogroCumplido;
	private FrmRealizarRutina frr;
	public FrmCronometro(Ejercicio[] ejercicios, Eventos eventos, int nivel, FrmRealizarRutina frr) {
		this.frr = frr;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		setBounds(100, 100, 250, 400);
		setIconImage(new ImageIcon(FrmPrincipal.class.getResource("/Imagenes/icono.png")).getImage());
		JPanel panel = new JPanel();
		panel.setBorder(null);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		lblNombre = new JLabel("Nombre Ejercicio");
		lblNombre.setForeground(new Color(0, 204, 255));
		lblNombre.setBounds(0, 11, 250, 52);
		lblNombre.setFont(new Font("Agency FB", Font.BOLD, 37));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNombre);
		lblTiempo = new JLabel("00:00");
		lblTiempo.setForeground(Color.GREEN);
		lblTiempo.setBounds(0, 99, 250, 40);
		lblTiempo.setFont(new Font("Virtual DJ", Font.PLAIN, 50));
		lblTiempo.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblTiempo);
		JLabel lblTotal = new JLabel("00:00");
		lblTotal.setForeground(new Color(0, 255, 102));
		lblTotal.setBounds(0, 164, 250, 40);
		lblTotal.setFont(new Font("Virtual DJ", Font.PLAIN, 50));
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblTotal);

		JButton btnIniciarEjercicio = new JButton("Iniciar Ejercicio");
		btnIniciarEjercicio.setHorizontalAlignment(SwingConstants.LEFT);
		btnIniciarEjercicio.setIcon(new ImageIcon(FrmCronometro.class.getResource("/Imagenes/play1.png")));
		btnIniciarEjercicio.setBackground(new Color(42,154,255));
		btnIniciarEjercicio.setForeground(new Color(255, 255, 255));
		btnIniciarEjercicio.setBounds(0, 280, 250, 40);
		btnIniciarEjercicio.setFont(new Font("Agency FB", Font.PLAIN, 27));
		btnIniciarEjercicio.addActionListener(eventos);

		JButton btnInfografia  = new JButton("Info");
		btnInfografia.setHorizontalAlignment(SwingConstants.LEFT);
		btnInfografia.setIcon(new ImageIcon(FrmCronometro.class.getResource("/Imagenes/info.png")));
		btnInfografia.setBackground(new Color(42,154,255));
		btnInfografia.setForeground(new Color(255, 255, 255));
		btnInfografia.setBounds(0, 240, 108, 40);
		btnInfografia.setFont(new Font("Agency FB", Font.PLAIN, 20));
		btnInfografia.addActionListener(eventos);
		panel.add(btnInfografia);
		panel.add(btnIniciarEjercicio);

		JButton btnFinalizarEjercicio = new JButton("Finalizar Ejercicio");
		btnFinalizarEjercicio.setHorizontalAlignment(SwingConstants.LEFT);
		btnFinalizarEjercicio.setIcon(new ImageIcon(FrmCronometro.class.getResource("/Imagenes/stop.png")));
		btnFinalizarEjercicio.setBackground(new Color(42,154,255));
		btnFinalizarEjercicio.setForeground(new Color(255, 255, 255));
		btnFinalizarEjercicio.setBounds(0, 319, 250, 40);
		btnFinalizarEjercicio.setFont(new Font("Agency FB", Font.PLAIN, 27));
		btnFinalizarEjercicio.addActionListener(eventos);
		panel.add(btnFinalizarEjercicio);

		JLabel lblTiempoParcial = new JLabel("Tiempo Parcial:");
		lblTiempoParcial.setHorizontalAlignment(SwingConstants.CENTER);
		lblTiempoParcial.setFont(new Font("Agency FB", Font.PLAIN, 23));
		lblTiempoParcial.setForeground(new Color(255, 255, 255));
		lblTiempoParcial.setBounds(0, 74, 250, 24);
		panel.add(lblTiempoParcial);

		JLabel lblTiempoTotal = new JLabel("Tiempo Total:");
		lblTiempoTotal.setForeground(new Color(255, 255, 255));
		lblTiempoTotal.setFont(new Font("Agency FB", Font.PLAIN, 23));
		lblTiempoTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTiempoTotal.setBounds(0, 140, 250, 24);
		panel.add(lblTiempoTotal);
		lblLogroCumplido = new JLabel("");
		lblLogroCumplido.setForeground(Color.GREEN);
		lblLogroCumplido.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogroCumplido.setFont(new Font("Agency FB", Font.PLAIN, 20));
		lblLogroCumplido.setBounds(0, 216, 240, 24);
		panel.add(lblLogroCumplido);
		JButton btnPausa = new JButton("Pausa");
		btnPausa.setHorizontalAlignment(SwingConstants.LEFT);
		btnPausa.setIcon(new ImageIcon(FrmCronometro.class.getResource("/Imagenes/pause.png")));
		btnPausa.setBackground(new Color(42,154,255));
		btnPausa.setForeground(new Color(255, 255, 255));
		btnPausa.setFont(new Font("Agency FB", Font.PLAIN, 20));
		btnPausa.setBounds(142, 240, 108, 40);
		btnPausa.addActionListener(eventos);
		panel.add(btnPausa);
		
		JLabel lblFondo = new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Framefondo.png")));
		lblFondo.setBounds(0, 0, 250, 400);
		panel.add(lblFondo);
		JButton btnTerminar = new JButton("Finalizar Rutina");
		btnTerminar.setHorizontalAlignment(SwingConstants.LEFT);
		btnTerminar.setIcon(new ImageIcon(FrmCronometro.class.getResource("/Imagenes/stop.png")));
		btnTerminar.setBackground(new Color(42,154,255));
		btnTerminar.setForeground(new Color(255, 255, 255));
		btnTerminar.setFont(new Font("Agency FB", Font.PLAIN, 27));
		btnTerminar.addActionListener(this);
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
		if (contador > 0){
			eventos.crearHistorial(ejercicios[contador-1], tiempo, nivel);
		}
		if (contador == ejercicios.length){
			setVisible(false);
			frr.setVisible(true);
		}
		if (contador < ejercicios.length){
			lblNombre.setText(ejercicios[contador].getNombreEjercicio());
			thrTiempo.continuar(false);
			contador++;
		}
	}
	public void pausar(){
		thrTiempo.continuar(false);
	}
	public ThrTiempo getThrTiempo() {
		return thrTiempo;
	}
	public int getIdEjercicio() {
		return ejercicios[contador-1].getIdEjercicio();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		setVisible(false);
		frr.setVisible(true);
		
	}
	public JLabel getLblLogroCumplido() {
		return lblLogroCumplido;
	}
	
}
