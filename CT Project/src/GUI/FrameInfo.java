package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JRootPane;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;

public class FrameInfo extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblTipo;
	private JLabel lblImagen;
	private JTextArea txtrDescripcion;
	private FrmPrincipal fp;
	private FrmCronometro fc;


	/**
	 * Create the frame.
	 * @param fp 
	 * @param fc 
	 */
	public FrameInfo(FrmPrincipal fp, FrmCronometro fc) {
		this.fp = fp;
		this.fc = fc;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 400);
		setIconImage(new ImageIcon(FrmPrincipal.class.getResource("/Imagenes/icono.png")).getImage());
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(10, 11, 224, 33);
		lblTipo.setForeground(new Color(0, 204, 102));
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo.setFont(new Font("Agency FB", Font.PLAIN, 30));
		contentPane.add(lblTipo);
		
		lblImagen = new JLabel("");
		lblImagen.setBounds(10, 78, 224, 94);
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblImagen);
		
		JButton btnVolver = new JButton("Ok");
		btnVolver.setIcon(new ImageIcon(FrameInfo.class.getResource("/Imagenes/accept1.png")));
		btnVolver.setBounds(0, 363, 250, 37);
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setBackground(new Color(42,154,255));
		btnVolver.setFont(new Font("Agency FB", Font.PLAIN, 27));
		btnVolver.addActionListener(this);
		contentPane.add(btnVolver);
		txtrDescripcion = new JTextArea();
		txtrDescripcion.setColumns(2);
		txtrDescripcion.setFont(new Font("Agency FB", Font.PLAIN, 18));
		txtrDescripcion.setEditable(false);
		txtrDescripcion.setBackground(new Color(51,51,51));
		txtrDescripcion.setForeground(new Color(0, 204, 153));
		txtrDescripcion.setText("Descripcion");
		txtrDescripcion.setLineWrap(true);
		txtrDescripcion.setWrapStyleWord(true);
		txtrDescripcion.setBounds(10, 200, 224, 147);
		contentPane.add(txtrDescripcion);
		JScrollPane scrollPane = new JScrollPane(txtrDescripcion);
		scrollPane.setBounds(10, 200, 224, 147);
		scrollPane.setBorder(null);
		contentPane.add(scrollPane);
		
		JLabel lblFondo = new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Framefondo.png")));
		lblFondo.setBounds(0, 0, 250, 400);
		contentPane.add(lblFondo);
		
		
	}

	public JLabel getLblTipo() {
		return lblTipo;
	}

	public JLabel getLblImagen() {
		return lblImagen;
	}

	public JTextArea getTxtrDescripcion() {
		return txtrDescripcion;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		this.setVisible(false);
		if (fc != null) {
			fc.setVisible(true);
		}else
		if (fp != null) {
			fp.setVisible(true);
		}
	}
}
