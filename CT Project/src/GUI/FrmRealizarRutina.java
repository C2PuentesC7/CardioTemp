package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import Logica.Rutina;

import javax.swing.SwingConstants;

public class FrmRealizarRutina extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Eventos eventos;
	private Rutina[] rutinas;
	private JLabel lblRutinaVacia;
	private FrmPrincipal fp;

	public FrmRealizarRutina(Rutina[] rutinas, FrmPrincipal fp, Eventos eventos) {
		this.fp = fp;
		getContentPane().setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 250, 400);
		setUndecorated(true);
		setIconImage(new ImageIcon(FrmPrincipal.class.getResource("/Imagenes/icono.png")).getImage());
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		JButton btnVolver = new JButton("Volver");
		btnVolver.setIcon(new ImageIcon(FrmRealizarRutina.class.getResource("/Imagenes/previous.png")));
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setBackground(new Color(42,154,255));
		btnVolver.setBounds(0, 363, 250, 37);
		btnVolver.setFont(new Font("Agency FB", Font.PLAIN, 27));
		btnVolver.addActionListener(this);
		getContentPane().setLayout(null);
		getContentPane().add(btnVolver);
		JLabel label = new JLabel("Realizar Rutina");
		label.setForeground(new Color(0, 204, 102));
		label.setBounds(0, 0, 250, 33);
		label.setFont(new Font("Agency FB", Font.PLAIN, 30));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(label);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51,51,51));
		panel.setBounds(10, 43, 230, 298);
		GridLayout gl_panel = new GridLayout(21, 1);
		gl_panel.setVgap(5);
		gl_panel.setHgap(5);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setBounds(10, 43, 230, 280);
		getContentPane().add(scrollPane);
		
		lblRutinaVacia = new JLabel("");
		lblRutinaVacia.setHorizontalAlignment(SwingConstants.CENTER);
		lblRutinaVacia.setForeground(new Color(255, 0, 0));
		lblRutinaVacia.setFont(new Font("Agency FB", Font.PLAIN, 20));
		lblRutinaVacia.setBounds(0, 328, 250, 24);
		getContentPane().add(lblRutinaVacia);
		
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
			btnRutina.setIcon(new ImageIcon(FrmRealizarRutina.class.getResource("/Imagenes/play.png")));
			btnRutina.setForeground(new Color(0, 204, 153));
			btnRutina.setBackground(new Color(51,51,51));
			btnRutina.setFont(new Font("Agency FB", Font.PLAIN, 25));
			btnRutina.setHorizontalAlignment(SwingConstants.LEFT);
			btnRutina.addActionListener(eventos);
			panel.add(btnRutina);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		setVisible(false);
		fp.setVisible(true);
	}

	public JLabel getLblRutinaVacia() {
		return lblRutinaVacia;
	}
}
