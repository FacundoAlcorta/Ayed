package tp03.ejercicio5;

import tp02.ejercicio3.ColaGenerica;
import tp03.ejercicio2.*;

public class profundiadDeArbolBinario {
	private ArbolBinario<Integer> raiz;
	
	public 	profundiadDeArbolBinario(ArbolBinario<Integer> a) {
		raiz=a;
	}
	
	
	public int sumaDeElementosProfundidad(int p) {
		int i=0;
		int res=0;
		ArbolBinario<Integer> arbol = null;   
		ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();   
		cola.encolar(raiz);     
		cola.encolar(null);  
		i++;
		while (!cola.esVacia()) {    
			arbol = cola.desencolar();
			i--;
			if (arbol != null && p == i) {
				res = res + arbol.getDatoRaiz();  
				if (!arbol.getHijoIzquierdo().esVacio()){
				    cola.encolar(arbol.getHijoIzquierdo()); 
				    i++;
					if (!arbol.getHijoDerecho().esVacio()){    
						cola.encolar(arbol.getHijoDerecho()); 
						} else         
							if (!cola.esVacia()) {            
								System.out.println();            
								cola.encolar(null);        
								}      
					} 
				}} 
		return res;
	}
}