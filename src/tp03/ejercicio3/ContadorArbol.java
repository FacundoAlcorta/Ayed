package tp03.ejercicio3;

import tp03.ejercicio2.*;
import tp02.ejercicio1.*;

class ContadorArbol {
	private ArbolBinario<Integer> arbol;
	
	public ContadorArbol(ArbolBinario<Integer> ar) {
		arbol=ar;
	}

	public void  calcularPares(ArbolBinario<Integer> a , ListaDeEnterosEnlazada contPares) {
		if(! a.esVacio()) {
			if(a.getDatoRaiz() % 2 == 0) {
				contPares.agregarFinal(a.getDatoRaiz());
				System.out.println("......");
			}
			calcularPares(a.getHijoIzquierdo(),contPares);
			calcularPares(a.getHijoDerecho(),contPares);
		}	
	}
	
	public ListaDeEnterosEnlazada numerosPares() {
		ListaDeEnterosEnlazada contPares = new ListaDeEnterosEnlazada();
		contPares.comenzar();
		calcularPares(arbol , contPares);
		return contPares;
		
}
		
		

}
