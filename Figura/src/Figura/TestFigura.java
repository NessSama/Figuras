package Figura;

import java.util.ArrayList;
import java.util.Iterator;

class TestFigura {

	public static void main(String[] args) {
		
		Figura cuadrado1 = new Cuadrado(3.5f);
		Figura cuadrado2 = new Cuadrado(2.2f);
		Figura cuadrado3 = new Cuadrado(8.9f);
		
		Figura circulo1 = new Circulo(3.5f);
		Figura circulo2 = new Circulo(4f);
		
		Figura rectangulo1 = new Rectangulo(2.35f, 2.44f);
		Figura rectangulo2 = new Rectangulo(12f, 8f);
		
		ArrayList serieFiguras = new ArrayList();
		
		serieFiguras.add(cuadrado1);
		serieFiguras.add(cuadrado2);
		serieFiguras.add(cuadrado3);
		serieFiguras.add(circulo1);
		serieFiguras.add(circulo2);
		serieFiguras.add(rectangulo1);
		serieFiguras.add(rectangulo2);
				
		float areaTotal = 0;
		Iterator it = serieFiguras.iterator();
		
		while(it.hasNext()) {
			Figura tmp = (Figura)it.next();
			areaTotal += tmp.area();
		}
		
		System.out.println("Area total:" + areaTotal);

	}

}
