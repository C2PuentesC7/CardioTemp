package Persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.crypto.spec.GCMParameterSpec;

public class Archivos {
	public static ArrayList<Object> cargarDatos(){
		ArrayList<Object> lista = new ArrayList<Object>();
		try {
			ObjectInputStream entrada=new ObjectInputStream(new FileInputStream("Datos.act"));
			lista = (ArrayList<Object>)entrada.readObject();
		}
		catch(Exception e){}
		return lista;
	}
	public static void descargarDatos(ArrayList<Object> lista){
		try
		{
			ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream("Datos.act"));
			salida.writeObject(lista);	
		} catch (Exception e) {}
	}
}
