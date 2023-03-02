package tp06.Ejemplo;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;

import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.Vertice;
import tp06.ejercicio3.VerticeImplListAdy;

public class Mapa {
	Grafo<String> grafo;

	public Mapa(Grafo<String> grafo) {
		this.grafo = grafo;
	}


	public ListaGenerica<String> camino(String o, String d) {
		boolean[] marcas = new boolean[grafo.listaDeVertices().tamanio() + 1];
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();

		Vertice<String> vo = obtenerVertice(o);
		Vertice<String> vd = obtenerVertice(d);

		if (vo != null && vd != null) {
			camino(vo, vd, camino, marcas);
		}

		return camino;
	}

	private Vertice<String> obtenerVertice(String o) {
		ListaGenerica<Vertice<String>> lista = grafo.listaDeVertices();
		Vertice<String> ret = null;
		lista.comenzar();
		while (!lista.fin() && ret == null) {
			Vertice<String> vertice = lista.proximo();
			if (vertice.dato().equals(o)) {
				ret = vertice;
			}

		}
		return ret;
	}

	private boolean camino(Vertice<String> o, Vertice<String> d, ListaGenerica<String> camino, boolean[] marcas) {

		boolean encontre = false;
		camino.agregarFinal(o.dato());
		marcas[o.getPosicion()] = true;
		if (o.equals(d)) {
			encontre = true;
		} else {
			ListaGenerica<Arista<String>> adys = grafo.listaDeAdyacentes(o);
			adys.comenzar();
			while (!adys.fin() && !encontre) {
				Vertice<String> ady = adys.proximo().verticeDestino();
				if (!marcas[ady.getPosicion()]) {
					encontre = camino(ady, d, camino, marcas);
				}
			}
		}
		if (!encontre) {
			camino.eliminarEn(camino.tamanio());
		}

		return encontre;
	}

	public ListaGenerica<String> caminoMasCortoEnTramos(String o, String d) { //cuenta la cantidad de aristas
		boolean[] marcas = new boolean[grafo.listaDeVertices().tamanio() + 1];
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		ListaGenerica<String> caminoTemp = new ListaEnlazadaGenerica<String>();

		Vertice<String> vo = obtenerVertice(o);
		Vertice<String> vd = obtenerVertice(d);

		if (vo != null && vd != null) {
			caminoMasCortoEnTramos(vo, vd, camino, caminoTemp, marcas);
		}
		return camino;
	}

	private void caminoMasCortoEnTramos(Vertice<String> o, Vertice<String> d, ListaGenerica<String> camino,
			ListaGenerica<String> caminoTemp, boolean[] marcas) { //cuenta la cantidad de aristas

		caminoTemp.agregarFinal(o.dato());
		marcas[o.getPosicion()] = true;

		if (o.equals(d)) {
			if (camino.esVacia() || caminoTemp.tamanio() < camino.tamanio()) {
				copiar(camino, caminoTemp);
			}
		} else {
			ListaGenerica<Arista<String>> adys = grafo.listaDeAdyacentes(o);
			adys.comenzar();
			while (!adys.fin()) {
				Vertice<String> ady = adys.proximo().verticeDestino();
				if (!marcas[ady.getPosicion()]) {
					caminoMasCortoEnTramos(ady, d, camino, caminoTemp, marcas);
				}
			}
		}

		caminoTemp.eliminarEn(caminoTemp.tamanio());
		marcas[o.getPosicion()] = false;

	}
	
	private void copiar(ListaGenerica<String> camino, ListaGenerica<String> caminoTemp) {
		// Vacio la lista
		int tamanio = camino.tamanio();
		for (int i = 1; i <= tamanio; i++) {
			camino.eliminarEn(1);
		}
		// Copio los elementos
		caminoTemp.comenzar();
		while (!caminoTemp.fin()) {
			camino.agregarFinal(caminoTemp.proximo());
		}

	}
	
	public CaminoPesado<String> caminoMasCortoPesado(String o, String d) {
		boolean[] marcas = new boolean[grafo.listaDeVertices().tamanio() + 1];
		CaminoPesado<String> camino = new CaminoPesado<String>();
		CaminoPesado<String> caminoTemp = new CaminoPesado<String>();

		Vertice<String> vo = obtenerVertice(o);
		Vertice<String> vd = obtenerVertice(d);

		if (vo != null && vd != null) {
			caminoTemp.getCamino().agregarFinal(o);
			marcas[vo.getPosicion()] = true;
			caminoMasCortoPesado(vo, vd, camino, caminoTemp, marcas);
		}
		return camino;
	}

	private void caminoMasCortoPesado(Vertice<String> o, Vertice<String> d, CaminoPesado<String> camino,
			CaminoPesado<String> caminoTemp, boolean[] marcas) {
		
		if (o.equals(d)) {
			if (camino.getCamino().esVacia() || caminoTemp.getPeso() < camino.getPeso()) {
				camino.setCamino(caminoTemp.getCamino().clonar());
				camino.setPeso(caminoTemp.getPeso());
			}
		} else {
			ListaGenerica<Arista<String>> adys = grafo.listaDeAdyacentes(o);
			adys.comenzar();
			while (!adys.fin()) {
				Arista<String> aristaAdy = adys.proximo();
				Vertice<String> VerticeAdy = aristaAdy.verticeDestino();
				if (!marcas[VerticeAdy.getPosicion()]) {
					
					caminoTemp.getCamino().agregarFinal(VerticeAdy.dato());
					caminoTemp.setPeso(caminoTemp.getPeso() + aristaAdy.peso());
					marcas[VerticeAdy.getPosicion()] = true;
					
					caminoMasCortoPesado(VerticeAdy, d, camino, caminoTemp, marcas);
					
					caminoTemp.getCamino().eliminarEn(caminoTemp.getCamino().tamanio());
					caminoTemp.setPeso(caminoTemp.getPeso() - aristaAdy.peso());
					marcas[VerticeAdy.getPosicion()] = false;
				}
			}
		}
		
	}


	public static void main(String[] args) {

		Grafo<String> grafo = new GrafoImplListAdy<String>();

		Vertice<String> ba = new VerticeImplListAdy<String>("Buenos Aires");
		Vertice<String> m = new VerticeImplListAdy<String>("Montevideo");
		Vertice<String> l = new VerticeImplListAdy<String>("Lima");
		Vertice<String> a = new VerticeImplListAdy<String>("Asuncion");
		Vertice<String> r = new VerticeImplListAdy<String>("Rusia");

		grafo.agregarVertice(ba);
		grafo.agregarVertice(m);
		grafo.agregarVertice(l);
		grafo.agregarVertice(a);
		grafo.agregarVertice(r);

		grafo.conectar(ba, m, 10);
		grafo.conectar(ba, l, 60);
		grafo.conectar(ba, a, 5);
		grafo.conectar(m, l,10);
		grafo.conectar(a, l, 3);
		grafo.conectar(l, r);
		
		Mapa mapa = new Mapa(grafo);
		
		//ListaGenerica<String> res = mapa.camino("Buenos Aires", "Lima");
		ListaGenerica<String> res = mapa.caminoMasCortoEnTramos("Buenos Aires", "Rusia");
		//CaminoPesado<String> res = mapa.caminoMasCortoPesado("Buenos Aires", "Lima");
		
		System.out.print(res);
	}
}
