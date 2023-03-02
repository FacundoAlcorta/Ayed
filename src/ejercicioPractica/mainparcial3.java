package ejercicioPractica;

import tp04.abgen.ArbolGeneral;

public class mainparcial3 {
	public static void main(String[] args) {
		ArbolGeneral<Integer> arbol2 = new ArbolGeneral<>(2);
		ArbolGeneral<Integer> arbol7 = new ArbolGeneral<>(7);
		ArbolGeneral<Integer> arbol5 = new ArbolGeneral<>(5);
		ArbolGeneral<Integer> arbol8 = new ArbolGeneral<>(8);
		ArbolGeneral<Integer> arbol23 = new ArbolGeneral<>(23);
		ArbolGeneral<Integer> arbol6 = new ArbolGeneral<>(6);
		ArbolGeneral<Integer> arbol19 = new ArbolGeneral<>(19);
		ArbolGeneral<Integer> arbol3 = new ArbolGeneral<>(3);
		ArbolGeneral<Integer> arbol20 = new ArbolGeneral<>(20);
		ArbolGeneral<Integer> arbol55 = new ArbolGeneral<>(55);
		ArbolGeneral<Integer> arbol11 = new ArbolGeneral<>(11);
		ArbolGeneral<Integer> arbol4 = new ArbolGeneral<>(4);
		
		arbol2.agregarHijo(arbol7);
		arbol2.agregarHijo(arbol5);
		arbol2.agregarHijo(arbol8);
		
		arbol7.agregarHijo(arbol23);		
		arbol7.agregarHijo(arbol6);
		
		arbol5.agregarHijo(arbol19);
		arbol5.agregarHijo(arbol3);
		arbol5.agregarHijo(arbol20);
		
		arbol19.agregarHijo(arbol4);
		
		arbol6.agregarHijo(arbol55);
		arbol6.agregarHijo(arbol11);
		
		parcial3 resultado = new parcial3(arbol2);
		System.out.println("el resultado es: " + resultado.resolver(3).getDatoRaiz());
		}
}

