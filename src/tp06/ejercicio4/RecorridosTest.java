package tp06.ejercicio4;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.*;
import tp06.ejercicio5.MapaCiudades;

public class RecorridosTest {
	public static void main(String[] args) {
		 Vertice<String> bs = new VerticeImplListAdy<String>("Buenos Aires");
		 Vertice<String> sant = new VerticeImplListAdy<String>("Santiago");
		 Vertice<String> lima = new VerticeImplListAdy<String>("Lima");
		 Vertice<String> mont =  new VerticeImplListAdy<String>("Montevideo");
		 Vertice<String> as = new VerticeImplListAdy<String>("Asuncion");
		 Vertice<String> lh = new VerticeImplListAdy<String>("La Habana");
		 Vertice<String> c = new VerticeImplListAdy<String>("Caracas");


		 Grafo<String> ciudades = new GrafoImplListAdy<String>();
		 ciudades.agregarVertice(bs);
		 ciudades.agregarVertice(sant);
		 ciudades.agregarVertice(lima);
		 ciudades.agregarVertice(mont);
		 ciudades.agregarVertice(as);
		 ciudades.agregarVertice(lh);
		 ciudades.agregarVertice(c);

	 
		 ciudades.conectar(bs, sant,3); //buenos aires - santiago
		 ciudades.conectar(bs, lima,2); //buenos aires - lima
		 ciudades.conectar(bs,mont,4 ); //buenos aires - montevideo
		 ciudades.conectar(bs, as,10); //buenos aires - asuncion
		 ciudades.conectar(sant, as,500); //santiago - asuncion
		 ciudades.conectar(sant, lh,4); //santiago - la habana
		 ciudades.conectar(lima, as,4); //lima - asuncion
		 ciudades.conectar(mont, as,6); //montevideo - asuncion
		 ciudades.conectar(c, lh,10); //caracas - la habana
		 ciudades.conectar(c, as,11); //caracas - asuncion
		 
		 recorrido<String> r = new recorrido<String>();
		 
		 System.out.println("---la lista de los elementos en dfs es---");
		 r.dfs(ciudades);
		 System.out.println("---la lista de los elementos en bfs es---");
		 r.bfs(ciudades);
	}

}
