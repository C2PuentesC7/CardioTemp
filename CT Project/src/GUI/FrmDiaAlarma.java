package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;

import Logica.Ejercicio;

import java.awt.Font;
import java.awt.Color;

public class FrmDiaAlarma extends JFrame {
	private int idRutina;
	private Eventos eventos;
	private JCheckBox[] ckbLista;
	private JTextField txfHora;
	private JTextField txfMinuto;
	public FrmDiaAlarma(int idRutina, Eventos eventos) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 400);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		getContentPane().setLayout(null);

		JLabel lblEditarListaDe = new JLabel("Dias alarma de la Rutina 0");
		lblEditarListaDe.setForeground(new Color(255, 255, 255));
		lblEditarListaDe.setBounds(0, 0, 234, 30);
		lblEditarListaDe.setFont(new Font("Agency FB", Font.PLAIN, 25));
		lblEditarListaDe.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblEditarListaDe);

		JPanel pnlAcciones = new JPanel();
		pnlAcciones.setBounds(0, 329, 234, 33);
		getContentPane().add(pnlAcciones);
		pnlAcciones.setLayout(new GridLayout(0, 2));

		JButton btnVolver = new JButton("Volver");
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setBackground(new Color(0, 0, 0));
		btnVolver.setFont(new Font("Agency FB", Font.PLAIN, 20));
		btnVolver.addActionListener(eventos);
		pnlAcciones.add(btnVolver);

		JButton btnProgramar = new JButton("Programar");
		btnProgramar.setForeground(new Color(255, 255, 255));
		btnProgramar.setBackground(new Color(0, 0, 0));
		btnProgramar.setFont(new Font("Agency FB", Font.PLAIN, 20));
		btnProgramar.addActionListener(eventos);
		pnlAcciones.add(btnProgramar);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(null);
		panel.setLayout(new GridLayout(11,1));
		JScrollPane slpLista = new JScrollPane(panel);
		slpLista.setBounds(0, 30, 234, 299);
		getContentPane().add(slpLista);

		boolean[] seleccion = eventos.getGestion().getRutina(idRutina).getDiaAlarma();
		int[] hora = eventos.getGestion().getRutina(idRutina).getHoraAlarma();
		String [] dias = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
		ckbLista = new JCheckBox[7];
		for (int i = 0; i < 7; i++){
			ckbLista[i] = new JCheckBox(dias[i]);
			ckbLista[i].setFont(new Font("Agency FB", Font.PLAIN, 20));
			ckbLista[i].setBackground(new Color(255, 255, 255));
			ckbLista[i].setSelected(seleccion[i]);
			panel.add(ckbLista[i]);
		}
		
		JLabel label = new JLabel("Hora Alarma");
		label.setFont(new Font("Agency FB", Font.PLAIN, 20));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label);
		txfHora = new JTextField(hora[0]+"", 2);
		txfHora.setFont(new Font("LCD", Font.PLAIN, 23));
		panel.add(txfHora);
		JLabel label_1 = new JLabel("Minuto Alarma");
		label_1.setFont(new Font("Agency FB", Font.PLAIN, 20));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label_1);
		txfMinuto = new JTextField(hora[1]+"",2);
		txfMinuto.setFont(new Font("LCD", Font.PLAIN, 23));
		panel.add(txfMinuto);
		
		this.eventos = eventos;
		this.idRutina = idRutina;
		JLabel lblFondo = new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Framefondo.png")));
		lblFondo.setBounds(0, 0, 250, 400);
		getContentPane().add(lblFondo);
		setVisible(true);
	}

	public int getIdRutina() {
		return idRutina;
	}

	public boolean[] getDiaAlarma() {
		boolean[] lista = new boolean[7];
		for (int i = 0; i < 7; i++)
			lista[i] = ckbLista[i].isSelected();
		return lista;
	}
	public int[] getHoraAlarma(){
		int[] par= new int[2];
		par[0] = new Integer(txfHora.getText());
		par[1] = new Integer(txfMinuto.getText());
		return par;
	}
}
