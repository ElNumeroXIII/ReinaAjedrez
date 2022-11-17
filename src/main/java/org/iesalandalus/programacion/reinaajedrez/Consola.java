package org.iesalandalus.programacion.reinaajedrez;

import org.iesalandalus.programacion.reinaajedrez.modelo.Color;
import org.iesalandalus.programacion.reinaajedrez.modelo.Direccion;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

	private Consola() {
	}

	public static void mostrarMenu() {
		System.out.println("1) Crear reina por defecto");
		System.out.println("2) Crear reina con color");
		System.out.println("3) Mover reina");
		System.out.println("4) Salir");
	}

	public static int elegirOpcionMenu() {
		int entrada;
		System.out.println("Elige una opción:");
		entrada = Entrada.entero();
		if (entrada > 4 || entrada < 1) {
			throw new IllegalArgumentException("Entrada no puede ser menor que 1 ni mayor que 4");
		}
		return entrada;
	}

	public static Color elegirColor() {
		String entrada;
		Color color;
		do {
			System.out.println("Elige un color:");
			System.out.println("1) Blanco");
			System.out.println("2) Negro");
			entrada = Entrada.cadena();
		} while (entrada != "Blanco" || entrada != "Negro");

		if (entrada == "Blanco") {
			color = Color.BLANCO;
		} else {
			color = Color.NEGRO;
		}

		return color;
	}

	public static void mostrarMenuDirecciones() {
		System.out.println("Elige una direccion:");
		System.out.println("1) Norte");
		System.out.println("2) Sur");
		System.out.println("3) Este");
		System.out.println("4) Oeste");
		System.out.println("5) Noreste");
		System.out.println("6) Sureste");
		System.out.println("7) Noroeste");
		System.out.println("8) Suroeste");
	}
	
	public static Direccion elegirDireccion() {
		
		int entrada;
		Direccion dir=null;
		do {
		System.out.println("Elija una dirección");
		entrada = Entrada.entero();
		}while(entrada<1||entrada>8);
		
		switch(entrada) {
		case 1:
			dir= Direccion.NORTE;
			break;
		case 2:
			dir=Direccion.SUR;
			break;
		case 3:
			dir= Direccion.ESTE;
			break;
		case 4:
			dir= Direccion.OESTE;
			break;
		case 5:
			dir= Direccion.NORESTE;
			break;
		case 6:
			dir= Direccion.SURESTE;
			break;
		case 7:
			dir= Direccion.NOROESTE;
			break;
		case 8:
			dir= Direccion.SUROESTE;
			break;
		}
		
		return dir;
	}
	
	public static int elegirPasos() {
		int pasos;
		System.out.println("Indica cuantos pasos dar:");
		pasos=Entrada.entero();
		return pasos;
	}
	
	public static void despedirse() {
		System.out.println("Hasta la próxima");
	}
	
}
