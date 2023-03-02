package ejercicioPractica;

import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp04.abgen.ArbolGeneral;

public class parcial3 {
	private ArbolGeneral<Integer> raiz;
	 
	public parcial3(ArbolGeneral<Integer> r) {
		raiz=r;
	}
	

	public ArbolGeneral<Integer> resolver(int nivel) {
		ColaGenerica<ArbolGeneral<Integer>> cola= new ColaGenerica<ArbolGeneral<Integer>>();
		ListaGenerica<ArbolGeneral<Integer>> hijos;
		ArbolGeneral<Integer> arbol;
		ArbolGeneral<Integer> minHoja = new ArbolGeneral<Integer>(null);
		int min=99999;
		int altura=0;
		cola.encolar(this.raiz);
		cola.encolar(null);
		while(!cola.esVacia()){
			arbol=cola.desencolar();
			if(arbol != null){
				if((altura == nivel) & (arbol.esHoja()) & (arbol.getDatoRaiz() < min)){
					minHoja=arbol;
					min=arbol.getDatoRaiz();
				}
				if(!arbol.esHoja()) {
				hijos = arbol.getHijos();
				hijos.comenzar();
				while(!hijos.fin()) { 
					cola.encolar(hijos.proximo());
					}}
			}else{
				if(!cola.esVacia()){
					altura++;
					cola.encolar(null);
					}
				 }		
			}
		return minHoja;
	}

}
