package Persistencia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.crypto.spec.GCMParameterSpec;

public class Archivos {
	public static ArrayList<Object> cargarDatos(){
		ArrayList<Object> lista = new ArrayList<Object>();
		try {
			ObjectInputStream entrada=new ObjectInputStream(new FileInputStream("Datos.act"));
			lista = (ArrayList<Object>)entrada.readObject();
			entrada.close();
		}
		catch(Exception e){}
		return lista;
	}
	public static void descargarDatos(ArrayList<Object> lista){
		try
		{
			ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream("Datos.act"));
			salida.writeObject(lista);	
			salida.close();
		} catch (Exception e) {}
	}
	
	public static void restaurar(ArrayList<Object> lista){
		try
		{
			ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream("Datos.act"));
			salida.writeObject(lista);	
			salida.close();
		} catch (Exception e) {}
  }
	}

