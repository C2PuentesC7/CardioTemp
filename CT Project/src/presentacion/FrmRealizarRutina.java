package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.border.TitledBorder;

import Logica.Rutina;
import java.awt.Font;
import javax.swing.SwingConstants;

public class FrmRealizarRutina extends JFrame {

	private Eventos eventos;
	private int cantidad;

	public FrmRealizarRutina(int cantidad, Eventos eventos) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 250, 400);
		getContentPane().setLayout(new BorderLayout(10, 10));

		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		btnVolver.addActionListener(eventos);
		getContentPane().add(btnVolver, BorderLayout.SOUTH);
		JLabel label = new JLabel("Realizar Rutina");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Segoe UI Light", Font.PLAIN, 22));
		getContentPane().add(label, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(10, 1, 10, 10));
		panel.setBorder(null);
		getContentPane().add(panel, BorderLayout.CENTER);

		this.cantidad = cantidad;
		this.eventos = eventos;
		listarRutinas(panel);
		setVisible(true);
	}

	private void listarRutinas(JPanel panel) {
		for (int i = 0; i < cantidad; i++) {
			JButton btnRutina = new JButton("Realizar Rutina " + i);
			btnRutina.setHorizontalAlignment(SwingConstants.CENTER);
			btnRutina.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
			
			btnRutina.addActionListener(eventos);
			panel.add(btnRutina);
		}
	}

}
