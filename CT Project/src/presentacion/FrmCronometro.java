package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.UIManager;

import logica.Ejercicio;
import logica.Gestion;

import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Font;

public class FrmCronometro extends JFrame {
	private JLabel lblDescripcion;
	private JLabel lblNombre;
	private Ejercicio[] ejercicios;
	private ThrTiempo thrTiempo;
	private int contador;
	private Eventos eventos;
	private int nivel;
	public FrmCronometro(Ejercicio[] ejercicios, Eventos eventos, int nivel) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 250, 400);
		JPanel panel = new JPanel();
		panel.setBorder(null);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		lblNombre = new JLabel("Nombre Ejercicio");
		lblNombre.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		panel.add(lblNombre);
		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		panel.add(lblDescripcion);
		JLabel lblTiempo = new JLabel("Tiempo");
		lblTiempo.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		panel.add(lblTiempo);
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		panel.add(lblTotal);

		JButton btnIniciarEjercicio = new JButton("Iniciar Ejercicio");
		btnIniciarEjercicio.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		btnIniciarEjercicio.addActionListener(eventos);
		panel.add(btnIniciarEjercicio);

		JButton btnFinalizarEjercicio = new JButton("Finalizar Ejercicio");
		btnFinalizarEjercicio.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		btnFinalizarEjercicio.addActionListener(eventos);
		panel.add(btnFinalizarEjercicio);

		JLabel label = new JLabel("Rutina");
		label.setFont(new Font("Segoe UI Light", Font.PLAIN, 22));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(label, BorderLayout.NORTH);

		JButton btnTerminar = new JButton("Finalizar Rutina");
		btnTerminar.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
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
		if (contador > 0)
			eventos.crearHistorial(ejercicios[contador-1].getIdEjercicio(), tiempo, nivel);
		if (contador == ejercicios.length)
			eventos.cerrarVentanas();
		if (contador < ejercicios.length){
			lblNombre.setText(ejercicios[contador].getNombreEjercicio());
			lblDescripcion.setText(ejercicios[contador].getDescripcionEjercicio());
			thrTiempo.continuar(false);
			contador++;
		}
	}
	public ThrTiempo getThrTiempo() {
		return thrTiempo;
	}
}
