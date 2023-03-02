package tp03.ejercicio5;

import tp03.ejercicio2.ArbolBinario;

public class mainEjer5 {
	public static void main(String[] args) {
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
		
		profundiadDeArbolBinario p = new profundiadDeArbolBinario(arbol);
		System.out.println();
		System.out.println("la suma de numeros del nivel 1 es " + p.sumaDeElementosProfundidad(1));
	}

}
