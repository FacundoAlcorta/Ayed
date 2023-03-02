package tp04.ejercicio5;

import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp04.abgen.ArbolGeneral;

public class mainejer5 {
	
	
	public static Integer DevolverMaximoPromedio(ArbolGeneral<AreaEmpresa> ar){
		int cantidad=0;
		int promedio=0;
		int promediom=-1;
		int contador=0;
		ColaGenerica<ArbolGeneral<AreaEmpresa>> cola= new ColaGenerica<ArbolGeneral<AreaEmpresa>>();
		ListaGenerica<ArbolGeneral<AreaEmpresa>> hijos;
		ArbolGeneral<AreaEmpresa> arbol;
		cola.encolar(ar);
		cola.encolar(null);
		while(!cola.esVacia()){
			arbol=cola.desencolar();
			if(arbol != null){
				contador = contador + arbol.getDatoRaiz().getRetardo();
				cantidad++;
				hijos = arbol.getHijos();//obtengo hijos
				hijos.comenzar();
				while(!hijos.fin()) { //para cada hijo del arbol
					cola.encolar(hijos.proximo());//lo meto en la cola					
					}
			}else{
				if(!cola.esVacia()){
					cola.encolar(null);
				 }
				promedio = contador / cantidad;
				if(promedio > promediom) {
					promediom=promedio;
				}
				contador=0;
				cantidad=0;
				promedio=0;
			}
		}
		return promediom;
	}
	
	
	public static void main(String[] args) {
		AreaEmpresa m = new AreaEmpresa("m",20);
		ArbolGeneral<AreaEmpresa> m0 = new ArbolGeneral<AreaEmpresa>(m);
		AreaEmpresa j = new AreaEmpresa("j",13);
		ArbolGeneral<AreaEmpresa> j1 = new ArbolGeneral<AreaEmpresa>(j);
		AreaEmpresa k = new AreaEmpresa("k",25);
		ArbolGeneral<AreaEmpresa> k1 = new ArbolGeneral<AreaEmpresa>(k);
		AreaEmpresa l = new AreaEmpresa("l",10);
		ArbolGeneral<AreaEmpresa> l1 = new ArbolGeneral<AreaEmpresa>(l);
		
		m0.agregarHijo(l1);
		m0.agregarHijo(k1);
		m0.agregarHijo(j1);
		
		
		AreaEmpresa a = new AreaEmpresa("a",4);
		ArbolGeneral<AreaEmpresa> a2 = new ArbolGeneral<AreaEmpresa>(a);
		AreaEmpresa b = new AreaEmpresa("b",7);
		ArbolGeneral<AreaEmpresa> b2 = new ArbolGeneral<AreaEmpresa>(b);
		AreaEmpresa c = new AreaEmpresa("c",5);
		ArbolGeneral<AreaEmpresa> c2 = new ArbolGeneral<AreaEmpresa>(c);
		AreaEmpresa d = new AreaEmpresa("d",6);
		ArbolGeneral<AreaEmpresa> d2 = new ArbolGeneral<AreaEmpresa>(d);
		AreaEmpresa e = new AreaEmpresa("e",10);
		ArbolGeneral<AreaEmpresa> e2 = new ArbolGeneral<AreaEmpresa>(e);
		AreaEmpresa f = new AreaEmpresa("f",18);
		ArbolGeneral<AreaEmpresa> f2 = new ArbolGeneral<AreaEmpresa>(f);
		AreaEmpresa g = new AreaEmpresa("g",9);
		ArbolGeneral<AreaEmpresa> g2 = new ArbolGeneral<AreaEmpresa>(g);
		AreaEmpresa h = new AreaEmpresa("h",12);
		ArbolGeneral<AreaEmpresa> h2 = new ArbolGeneral<AreaEmpresa>(h);
		AreaEmpresa i = new AreaEmpresa("i",19);
		ArbolGeneral<AreaEmpresa> i2 = new ArbolGeneral<AreaEmpresa>(i);
		
		j1.agregarHijo(a2);
		j1.agregarHijo(b2);
		j1.agregarHijo(c2);
		
		k1.agregarHijo(d2);
		k1.agregarHijo(e2);
		k1.agregarHijo(f2);
		
		l1.agregarHijo(g2);
		l1.agregarHijo(h2);
		l1.agregarHijo(i2);
		
		System.out.println(DevolverMaximoPromedio(l1));
	}

}
