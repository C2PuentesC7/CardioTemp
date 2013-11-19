package logica;

import java.io.Serializable;

public class Nodo implements Serializable{
private Object dato;
private Nodo siguienteNodo;
public Nodo(Object dato, Nodo siguienteNodo) {
	super();
	this.dato = dato;
	this.siguienteNodo = siguienteNodo;
}
public Nodo getSiguienteNodo() {
	return siguienteNodo;
}
public void setSiguienteNodo(Nodo siguienteNodo) {
	this.siguienteNodo = siguienteNodo;
}
public Object getDato() {
	return dato;
}
}

