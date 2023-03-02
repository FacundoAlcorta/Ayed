package tp03.ejercicio3;

import tp02.ejercicio1.ListaDeEnterosEnlazada;
import tp03.ejercicio2.ArbolBinario;

public class ejer3 {
	
	public static void main(String[] args) {
		ArbolBinario<Integer> arbol = new ArbolBinario<Integer>(6);
		ArbolBinario<Integer> hijoIzq = new ArbolBinario<Integer>(7);
		ArbolBinario<Integer> hijoDer = new ArbolBinario<Integer>(8);
		arbol.agregarHijoIzquierdo(hijoIzq);
		arbol.agregarHijoDerecho(hijoDer);
		ArbolBinario<Integer> hijodelhijoi = new ArbolBinario<Integer>(9);
		ArbolBinario<Integer> hijodelhijod = new ArbolBinario<Integer>(1);
		hijoIzq.agregarHijoDerecho(hijodelhijod);
		hijoIzq.agregarHijoIzquierdo(hijodelhijoi);
		
		arbol.recorridoPorNiveles();
	
		ContadorArbol c = new ContadorArbol(arbol);
		ListaDeEnterosEnlazada l= new ListaDeEnterosEnlazada();
		l.comenzar();
		l=c.numerosPares();
		l.comenzar();
		while(!l.fin()) {
			System.out.println("--------");
			System.out.println(l.proximo());
		}
		
	}

}
