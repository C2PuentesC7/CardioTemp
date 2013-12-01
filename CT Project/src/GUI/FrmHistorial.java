package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;

import Logica.Historial;

import java.awt.GridLayout;

public class FrmHistorial extends JFrame {

	public FrmHistorial(Historial [] historiales, Eventos eventos) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 250, 400);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		add(new JLabel("Historial"), BorderLayout.NORTH);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Lista de historial", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setLayout(new GridLayout(10,1));
		JScrollPane slpLista = new JScrollPane(panel);
		add(slpLista, BorderLayout.CENTER);

		JPanel pnlAcciones = new JPanel();
		add(pnlAcciones, BorderLayout.SOUTH);
		pnlAcciones.setLayout(new GridLayout(0, 2, 0, 0));

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(eventos);
		pnlAcciones.add(btnVolver);

		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(eventos);
		pnlAcciones.add(btnBorrar);
		
		JLabel[] lista = new JLabel[historiales.length];
		for (int i = 0; i < historiales.length; i++){
			lista[i] = new JLabel(historiales[i]+"");
			panel.add(lista[i]);
		}
		
		this.setVisible(true);
	}
}
