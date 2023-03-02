package tp06.ejemplo3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.Vertice;
import tp06.ejercicio3.VerticeImplListAdy;

public class GrafoPersonas {
	
	private static Vertice<String> obtenerVertice(String o, Grafo<String> grafo) {
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
	
	public static Integer devolverGradoDeSeparacion(String per1, String per2 , Grafo<String> g){
		boolean[] marcas = new boolean[g.listaDeVertices().tamanio() + 1];
		separacion min= new separacion();
		min.setSeparacionMinima(Integer.MAX_VALUE);
		ListaGenerica<String> caminoTemp = new ListaEnlazadaGenerica<String>();
		Vertice<String> o= obtenerVertice(per1,g);
		caminoMasCortoEnTramos(o, per2, min, caminoTemp, marcas,g);
		return min.getSeparacionMinima();
	}

	

private static void caminoMasCortoEnTramos(Vertice<String> o , String d, separacion min,
			ListaGenerica<String> caminoTemp, boolean[] marcas , Grafo<String> grafo) {
	caminoTemp.agregarFinal(o.dato());
	marcas[o.getPosicion()] = true;

	if (o.dato() == d) {
		if (min.getSeparacionMinima() == Integer.MAX_VALUE || (caminoTemp.tamanio() - 1) < min.getSeparacionMinima()) {
			min.setSeparacionMinima(caminoTemp.tamanio() - 1); //el (-1) es porque empieza el arreglo no empieza desde 0
		}
	} else {
		ListaGenerica<Arista<String>> adys = grafo.listaDeAdyacentes(o);
		adys.comenzar();
		while (!adys.fin()) {
			Vertice<String> ady = adys.proximo().verticeDestino();
			if (!marcas[ady.getPosicion()]) {
				caminoMasCortoEnTramos(ady, d, min, caminoTemp, marcas,grafo);
			}
		}
	}
	caminoTemp.eliminarEn(caminoTemp.tamanio());
	marcas[o.getPosicion()] = false;
		
	}



public static void main (String[] args){	

		Grafo<String> grafo = new GrafoImplListAdy<String>();
		
		VerticeImplListAdy<String> a = new VerticeImplListAdy<String>("a");
		VerticeImplListAdy<String> b = new VerticeImplListAdy<String>("b");
		VerticeImplListAdy<String> c = new VerticeImplListAdy<String>("c");
		VerticeImplListAdy<String> d = new VerticeImplListAdy<String>("d");
		VerticeImplListAdy<String> e = new VerticeImplListAdy<String>("e");
		VerticeImplListAdy<String> f = new VerticeImplListAdy<String>("f");
		VerticeImplListAdy<String> g = new VerticeImplListAdy<String>("g");
		VerticeImplListAdy<String> h = new VerticeImplListAdy<String>("h");
		VerticeImplListAdy<String> i = new VerticeImplListAdy<String>("i");
		
		
		grafo.agregarVertice(a);
		grafo.agregarVertice(b);
		grafo.agregarVertice(c);
		grafo.agregarVertice(d);
		grafo.agregarVertice(e);
		grafo.agregarVertice(f);
		grafo.agregarVertice(g);
		grafo.agregarVertice(h);
		grafo.agregarVertice(i);
		
		grafo.conectar(a, i);
		grafo.conectar(i, a);
		
		grafo.conectar(a, b);
		grafo.conectar(b, a);
		
		grafo.conectar(a, f);
		grafo.conectar(f, a);
		
		grafo.conectar(g, f);
		grafo.conectar(f, g);
		
		grafo.conectar(g, e);
		grafo.conectar(e, g);
		
		grafo.conectar(g, d);
		grafo.conectar(d, g);
		
		grafo.conectar(b, e);
		grafo.conectar(e, b);
		
		grafo.conectar(c, e);
		grafo.conectar(e, c);
		
		grafo.conectar(b, c);
		grafo.conectar(c, b);
		
		grafo.conectar(c, d);
		grafo.conectar(d, c);
		
		grafo.conectar(d, h);
		grafo.conectar(h, d);
		

		Integer resultado= devolverGradoDeSeparacion(i.dato(),h.dato(),grafo);
		System.out.println("la separacion minima es: " + resultado);
		
	}

}
