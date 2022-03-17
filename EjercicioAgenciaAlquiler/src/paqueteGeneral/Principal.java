package paqueteGeneral;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	static ArrayList<Vehiculo> alquilados= new ArrayList<Vehiculo>();
	static ArrayList<Vehiculo> noAlquilados= new ArrayList<Vehiculo>();
	static Scanner sc=new Scanner(System.in);
	static Empresa[] empresasClientes= new Empresa[6];
	public static void main(String[] args) {
		inicializar();
		int entrada=0;
		int dia=1;
		while(true) {
			System.out.println("DIA " + dia);
			while(entrada!=-1) {
				System.out.println("Cual empresa quiere alquilar el coche?");
				listarEmpresas();
				try {
					entrada=sc.nextInt();
				} catch (java.util.InputMismatchException e) {
					System.out.println("Formato de entrada no valido");
				}
				if(entrada!=-1) {
					if(entrada<0 || entrada>=empresasClientes.length) {
						System.out.println("Entrada no valida");
					}
					else {
						menuVehiculos(empresasClientes[entrada]);
					}
				}
			}
		}
		
	}
	public static void inicializar() {
		String[] matricula= {"5740 GZK","1992 ORS" ,"2389 HAW" ,"9040 XYE" ,"2477 RND" ,"2839 PKZ" ,"2694 EVB" ,"8504 KFA" ,"6210 XPH" ,"4832 KSR" ,"8663 UET" ,"6221 VJX" };
		String[] marca= {"Seat","Seat","Seat","Seat","Seat","Seat","Seat","VW","VW","VW","Honda","Honda"};
		String[] modelo= {"Arona","Arona","Arona","Arona","Arona","Arona","Arona","Crafter","Crafter","Crafter","PCX 125","PCX 125"};
		int[] caballos= {100,100,100,100,100,100,100,140,140,140,12,12};
		int[] numPuertas= {5,5,5,5,5,5,5};
		double[] capacidad= {9900,9900,9900};
		boolean[] tieneMaletinPortacasco= {true,true,false};
		for (int i = 0; i < matricula.length; i++) {
			if(i<numPuertas.length) {
				noAlquilados.add(new Coche(matricula[i], marca[i], modelo[i], caballos[i], numPuertas[i]));
			}
			else if(i<numPuertas.length+capacidad.length) {
				noAlquilados.add(new Furgoneta(matricula[i], marca[i], modelo[i], caballos[i], capacidad[i-numPuertas.length]));
			}
			else {
				noAlquilados.add(new Moto(matricula[i], marca[i], modelo[i], caballos[i], tieneMaletinPortacasco[i-numPuertas.length-capacidad.length]));
			}
		}
		String[] nombreEmpresa= {"Empresa1","Empresa2","Empresa3","Empresa4","Empresa5","Empresa6"};
		String[] cif= {"C26415299","W7230245H" ,"D13336953" ,"F04553400" ,"F05921341" ,"R7103188D" };
		for (int i = 0; i < cif.length; i++) {
			empresasClientes[i]=new Empresa(nombreEmpresa[i], cif[i]);
		}
	}
	public static void listarEmpresas() {
		for (int i = 0; i < empresasClientes.length; i++) {
			System.out.println(i+".- "+ empresasClientes[i]);
		}
	}
	public static void pasarDia() {
		for (Vehiculo vehiculo : alquilados) {
			if(vehiculo.pasarDia()) {
				alquilados.remove(vehiculo);
				noAlquilados.add(vehiculo);
			}
		}
	}
	public static void menuVehiculos(Empresa alquilador) {
		System.out.println("Que tipo de vehiculo se quiere alquilar");
		System.out.println("1.- Coche");
		System.out.println("2.- Furgoneta");
		System.out.println("3.- Moto");
		boolean repeat=true;
		int tipo=0;
		while (repeat) {
			try {
				tipo=sc.nextInt();
				repeat=false;
				if(tipo>=0) {
					repeat=false;
				}
				else System.out.println("No se admiten numeros negativos");
			} catch (java.util.InputMismatchException e) {
				System.out.println("Formato de entrada no valido");
			}
		}
		System.out.println("Para cuantos dias?");
		repeat=true;
		int dias=0;
		while (repeat) {
			try {
				dias=sc.nextInt();
				if(dias>=0) {
					repeat=false;
				}
				else System.out.println("No se admiten numeros negativos");
			} catch (java.util.InputMismatchException e) {
				System.out.println("Formato de entrada no valido");
			}
		}
		switch (tipo) {
		case 1:
			
			break;

		default:
			break;
		}
	}
	public static void alquilarTipo() {
		
	}
}
