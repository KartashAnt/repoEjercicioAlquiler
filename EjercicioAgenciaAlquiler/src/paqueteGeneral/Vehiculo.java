package paqueteGeneral;

public class Vehiculo {
	// Caracterisiticas principales
	private String matricula;
	private String marca;
	private String modelo;
	private int caballos;
	
	// Caracteristicas que definen si un coche está alquilado o no
	private int diasRestantes = -1;
	private Empresa alquilador;

	// El metodo para pasar un dia
	public boolean pasarDia() {
		if (this.diasRestantes >= 0) { // Si coche esta alquilado o no
			this.diasRestantes--;
			if (this.diasRestantes < 0) { // Si esta libre despues de quitarlo un dia
				alquilador = null;
				return true;
			}
			return false;
		}
		return true;

	}
	
	// Constructor vacio
	public Vehiculo() {
		super();
	}

	// Constructor con todos los campos
	public Vehiculo(String matricula, String marca, String modelo, int caballos) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.caballos = caballos;
	}
	
	// toString funciona dependientose si un coche es alquilado o no
	@Override
	public String toString() {
		if (this.diasRestantes >= 0) {
			return marca + " " + modelo + " " + matricula + " " + alquilador.getNombre() + " lo quedan " + diasRestantes
					+ " dias";
		} else {
			return marca + " " + modelo + " " + matricula;
		}
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getCaballos() {
		return caballos;
	}

	public void setCaballos(int caballos) {
		this.caballos = caballos;
	}

	public int getDiasRestantes() {
		return diasRestantes;
	}

	public void setDiasRestantes(int diasRestantes) {
		this.diasRestantes = diasRestantes;
	}

	public Empresa getAlquilador() {
		return alquilador;
	}

	public void setAlquilador(Empresa alquilador) {
		this.alquilador = alquilador;
	}

}
