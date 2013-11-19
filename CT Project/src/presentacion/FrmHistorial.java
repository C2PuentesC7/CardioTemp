package presentacion;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;

import Logica.Historial;

import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

public class FrmHistorial extends JFrame {

	public FrmHistorial(Historial [] historiales, Eventos eventos) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 250, 400);

		JLabel label = new JLabel("Historial");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Segoe UI Light", Font.PLAIN, 22));
		getContentPane().add(label, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		panel.setBorder(null);
		JScrollPane jsb = new JScrollPane(panel);
		getContentPane().add(jsb, BorderLayout.CENTER);

		JPanel pnlAcciones = new JPanel();
		getContentPane().add(pnlAcciones, BorderLayout.SOUTH);
		pnlAcciones.setLayout(new GridLayout(0, 2, 0, 0));

		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		btnVolver.addActionListener(eventos);
		pnlAcciones.add(btnVolver);

		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		btnBorrar.addActionListener(eventos);
		pnlAcciones.add(btnBorrar);
		
		String texto = "";
		JTextArea txtHistorial = new JTextArea();
		for (int i = 0; i < historiales.length; i++){
			texto += historiales[i]+"\n";
			txtHistorial.setText(texto);
		panel.add(txtHistorial, BorderLayout.CENTER);
		}
		this.setVisible(true);
	}
}
