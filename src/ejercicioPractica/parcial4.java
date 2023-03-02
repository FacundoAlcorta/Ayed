package ejercicioPractica;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.abgen.ArbolGeneral;

public class parcial4 {
	
	public ListaGenerica<ArbolGeneral<Integer>> resolver(ArbolGeneral<Integer> arbol){
		ListaGenerica<ArbolGeneral<Integer>> l = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
		resolver(arbol,l);
		return  l;
	}

	private void resolver(ArbolGeneral<Integer> arbol, ListaGenerica<ArbolGeneral<Integer>> l) {
		if(!arbol.esHoja()) {
		    ListaGenerica<ArbolGeneral<Integer>> lHijos = arbol.getHijos();  
	        lHijos.comenzar();
	        if(!lHijos.esVacia()) {
	            resolver(lHijos.proximo(),l);
	        }	        
	        if(((lHijos.tamanio() % 2) == 0) && (lHijos.tamanio() != 0)&& !arbol.esHoja()) {
	        	l.agregarFinal(arbol);
	        }	        
	        while(!lHijos.fin()){ 
	            resolver(lHijos.proximo(),l);  
	        }
		}
	}

}
