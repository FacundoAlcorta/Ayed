package parcial;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.Vertice;
import tp06.ejercicio3.VerticeImplListAdy;

public class ParcialAlcorta {
	 
	public static ListaGenerica<String> resolver(Grafo<String> ciudad , String origen, String destino , String plazaEvitar){
		if((destino == plazaEvitar) || (origen == plazaEvitar)) {
			return null;
		}
		boolean[] marcas = new boolean[ciudad.listaDeVertices().tamanio() + 1];
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		ListaGenerica<String> caminoTemp = new ListaEnlazadaGenerica<String>();
		Vertice<String> o = buscarOrigen(origen,ciudad);
		if((o != null) && (verificarDestino(destino,ciudad))) {
			resolver(o, destino, camino, caminoTemp, marcas, plazaEvitar, ciudad);
		}
		else {
			return null;
		}
		
		return camino;
	}
	
	
	private static void resolver(Vertice<String> o, String destino, ListaGenerica<String> camino,
			ListaGenerica<String> caminoTemp, boolean[] marcas, String plazaEvitar , Grafo<String> ciudad) {
		
		caminoTemp.agregarFinal(o.dato());
		marcas[o.getPosicion()] = true;
		if (o.dato() == destino) {
			if (camino.esVacia() || caminoTemp.tamanio() > camino.tamanio() && (!caminoTemp.incluye(plazaEvitar))) {
				while(!camino.fin()) {
					camino.eliminarEn(camino.tamanio());//proceso de actualizar camino minimo (es una lista)
				}
				caminoTemp.comenzar();
				while (!caminoTemp.fin()) {
					 camino.agregarFinal(caminoTemp.proximo());//aca lo actualiza , arriba lo borra
				}
			}
		} else {
			ListaGenerica<Arista<String>> adys = ciudad.listaDeAdyacentes(o);
			adys.comenzar();
			while (!adys.fin()) {
				Vertice<String> ady = adys.proximo().verticeDestino();
				if (!marcas[ady.getPosicion()] && (!caminoTemp.incluye(plazaEvitar))) {
					resolver(ady, destino, camino, caminoTemp, marcas, plazaEvitar, ciudad);
				}
			}
		}
		caminoTemp.eliminarEn(caminoTemp.tamanio());
		marcas[o.getPosicion()] = false;
	}


	public static boolean verificarDestino(String d, Grafo<String> grafo) {
		ListaGenerica<Vertice<String>> lista = grafo.listaDeVertices();
		boolean ret = false;
		lista.comenzar();
		while (!lista.fin()) {
			Vertice<String> vertice = lista.proximo();
			if (vertice.dato().equals(d)) {
				ret = true;
			}

		}
		return ret;
	}
		
	

	private static Vertice<String> buscarOrigen(String o ,Grafo<String> grafo) {
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
	
	public static void main(String[] args) {

		Grafo<String> ciudad = new GrafoImplListAdy<String>();

		Vertice<String> a = new VerticeImplListAdy<String>("a");
		Vertice<String> b = new VerticeImplListAdy<String>("b");
		Vertice<String> c = new VerticeImplListAdy<String>("c");
		Vertice<String> d = new VerticeImplListAdy<String>("d");
		Vertice<String> e = new VerticeImplListAdy<String>("e");
		Vertice<String> f = new VerticeImplListAdy<String>("f");
		
		ciudad.agregarVertice(a);
		ciudad.agregarVertice(b);
		ciudad.agregarVertice(c);
		ciudad.agregarVertice(d);
		ciudad.agregarVertice(e);
		ciudad.agregarVertice(f);

		
		ciudad.conectar(a, b);
		ciudad.conectar(b,a);
	
		ciudad.conectar(a, e);
		ciudad.conectar(e, a);
		
		ciudad.conectar(a, c);
		ciudad.conectar(c, a);
		
		ciudad.conectar(b,e);
		ciudad.conectar(e,b);
		
		ciudad.conectar(b,d);
		ciudad.conectar(d,b);
		
		ciudad.conectar(c,e);
		ciudad.conectar(e,c);
		
		ciudad.conectar(c,d);
		ciudad.conectar(d,c);
		
		ciudad.conectar(d,e);
		ciudad.conectar(e,d);
		
		ciudad.conectar(d,f);
		ciudad.conectar(f,d);
		
		ListaGenerica<String> recorrido = resolver(ciudad,"a" , "f" , "f");
		recorrido.comenzar();
		System.out.println("el recorrido maximo sin pasar por la plaza indicada es:");
		System.out.println(recorrido);
		while(!recorrido.fin()) {
			System.out.println(recorrido.proximo());
		}
}
		

	
	

}
