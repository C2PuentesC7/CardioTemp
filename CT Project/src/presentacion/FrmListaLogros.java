package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class FrmListaLogros extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmListaLogros frame = new FrmListaLogros();
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
	public FrmListaLogros() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblListaDeLogros = new JLabel("Lista de Logros");
		lblListaDeLogros.setFont(new Font("Segoe UI Light", Font.PLAIN, 22));
		lblListaDeLogros.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblListaDeLogros, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		contentPane.add(btnVolver, BorderLayout.SOUTH);
	}

}
