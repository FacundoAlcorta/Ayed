package ejercicioPractica;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.abgen.ArbolGeneral;

public class mainEjerParcial {
	public static void main(String[] args) {
		ArbolGeneral<Integer> arbolm3 = new ArbolGeneral<>(3);
		ArbolGeneral<Integer> arbolm7 = new ArbolGeneral<>(7);
		ArbolGeneral<Integer> arbol5 = new ArbolGeneral<>(5);
		ArbolGeneral<Integer> arbol1 = new ArbolGeneral<>(1);
		ArbolGeneral<Integer> arbol2 = new ArbolGeneral<>(2);
		ArbolGeneral<Integer> arbol6 = new ArbolGeneral<>(6);
		ArbolGeneral<Integer> arbolm9 = new ArbolGeneral<>(9);
		ArbolGeneral<Integer> arbol3 = new ArbolGeneral<>(3);
		ArbolGeneral<Integer> arbol11 = new ArbolGeneral<>(11);
		ArbolGeneral<Integer> arbol4 = new ArbolGeneral<>(4);
		ArbolGeneral<Integer> arbol10 = new ArbolGeneral<>(null);
		
		arbolm3.agregarHijo(arbolm7);
		arbolm3.agregarHijo(arbol5);
		arbolm3.agregarHijo(arbol1);
		
		arbol1.agregarHijo(arbol3);
		
		arbol5.agregarHijo(arbolm9);
		
		arbolm7.agregarHijo(arbol2);
		arbolm7.agregarHijo(arbol6);
		
		arbolm9.agregarHijo(arbol4);
		arbol6.agregarHijo(arbol11);
		//arbol6.agregarHijo(arbol10);
		
		
		//parcial 1
		//parcial calcular = new parcial();
		//System.out.println();
		//System.out.println("el resultado es: " + calcular.resolver(arbolm3));
		
		parcial2 calcular2 = new parcial2();
		ListaGenerica<Integer> resultado = new ListaEnlazadaGenerica<Integer>();
		System.out.println("el resultado devuelve una lista donde el primer nodo es el elemento y el segundo el nivel"
				+ "si devuelve null es arbol esta vacio");
		resultado=calcular2.resolver(arbolm3);
		if(resultado == null){
			System.out.println("el arbol no posee elemento pares o la raiz es null");
		}else {
			System.out.println("el elemento es: " + resultado.elemento(1));
			System.out.println("el nivel del elemento es: " + resultado.elemento(2));
		}
		
		
		
		
	}

}
