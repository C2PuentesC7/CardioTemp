package GUI;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmDiaAlarma extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idRutina;
	private JCheckBox[] ckbLista;
	private JTextField txfHora;
	private JTextField txfMinuto;
	private JPanel panel;
	private FrameEdicionRutina fer;
	private JLabel lblError;
	public FrmDiaAlarma(int idRutina, FrameEdicionRutina fer, Eventos eventos) {
		this.fer = fer;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 400);
		setIconImage(new ImageIcon(FrmPrincipal.class.getResource("/Imagenes/icono.png")).getImage());
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		getContentPane().setLayout(null);

		JLabel lblEditarListaDe = new JLabel("Dias alarma de la Rutina "+idRutina);
		lblEditarListaDe.setForeground(new Color(0, 204, 102));
		lblEditarListaDe.setBounds(0, 0, 234, 30);
		lblEditarListaDe.setFont(new Font("Agency FB", Font.PLAIN, 25));
		lblEditarListaDe.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblEditarListaDe);

		panel = new JPanel();
		panel.setBackground(new Color(51,51,51));
		panel.setBorder(null);
		panel.setLayout(new GridLayout(7,1));
		JScrollPane slpLista = new JScrollPane(panel);
		slpLista.setBounds(10, 184, 224, 140);
		getContentPane().add(slpLista);

		boolean[] seleccion = eventos.getGestion().getRutina(idRutina).getDiaAlarma();
		int[] hora = eventos.getGestion().getRutina(idRutina).getHoraAlarma();
		String [] dias = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
		ckbLista = new JCheckBox[7];
		for (int i = 0; i < 7; i++){
			ckbLista[i] = new JCheckBox(dias[i]);
			ckbLista[i].setFont(new Font("Agency FB", Font.PLAIN, 20));
			ckbLista[i].setBackground(new Color(51,51,51));
			ckbLista[i].setForeground(new Color(0, 204, 153));
			ckbLista[i].setSelected(seleccion[i]);
			panel.add(ckbLista[i]);
		}

		this.idRutina = idRutina;

		JButton btnProgramar = new JButton("Programar");
		btnProgramar.setToolTipText("Guardar alarma");
		btnProgramar.setBounds(123, 367, 127, 33);
		btnProgramar.setBackground(new Color(42,154,255));
		btnProgramar.setForeground(new Color(255, 255, 255));
		btnProgramar.setFont(new Font("Agency FB", Font.PLAIN, 25));
		getContentPane().add(btnProgramar);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setIcon(new ImageIcon(FrmDiaAlarma.class.getResource("/Imagenes/previous.png")));
		btnVolver.setBounds(0, 367, 127, 33);
		btnVolver.setBackground(new Color(42,154,255));
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setFont(new Font("Agency FB", Font.PLAIN, 27));
		btnVolver.addActionListener(this);
		getContentPane().add(btnVolver);
		btnProgramar.addActionListener(eventos);
		
		lblError = new JLabel("");
		lblError.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblError.setForeground(Color.RED);
		lblError.setBounds(10, 335, 224, 21);
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblError);
		
		JLabel label = new JLabel("Hora Alarma");
		label.setBounds(0, 45, 250, 30);
		getContentPane().add(label);
		label.setForeground(new Color(0, 204, 153));
		label.setFont(new Font("Agency FB", Font.PLAIN, 20));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		txfHora = new JTextField(hora[0]+"", 2);
		txfHora.setBounds(10, 75, 230, 30);
		getContentPane().add(txfHora);
		txfHora.setFont(new Font("Agency FB", Font.PLAIN, 20));
		
		JLabel label_1 = new JLabel("Minuto Alarma");
		label_1.setBounds(10, 114, 230, 30);
		getContentPane().add(label_1);
		label_1.setForeground(new Color(0, 204, 153));
		label_1.setFont(new Font("Agency FB", Font.PLAIN, 20));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		txfMinuto = new JTextField(hora[1]+"",2);
		txfMinuto.setBounds(10, 143, 230, 30);
		getContentPane().add(txfMinuto);
		txfMinuto.setFont(new Font("Agency FB", Font.PLAIN, 20));
		
		JLabel lblFondo = new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Framefondo.png")));
		lblFondo.setBounds(0, 0, 250, 400);
		getContentPane().add(lblFondo);
		
		
		
		
				
		
		
		

		setVisible(true);
	}

	public int getIdRutina() {
		return idRutina;
	}

	public boolean[] getDiaAlarma() {
		boolean[] lista = new boolean[7];
		for (int i = 0; i < 7; i++)
			lista[i] = ckbLista[i].isSelected();
		return lista;
	}
	public int[] getHoraAlarma(){
		int[] par= new int[2];
		try{
			par[0] = new Integer(txfHora.getText());
			par[1] = new Integer(txfMinuto.getText());
			if (par[0]<=24 && par[1]<=60) {
				lblError.setText("Alarma guardada!!!");
				lblError.setForeground(Color.GREEN);
			}
		}catch(Exception e){
			lblError.setText("Digite solo n\u00FAmeros por favor");
		}
		
		return par;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		setVisible(false);
		fer.setVisible(true);
	}

	public JLabel getLblError() {
		return lblError;
	}
	
}
