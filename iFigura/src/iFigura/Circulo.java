package iFigura;

public class Circulo implements iFigura {
	
	// Variables for Circulo
	private double radio;
	
	// Constructor
	public Circulo(double radio) {
		
		this.radio = radio;
		
	}
	
	// Getter
	public double getRadio() {
		return radio;
	}

	// Setter
	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	
	// Override the interface methods.
	public double perimetro() {
		
		double perimetro = 2 * Math.PI * radio;
		
		return perimetro;
	}
	
	public double area() {
		
		double area = Math.PI * radio * radio;
		
		return area;
		
	}
	
	public void escalar(double escala) {
		
		if (escala >= 0) {
			radio = (radio * escala);
		}
		
		else {
			System.out.println("Escala menor que 0, no se puede operar");
		}
		
	}
	
	public void imprimir() {
		
		System.out.println("_________________________________________");
		System.out.println("Este circulo tiene un lado de: " + radio + " cm.");
		System.out.println("Su perímetro es de: " + perimetro() + " cm.");
		System.out.println("Tiene un area de: " + area() + " cm.");
	
	}
	

}
