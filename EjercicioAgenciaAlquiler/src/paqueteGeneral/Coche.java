package paqueteGeneral;

public class Coche extends Vehiculo {
	private int numPuertas;
	
	public Coche() {
		super();
	}
	
	public Coche(String matricula, String marca, String modelo, int caballos, int numPuertas) {
		super(matricula, marca, modelo, caballos);
		this.numPuertas = numPuertas;
	}

	public int getNumPuertas() {
		return numPuertas;
	}

	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}
	
}
