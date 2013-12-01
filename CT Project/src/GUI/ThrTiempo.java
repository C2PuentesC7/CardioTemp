package GUI;

import javax.swing.JLabel;

public class ThrTiempo extends Thread {
	private int contadorParcial = 0;
	private int contadorTotal = 0;
	private JLabel lblTiempo;
	private JLabel lblTotal;
	private boolean continuar;
	public ThrTiempo(JLabel lblTiempo, JLabel lblTotal) {
		super();
		this.lblTiempo = lblTiempo;
		this.lblTotal = lblTotal;
	}
	public void run(){
		while(true){
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (continuar){
				contadorParcial++;
				contadorTotal++;
				lblTiempo.setText(""+contadorParcial/60+":"+contadorParcial%60);
				lblTotal.setText(""+contadorTotal/60+":"+contadorTotal%60);
			}
		}
	}
	public int reiniciarParcial(){
		int aux = contadorParcial;
		contadorParcial = 0;
		return aux;
	}
	public JLabel getLblTotal() {
		return lblTotal;
	}
	public void continuar(boolean b) {
		continuar = b;
	}
}
