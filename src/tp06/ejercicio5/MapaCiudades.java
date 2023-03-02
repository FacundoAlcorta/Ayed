package tp06.ejercicio5;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class MapaCiudades{
	Grafo<String> mapaCiudades;

	
	public MapaCiudades(Grafo<String> ciudades) {
		mapaCiudades=ciudades;
	}
	
	
	public void ListaCiudades(){
		ListaGenerica<Vertice<String>> listaVertices = mapaCiudades.listaDeVertices();
		listaVertices.comenzar();
		while(!listaVertices.fin()) {
			System.out.println(listaVertices.proximo().dato());
		}
	}


	private Vertice<String> buscarCiudad(String ciudad1){
		ListaGenerica<Vertice<String>> listaVertices = mapaCiudades.listaDeVertices();
	    Vertice<String> v = null;
	    listaVertices.comenzar();
	    while(!listaVertices.fin()){
	       v = listaVertices.proximo();
	       if(v.dato().equals(ciudad1)) {
	         return v;
	       }
	    }
	   return v;
	}
	
	private void BuscarCamino(Vertice<String> v, String c2,ListaGenerica<String> camino, boolean[] marca) {
		marca[v.getPosicion()]=true;
		camino.agregarFinal(v.dato());
		ListaGenerica<Arista<String>> ady= mapaCiudades.listaDeAdyacentes(v);
		ady.comenzar();
		while(!ady.fin() && !camino.incluye(c2)) {
			Arista<String> a= ady.proximo();
			int j= a.verticeDestino().getPosicion();
			if(!marca[j]) {
				this.BuscarCamino(a.verticeDestino(),c2,camino,marca);
			}
		}
		if(!camino.incluye(c2)) {
			camino.eliminarEn(camino.tamanio());			
		}		
	}
	
	public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2){
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1];
		Vertice<String> v= buscarCiudad(ciudad1);
		Vertice<String> c2= buscarCiudad(ciudad2);
		if((v != null) && (c2 != null)) {
			BuscarCamino(v,ciudad2,camino,marca);						
		}else { 
			System.out.println("EL COMIENZO O DESTINO NO EXISTEN");
		}	
		return camino;		
	}
	
	
	private void BuscarCaminoExceptuado(Vertice<String> v, String c2,ListaGenerica<String> camino, boolean[] marca,ListaGenerica<String> prohibido) {
		marca[v.getPosicion()]=true;
		camino.agregarFinal(v.dato());
		ListaGenerica<Arista<String>> ady= mapaCiudades.listaDeAdyacentes(v);
		ady.comenzar();
		while(!ady.fin() && !camino.incluye(c2)) {
			Arista<String> a= ady.proximo();
			int j= a.verticeDestino().getPosicion();
			if(!marca[j] && !(prohibido.incluye(a.verticeDestino().dato()))) {
				this.BuscarCamino(a.verticeDestino(),c2,camino,marca);
			}
		}
		if(!camino.incluye(c2)) {
			camino.eliminarEn(camino.tamanio());			
		}		
	}
	
	public ListaGenerica<String> devolverCaminoExeptuado(String ciudad1, String ciudad2, ListaGenerica<String> prohibido){
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1];
		Vertice<String> v= buscarCiudad(ciudad1);
		Vertice<String> c2= buscarCiudad(ciudad2);
		if((v != null) && (c2 != null)&&(!prohibido.incluye(v.dato()))&&(!prohibido.incluye(c2.dato()))) {
			BuscarCaminoExceptuado(v,ciudad2,camino,marca,prohibido);						
		}else { 
			System.out.println("EL COMIENZO O DESTINO NO EXISTEN");
		}	
		return camino;		
	}
	
	
	public ListaGenerica<String> devolverCaminoCorto(String ciudad1, String ciudad2){
		Integer peso=0;
		ListaGenerica<String> caminoAct= new ListaEnlazadaGenerica<String>();
		caminoMinimo cm= new caminoMinimo();
		boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1];
		Vertice<String> v= buscarCiudad(ciudad1);
		Vertice<String> c2= buscarCiudad(ciudad2);
		if((v != null) && (c2 != null)) {
			BuscarCaminoCorto(v,ciudad2,caminoAct,marca,cm,peso);						
		}else { 
			System.out.println("EL COMIENZO O DESTINO NO EXISTEN");
		}	
		return cm.getCaminoMinimo();
		}
	
	private void BuscarCaminoCorto(Vertice<String> v, String ciudad2,ListaGenerica<String> caminoAct, boolean[] marca,
									caminoMinimo cm,Integer peso) 
		{
		System.out.println(v.dato());
		marca[v.getPosicion()]=true;
		caminoAct.agregarFinal(v.dato());
		ListaGenerica<Arista<String>> ady= mapaCiudades.listaDeAdyacentes(v);
		ady.comenzar();
		while(!ady.fin()) {
			Arista<String> a= ady.proximo();
			Vertice<String> vDest= a.verticeDestino();
			if(!marca[vDest.getPosicion()]){
				//caminoAct.agregarFinal(vDest.dato());
				peso = peso + a.peso();
				if(vDest.dato().equals(ciudad2)){
					if(peso<cm.getValorMinimo()) {
						cm.setValorMinimo(peso);
						cm.copiar(caminoAct);
					}
				}else {
					this.BuscarCaminoCorto(vDest, ciudad2, caminoAct, marca, cm, peso);
				}
				marca[vDest.getPosicion()]=false;
				caminoAct.eliminarEn(caminoAct.tamanio());
				peso=peso - a.peso();
			}				
		}
	}
		
	}

	
	

