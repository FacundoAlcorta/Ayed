package ejercicioPractica;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.abgen.ArbolGeneral;


public class parcial2 {
	
	private void recorrerArbol(ArbolGeneral<Integer> arbol,ListaGenerica<Integer> resultado, int nivel) {
		ListaGenerica<ArbolGeneral<Integer>> lHijos = arbol.getHijos();
		ArbolGeneral<Integer> hijo;
		lHijos.comenzar();
		nivel++;
		while(!lHijos.fin()) {
			hijo=lHijos.proximo();
			recorrerArbol(hijo,resultado,nivel);
		}
		nivel--;
		if(arbol.getDatoRaiz() % 2 == 0) {
			resultado.agregarFinal(arbol.getDatoRaiz());
			resultado.agregarFinal(nivel);
			return;
		}

	}
	public ListaGenerica<Integer> resolver(ArbolGeneral<Integer> arbol){
		if(arbol.esVacio()) {
			return null;
		}
		ListaGenerica<Integer> resultado = new ListaEnlazadaGenerica<Integer>();
		int nivel=0;
		resultado.comenzar();
		recorrerArbol(arbol,resultado,nivel);
		return resultado;
	}

}
