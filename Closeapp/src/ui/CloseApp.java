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
		int base = 0;
		int efective = 0;
		int cuadre = 0;	
		// Case 2
		int[] ticketsPaid = {0};
		String[] ticketsP = {"Compras"};
		// Case 3
		int[] tickets = {0};
		// Case 4
		int[] nequi = {0};
		// Case 5
		int[] receiptsWorker = {0};
		String[] receiptsW = {"Creditos"};
		// Case 6
		int[] outlay = {0};
		String[] outlayCase = {"Gastos"};
		do {
			System.out.println("1) Cierre efectivo");
			System.out.println("2) Compras");
			System.out.println("3) Creditos");
			System.out.println("4) Datafono");
			System.out.println("5) Nequi");
			System.out.println("6) Gastos");
			System.out.println("7) Cerrar facturas");
			System.out.println("");
			System.out.println("0) Cerrar programa");
			option = Integer.parseInt(sc.nextLine());
			switch(option) {
			case 1:
				System.out.println("1) Efectivo");
				System.out.println("2) Volver");
				option = Integer.parseInt(sc.nextLine());
				switch(option) {
				case 1:
					int cash = 0;
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
					efective = cash;

					// Calculate...
					cuadre = cash-base;
					System.out.println("El dinero a sacar de la caja es: "+cuadre);
					System.out.println("");

					break;
				case 2:
					System.out.println("<---");
					break;
				default:
					option = option+99;
					break;
				}
				break;
			case 2:
				counter = 0;
				System.out.println("Ingrese el numero de compras");
				counter = Integer.parseInt(sc.nextLine());
				ticketsPaid = new int[counter];
				ticketsP = new String[counter];
				for (int i=0; i<ticketsP.length; i++) {
					System.out.println("Ingrese el nombre del proveedor "+(i+1));
					ticketsP[i] = sc.nextLine();
					System.out.println("Ingrese cuanto se le pago a "+ticketsP[i]);
					ticketsPaid[i] = Integer.parseInt(sc.nextLine());
				}
				break;
			case 3:
				counter = 0;
				System.out.println("Ingrese el numero de creditos");
				counter = Integer.parseInt(sc.nextLine());
				receiptsWorker = new int[counter];
				receiptsW = new String[counter];
				for (int i=0; i<receiptsW.length; i++) {
					System.out.println("Ingrese el nombre del deudor "+(i+1));
					receiptsW[i] = sc.nextLine();
					System.out.println("Ingrese cuanto debe "+receiptsW[i]);
					receiptsWorker[i] = Integer.parseInt(sc.nextLine());
				}
				break;
			case 4:
				counter = 0;
				System.out.println("Ingrese el numero de pagos con datafono");
				counter = Integer.parseInt(sc.nextLine());
				tickets = new int[counter];
				for (int i=0; i<tickets.length; i++) {
					System.out.println("Ingrese el valor del pago "+(i+1));
					tickets[i] = Integer.parseInt(sc.nextLine());
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
				outlay = new int[counter];
				outlayCase = new String[counter];
				for (int i=0; i<outlayCase.length; i++) {
					System.out.println("Ingrese el asunto del gasto "+(i+1));
					outlayCase[i] = sc.nextLine();
					System.out.println("Ingrese cuanto se pago en "+outlayCase[i]);
					outlay[i] = Integer.parseInt(sc.nextLine());
				}
				break;
			case 7:
				calculateTickets(receiptsWorker, receiptsW, tickets, nequi, ticketsPaid, ticketsP, outlay, outlayCase, cuadre);
				System.out.println("");
				break;
			default:
				System.out.println("Cierre existoso");
				break;
			}
		}while(option != 0);

	}

	//Methods
	public void calculateTickets(int[] receiptsWorker, String[] receiptsW, int[] tickets, int[] nequi, int[] ticketsPaid, String[] ticketsP, int[] outlay, String[] outlayCase, int cuadre) {
		int totalTicketsPaid = 0;
		int totalOutlay = 0;
		int totalReceipts = 0;
		int totalTickets = 0;
		int totalNequi = 0;
		int total = 0;
		// COMPRAS
		System.out.println("");
		System.out.println("COMPRAS");
		for (int i=0; i<ticketsPaid.length; i++) {
			System.out.println(ticketsP[i]+": "+ticketsPaid[i]);
			totalTicketsPaid += ticketsPaid[i];
		}
		System.out.println("Total compras: "+totalTicketsPaid);
		// COMPRAS
		System.out.println("");
		System.out.println("GASTOS");
		for (int i=0; i<outlay.length; i++) {
			System.out.println(outlayCase[i]+": "+outlay[i]);
			totalOutlay += outlay[i];
		}
		System.out.println("Total gastos: "+totalOutlay);
		// CREDITOS
		System.out.println("");
		System.out.println("CREDITOS");
		for (int i=0; i<receiptsWorker.length; i++) {
			System.out.println(receiptsW[i]+": "+receiptsWorker[i]);
			totalReceipts += receiptsWorker[i];
		}
		System.out.println("Total creditos: "+totalReceipts);
		// DATAFONO
		for (int i=0; i<tickets.length; i++) {
			totalTickets += tickets[i];
		}
		System.out.println("");
		System.out.println("DATAFONO");
		System.out.println("Total datafono: "+totalTickets);
		// NEQUI
		for (int i=0; i<nequi.length; i++) {
			totalNequi += nequi[i];
		}
		System.out.println("");
		System.out.println("NEQUI");
		System.out.println("Total Nequi: "+totalNequi);
		// TOTAL
		total = (totalTicketsPaid+totalOutlay+totalReceipts+totalTickets+totalNequi);
		System.out.println("");
		System.out.println("SUBTOTAL: "+total);
		System.out.println("EFECTIVO: "+cuadre);
		System.out.println("TOTAL: "+(total+cuadre));
		System.out.println("");
		System.out.println("--------------------------");
	}
	
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
}