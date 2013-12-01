package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import Logica.Logro;

import java.awt.Font;
import java.awt.Color;

public class FrmListaLogros extends JFrame {

	public FrmListaLogros(Logro[] logros, Eventos eventos) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 400);
		getContentPane().setLayout(null);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		JLabel lblListaDeLogros = new JLabel("Lista de Logros");
		lblListaDeLogros.setForeground(new Color(255, 255, 255));
		lblListaDeLogros.setBounds(0, 0, 234, 33);
		lblListaDeLogros.setFont(new Font("Agency FB", Font.PLAIN, 27));
		lblListaDeLogros.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblListaDeLogros);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(null);
		panel.setLayout(new GridLayout(10,1));
		JScrollPane slpLista = new JScrollPane(panel);
		slpLista.setBounds(0, 33, 234, 292);
		getContentPane().add(slpLista);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBackground(new Color(255, 255, 255));
		btnVolver.setForeground(new Color(0, 0, 0));
		btnVolver.setBounds(0, 325, 234, 37);
		btnVolver.setFont(new Font("Agency FB", Font.ITALIC, 23));
		btnVolver.addActionListener(eventos);
		getContentPane().add(btnVolver);
		
		JLabel[] lista = new JLabel[logros.length];
		for (int i = 0; i < logros.length; i++){
			lista[i] = new JLabel(logros[i]+"");
			if (!logros[i].isCumplido())
				lista[i].setEnabled(false);
			panel.add(lista[i]);
		}
		JLabel lblFondo = new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Framefondo.png")));
		lblFondo.setBounds(0, 0, 250, 400);
		getContentPane().add(lblFondo);

		setVisible(true);
	}
}
