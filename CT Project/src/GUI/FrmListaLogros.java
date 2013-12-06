package GUI;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;

import Logica.Logro;

import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmListaLogros extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FrmPrincipal fp;
	public FrmListaLogros(Logro[] logros, FrmPrincipal fp, Eventos eventos) {
		this.fp =fp;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 400);
		setUndecorated(true);
		setIconImage(new ImageIcon(FrmPrincipal.class.getResource("/Imagenes/icono.png")).getImage());
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		getContentPane().setLayout(null);
		JLabel lblListaDeLogros = new JLabel("Lista de Logros");
		lblListaDeLogros.setBounds(0, 0, 250, 33);
		lblListaDeLogros.setForeground(new Color(0, 204, 102));
		lblListaDeLogros.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblListaDeLogros.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblListaDeLogros);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51,51,51));
		panel.setBorder(null);
		panel.setLayout(new GridLayout(10,1));
		JScrollPane slpLista = new JScrollPane(panel);
		slpLista.setBounds(10, 43, 230, 309);
		getContentPane().add(slpLista);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setIcon(new ImageIcon(FrmListaLogros.class.getResource("/Imagenes/previous.png")));
		btnVolver.setBounds(0, 363, 250, 37);
		btnVolver.setBackground(new Color(42,154,255));
		btnVolver.setForeground(new Color(255,255,255));
		btnVolver.setFont(new Font("Agency FB", Font.PLAIN, 27));
		btnVolver.addActionListener(this);
		getContentPane().add(btnVolver);
		ImageIcon cumplido = new ImageIcon(FrmListaLogros.class.getResource("/Imagenes/accept.png"));
		ImageIcon noCumplido = new ImageIcon(FrmListaLogros.class.getResource("/Imagenes/remove.png"));
		JLabel[] lista = new JLabel[logros.length];
		for (int i = 0; i < logros.length; i++){
			lista[i] = new JLabel(logros[i]+"");
			lista[i].setFont(new Font("Agency FB", Font.PLAIN, 20));
			if(logros[i].isCumplido()){
				lista[i].setForeground(Color.GREEN);
				lista[i].setIcon(cumplido);
			}else{
				lista[i].setIcon(noCumplido);
				lista[i].setForeground(Color.white);
			}
			panel.add(lista[i]);
		}
		JLabel lblFondo = new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Framefondo.png")));
		lblFondo.setBounds(0, 0, 250, 400);
		getContentPane().add(lblFondo);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		setVisible(false);
		fp.setVisible(true);

	}
}
