package Figura;

class Rectangulo implements Figura {

	private float base;
	private float altura;
	
	public Rectangulo(float base, float altura) {
		this.base = base;
		this.altura = altura;
	}
	
	public float area() {
		return base*altura;
	}

	
}
