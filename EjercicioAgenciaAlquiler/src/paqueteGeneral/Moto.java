package paqueteGeneral;

public class Moto extends Vehiculo {
	private boolean tieneMaletinPortacasco;

	// Constructor entero
	public Moto(String matricula, String marca, String modelo, int caballos, boolean tieneMaletinPortacasco) {
		super(matricula, marca, modelo, caballos);
		this.tieneMaletinPortacasco = tieneMaletinPortacasco;
	}
	// Constructor vacio
	public Moto() {
		super();
	}

	@Override
	public String toString() {
		return "Moto " + super.toString();
	}

	public boolean isTieneMaletinPortacasco() {
		return tieneMaletinPortacasco;
	}

	public void setTieneMaletinPortacasco(boolean tieneMaletinPortacasco) {
		this.tieneMaletinPortacasco = tieneMaletinPortacasco;
	}

}
