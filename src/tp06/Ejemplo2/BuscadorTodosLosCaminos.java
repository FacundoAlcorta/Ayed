package tp06.Ejemplo2;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;
import tp06.ejercicio3.Arista;


public class BuscadorTodosLosCaminos{
	private Grafo<String> bosque;
	
	public BuscadorTodosLosCaminos(Grafo<String> bosque) {
		this.bosque = bosque;
	}

	public ListaGenerica<ListaGenerica<String>> recorridosMasSeguros() {
		ListaGenerica<ListaGenerica<String>> resultado = new ListaEnlazadaGenerica<ListaGenerica<String>>();
		ListaGenerica<String> caminoActual = new ListaEnlazadaGenerica<String>();
		boolean[] marca = new boolean[bosque.listaDeVertices().tamanio() + 1];
		// Búsqueda de la casa de Caperucita Roja
		Vertice<String> v = buscarCasaCaperucita();
		caminoActual.agregarFinal(v.dato());
		marca[v.getPosicion()] = true;
		dfs(v, caminoActual, marca, resultado);
		return resultado;
	}

	private void dfs(Vertice<String> v, ListaGenerica<String> caminoActual, boolean[] marca,
										ListaGenerica<ListaGenerica<String>> resultado) {
		ListaGenerica<Arista<String>> ady = bosque.listaDeAdyacentes(v);
		ady.comenzar();
		while (!ady.fin()) {
			Arista<String> a = ady.proximo();
			Vertice<String> vDest = a.verticeDestino();
			int posDest = vDest.getPosicion();
			if (!marca[posDest] && a.peso() < 5) {
				marca[posDest] = true;	
				caminoActual.agregarFinal(vDest.dato());
				if (vDest.dato().equals("Casa Abuelita")) {
					resultado.agregarFinal(caminoActual.clonar());
				}else {
					dfs(vDest, caminoActual, marca, resultado);
				}
				marca[posDest] = false;
				caminoActual.eliminarEn(caminoActual.tamanio());
			} // fin del 1er If
		} // fin del while
	}

	private Vertice<String> buscarCasaCaperucita() {
		ListaGenerica<Vertice<String>> vertices = bosque.listaDeVertices();
		vertices.comenzar();
		while (!vertices.fin()) {
			Vertice<String> v = vertices.proximo();
			if (v.dato().equals("Casa Caperucita"))
				return v;
		}
		return null; // aunque siempre tiene que estar
	}
}


