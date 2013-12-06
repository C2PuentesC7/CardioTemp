package GUI;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import Logica.Rutina;

public class ThrAlarma extends Thread{
	private Rutina[] rutinas;
	public ThrAlarma(Rutina[] rutinas) {
		super();
		this.rutinas = rutinas;
	}
	public void run(){
		while(true){
			try {
				sleep(60000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			GregorianCalendar fecha = new GregorianCalendar();
			fecha.get(Calendar.DAY_OF_WEEK);
			for (int i = 0; i < rutinas.length; i++)
				for (int j = 0; j < 7; j++)
					if (rutinas[i].getDiaAlarma()[j]
							&& rutinas[i].getHoraAlarma()[0] == fecha.get(Calendar.HOUR_OF_DAY)
							&& rutinas[i].getHoraAlarma()[1] == fecha.get(Calendar.MINUTE))
						JOptionPane.showMessageDialog(null, "Hora de rutina "+rutinas[i]);
		}
	}
}
