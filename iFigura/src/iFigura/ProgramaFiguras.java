package iFigura;

import java.util.ArrayList;
import java.util.Iterator;

public class ProgramaFiguras {

    public static void main(String[] args) {
        
        ArrayList<iFigura> listaFiguras = new ArrayList<iFigura>();
        
        Cuadrado cuadrado1 = new Cuadrado(3);
        Circulo circulo1 = new Circulo(5);
        
        listaFiguras.add(cuadrado1);
        listaFiguras.add(circulo1);
                
        mostrar(listaFiguras);
        escalar(listaFiguras, 2);
        mostrar(listaFiguras);
        escalar(listaFiguras, 0.1);
        mostrar(listaFiguras);
        
    }   
    
    public static void mostrar(ArrayList<iFigura> figuras) {
       for (int i = 0; i < figuras.size(); i++) {
    	   
    	   figuras.get(i).imprimir();
    	   
       }
    }
    
    public static void escalar(ArrayList<iFigura> figuras, double escala) {
    	
    	for (int i = 0; i < figuras.size(); i++) {
    		
    		figuras.get(i).escalar(escala);
    		
    	}
       
    }
    
}

