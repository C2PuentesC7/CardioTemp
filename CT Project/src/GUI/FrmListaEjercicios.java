package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import Logica.Ejercicio;

public class FrmListaEjercicios extends JFrame {
private int idRutina;
private Eventos eventos;
private JCheckBox[] ckbLista;
	public FrmListaEjercicios(int idRutina, Ejercicio[] ejercicios, Eventos eventos) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 400);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);

		JLabel lblEditarListaDe = new JLabel("Editar Lista de Ejercicios");
		add(lblEditarListaDe, BorderLayout.NORTH);

		JPanel pnlAcciones = new JPanel();
		add(pnlAcciones, BorderLayout.SOUTH);
		pnlAcciones.setLayout(new GridLayout(0, 2, 0, 0));

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(eventos);
		pnlAcciones.add(btnVolver);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(eventos);
		pnlAcciones.add(btnGuardar);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Lista Ejercicios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setLayout(new GridLayout(10,1));
		JScrollPane slpLista = new JScrollPane(panel);
		add(slpLista, BorderLayout.CENTER);
		
		Ejercicio[] listaEjercicios = eventos.listarEjercicios();
		ckbLista = new JCheckBox[listaEjercicios.length];
		for (int i = 0; i < ckbLista.length; i++){
			ckbLista[i] = new JCheckBox(listaEjercicios[i]+"");
			ckbLista[i].setSelected(existe(listaEjercicios[i], ejercicios));
			panel.add(ckbLista[i]);
		}
		this.eventos = eventos;
		this.idRutina = idRutina;
		
		setVisible(true);
	}

	private boolean existe(Ejercicio ejercicio, Ejercicio[] ejercicios) {
		for (int i = 0; i < ejercicios.length; i++)
			if (ejercicio.getIdEjercicio() == ejercicios[i].getIdEjercicio())
				return true;
		return false;
	}

	public int getIdRutina() {
		return idRutina;
	}

	public ArrayList<Ejercicio> getListaEjercicios() {
		ArrayList<Ejercicio> lista = new ArrayList<Ejercicio>();
		Ejercicio[] listaEjercicios = eventos.listarEjercicios();
		for (int i = 0; i < listaEjercicios.length; i++)
			if (ckbLista[i].isSelected())
				lista.add(listaEjercicios[i]);
		return lista;
	}

}
