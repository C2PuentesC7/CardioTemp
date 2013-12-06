package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import Logica.Ejercicio;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class FrmListaEjercicios extends JFrame implements ActionListener {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int idRutina;
private Eventos eventos;
private JCheckBox[] ckbLista;
private FrameEdicionRutina fer;
	public FrmListaEjercicios(int idRutina, Ejercicio[] ejercicios, FrameEdicionRutina fer, Eventos eventos) {
		this.fer = fer;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 400);
		setUndecorated(true);
		setIconImage(new ImageIcon(FrmPrincipal.class.getResource("/Imagenes/icono.png")).getImage());
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		getContentPane().setLayout(null);

		JLabel lblEditarListaDe = new JLabel("Editar Lista de Ejercicios");
		lblEditarListaDe.setForeground(new Color(0, 204, 102));
		lblEditarListaDe.setBounds(0, 0, 250, 36);
		lblEditarListaDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarListaDe.setFont(new Font("Agency FB", Font.PLAIN, 30));
		getContentPane().add(lblEditarListaDe);

		JPanel pnlAcciones = new JPanel();
		pnlAcciones.setBounds(0, 359, 250, 41);
		getContentPane().add(pnlAcciones);
		pnlAcciones.setLayout(new GridLayout(0, 2, 0, 0));

		JButton btnVolver = new JButton("Volver");
		btnVolver.setHorizontalAlignment(SwingConstants.LEFT);
		btnVolver.setIcon(new ImageIcon(FrmListaEjercicios.class.getResource("/Imagenes/previous.png")));
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setBackground(new Color(42,154,255));
		btnVolver.setFont(new Font("Agency FB", Font.PLAIN, 23));
		btnVolver.addActionListener(this);
		pnlAcciones.add(btnVolver);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(FrmListaEjercicios.class.getResource("/Imagenes/save.png")));
		btnGuardar.setHorizontalAlignment(SwingConstants.LEFT);
		btnGuardar.setForeground(new Color(255, 255, 255));
		btnGuardar.setBackground(new Color(42,154,255));
		btnGuardar.setFont(new Font("Agency FB", Font.PLAIN, 23));
		btnGuardar.addActionListener(eventos);
		pnlAcciones.add(btnGuardar);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51,51,51));
		panel.setBorder(null);
		panel.setLayout(new GridLayout(10,1));
		JScrollPane slpLista = new JScrollPane(panel);
		slpLista.setBounds(10, 36, 230, 323);
		getContentPane().add(slpLista);
		
		
		
		Ejercicio[] listaEjercicios = eventos.listarEjercicios();
		ckbLista = new JCheckBox[listaEjercicios.length];
		for (int i = 0; i < ckbLista.length; i++){
			ckbLista[i] = new JCheckBox(listaEjercicios[i]+"");
			ckbLista[i].setFont(new Font("Agency FB", Font.PLAIN, 20));
			ckbLista[i].setBackground(new Color(51,51,51));
			ckbLista[i].setForeground(new Color(0, 204, 153));
			ckbLista[i].setSelected(existe(listaEjercicios[i], ejercicios));
			panel.add(ckbLista[i]);
		}
		this.eventos = eventos;
		this.idRutina = idRutina;
		JLabel lblFondo = new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Framefondo.png")));
		lblFondo.setBounds(0,0,250,400);
		getContentPane().add(lblFondo);
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		setVisible(false);
		fer.setVisible(true);
		
	}

}
