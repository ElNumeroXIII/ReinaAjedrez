package org.iesalandalus.programacion.reinaajedrez.modelo;

public enum Color {
	//Enum Color
	BLANCO("Blanco"), NEGRO("Negro");
	private String cadenaAMostrar;
	
	private Color(String cadenaAMostrar) 
	{
		this.cadenaAMostrar=cadenaAMostrar;
	}
	
	public String toString() 
	{
		return cadenaAMostrar;
		
	}
	
}
