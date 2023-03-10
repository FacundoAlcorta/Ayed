package estructuras;

import estructuras.*;

public class ArbolBinario<T> {

	private NodoBinario<T> raiz;

	public ArbolBinario(T dato) {
		this.raiz = new NodoBinario<T>(dato);
	}

	private ArbolBinario(NodoBinario<T> nodo) {
		this.raiz = nodo;
	}

	private NodoBinario<T> getRaiz() {
		return raiz;
	}

	public T getDatoRaiz() {
		if (this.getRaiz() != null) {
			return this.getRaiz().getDato();
		} else {
			return null;
		}
	}

	public ArbolBinario<T> getHijoIzquierdo() {
		return new ArbolBinario<T>(this.raiz.getHijoIzquierdo());
	}

	public ArbolBinario<T> getHijoDerecho() {
		return new ArbolBinario<T>(this.raiz.getHijoDerecho());
	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.raiz.setHijoIzquierdo(hijo.getRaiz());
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.raiz.setHijoDerecho(hijo.getRaiz());
	}

	public void eliminarHijoIzquierdo() {
		this.raiz.setHijoIzquierdo(null);
	}

	public void eliminarHijoDerecho() {
		this.raiz.setHijoDerecho(null);
	}

	public boolean esVacio() {
		return this.getDatoRaiz() == null;
	}

	public boolean esHoja() {
		return this.getDatoRaiz() != null && this.getHijoIzquierdo().esVacio() && this.getHijoDerecho().esVacio();
	}
	
	private int recorrer()
	{
		int a = 0;
		if (this.esHoja())
		{
			a++;
		}
		if(!this.getHijoIzquierdo().esVacio())
		{
			a=a + this.getHijoIzquierdo().recorrer();
		}
		if(!this.getHijoDerecho().esVacio())
		{
			a=a + this.getHijoDerecho().recorrer();
		}
		return a;
	}	
	
	public int contarHojas(ArbolBinario<T> nodo) {
		return nodo.recorrer();
	}
	
	public void espejar( ArbolBinario<T> a , ArbolBinario<T> esp) {
		if(a.esHoja() != true) {
			esp.agregarHijoIzquierdo(a.getHijoDerecho());
			esp.agregarHijoDerecho(a.getHijoIzquierdo());
			espejar(a.getHijoIzquierdo(),esp.getHijoDerecho());
			espejar(a.getHijoDerecho(),esp.getHijoIzquierdo());
		}
		System.out.println(a.getDatoRaiz());
	}
	
	public ArbolBinario<T> espejo( ArbolBinario<T> a){
		 if(a.esVacio()) {
			 return null;
		 }
		 ArbolBinario<T> esp = new ArbolBinario(a.getDatoRaiz());
		 espejar(a,esp);
		 return esp;
	}
	
	public void recorridoPorNiveles() {   
		ArbolBinario<T> arbol = null;   
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();   
		cola.encolar(this);     
		cola.encolar(null);     
		while (!cola.esVacia()) {    
			arbol = cola.desencolar();     
			if (arbol != null) {       
				System.out.print(arbol.getDatoRaiz() + "-");        
				if (!arbol.getHijoIzquierdo().esVacio()){
				    cola.encolar(arbol.getHijoIzquierdo());        
					if (!arbol.getHijoDerecho().esVacio()){    
						cola.encolar(arbol.getHijoDerecho());     
						} else         
							if (!cola.esVacia()) {            
								System.out.println();            
								cola.encolar(null);        
								}      
					} 
				}} 
	}

}