package ejercicioPractica;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.abgen.ArbolGeneral;

public class mainparcial4 {
	public static void main(String[] args) {
		ArbolGeneral<Integer> arbol7 = new ArbolGeneral<>(7);
		ArbolGeneral<Integer> arbol2 = new ArbolGeneral<>(2);
		ArbolGeneral<Integer> arbol75 = new ArbolGeneral<>(75);
		ArbolGeneral<Integer> arbol5 = new ArbolGeneral<>(5);
		ArbolGeneral<Integer> arbol8 = new ArbolGeneral<>(8);
		ArbolGeneral<Integer> arbol43 = new ArbolGeneral<>(43);
		ArbolGeneral<Integer> arbol12 = new ArbolGeneral<>(12);
		ArbolGeneral<Integer> arbol11 = new ArbolGeneral<>(11);
		ArbolGeneral<Integer> arbol3 = new ArbolGeneral<>(3);
		ArbolGeneral<Integer> arbol30 = new ArbolGeneral<>(30);
		ArbolGeneral<Integer> arbol23 = new ArbolGeneral<>(23);
		ArbolGeneral<Integer> arbol9 = new ArbolGeneral<>(9);
		ArbolGeneral<Integer> arbol54 = new ArbolGeneral<>(54);
		ArbolGeneral<Integer> arbol18 = new ArbolGeneral<>(18);
		
		arbol7.agregarHijo(arbol2);
		arbol7.agregarHijo(arbol75);
		
		arbol75.agregarHijo(arbol5);		
		arbol75.agregarHijo(arbol43);
		
		arbol43.agregarHijo(arbol12);
		arbol43.agregarHijo(arbol11);
		
		arbol2.agregarHijo(arbol8);
		
		arbol8.agregarHijo(arbol3);
		arbol8.agregarHijo(arbol30);
		arbol8.agregarHijo(arbol23);
		arbol8.agregarHijo(arbol9);

		
		arbol30.agregarHijo(arbol54);
		arbol30.agregarHijo(arbol18);
		
		parcial4 p = new parcial4();
		ListaGenerica<ArbolGeneral<Integer>> l =new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
		l=p.resolver(arbol7);
		l.comenzar();
		while(!l.fin()) {
			System.out.print(l.proximo().getDatoRaiz()+ "-");
			}
		}

}
