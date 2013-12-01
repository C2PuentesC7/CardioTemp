package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.JScrollBar;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;

import Logica.Rutina;

public class FrmRealizarRutina extends JFrame {

	private Eventos eventos;
	private Rutina[] rutinas;

	public FrmRealizarRutina(Rutina[] rutinas, Eventos eventos) {
		getContentPane().setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 250, 400);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBackground(new Color(255, 255, 255));
		btnVolver.setBounds(0, 325, 234, 37);
		btnVolver.setFont(new Font("Agency FB", Font.ITALIC, 23));
		btnVolver.addActionListener(eventos);
		getContentPane().setLayout(null);
		getContentPane().add(btnVolver);
		JLabel label = new JLabel("Realizar Rutina");
		label.setForeground(new Color(255, 255, 255));
		label.setBounds(0, 0, 234, 33);
		label.setFont(new Font("Agency FB", Font.PLAIN, 27));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(label);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 43, 234, 272);
		panel.setLayout(new GridLayout(10, 1));
		getContentPane().add(panel);
		JLabel lblFondo = new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Framefondo.png")));
		lblFondo.setBounds(0, 0, 250, 400);
		getContentPane().add(lblFondo);
		
		this.rutinas = rutinas;
		this.eventos = eventos;
		listarRutinas(panel);
		setVisible(true);
	}

	private void listarRutinas(JPanel panel) {
		for (int i = 0; i < rutinas.length; i++) {
			JButton btnRutina = new JButton("Realizar Rutina " + rutinas[i].getIdRutina());
			btnRutina.setBackground(new Color(255, 255, 255));
			btnRutina.setFont(new Font("Agency FB", Font.ITALIC, 20));
			btnRutina.addActionListener(eventos);
			panel.add(btnRutina);
		}
	}

}
