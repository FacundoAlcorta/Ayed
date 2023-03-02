package tp06.Ejemplo2;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;
import tp06.ejercicio3.Arista;

public class BuscadorDeCaminos {
	private Grafo<String> bosque;
	
	public BuscadorDeCaminos() {
		// TODO Auto-generated constructor stub
	}

			
	public ListaGenerica<String> recorridoMasSeguro(){
		ListaGenerica<String> lis = new ListaEnlazadaGenerica<String>();
		Boolean[] marca = new Boolean[bosque.listaDeVertices().tamanio()+1];
		Vertice<String> v;
		// Búsqueda de la casa de Caperucita Roja
		v = buscarCasaCaperucita();
		dfs(v.getPosicion(), lis, marca);
		return lis;
	}

	private Boolean dfs(int posV,ListaGenerica<String> lis, Boolean[] marca){
		Boolean encontre = false ;
		marca[posV] = true;
		Vertice<String> vert  = bosque.vetice(posV);
		lis.agregarEn(vert.dato(), lis.tamanio());
		if (vert.dato().equals("Casa Abuelita"))
			encontre = true;
		else{
			ListaGenerica<Arista<String>>ady = bosque.listaDeAdyacentes(vert);
			ady.comenzar();
			while(!ady.fin()&& !encontre){
				Arista<String>  a = ady.proximo();
				int  j = a.verticeDestino().getPosicion();
				if (!marca [j])
					if(a.peso()<5)
						encontre  = dfs(j, lis, marca);
			}
			if(!encontre)
				lis.eliminarEn(lis.tamanio());
		}
		return encontre;
	}

	private Vertice<String> buscarCasaCaperucita(){

		ListaGenerica<Vertice<String> >vertices = bosque.listaDeVertices();
		Vertice<String> v = null;
		vertices.comenzar();
		while(!vertices.fin()){
			v = vertices.proximo();
			if (v.dato().equals ("Casa Caperucita"))
				return  v;
		}
		return v;
	}
		

	
}
