package GUI;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

public class FrameEdicionRutina extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel labelNumero;
	private JRadioButton rdbtnEliminar;
	private JRadioButton rdbtnEditarNivel;
	private JRadioButton rdbtnEditarListaEjercicios;
	private JRadioButton rdbtnEditarAlarma;
	private FrmGestionarRutina fgr;
	private JTextField txtNivel;
	private JRadioButton rdbtnNo;
	private JInternalFrame internalFrame;
	private JRadioButton rdbtnSi;
	private JLabel lblInfo;
	private JButton btnListo;
	private JButton btnVolver;
	private JButton btnOk;
	


	/**
	 * Create the frame.
	 * @param fgr 
	 */
	public FrameEdicionRutina(Eventos eventos, FrmGestionarRutina fgr) {
		this.fgr = fgr;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 250, 400);
		setUndecorated(true);
		setIconImage(new ImageIcon(FrmPrincipal.class.getResource("/Imagenes/icono.png")).getImage());
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEditarRutina = new JLabel("Editar Rutina");
		lblEditarRutina.setBackground(new Color(255, 255, 255));
		lblEditarRutina.setForeground(new Color(0, 204, 153));
		lblEditarRutina.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblEditarRutina.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarRutina.setBounds(0, 11, 250, 33);
		contentPane.add(lblEditarRutina);

		btnVolver = new JButton("Volver");
		btnVolver.setHorizontalAlignment(SwingConstants.LEFT);
		btnVolver.setIcon(new ImageIcon(FrameEdicionRutina.class.getResource("/Imagenes/previous.png")));
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setBackground(new Color(42,154,255));
		btnVolver.setFont(new Font("Agency FB", Font.PLAIN, 20));
		btnVolver.setBounds(0, 367, 111, 33);
		btnVolver.addActionListener(this);
		contentPane.add(btnVolver);

		btnOk = new JButton("Ok");
		btnOk.setHorizontalAlignment(SwingConstants.LEFT);
		btnOk.setIcon(new ImageIcon(FrameEdicionRutina.class.getResource("/Imagenes/accept1.png")));
		btnOk.setForeground(new Color(255, 255, 255));
		btnOk.setFont(new Font("Agency FB", Font.PLAIN, 27));
		btnOk.setBackground(new Color(42,154,255));
		btnOk.setBounds(139, 367, 111, 33);
		btnOk.addActionListener(eventos);
		contentPane.add(btnOk);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 51));
		panel.setBounds(12, 235, 228, 121);
		contentPane.add(panel);
		panel.setLayout(null);

		rdbtnEliminar = new JRadioButton("Eliminar");
		rdbtnEliminar.setForeground(new Color(0, 204, 204));
		rdbtnEliminar.setBackground(new Color(51, 51, 51));
		rdbtnEliminar.setBounds(0, 7, 228, 23);
		rdbtnEliminar.setFont(new Font("Agency FB", Font.PLAIN, 20));
		panel.add(rdbtnEliminar);

		rdbtnEditarNivel = new JRadioButton("Editar Nivel");
		rdbtnEditarNivel.setBackground(new Color(51, 51, 51));
		rdbtnEditarNivel.setForeground(new Color(0, 204, 204));
		rdbtnEditarNivel.setBounds(0, 33, 228, 23);
		rdbtnEditarNivel.setFont(new Font("Agency FB", Font.PLAIN, 20));
		panel.add(rdbtnEditarNivel);

		rdbtnEditarListaEjercicios = new JRadioButton("Editar Lista Ejercicios");
		rdbtnEditarListaEjercicios.setBackground(new Color(51, 51, 51));
		rdbtnEditarListaEjercicios.setForeground(new Color(0, 204, 204));
		rdbtnEditarListaEjercicios.setBounds(0, 59, 222, 23);
		rdbtnEditarListaEjercicios.setFont(new Font("Agency FB", Font.PLAIN, 20));
		panel.add(rdbtnEditarListaEjercicios);

		rdbtnEditarAlarma = new JRadioButton("Editar Alarma");
		rdbtnEditarAlarma.setBackground(new Color(51, 51, 51));
		rdbtnEditarAlarma.setForeground(new Color(0, 204, 204));
		rdbtnEditarAlarma.setBounds(0, 85, 222, 23);
		rdbtnEditarAlarma.setFont(new Font("Agency FB", Font.PLAIN, 20));
		panel.add(rdbtnEditarAlarma);
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdbtnEditarAlarma);
		grupo.add(rdbtnEditarListaEjercicios);
		grupo.add(rdbtnEliminar);
		grupo.add(rdbtnEditarNivel);

		internalFrame = new JInternalFrame("");
		internalFrame.setBorder(null);
		internalFrame.getContentPane().setBackground(new Color(51, 51, 51));
		internalFrame.setBounds(12, 68, 228, 156);
		internalFrame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		contentPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		labelNumero = new JLabel("");
		labelNumero.setForeground(new Color(0, 255, 255));
		labelNumero.setFont(new Font("Virtual DJ", Font.PLAIN, 92));
		labelNumero.setHorizontalAlignment(SwingConstants.CENTER);
		labelNumero.setBounds(12, 55, 228, 169);

		lblInfo = new JLabel("");
		lblInfo.setForeground(new Color(0, 255, 153));
		lblInfo.setFont(new Font("Agency FB", Font.PLAIN, 23));
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setBounds(0, 0, 228, 37);
		internalFrame.getContentPane().add(lblInfo);

		txtNivel = new JTextField();
		txtNivel.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtNivel.setBounds(10, 48, 208, 20);
		internalFrame.getContentPane().add(txtNivel);
		txtNivel.setColumns(10);

		btnListo = new JButton("Listo");
		btnListo.setHorizontalAlignment(SwingConstants.LEFT);
		btnListo.setIcon(new ImageIcon(FrameEdicionRutina.class.getResource("/Imagenes/accept1.png")));
		btnListo.setForeground(new Color(255, 255, 255));
		btnListo.setBackground(new Color(0, 102, 204));
		btnListo.setFont(new Font("Agency FB", Font.PLAIN, 26));
		btnListo.setBounds(50, 82, 104, 37);
		btnListo.addActionListener(eventos);
		internalFrame.getContentPane().add(btnListo);
		rdbtnSi = new JRadioButton("Si");
		rdbtnSi.setForeground(new Color(255, 255, 255));
		rdbtnSi.setFont(new Font("Agency FB", Font.PLAIN, 23));
		rdbtnSi.setBackground(new Color(51, 51, 51));
		rdbtnSi.setBounds(50, 62, 53, 23);
		rdbtnSi.addActionListener(eventos);
		internalFrame.getContentPane().add(rdbtnSi);

		rdbtnNo = new JRadioButton("No");
		rdbtnNo.setFont(new Font("Agency FB", Font.PLAIN, 23));
		rdbtnNo.setBackground(new Color(51, 51, 51));
		rdbtnNo.setForeground(new Color(255, 255, 255));
		rdbtnNo.setBounds(134, 62, 53, 23);
		rdbtnNo.addActionListener(eventos);
		ButtonGroup group2 = new ButtonGroup();
		group2.add(rdbtnSi);
		group2.add(rdbtnNo);
		internalFrame.getContentPane().add(rdbtnNo);
		
		
		internalFrame.setVisible(false);


		contentPane.add(labelNumero);



		JLabel lblFondo = new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Framefondo.png")));
		lblFondo.setBounds(0, 0, 250, 400);
		contentPane.add(lblFondo);




		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		setVisible(false);
		fgr.setVisible(true);

	}

	public JLabel getLabelNumero() {
		return labelNumero;
	}

	public JRadioButton getBtnEliminar() {
		return rdbtnEliminar;
	}

	public JRadioButton getBtnEditarNivel() {
		return rdbtnEditarNivel;
	}

	public JRadioButton getBtnEditarListaEjercicios() {
		return rdbtnEditarListaEjercicios;
	}

	public JRadioButton getBtnEditarAlarma() {
		return rdbtnEditarAlarma;
	}

	public JTextField getTxtNivel() {
		return txtNivel;
	}

	public JRadioButton getRdbtnNo() {
		return rdbtnNo;
	}

	public JRadioButton getRdbtnSi() {
		return rdbtnSi;
	}

	public JInternalFrame getInternalFrame() {
		return internalFrame;
	}

	public JLabel getLblInfo() {
		return lblInfo;
	}

	public JButton getBtnListo() {
		return btnListo;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public JButton getBtnOk() {
		return btnOk;
	}
}
