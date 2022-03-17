package paqueteGeneral;

public class Moto extends Vehiculo {
	private boolean tieneMaletinPortacasco;

	public Moto(String matricula, String marca, String modelo, int caballos, boolean tieneMaletinPortacasco) {
		super(matricula, marca, modelo, caballos);
		this.tieneMaletinPortacasco = tieneMaletinPortacasco;
	}

	public Moto() {
		super();
	}

	public boolean isTieneMaletinPortacasco() {
		return tieneMaletinPortacasco;
	}

	public void setTieneMaletinPortacasco(boolean tieneMaletinPortacasco) {
		this.tieneMaletinPortacasco = tieneMaletinPortacasco;
	}
	
}
