package addUpperTriangle;

import java.util.Arrays;

/*
 * Haz un programa que imprima la suma del triangulo superior de una matriz a traves de un método.
 * 
 * Ejemplo:
 * 
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * Salida:
 * Suma = 26
 */

class addUpperTriangle {

	public static void main(String[] args) {
		
		int[][] matrix = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9},
		}; 
		
		System.out.println(Arrays.deepToString(matrix));
		
		int add = 0;
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix[i].length; j++) {
				add += matrix[i][j];
			}
			
		}
		System.out.println("La suma es:" + add);
	}

}
