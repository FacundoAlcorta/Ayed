package ejercicioPractica;

import tp02.ejercicio2.ListaGenerica;
import tp04.abgen.ArbolGeneral;

public class mainparcial5 {
	public static void main(String[] args) {
		ArbolGeneral<Integer> arbol2 = new ArbolGeneral<>(2);
		ArbolGeneral<Integer> arbol1 = new ArbolGeneral<>(1);
		ArbolGeneral<Integer> arbol12 = new ArbolGeneral<>(12);
		ArbolGeneral<Integer> arbol14 = new ArbolGeneral<>(14);
		ArbolGeneral<Integer> arbol5 = new ArbolGeneral<>(5);
		ArbolGeneral<Integer> arbol4 = new ArbolGeneral<>(4);
		ArbolGeneral<Integer> arbol8 = new ArbolGeneral<>(8);
		ArbolGeneral<Integer> arbolm4 = new ArbolGeneral<>(4);
		ArbolGeneral<Integer> arbol7 = new ArbolGeneral<>(7);
		ArbolGeneral<Integer> arbol9 = new ArbolGeneral<>(9);
		ArbolGeneral<Integer> arbol10= new ArbolGeneral<>(10);
		ArbolGeneral<Integer> arbolm5 = new ArbolGeneral<>(5);
		ArbolGeneral<Integer> arbol3 = new ArbolGeneral<>(3);
		ArbolGeneral<Integer> arbol13 = new ArbolGeneral<>(13);
		
		arbol2.agregarHijo(arbol1);
		arbol2.agregarHijo(arbol12);
		arbol2.agregarHijo(arbol14);
		
		arbol1.agregarHijo(arbol5);		
		arbol1.agregarHijo(arbol4);
		
		arbol12.agregarHijo(arbol8);
		arbol12.agregarHijo(arbolm4);
		arbol12.agregarHijo(arbol7);
		
		arbol4.agregarHijo(arbol9);		
		arbol4.agregarHijo(arbol10);
		arbol4.agregarHijo(arbolm5);
		
		arbol8.agregarHijo(arbol3);
		arbol7.agregarHijo(arbol13);
		
		parcial5 p = new parcial5(arbol2);
		ListaGenerica<Integer> l;
		l=p.resolver();
		l.comenzar();
		while(!l.fin()) {
			System.out.print(l.proximo()+ ("-"));
		}
		
		
		
	}
}
