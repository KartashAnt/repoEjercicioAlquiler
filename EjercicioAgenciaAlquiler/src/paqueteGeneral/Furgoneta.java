package paqueteGeneral;

public class Furgoneta extends Vehiculo {
	private double capacidad;

	// Constructor vacio
	public Furgoneta() {
		super();
	}
	
	// Constructor entero
	public Furgoneta(String matricula, String marca, String modelo, int caballos, double capacidad) {
		super(matricula, marca, modelo, caballos);
		this.capacidad = capacidad;
	}

	@Override
	public String toString() {
		return "Furgoneta " + super.toString();
	}

	public double getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(double capacidad) {
		this.capacidad = capacidad;
	}

}
