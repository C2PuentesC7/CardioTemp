package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import Logica.Gestion;
import javax.swing.SwingConstants;
import java.awt.Font;

public class FrmPrincipal extends JFrame {

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
	}

	public FrmPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 400);
		getContentPane().setLayout(new BorderLayout(0, 0));
		eventos = new Eventos();

		JLabel labelTitulo = new JLabel("Cardio Temp");
		labelTitulo.setFont(new Font("Segoe UI Light", Font.BOLD, 22));
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(labelTitulo, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		panel.setBorder(null);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(5, 1, 10, 10));

		JButton btnRealizarRutina = new JButton("Realizar Rutina");
		btnRealizarRutina.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		btnRealizarRutina.addActionListener(eventos);
		panel.add(btnRealizarRutina);

		JButton btnGestionarRutinas = new JButton("Gestionar Rutinas");
		btnGestionarRutinas.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		btnGestionarRutinas.addActionListener(eventos);
		panel.add(btnGestionarRutinas);

		JButton btnVerTip = new JButton("Ver Tip");
		btnVerTip.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		btnVerTip.addActionListener(eventos);
		panel.add(btnVerTip);

		JButton btnListaLogros = new JButton("Lista de Logros");
		btnListaLogros.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		btnListaLogros.addActionListener(eventos);
		panel.add(btnListaLogros);

		JButton btnVerHistorial = new JButton("Ver Historial");
		btnVerHistorial.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		btnVerHistorial.addActionListener(eventos);
		panel.add(btnVerHistorial);
	}

}
