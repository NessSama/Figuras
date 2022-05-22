package ArrayListExample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class ArrayListExample {
	
	public static void main (String[] args) {
		
		ArrayList newArrayList = new ArrayList();
	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce una cadena de caracteres para el elemento 1.");
		newArrayList.add(sc.nextInt());
		
		System.out.println("Introduce una cadena de caracteres para el elemento 2.");
		newArrayList.add(sc.nextInt());
		
		System.out.println("Introduce una cadena de caracteres para el elemento 3.");
		newArrayList.add(sc.nextInt());
		
		for (int i = 0; i < newArrayList.size(); i++) {
			System.out.print(newArrayList.get(i));
		}
		
		Iterator it = newArrayList.iterator();
		
		while (it.hasNext()) {
			System.out.print(it.next());
		}
		
		for (Object elements : newArrayList) {
			System.out.print(elements.toString());
			
		}

	}

}
