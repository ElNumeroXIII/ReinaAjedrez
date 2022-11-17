package org.iesalandalus.programacion.reinaajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reinaajedrez.modelo.Reina;

public class MainApp {
	//Clase Main
	private static Reina reina;
	
	public static void main(String[] args) {
		int opcion;
		do {
			Consola.mostrarMenu();
			opcion= Consola.elegirOpcionMenu();
			MainApp.ejecutarOpcion(opcion);
			
		}while(opcion!=4);
	}
	
	private static void ejecutarOpcion(int opcion) 
	{
		if(opcion==1) {
			MainApp.crearReinaDefecto();
			MainApp.mostrarReina();
		}
		if(opcion==2) {
			MainApp.crearReinaColor();
			MainApp.mostrarReina();
		}
		if(opcion==3) {
			MainApp.moverReina();
			MainApp.mostrarReina();
		}
		if(opcion==4) {
			Consola.despedirse();
		}
	}
	private static void crearReinaDefecto() {
		reina=new Reina();
	}
	
	private static void crearReinaColor() {
		reina = new Reina(Consola.elegirColor());
	}
	
	private static void moverReina() {
		try {
				Consola.mostrarMenuDirecciones();
			reina.mover(Consola.elegirDireccion(), Consola.elegirPasos());
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void mostrarReina() {
		System.out.println(reina.toString());
	}
	
}
