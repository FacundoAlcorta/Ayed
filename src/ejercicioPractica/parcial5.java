package ejercicioPractica;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.abgen.ArbolGeneral;

public class parcial5 {
	private ArbolGeneral<Integer> arbol;
	
	public parcial5(ArbolGeneral<Integer> a){
		arbol=a;
	}
	
	
	public ListaEnlazadaGenerica<Integer> resolver(){
    	ListaEnlazadaGenerica<Integer> l =new ListaEnlazadaGenerica<Integer>();
    	resolver(arbol,l);
		return l;	
    }
    
	private void resolver(ArbolGeneral<Integer> arbol,ListaGenerica<Integer> l) {
		int sumatoria=0;
		if(arbol.esHoja()) {
			return;
		}
		ListaGenerica<ArbolGeneral<Integer>> lHijos = arbol.getHijos();
		ArbolGeneral<Integer> hijo;
		lHijos.comenzar();
		while(!lHijos.fin()) {
			hijo=lHijos.proximo();
			sumatoria = sumatoria + hijo.getDatoRaiz();
			resolver(hijo,l);
		}
		if(lHijos.tamanio() % 2 == 1) {
			l.agregarFinal(sumatoria);
		}
	}

}
