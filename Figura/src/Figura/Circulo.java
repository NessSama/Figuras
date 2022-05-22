package Figura;

class Circulo implements Figura {

	private float radio;
		
	public Circulo(float radio) {
		this.radio = radio;
	}

	public float area() {
		return PI*radio*radio;
	}
}
