package iFigura;

public class Cuadrado implements iFigura {
	
	// Variables for Cuadrado
	private double lado;
	
	// Constructor
	public Cuadrado(int lado) {
		this.lado = lado;
	}

	// Getter
	public double getLado() {
		return lado;
	}

	// Setter
	public void setLado(double lado) {
		this.lado = lado;
	}
	
	
	// Override the interface methods.
	public double perimetro() {
		
		double perimetro = 4 * lado;
		
		return perimetro;
		
	}
	
	public double area() {
		
		double area = lado * lado;
		
		return area;
		
	}
	
	public void escalar(double escala) {
		
		if (escala >= 0) {
			lado = (lado * escala);
		}
		
		else {
			System.out.println("Escala menor que 0, no se puede operar");
		}
		
	}
	
	public void imprimir() {
		
		System.out.println("_________________________________________");
		System.out.println("Este cuadrado tiene un lado de: " + lado + " cm.");
		System.out.println("Su perímetro es de: " + perimetro() + " cm.");
		System.out.println("Tiene un area de: " + area() + " cm.");
	
	}
		
}
