package DamBank;

/*
 * This program is was made for a school project. This is what the exercise asks us to do with this class (is in Spanish because my classes are given in Spanish):
 * 
 * La empresa LibreCoders te ha contratado para desarrollar un software de gestión de una cuenta bancaria para la cooperativa de banca 
 * ética y sostenible DamBank. Se trata de una aplicación Java formada por una clase principal DamBank y otra llamada CuentaBancaria.
 * El programa pedirá los datos necesarios para crear una cuenta bancaria. 
 * Si son válidos, creará la cuenta y mostrará el menú principal para permitir actuar sobre la cuenta. 
 * Tras cada acción se volverá a mostrar el menú.
 * 		1. Datos de la cuenta. Mostrará el IBAN, el titular y el saldo.
 * 		2. IBAN. Mostrará el IBAN.
 * 		3. Titular. Mostrará el titular.
 * 		4. Saldo. Mostrará el saldo disponible.
 * 		5. Ingreso. Pedirá la cantidad a ingresar y realizará el ingreso si es posible.
 * 		6. Retirada. Pedirá la cantidad a retirar y realizará la retirada si es posible.
 * 		7. Movimientos. Mostrará una lista con el historial de movimientos.
 * 		8. Salir. Termina el programa
 * 
 */

/**
 * @author Jennifer T. Sama
 * @version 1.0.0
 * 
 * @param String iban saves the IBAN given by the user.
 * @param String holderName	saves the same given by the user.
 * @param String holderSurname saves the surname(s) given by the user.
 * @param account creates the new account with the data given by the user, if this data is valid.
 * @param quantity saves the amount given by the user. This variable is used in the methods "withdraw" and "deposit".
 * @param option saves the option chosen by the user, so he can operate his account.
 * 
 * @return case 1 shows IBAN, holder and balance.
 * @return case 2 shows IBAN.
 * @return case 3 shows holder.
 * @return case 4 shows balance.
 * @return case 5 allows user to deposit money on the account.
 * @return case 6 allows user to withdraw money from the account.
 * @return case 7 shows number of movements recorded and the amount in each one.
 * @return case 8 exit program.
 * @return default does nothing and tells the user to chose a valid option.
 * 
 */

import java.util.Scanner;

class DamBank {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		CuentaBancaria account;
		
		// Test account:
		// ES6621000418401234567891

		// If the account introduced is not valid it will ask for the info again until it is valid.
		do {
			System.out.print("Introduzca número IBAN: ");
			String iban = sc.nextLine();
			
			System.out.println("Introduzca el nombre del titular de cuenta: ");
			String holderName = sc.nextLine();

			System.out.println("Introduzca el/los apellidos del titular de cuenta: ");
			String holderSurname = sc.nextLine();
			
			account = new CuentaBancaria(iban, holderName, holderSurname);
		} 
		while (!account.getValidAccount());
	
		int option;
		double quantity;
		
		do {
			System.out.println("Elija una opción: ");
			System.out.println("1. Datos de la cuenta.");
			System.out.println("2. IBAN.");
			System.out.println("3. Titular.");
			System.out.println("4. Saldo.");
			System.out.println("5. Ingresar.");
			System.out.println("6. Retirar.");
			System.out.println("7. Comprobar movimientos.");
			System.out.println("8. Salir.");
			
			// Checks option selected.
			option = sc.nextInt();
			
			switch (option) {
			// 1. Datos de la cuenta.
			case 1:
				account.print();
				break;
			
			// 2. IBAN.
			case 2:
				System.out.println("IBAN: " + account.getIban());
				break;
				
			// 3. Titular.
			case 3:
				System.out.println("Titular: " + account.getHolderName() + account.getHolderSurname());
				break;
			
			// 4. Saldo.
			case 4: 
				System.out.println("Saldo: " + account.getBalance());
				break;
			
			// 5. Ingresar.
			case 5:
				System.out.println("Inserte cantidad a ingresar: ");
				quantity = sc.nextDouble();
				if (account.deposit(quantity) ) {
					System.out.println("El ingreso se ha realizado con exito.");	
				}
				else {
					System.out.println("OPERACIÓN CANCELADA: La operacion no se pudo realizar.");
				}
				break;
			
			// 6. Retirar.
			case 6:
				System.out.println("Inserte cantidad a retirar: ");
				quantity = sc.nextDouble();
				if (account.withdraw(quantity)) {
					System.out.println("Operacion realizada con exito. Recuerde retirar su dinero.");
				}
				else {
					System.out.println("OPERACIÓN CANCELADA: La operacion no se pudo realizar.");
				}
				break;
			
			// 7. Comprobar movimientos.
			case 7:
				account.printMovements();
				break;
			
			// 8. Salir.
			case 8:
				System.out.println("¡GRACIAS POR USAR NUESTRA APLICACIÓN!");
				break;
				
			// If you chose something different from the options above.
			default:
				System.out.println("Opción elegida incorrecta.");
				break;
			}
		}
		while (option != 8);
		
		sc.close(); //This is not necessary for the program to work, but the most correct way of using an scan.
	}

}
