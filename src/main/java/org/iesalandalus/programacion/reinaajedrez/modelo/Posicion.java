package org.iesalandalus.programacion.reinaajedrez.modelo;

import java.util.Objects;

public class Posicion {
private int  fila;
private char columna;

//Clase posicion

public Posicion(int fila, char columna) 
{
	this.setFila(fila);
	this.setColumna(columna);
	
}

public Posicion(Posicion pos) 
{
	if(pos==null) 
	{
		throw new NullPointerException("ERROR: No es posible copiar una posición nula.");
	}
	this.setFila(pos.getFila());
	this.setColumna(pos.getColumna());
}


public int getFila() {
	return fila;
}



private void setFila(int fila) {
	if(fila<1||fila>8) 
	{
		throw new IllegalArgumentException("ERROR: Fila no válida.");
	}
	else
		this.fila=fila;
}

public char getColumna() {
	return columna;
}


private void setColumna(char columna) {
	if(columna<'a'||columna>'h') 
	{
		throw new IllegalArgumentException("ERROR: Columna no válida.");
	}
	else
		this.columna=columna;
}

@Override
public int hashCode() {
	return Objects.hash(columna, fila);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Posicion other = (Posicion) obj;
	return columna == other.columna && fila == other.fila;
}

public String toString() 
{
	//
	return "fila=" + this.getFila()+", columna="+this.getColumna();
}

}
