package paqueteGeneral;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Principal {
	// ArrayLists para sortear los vehiculos alquilados y no
	static ArrayList<Vehiculo> alquilados = new ArrayList<Vehiculo>();
	static ArrayList<Vehiculo> noAlquilados = new ArrayList<Vehiculo>();
	// Scanner de entrada de los datos
	static Scanner sc = new Scanner(System.in);
	// Clientes
	static Empresa[] empresasClientes = new Empresa[6];
	
	// main
	public static void main(String[] args) {
		inicializar();
		int entrada = 0;
		int dia = 1;
		// Repito la programa infinitamente
		while (true) {
			System.out.println("DIA " + dia);
			entrada = 0;
			int tipoMuestra=1;
			while (entrada != -1 && entrada != -2) {
				System.out.println("Cual empresa quiere alquilar el coche?");
				listarEmpresas();
				try {
					entrada = sc.nextInt();
				} catch (java.util.InputMismatchException e) {
					System.out.println("Formato de entrada no valido");
				}
				if (entrada != -1) {
					// Hay tres posibles comandos
					// 1. Pasar el dia con la lista desordenada: -1
					// 2. Pasar el dia con la lista ordenada: -2
					// 3. Alquilar el vehiculo para la empresa n
					// Toda otra entrada se considera erronea
					if (entrada == -2) {
						tipoMuestra=2;
						
					} else if (entrada < 0 || entrada >= empresasClientes.length) {
						System.out.println("Entrada no valida");
					} else {
						menuVehiculos(empresasClientes[entrada]);
					}
				}
				else {
					
				}
			}
			dia++;
			pasarDia(tipoMuestra);
		}

	}

	//Dar valores iniciales a los vehiculos y empresas-clientes
	public static void inicializar() {
		String[] matricula = { "5740 GZK", "1992 ORS", "2389 HAW", "9040 XYE", "2477 RND", "2839 PKZ", "2694 EVB",
				"8504 KFA", "6210 XPH", "4832 KSR", "8663 UET", "6221 VJX" };
		String[] marca = { "Seat", "Seat", "Seat", "Seat", "Seat", "Seat", "Seat", "VW", "VW", "VW", "Honda", "Honda" };
		String[] modelo = { "Arona", "Arona", "Arona", "Arona", "Arona", "Arona", "Arona", "Crafter", "Crafter",
				"Crafter", "PCX 125", "PCX 125" };
		int[] caballos = { 100, 100, 100, 100, 100, 100, 100, 140, 140, 140, 12, 12 };
		int[] numPuertas = { 5, 5, 5, 5, 5, 5, 5 };
		double[] capacidad = { 9900, 9900, 9900 };
		boolean[] tieneMaletinPortacasco = { true, true, false };
		for (int i = 0; i < matricula.length; i++) {
			if (i < numPuertas.length) {
				noAlquilados.add(new Coche(matricula[i], marca[i], modelo[i], caballos[i], numPuertas[i]));
			} else if (i < numPuertas.length + capacidad.length) {
				noAlquilados.add(new Furgoneta(matricula[i], marca[i], modelo[i], caballos[i],
						capacidad[i - numPuertas.length]));
			} else {
				noAlquilados.add(new Moto(matricula[i], marca[i], modelo[i], caballos[i],
						tieneMaletinPortacasco[i - numPuertas.length - capacidad.length]));
			}
		}
		String[] nombreEmpresa = { "Empresa1", "Empresa2", "Empresa3", "Empresa4", "Empresa5", "Empresa6" };
		String[] cif = { "C26415299", "W7230245H", "D13336953", "F04553400", "F05921341", "R7103188D" };
		for (int i = 0; i < cif.length; i++) {
			empresasClientes[i] = new Empresa(nombreEmpresa[i], cif[i]);
		}
	}

	//Listo empresas
	public static void listarEmpresas() {
		for (int i = 0; i < empresasClientes.length; i++) {
			System.out.println(i + ".- " + empresasClientes[i]);
		}
	}

	//Paso el dia
	public static void pasarDia(int tipoMuestra) {
		//Trabajamos con los dias que quedan para los coches alquilados
		for (int i = 0; i < alquilados.size(); i++) {
			Vehiculo vehiculo = alquilados.get(i);
			if (vehiculo.pasarDia()) {
				//Movemos vehiculo de un array al otro
				alquilados.remove(vehiculo);
				noAlquilados.add(vehiculo);
				i--;
			}
		}
		mostrarVehiculosNoAlcilados();
		mostrarAlquiler(tipoMuestra);
	}
	public static void mostrarAlquiler(int tipoMuestra) {
		if(tipoMuestra==1) {
			mostrarAlquilerDesordenado();
		}
		else {
			mostrarAlquilerOrdenado();
		}
	}
	//Pinto lista de los vehiculos libres
	public static void mostrarVehiculosNoAlcilados() {
		System.out.println("VEHICULOS SIN ALQUILAR");
		for (Vehiculo vehiculo : noAlquilados) {
			System.out.println(vehiculo);
		}
		System.out.println("---");
	}

	public static void mostrarAlquilerDesordenado() {
		System.out.println("VEHICULOS ALQUILADOS");
		for (Vehiculo vehiculo : alquilados) {
			System.out.println(vehiculo);
		}
		System.out.println("---");
	}

	// Menu de alquiler del vehiculo
	public static void menuVehiculos(Empresa alquilador) {
		System.out.println("Que tipo de vehiculo se quiere alquilar");
		System.out.println("1.- Coche");
		System.out.println("2.- Furgoneta");
		System.out.println("3.- Moto");
		// Pido tipo y cantidad de los dias
		int tipo=introducirIntegerNoNegativo();
		System.out.println("Para cuantos dias?");
		int dias=introducirIntegerNoNegativo();
		// Alquilo vehiculo en función de su tipo
		switch (tipo) {
		case 1:
			alquilarTipo(new Coche().getClass(), dias, alquilador);
			break;
		case 2:
			alquilarTipo(new Furgoneta().getClass(), dias, alquilador);
			break;
		case 3:
			alquilarTipo(new Moto().getClass(), dias, alquilador);
			break;
		default:
			break;
		}
	}

	//Programa para asegurar introdución de los ints no negativos
	public static int introducirIntegerNoNegativo() {
		boolean repeat = true;
		int entrada = 0;
		while (repeat) {
			try {
				entrada = sc.nextInt();
				repeat = false;
				if (entrada >= 0) {
					repeat = false;
				} else
					System.out.println("No se admiten numeros negativos");
			} catch (java.util.InputMismatchException e) {
				System.out.println("Formato de entrada no valido");
			}
		}
		return entrada;
	}
	
	//Alquilo tipo en función de su clase
	public static void alquilarTipo(Class tipo, int dias, Empresa alquilador) {
		for (Vehiculo vehiculo : noAlquilados) {
			if (vehiculo.getClass() == tipo) {
				noAlquilados.remove(vehiculo);
				alquilados.add(vehiculo);
				vehiculo.setDiasRestantes(dias);
				vehiculo.setAlquilador(alquilador);
				return;
			}
		}
		System.out.println("No hay " + tipo.getSimpleName() + " disponible");
	}

	//Sorteo y muestro la lista en función de los dias restantes
	public static void mostrarAlquilerOrdenado() {
		ArrayList<Vehiculo> lista = new ArrayList<Vehiculo>();
		lista.addAll(alquilados);
		Comparator<Vehiculo> comparator = new Comparator<Vehiculo>() {
			@Override
			public int compare(Vehiculo arg0, Vehiculo arg1) {
				return arg0.getDiasRestantes() - arg1.getDiasRestantes();
			}
		};
		Collections.sort(lista, comparator);
		System.out.println("VEHICULOS ALQUILADOS");
		for (Vehiculo vehiculo : lista) {
			System.out.println(vehiculo);
		}
		System.out.println("--");
	}
}
