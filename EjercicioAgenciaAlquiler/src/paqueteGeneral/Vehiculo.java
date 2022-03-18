package paqueteGeneral;

public class Vehiculo {
	private String matricula;
	private String marca;
	private String modelo;
	private int caballos;
	private int diasRestantes=-1;
	private Empresa alquilador;
	
	public boolean pasarDia() {
		if(this.diasRestantes>=0) {
			this.diasRestantes--;
			if(this.diasRestantes<0) {
				alquilador=null;
				return true;
			}
			return false;
		}
		return true;
		
	}
	
	public Vehiculo() {
		super();
	}
	public Vehiculo(String matricula, String marca, String modelo, int caballos) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.caballos = caballos;
	}
	
	@Override
	public String toString() {
		if(this.diasRestantes>=0) {
			return marca + " " +  modelo + " "+matricula + " "+alquilador+" lo quedan "+diasRestantes +" dias";
		}
		else {
			return marca + " " +  modelo + " "+matricula ;
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
