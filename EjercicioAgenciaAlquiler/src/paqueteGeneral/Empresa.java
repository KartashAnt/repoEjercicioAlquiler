package paqueteGeneral;

public class Empresa {
	private String nombre;
	private String cif;

	// Constructor vacio
	public Empresa() {
		super();
	}

	// Constructor con todos los datos
	public Empresa(String nombre, String cif) {
		super();
		this.nombre = nombre;
		this.cif = cif;
	}

	// toString para demostrar todos los datos
	@Override
	public String toString() {
		return this.nombre + " tiene asociada CIF: " + this.cif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

}
