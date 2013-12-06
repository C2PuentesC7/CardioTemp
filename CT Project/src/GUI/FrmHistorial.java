package GUI;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;

import Logica.Historial;

import java.awt.GridLayout;
import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmHistorial extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FrmPrincipal fp;
	private JRadioButton rdbtnNo;
	private JInternalFrame internalFrame;
	private JRadioButton rdbtnSi;
	private JLabel lblInfo;
	private JButton btnVolver;
	private JButton btnBorrar;

	public FrmHistorial(Historial [] historiales, FrmPrincipal fp, Eventos eventos) {
		this.fp = fp;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 250, 400);
		setUndecorated(true);
		setIconImage(new ImageIcon(FrmPrincipal.class.getResource("/Imagenes/icono.png")).getImage());
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		getContentPane().setLayout(null);
		JLabel label = new JLabel("Historial");
		label.setForeground(new Color(0, 204, 102));
		label.setBounds(0, 0, 250, 33);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Agency FB", Font.PLAIN, 30));
		getContentPane().add(label);
		internalFrame = new JInternalFrame("");
		internalFrame.setBorder(null);
		internalFrame.getContentPane().setBackground(new Color(51, 51, 51));
		internalFrame.setBounds(10, 34, 228, 156);
		internalFrame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		lblInfo = new JLabel("Borrar historial?");
		lblInfo.setForeground(new Color(0, 255, 153));
		lblInfo.setFont(new Font("Agency FB", Font.PLAIN, 23));
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setBounds(0, 0, 228, 37);
		internalFrame.getContentPane().add(lblInfo);
		rdbtnSi = new JRadioButton("Si");
		rdbtnSi.setForeground(new Color(255, 255, 255));
		rdbtnSi.setFont(new Font("Agency FB", Font.PLAIN, 23));
		rdbtnSi.setBackground(new Color(51, 51, 51));
		rdbtnSi.setBounds(35, 72, 53, 23);
		rdbtnSi.addActionListener(eventos);
		internalFrame.getContentPane().add(rdbtnSi);

		rdbtnNo = new JRadioButton("No");
		rdbtnNo.setFont(new Font("Agency FB", Font.PLAIN, 23));
		rdbtnNo.setBackground(new Color(51, 51, 51));
		rdbtnNo.setForeground(new Color(255, 255, 255));
		rdbtnNo.setBounds(132, 65, 53, 37);
		rdbtnNo.addActionListener(eventos);
		ButtonGroup group2 = new ButtonGroup();
		group2.add(rdbtnSi);
		group2.add(rdbtnNo);
		internalFrame.getContentPane().add(rdbtnNo);
		
		JLabel lblLogros = new JLabel("Logros incluidos");
		lblLogros.setForeground(new Color(0,255,153));
		lblLogros.setFont(new Font("Agency FB", Font.PLAIN, 23));
		lblLogros.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogros.setBounds(0, 34, 228, 31);
		internalFrame.getContentPane().add(lblLogros);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 51));
		panel.setLayout(new GridLayout(20,1));
		JScrollPane slpLista = new JScrollPane(panel);
		slpLista.setBounds(10,43,230,298);
		getContentPane().add(slpLista);
		
		
		
		
		JPanel pnlAcciones = new JPanel();
		pnlAcciones.setBounds(0, 363, 250, 37);
		getContentPane().add(pnlAcciones);
		pnlAcciones.setLayout(new GridLayout(0, 2, 0, 0));

		btnVolver = new JButton("Volver");
		btnVolver.setHorizontalAlignment(SwingConstants.LEFT);
		btnVolver.setIcon(new ImageIcon(FrmHistorial.class.getResource("/Imagenes/previous.png")));
		btnVolver.setBackground(new Color(42,154,255));
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setFont(new Font("Agency FB", Font.PLAIN, 23));
		btnVolver.addActionListener(this);
		pnlAcciones.add(btnVolver);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setIcon(new ImageIcon(FrmHistorial.class.getResource("/Imagenes/remove1.png")));
		btnBorrar.setHorizontalAlignment(SwingConstants.LEFT);
		btnBorrar.setBackground(new Color(42,154,255));
		btnBorrar.setForeground(new Color(255, 255, 255));
		btnBorrar.setFont(new Font("Agency FB", Font.PLAIN, 23));
		btnBorrar.addActionListener(eventos);
		pnlAcciones.add(btnBorrar);
		 
		
		JTextArea[] lista = new JTextArea[historiales.length];
		for (int i = 0; i < historiales.length; i++){
			lista[i] = new JTextArea(historiales[i]+"");
			lista[i].setBackground(new Color(51,51,51));
			lista[i].setForeground(new Color(0, 204, 153));
			lista[i].setFont(new Font("Agency FB", Font.PLAIN, 20));
			lista[i].setEditable(false);
			panel.add(lista[i]);
		}
		JLabel lblFondo = new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Framefondo.png")));
		lblFondo.setBounds(0,0,250,400);
		getContentPane().add(lblFondo);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		setVisible(false);
		fp.setVisible(true);
		
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
	public JButton getBtnVolver() {
		return btnVolver;
	}
	public JButton getBtnBorrar(){
		return btnBorrar;
		
	}
}
