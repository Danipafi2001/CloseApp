package ui;

import java.util.Scanner;

public class CloseApp {

	public final static int[] values = {50, 100, 200, 500, 1000, 2000, 5000, 10000, 20000, 50000, 100000};

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		CloseApp view = new CloseApp();
		view.showMenu();
	}

	public void showMenu() {
		int option = 0;
		int counter = 0;
		//Case 1
		int cash = 0;
		int base = 0;
		int cuadre = 0;	
		// Case 2
		int[] compras = {0};
		String[] comprasN = {"Compras"};
		// Case 3
		int[] creditos = {0};
		String[] creditosN = {"Creditos"};
		// Case 4
		int[] datafono = {0};
		// Case 5
		int[] nequi = {0};
		// Case 6
		int[] gastos = {0};
		String[] gastosN = {"Gastos"};
		// Case 8
		int totalCompras = 0;
		int totalCreditos = 0;
		int totalDatafono = 0;
		int totalNequi = 0;
		int totalGastos = 0;
		do {
			System.out.println("1) Efectivo");
			System.out.println("2) Compras");
			System.out.println("3) Creditos");
			System.out.println("4) Datafono");
			System.out.println("5) Nequi");
			System.out.println("6) Gastos");
			System.out.println("7) Agregar");
			System.out.println("8) Cerrar facturas");
			System.out.println("");
			System.out.println("0) Cerrar programa");
			option = Integer.parseInt(sc.nextLine());
			switch(option) {
			case 1:
				for(int i=0; i<values.length; i++)
					cash += counterCash(values[i]);
				System.out.println("Ingrese el valor de dinero extra");
				int coins = Integer.parseInt(sc.nextLine());

				// Receive the base
				System.out.println("Ingrese la base a dejar en la caja");
				base = Integer.parseInt(sc.nextLine());

				// Receive and calculate the total cash
				System.out.println("El dinero en la caja es de: "+cash);
				cash = cash+coins;
				System.out.println("El dinero total en efectivo es de: "+cash);

				// Calculate...
				cuadre = cash-base;
				System.out.println("El dinero a sacar de la caja es: "+cuadre);
				System.out.println("");
				break;
			case 2:
				counter = 0;
				System.out.println("Ingrese el numero de compras");
				counter = Integer.parseInt(sc.nextLine());
				compras = new int[counter];
				comprasN = new String[counter];
				for (int i=0; i<comprasN.length; i++) {
					System.out.println("Ingrese el nombre del proveedor "+(i+1));
					comprasN[i] = sc.nextLine();
					System.out.println("Ingrese cuanto se le pago a "+comprasN[i]);
					compras[i] = Integer.parseInt(sc.nextLine());
				}
				break;
			case 3:
				counter = 0;
				System.out.println("Ingrese el numero de creditos");
				counter = Integer.parseInt(sc.nextLine());
				creditos = new int[counter];
				creditosN = new String[counter];
				for (int i=0; i<creditosN.length; i++) {
					System.out.println("Ingrese el nombre del deudor "+(i+1));
					creditosN[i] = sc.nextLine();
					System.out.println("Ingrese cuanto debe "+creditosN[i]);
					creditos[i] = Integer.parseInt(sc.nextLine());
				}
				break;
			case 4:
				counter = 0;
				System.out.println("Ingrese el numero de pagos con datafono");
				counter = Integer.parseInt(sc.nextLine());
				datafono = new int[counter];
				for (int i=0; i<datafono.length; i++) {
					System.out.println("Ingrese el valor del pago "+(i+1));
					datafono[i] = Integer.parseInt(sc.nextLine());
				}
				break;
			case 5:
				counter = 0;
				System.out.println("Ingrese el numero de pagos con nequi");
				counter = Integer.parseInt(sc.nextLine());
				nequi = new int[counter];
				for (int i=0; i<nequi.length; i++) {
					System.out.println("Ingrese el valor del pago "+(i+1));
					nequi[i] = Integer.parseInt(sc.nextLine());
				}
				break;

			case 6:
				counter = 0;
				System.out.println("Ingrese el numero de gastos");
				counter = Integer.parseInt(sc.nextLine());
				gastos = new int[counter];
				gastosN = new String[counter];
				for (int i=0; i<gastosN.length; i++) {
					System.out.println("Ingrese el asunto del gasto "+(i+1));
					gastosN[i] = sc.nextLine();
					System.out.println("Ingrese cuanto se pago en "+gastosN[i]);
					gastos[i] = Integer.parseInt(sc.nextLine());
				}
				break;
			case 7:
				System.out.println("");
				break;
			case 8:
				totalCompras = calculadorCompras(compras, comprasN);
				totalGastos = calculadorGastos(gastos, gastosN);
				totalCreditos = calculadorCreditos(creditos, creditosN);
				totalDatafono = calculadorDatafono(datafono);
				totalNequi = calculadorNequi(nequi);
				calculadorCuadre(totalCompras,totalGastos, totalCreditos, totalDatafono, totalNequi, cuadre);
				System.out.println("");
				break;
			default:
				System.out.println("Cierre existoso");
				break;
			}
		}while(option != 0);

	}
	//Methods
	private int counterCash(int denomination) {
		String complement = "";
		String output = "";
		if(denomination<=1000) {
			complement = "monedas de "+denomination+" pesos";
			output = "Monedas de "+denomination;
		} else {
			complement = "billetes de "+denomination+" pesos";
			output = "Billetes de "+denomination;
		}
		System.out.println("Ingrese la cantidad de "+complement);
		int value = Integer.parseInt(sc.nextLine());
		value *= denomination;
		System.out.println(output+": "+value);
		return value;
	}
	// COMPRAS
	private int calculadorCompras(int[] compras, String[] comprasN) {
		int totalCompras = 0;
		System.out.println("");
		System.out.println("COMPRAS");
		for (int i=0; i<compras.length; i++) {
			System.out.println(comprasN[i]+": "+compras[i]);
			totalCompras += compras[i];
		}
		System.out.println("Total compras: "+totalCompras);
		return totalCompras;
	}
	// GASTOS
	private int calculadorGastos(int[] gastos, String[] gastosN) {
		int totalGastos = 0;
		System.out.println("");
		System.out.println("GASTOS");
		for (int i=0; i<gastos.length; i++) {
			System.out.println(gastosN[i]+": "+gastos[i]);
			totalGastos += gastos[i];
		}
		System.out.println("Total gastos: "+totalGastos);
		return totalGastos;
	}
	// CREDITOS
	private int calculadorCreditos(int[] creditos, String[] creditosN) {
		int totalCreditos = 0;
		System.out.println("");
		System.out.println("CREDITOS");
		for (int i=0; i<creditos.length; i++) {
			System.out.println(creditosN[i]+": "+creditos[i]);
			totalCreditos += creditos[i];
		}
		System.out.println("Total creditos: "+totalCreditos);
		return totalCreditos;
	}
	// DATAFONO
	private int calculadorDatafono(int[] datafono) {
		int totalDatafono = 0;
		System.out.println("");
		System.out.println("DATAFONO");
		for (int i=0; i<datafono.length; i++) {
			totalDatafono += datafono[i];
		}	
		System.out.println("Total datafono: "+totalDatafono);
		return totalDatafono;
	}
	// NEQUI
	private int calculadorNequi(int[] nequi) {
		int totalNequi = 0;
		System.out.println("");
		System.out.println("NEQUI");
		for (int i=0; i<nequi.length; i++) {
			totalNequi += nequi[i];
		}
		System.out.println("Total Nequi: "+totalNequi);
		return totalNequi;
	}
	// CUADRE
	private void calculadorCuadre(int totalCompras,int totalGastos, int totalCreditos, int totalDatafono, int totalNequi, int cuadre) {
		int total = 0;
		total = (totalCompras + totalGastos + totalCreditos + totalDatafono + totalNequi);
		System.out.println("");
		System.out.println("SUBTOTAL: "+total);
		System.out.println("EFECTIVO: "+cuadre);
		System.out.println("TOTAL: "+(total+cuadre));
		System.out.println("");
		System.out.println("--------------------------");
	}
}
