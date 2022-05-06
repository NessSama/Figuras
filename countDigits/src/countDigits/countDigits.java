package countDigits;

/*
 * Escribe un programa en Java que lea un entero positivo y cuente le número de dígitos (menor de 10 mil millones) que tiene.
 */

import java.util.Scanner;

class countDigits {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please, write down a number between 0 an 10 mil millions: ");
		
		long number = sc.nextLong();
		long digits = 0;
		
		if (number >= 1000000000L || number < 0 ) {
			System.out.println("The number especified is too long or negative. Please, write a number between 0 a 10 mil million: ");
		}
		else {
			if (number >= 0 && number < 10) {
				digits = 1;
			}
			else if (number <= 10 && number < 100) {
				digits = 2;
			}
			else if (number <= 100 && number < 1000) {
				digits = 3;
			}
			else if (number <= 1000 && number < 10000) {
				digits = 4;
			}
			else if (number <= 10000 && number < 100000) {
				digits = 5;
			}
			else if (number <= 100000 && number < 1000000) {
				digits = 6;
			}
			else if (number <= 1000000 && number < 10000000) {
				digits = 7;
			}
			else if (number <= 10000000 && number < 100000000) {
				digits = 8;
			}
			else if (number <= 100000000 && number < 1000000000) {
				digits = 9;
			}
		}

		System.out.println("The number especified has this many digits: " + digits);
	}

}
