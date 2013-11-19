package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeListener;
import javax.swing.text.Caret;
import javax.swing.text.JTextComponent;
import javax.swing.ImageIcon;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JPasswordField;
import javax.swing.JButton;

public class InicioDeSesion extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField passwordField;
	private JLabel lblNombreDeUsuario;
	private JLabel lblContrasea;
	private JLabel lblLogoct;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioDeSesion frame = new InicioDeSesion();
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
	public InicioDeSesion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		lblLogoct = new JLabel();
		lblLogoct.setIcon(new ImageIcon("logo.png"));
		contentPane.add(lblLogoct);
		
		txtUsuario = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, lblLogoct, -17, SpringLayout.WEST, txtUsuario);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtUsuario, 22, SpringLayout.WEST, contentPane);
		txtUsuario.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		passwordField = new JPasswordField();
		sl_contentPane.putConstraint(SpringLayout.WEST, passwordField, 0, SpringLayout.WEST, txtUsuario);
		sl_contentPane.putConstraint(SpringLayout.EAST, passwordField, -36, SpringLayout.EAST, contentPane);
		passwordField.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		contentPane.add(passwordField);
		
		lblNombreDeUsuario = new JLabel("Nombre de usuario");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblLogoct, -144, SpringLayout.NORTH, lblNombreDeUsuario);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblLogoct, -6, SpringLayout.NORTH, lblNombreDeUsuario);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNombreDeUsuario, 22, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNombreDeUsuario, -163, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtUsuario, 6, SpringLayout.SOUTH, lblNombreDeUsuario);
		lblNombreDeUsuario.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		contentPane.add(lblNombreDeUsuario);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		sl_contentPane.putConstraint(SpringLayout.NORTH, passwordField, 6, SpringLayout.SOUTH, lblContrasea);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblContrasea, 6, SpringLayout.SOUTH, txtUsuario);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblContrasea, 0, SpringLayout.WEST, txtUsuario);
		lblContrasea.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		contentPane.add(lblContrasea);
		
		JButton btnIniciarSesion = new JButton("Iniciar sesi\u00F3n");
		sl_contentPane.putConstraint(SpringLayout.EAST, lblLogoct, 0, SpringLayout.EAST, btnIniciarSesion);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnIniciarSesion, 49, SpringLayout.EAST, lblNombreDeUsuario);
		btnIniciarSesion.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		sl_contentPane.putConstraint(SpringLayout.WEST, btnIniciarSesion, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnIniciarSesion, 0, SpringLayout.SOUTH, contentPane);
		contentPane.add(btnIniciarSesion);
	}
}
