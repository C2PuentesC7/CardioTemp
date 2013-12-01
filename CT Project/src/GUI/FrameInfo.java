package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Window.Type;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;

public class FrameInfo extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblTipo;
	private JLabel lblImagen;
	private JTextArea txtrDescripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameInfo frame = new FrameInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameInfo() {
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTipo = new JLabel("Tipo");
		lblTipo.setForeground(new Color(255, 255, 255));
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo.setFont(new Font("Agency FB", Font.PLAIN, 27));
		lblTipo.setBounds(10, 11, 224, 33);
		contentPane.add(lblTipo);
		
		lblImagen = new JLabel("");
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setBounds(10, 55, 224, 153);
		contentPane.add(lblImagen);
		
		txtrDescripcion = new JTextArea();
		txtrDescripcion.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtrDescripcion.setEditable(false);
		txtrDescripcion.setBackground(new Color(51, 51, 51));
		txtrDescripcion.setForeground(new Color(255, 255, 255));
		txtrDescripcion.setText("Descripcion");
		txtrDescripcion.setBounds(10, 219, 224, 74);
		
		JButton btnVolver = new JButton("Ok");
		btnVolver.setBackground(new Color(255, 255, 255));
		btnVolver.setFont(new Font("Agency FB", Font.ITALIC, 23));
		btnVolver.setBounds(10, 328, 224, 37);
		btnVolver.addActionListener(this);
		contentPane.add(btnVolver);
		
		JScrollPane scrollPane = new JScrollPane(txtrDescripcion);
		scrollPane.setBounds(10, 219, 224, 74);
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
	}
	
}
