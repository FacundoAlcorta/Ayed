package ejercicioPractica;

import tp02.ejercicio2.ListaGenerica;
import tp04.abgen.ArbolGeneral;

public class parcial {
	private int posi=0;
	private int neg=0;
	
	
	private int calcularNodos(ArbolGeneral<Integer> arbol,int ar) {
		ar = arbol.getDatoRaiz();
		if(arbol.getHijos() == null) {
			return ar;
		}
		ListaGenerica<ArbolGeneral<Integer>> lHijos = arbol.getHijos();
		ArbolGeneral<Integer> hijo;
		
		lHijos.comenzar();
		while(!lHijos.fin()) {
			hijo=lHijos.proximo();
			ar= ar + this.calcularNodos(hijo,ar);
		}
		if(arbol.getDatoRaiz() >  0) {
			posi = posi + arbol.getDatoRaiz(); 
		} 
		else{ 
			neg= neg + arbol.getDatoRaiz();
		}
		return ar;
	}
	
	public int resolver (ArbolGeneral<Integer> arbol) {
		if(arbol == null) {
			return 0;
		}
		int ar=0;
		if((calcularNodos(arbol,ar) % 2) == 0){
			System.out.println("tienen en total nodos pares");
			return posi;
		}else
			System.out.println("tienen en total nodos impares");
			return neg;
	}

}
