package tp06.ejercicio4;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class recorrido<T> {
	
	public ListaGenerica<T> dfs(Grafo<T> grafo){
		ListaGenerica<T> Lista= new ListaEnlazadaGenerica<T>();
		boolean[] marca= new boolean[grafo.listaDeVertices().tamanio() + 1];
		for(int i= 1 ; i <= grafo.listaDeVertices().tamanio(); i++) {
			if(!marca[i]) 
				this.dfs(i, grafo, marca, Lista);
		}
			return Lista;
	}
	
	private void dfs(int i, Grafo<T> grafo, boolean[] marca, ListaGenerica<T> lista) {
		marca[i]=true;
		Vertice<T> v= grafo.listaDeVertices().elemento(i);
		//System.out.println(v.dato());  //aca es cuando imprimo el elemento
		//lista.agregarFinal(v.dato());
		ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		while(!ady.fin()) {
			int j= ady.proximo().verticeDestino().getPosicion();
			if(!marca[j]) {
				this.dfs(j, grafo, marca, lista);
			}
		}
	}
	
	public ListaGenerica<T> bfs(Grafo<T> ciudades) {
		ListaGenerica<T> Lista = new ListaEnlazadaGenerica<T>();
		boolean[] marca= new boolean[ciudades.listaDeVertices().tamanio() + 1];
		for(int i=1; i<= ciudades.listaDeVertices().tamanio(); i++ ) {
			if(!marca[i]) {
				this.bfs(i,ciudades,marca,Lista);
			}		
		}
		return Lista;
	}

	private void bfs(int i, Grafo<T> grafo, boolean[] marca, ListaGenerica<T> lista) {
		ListaGenerica<Arista<T>> ady = null;
		ColaGenerica<Vertice<T>> q = new ColaGenerica<Vertice<T>>();
 		q.encolar(grafo.listaDeVertices().elemento(i));
 		marca[i]=true;
 		while(!q.esVacia()) {
 			Vertice<T> v= q.desencolar();
 			//lista.agregarFinal(v.dato());
 			//System.out.println(v.dato()); //aca es cuando imprimo el elemento
 			ady = grafo.listaDeAdyacentes(v);
 			ady.comenzar();
 			while(!ady.fin()) {
 				Arista<T> arista = ady.proximo();
 				int j= arista.verticeDestino().getPosicion();
 				if(!marca[j]) {
 					Vertice<T> w = arista.verticeDestino();
 					marca[j] = true;
 					q.encolar(w);
 				}
 			}			
 		}
	}	
	
	
}

