package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.Font;

public class FrmGestionarRutina extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmGestionarRutina frame = new FrmGestionarRutina();
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
	public FrmGestionarRutina() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblGestionarRutinas = new JLabel("Gestionar Rutinas");
		lblGestionarRutinas.setFont(new Font("Segoe UI Light", Font.PLAIN, 22));
		contentPane.add(lblGestionarRutinas, BorderLayout.NORTH);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		contentPane.add(btnVolver, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		contentPane.add(panel, BorderLayout.CENTER);
	}

}
