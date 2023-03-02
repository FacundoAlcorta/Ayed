package tp03.ejercicio3;

import tp03.ejercicio2.*;

public class RedBinariaLlena {
	private ArbolBinario<Integer> raiz;
	
	public RedBinariaLlena(ArbolBinario<Integer> a) {
		raiz=a;
	}
	
	public int calcularRet(ArbolBinario<Integer> arbol,int retardoMax, int retardo) {
		retardo=retardo + arbol.getDatoRaiz();
		if(arbol.esHoja()) {
			if(retardo>retardoMax) {
				retardoMax=retardo;
				return retardoMax;
			}
		}else {
			retardoMax=calcularRet(arbol.getHijoIzquierdo(),retardoMax,retardo);
			retardoMax=calcularRet(arbol.getHijoDerecho(),retardoMax,retardo);
		}
		return retardoMax;
	}
	
	public int retardoEnvio() {
		int retardo=0;
		int retardoMax=-1;
		return calcularRet(raiz,retardoMax,retardo);
		
	}
	}
