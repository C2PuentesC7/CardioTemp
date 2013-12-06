package GUI;

import java.awt.EventQueue;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.awt.Color;

public class FrameLogo extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FrmPrincipal fp;
	//private JButton btnRestaurar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLogo frame = new FrameLogo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		try {
			Clip sonido = AudioSystem.getClip();
			File a = new File("Intro.wav");
			sonido.open(AudioSystem.getAudioInputStream(a));
			sonido.start();
			System.out.println("Reproduciendo 10s. de sonido...");
			Thread.sleep(50000); // 50.000 milisegundos (50 segundos)
			sonido.close();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public FrameLogo() {
		fp = new FrmPrincipal();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 400);
		setUndecorated(true);
		setIconImage(new ImageIcon(FrameLogo.class.getResource("/Imagenes/icono.png")).getImage());
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		setResizable(false);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 250,400);
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(null);
		getContentPane().add(panel);

		
		panel.setLayout(null);
		
		JButton btnLogo = new JButton("");
		btnLogo.setIcon(new ImageIcon(FrameLogo.class.getResource("/Imagenes/inicio.png")));
		btnLogo.setBounds(0, 0, 250, 400);
		btnLogo.addActionListener(this);
		panel.add(btnLogo);
		

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.setVisible(false);
		fp.setVisible(true);


	}
}
