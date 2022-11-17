package org.iesalandalus.programacion.reinaajedrez.modelo;

import javax.naming.OperationNotSupportedException;

public class Reina {
	private Posicion pos;
	private Color color;
	
	//Clase Reina

	public Reina() {
		this.pos = new Posicion(1, 'd');
		this.color = Color.BLANCO;
	}

	public Reina(Color colour) {
		
		if(colour==null) {
			throw new NullPointerException("ERROR: El color no puede ser nulo.");
		}
		
		if (colour == Color.BLANCO) {
			this.pos = new Posicion(1, 'd');
			this.color = colour;
		} else if (colour == Color.NEGRO) {
			this.pos = new Posicion(8, 'd');
			this.color = colour;
		}
	}

	public Posicion getPosicion() {
		return pos;
	}

	private void setPosicion(Posicion posicion) throws OperationNotSupportedException {

		if (this.pos.getFila() > 7 || this.pos.getFila() < 1 || this.pos.getColumna() > 'h'
				|| this.pos.getColumna() < 'a') {
			throw new OperationNotSupportedException("Operación no soportada");
		}
		this.pos = new Posicion(posicion);

	}

	public Color getColor() {
		return color;
	}

	private void setColor(Color color) {
		if (this.color.equals(null)) {
			throw new NullPointerException("ERROR: El color no puede ser nulo.");
		} else
			this.color = color;
	}

	public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException {
		if (direccion==null) {
			throw new NullPointerException("ERROR: La dirección no puede ser nula.");
		}
		if (pasos <= 0 || pasos > 7) {
			throw new IllegalArgumentException("ERROR: El número de pasos debe estar comprendido entre 1 y 7.");
		}

		switch (direccion.toString()) {
		case "NORTE": {
			if (this.pos.getFila() + pasos > 8) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
			}
			this.pos = new Posicion(pos.getFila() + pasos, pos.getColumna());
		}
			break;
		case "SUR": {
			if (this.pos.getFila() - pasos < 1) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
			}
			this.pos = new Posicion(pos.getFila() - pasos, pos.getColumna());
		}
			break;
		case "ESTE": {
			if (this.pos.getColumna() + pasos > 'h') {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
			}
			this.pos = new Posicion(pos.getFila(), (char) (pos.getColumna() + pasos));
		}
			break;
		case "OESTE": {
			if (this.pos.getColumna() - pasos < 'a') {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
			}
			this.pos = new Posicion(pos.getFila(), (char) (pos.getColumna() - pasos));
		}
			break;
		case "NORESTE": {
			if (this.pos.getColumna() + pasos > 'h' || this.pos.getFila() + pasos > 8) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
			}
			this.pos = new Posicion(pos.getFila() + pasos, (char) (pos.getColumna() + pasos));
		}
			break;
		case "SURESTE": {
			if (this.pos.getColumna() + pasos > 'h' || this.pos.getFila() - pasos < 1) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
			}
			this.pos = new Posicion(pos.getFila() - pasos, (char) (pos.getColumna() + pasos));
		}
			break;
		case "SUROESTE": {
			if (this.pos.getColumna() - pasos < 'a' || this.pos.getFila() - pasos < 1) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
			}
			this.pos = new Posicion(pos.getFila() - pasos, (char) (pos.getColumna() - pasos));
		}
			break;
		case "NOROESTE": {
			if (this.pos.getColumna() - pasos < 'a' || this.pos.getFila() + pasos > 8) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
			}
			this.pos = new Posicion(pos.getFila() + pasos, (char) (pos.getColumna() - pasos));
		}
			break;
		}
	}


	@Override
	public String toString() {
		return "color=" + this.getColor().toString() + ", posicion=(fila=" + this.getPosicion().getFila() + ", columna="
				+ this.getPosicion().getColumna() + ")";
	}
}
