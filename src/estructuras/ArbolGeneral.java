package estructuras;


import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;

public class ArbolGeneral<T> {

	private NodoGeneral<T> raiz;

	public ArbolGeneral() {

		this.raiz = null;
	}

	public ArbolGeneral(T dato) {

		this.raiz = new NodoGeneral<T>(dato);
		
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> lista) {

		this(dato);
		ListaGenerica<NodoGeneral<T>> hijos = new ListaEnlazadaGenerica<NodoGeneral<T>>();

		lista.comenzar();
		while (!lista.fin()) {
			ArbolGeneral<T> arbolTemp = lista.proximo();
			hijos.agregarFinal(arbolTemp.getRaiz());
			
		}

		raiz.setListaHijos(hijos);
	}

	private ArbolGeneral(NodoGeneral<T> nodo) {

		this.raiz = nodo;
	}


	private NodoGeneral<T> getRaiz() {

		return this.raiz;
	}

	public T getDatoRaiz() {

		return this.raiz.getDato();
	}

	
	public ListaGenerica<ArbolGeneral<T>> getHijos() {

		ListaGenerica<ArbolGeneral<T>> lista = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		ListaGenerica<NodoGeneral<T>> hijos = (ListaGenerica<NodoGeneral<T>>) this
				.getRaiz().getHijos();
		lista.comenzar();
		hijos.comenzar();

		while (!hijos.fin()) {
			lista.agregarFinal(new ArbolGeneral<T>(hijos.proximo()));
			
		}

		return lista;
	}

	
	public void agregarHijo(ArbolGeneral<T> unHijo) {

		NodoGeneral<T> hijo = unHijo.getRaiz();
		this.raiz.getHijos().agregarFinal(hijo);
	}

	
	public void eliminarHijo(ArbolGeneral<T> unHijo) {

		NodoGeneral<T> hijo = unHijo.getRaiz();
		boolean ok = false;

		ListaGenerica<NodoGeneral<T>> listaHijos = (ListaGenerica<NodoGeneral<T>>) this
				.getRaiz().getHijos();
		listaHijos.comenzar();

		while (!listaHijos.fin() && !ok) {

			NodoGeneral<T> hijoTemp = listaHijos.proximo();
			if (hijoTemp.getDato().equals(hijo.getDato())) {
				ok = listaHijos.eliminar(hijoTemp);
				
			}
		}	

		
	}
	
    
    
	public Integer nivel(T dato) {
		ColaGenerica<ArbolGeneral<T>> cola= new ColaGenerica<ArbolGeneral<T>>();
		int altura=0;
		ListaGenerica<ArbolGeneral<T>> hijos;
		ArbolGeneral<T> arbol;
		cola.encolar(this);
		cola.encolar(null);
		while(!cola.esVacia()){
			arbol=cola.desencolar();
			if(arbol != null){
				if(arbol.getDatoRaiz()== dato) {
					return altura;
				}
				hijos = arbol.getHijos();//obtengo hijos
				hijos.comenzar();
				while(!hijos.fin()) { //para cada hijo del arbol
					cola.encolar(hijos.proximo());//lo meto en la cola
					}
			}else{
				if(!cola.esVacia()){
					cola.encolar(null);
					altura++;
				 }		
			}
		}
		return -1;   
	}

	
	public Integer altura(){
		ColaGenerica<ArbolGeneral<T>> cola= new ColaGenerica<ArbolGeneral<T>>();
		int altura=0;
		ListaGenerica<ArbolGeneral<T>> hijos;
		ArbolGeneral<T> arbol;
		cola.encolar(this);
		cola.encolar(null);
		while(!cola.esVacia()){
			arbol=cola.desencolar();
			if(arbol != null){
				hijos = arbol.getHijos();
				hijos.comenzar();
				while(!hijos.fin()) { 
					cola.encolar(hijos.proximo());
					}
			}else{
				if(!cola.esVacia()){
					cola.encolar(null);
					altura++;
				 }		
			}
		}
		return altura;
	}


	public int Ancho(){
		ColaGenerica<ArbolGeneral<T>> cola= new ColaGenerica<ArbolGeneral<T>>();
		int max=-1;
		int cant=0;
		ListaGenerica<ArbolGeneral<T>> hijos;
		ArbolGeneral<T> arbol;
		cola.encolar(this);
		cola.encolar(null);
		while(!cola.esVacia()){
			arbol=cola.desencolar();
			if(arbol!=null){
				cant++;
				hijos = arbol.getHijos();//obtengo hijos
				hijos.comenzar();
				while(!hijos.fin()) { //para cada hijo del arbol
					cola.encolar(hijos.proximo());//lo meto en la cola
					}
			}else{
				if(!cola.esVacia()){
					cola.encolar(null);
					if(cant>max) { //paso al sig nivel la cant la guardo si es max
						max=cant;
						}
					cant=0;//pongo en 0
				}
				if(cant>max) {
					max=cant;
					}				
			}
		}
		return max;
	}

	public Boolean esHoja(){
		return raiz.getHijos().esVacia() && raiz.getDato() != null;
	}
	
	public Boolean esVacio(){
		return raiz.getDato() == null;
	}
	
	public ListaEnlazadaGenerica<T> inOrden(){
        ListaEnlazadaGenerica<T> l = new ListaEnlazadaGenerica<T>();
        this.inOrden(l);
        return l;
    }
    
    private void inOrden(ListaGenerica<T> l){  
        ListaGenerica<ArbolGeneral<T>> lHijos = this.getHijos();  
        ArbolGeneral<T> hijo;
        lHijos.comenzar();
        if(!lHijos.esVacia()) {
            hijo= lHijos.proximo();
            hijo.inOrden(l);
        }
        l.agregarFinal(this.getRaiz().getDato());
        while(!lHijos.fin()){ 
        	hijo= lHijos.proximo();
            hijo.inOrden(l);  
        }            
    }
	
    public ListaEnlazadaGenerica<T> PreOrden(){
    	ListaEnlazadaGenerica<T> l =new  ListaEnlazadaGenerica<T>();
    	this.PreOrden(l);
		return l;	
    }
    
	private void PreOrden(ListaGenerica<T> l) {
		l.agregarFinal(this.getRaiz().getDato());
		ListaGenerica<ArbolGeneral<T>> lHijos = this.getHijos();
		ArbolGeneral<T> hijo;
		lHijos.comenzar();
		while(!lHijos.fin()) {
			hijo=lHijos.proximo();
			hijo.PreOrden(l);
		}

	}
	
	
	  public ListaEnlazadaGenerica<T> PostOrden(){
	    	ListaEnlazadaGenerica<T> l =new  ListaEnlazadaGenerica<T>();
	    	this.PostOrden(l);
			return l;	
	    }
	    
		private void PostOrden(ListaGenerica<T> l) {
			ListaGenerica<ArbolGeneral<T>> lHijos = this.getHijos();
			ArbolGeneral<T> hijo;
			lHijos.comenzar();
			while(!lHijos.fin()) {
				hijo=lHijos.proximo();
				hijo.PostOrden(l);
			}
			l.agregarFinal(this.getRaiz().getDato());

		}
	
	public boolean esAncestro(T a, T b) {
		boolean ok=false;
		if (!this.esVacio()){
			if (this.getDatoRaiz() == a) {
				ok= this.esAncestro(b);
			}
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			while (!hijos.fin() && !ok)
				ok = ok | hijos.proximo().esAncestro(a, b);
			}
		return ok;
		}

	public boolean esAncestro(T b){
		boolean ok=false;
			if (this.getDatoRaiz() == b)
				return ok=true;
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			while (!hijos.fin())
				ok= ok | hijos.proximo().esAncestro(b);
			return ok;
		}
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
