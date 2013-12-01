package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;

import Logica.Rutina;

public class FrmGestionarRutina extends JFrame {

	private Rutina[] rutinas;
	private Eventos eventos;

	public FrmGestionarRutina(Rutina[] rutinas, Eventos eventos) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 250, 400);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		getContentPane().setLayout(null);

		JLabel label = new JLabel("Editar Rutina");
		label.setForeground(new Color(255, 255, 255));
		label.setBounds(0, 0, 234, 33);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Agency FB", Font.PLAIN, 27));
		getContentPane().add(label);
		
		JPanel pnlAcciones = new JPanel();
		pnlAcciones.setBounds(0, 325, 234, 37);
		getContentPane().add(pnlAcciones);
		pnlAcciones.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBackground(new Color(255, 255, 255));
		btnVolver.setFont(new Font("Agency FB", Font.ITALIC, 23));
		btnVolver.addActionListener(eventos);
		pnlAcciones.add(btnVolver);
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBackground(new Color(255, 255, 255));
		btnAgregar.setFont(new Font("Agency FB", Font.ITALIC, 23));
		btnAgregar.addActionListener(eventos);
		pnlAcciones.add(btnAgregar);
		

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 43, 234, 272);
		panel.setLayout(new GridLayout(10, 1));
		

		this.rutinas = rutinas;
		this.eventos = eventos;
		listarRutinas(panel);
		JLabel lblFondo = new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Framefondo.png")));
		lblFondo.setBounds(0, 0, 250, 400);
		getContentPane().add(panel);
		getContentPane().add(lblFondo);
		setVisible(true);
	}

	private void listarRutinas(JPanel panel) {
		for (int i = 0; i < rutinas.length; i++) {
			JButton btnRutina = new JButton("Editar Rutina " + rutinas[i].getIdRutina());
			btnRutina.setBackground(new Color(255, 255, 255));
			btnRutina.setFont(new Font("Agency FB", Font.ITALIC, 20));
			btnRutina.addActionListener(eventos);
			panel.add(btnRutina);
		}
	}
}