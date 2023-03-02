package tp03.ejercicio3;

import tp03.ejercicio2.ArbolBinario;

public class ejer4 {
	public static void main (String[] args) {
		ArbolBinario<Integer> arbol = new ArbolBinario<Integer>(4);
		ArbolBinario<Integer> hijoIzq = new ArbolBinario<Integer>(1);
		ArbolBinario<Integer> hijoDer = new ArbolBinario<Integer>(1);
		arbol.agregarHijoIzquierdo(hijoIzq);
		arbol.agregarHijoDerecho(hijoDer);
		ArbolBinario<Integer> hijodelhijoii = new ArbolBinario<Integer>(1);
		ArbolBinario<Integer> hijodelhijoid= new ArbolBinario<Integer>(5);
		hijoIzq.agregarHijoDerecho(hijodelhijoid);
		hijoIzq.agregarHijoIzquierdo(hijodelhijoii);
		ArbolBinario<Integer> hijodelhijodi = new ArbolBinario<Integer>(4);
		ArbolBinario<Integer> hijodelhijodd= new ArbolBinario<Integer>(3);
		hijoDer.agregarHijoDerecho(hijodelhijodd);
		hijoDer.agregarHijoIzquierdo(hijodelhijodi);
		
		arbol.recorridoPorNiveles();
		
		RedBinariaLlena r = new RedBinariaLlena(arbol);
		System.out.println();
		System.out.println("el retardo maximo del arbol es :" + r.retardoEnvio());
		
		
	}

}
