package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import Logica.Rutina;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class FrmGestionarRutina extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Rutina[] rutinas;
	private Eventos eventos;
	private JPanel panel;
	private JLabel lblConfirmacion;
	private FrmPrincipal fp;
	

	public FrmGestionarRutina(Rutina[] rutinas, FrmPrincipal fp, Eventos eventos) {
		this.fp = fp;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 250, 400);
		setUndecorated(true);
		setIconImage(new ImageIcon(FrmPrincipal.class.getResource("/Imagenes/icono.png")).getImage());
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		getContentPane().setLayout(null);

		
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setIcon(new ImageIcon(FrmGestionarRutina.class.getResource("/Imagenes/previous.png")));
		btnVolver.setHorizontalAlignment(SwingConstants.LEFT);
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setBounds(0, 363, 117, 37);
		btnVolver.setBackground(new Color(42,154,255));
		btnVolver.setFont(new Font("Agency FB", Font.BOLD, 16));
		btnVolver.addActionListener(this);
		getContentPane().add(btnVolver);
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setHorizontalAlignment(SwingConstants.LEFT);
		btnAgregar.setIcon(new ImageIcon(FrmGestionarRutina.class.getResource("/Imagenes/add.png")));
		btnAgregar.setForeground(new Color(255, 255, 255));
		btnAgregar.setBounds(133, 363, 117, 37);
		btnAgregar.setBackground(new Color(42,154,255));
		btnAgregar.setFont(new Font("Agency FB", Font.BOLD, 16));
		btnAgregar.addActionListener(eventos);
		getContentPane().add(btnAgregar);
		
		JLabel label = new JLabel("Editar Rutina");
		label.setForeground(new Color(0, 204, 102));
		label.setBounds(0, 0, 250, 33);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Agency FB", Font.PLAIN, 30));
		getContentPane().add(label);

		panel = new JPanel();
		panel.setBackground(new Color(51, 51, 51));
		panel.setBounds(10, 43, 230, 618);
		GridLayout gl_panel = new GridLayout(21, 1);
		gl_panel.setVgap(5);
		gl_panel.setHgap(5);
		panel.setLayout(gl_panel);
		

		this.rutinas = rutinas;
		this.eventos = eventos;
		listarRutinas(panel);
		JLabel lblFondo = new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Framefondo.png")));
		lblFondo.setBounds(0, 0, 250, 400);
		//getContentPane().add(panel);
		lblConfirmacion = new JLabel("");
		lblConfirmacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmacion.setFont(new Font("Agency FB", Font.PLAIN, 20));
		lblConfirmacion.setBounds(0, 323, 250, 25);
		getContentPane().add(lblConfirmacion);
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setBounds(10, 43, 230, 280);
		getContentPane().add(scrollPane);
		getContentPane().add(lblFondo);
		
		
		setVisible(true);
	}

	public JPanel listarRutinas(JPanel panel) {
		for (int i = 0; i < rutinas.length; i++) {
			JButton btnRutina = new JButton("Editar Rutina " + rutinas[i].getIdRutina());
			btnRutina.setIcon(new ImageIcon(FrmGestionarRutina.class.getResource("/Imagenes/page_edit.png")));
			btnRutina.setForeground(new Color(0, 204, 153));
			btnRutina.setBackground(new Color(51,51,51));
			btnRutina.setFont(new Font("Agency FB", Font.PLAIN, 25));

			btnRutina.setHorizontalAlignment(SwingConstants.LEFT);
			btnRutina.addActionListener(eventos);
			panel.add(btnRutina);
		}
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		setVisible(false);
		fp.setVisible(true);
		
		
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	public JLabel getLblConfirmacion() {
		return lblConfirmacion;
	}
}