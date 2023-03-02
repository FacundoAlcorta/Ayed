package ejercicioPractica;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.abgen.*; 

public class AnalizadorArbol {

	/**
	 * El metodo nodosConHijosDeSumaMayorIgual verifica para un árbol, y sobre cada nodo ,
	 * cuantos nodos tienen hijos cuya suma de como resultado un valor mayor o igual
	 * al almacenado en el nodo padre. En el caso de los nodos hojas, no tienen hijos (0) y 
	 * por tanto el valor del nodo hoja siempre va a ser mayor.
	 * 
	 * @param arbol corresponde a un arbol general de valores numericos
	 * @return un valor numerico que corresponde a la cantidad de nodos cuyos hijos
	 *         suman mayor o igual que el padre
	 */
	public int nodosConHijosDeSumaMayorIgual(ArbolGeneral<Integer> arbol) {
		// escriba su solucion a partir de aqui
		 	   ArbolGeneral<Integer> arbAux;
		       int contador=0;
		       int suma=0;
		       if(arbol.esHoja() || arbol.esVacio()) {
		            return 0;
		        }
		       ListaGenerica<ArbolGeneral<Integer>> hijos = arbol.getHijos();
		       while(!hijos.fin()){
		            arbAux=hijos.proximo();
		            contador=contador+nodosConHijosDeSumaMayorIgual(arbAux);
		            suma=suma + arbAux.getDatoRaiz();
		       }
		       if(suma>=arbol.getDatoRaiz()){
		           contador++;
		       }
		  return contador;
		}
		// fin del código de su solución

	public static void main(String[] args) {
		// Casos de ejemplo para probar su implementación.
		// Se instancia el siguiente ejemplo:
		//
		// 		 8
		// 		/ \
		// 	  3    5
		// 	/ | \ 	\
		//  4 7 6 	1
		// 		 \
		// 		  2

		ArbolGeneral<Integer> arbol8 = new ArbolGeneral<>(8);
		ArbolGeneral<Integer> arbol3 = new ArbolGeneral<>(3);
		ArbolGeneral<Integer> arbol5 = new ArbolGeneral<>(5);
		ArbolGeneral<Integer> arbol4 = new ArbolGeneral<>(4);
		ArbolGeneral<Integer> arbol7 = new ArbolGeneral<>(7);
		ArbolGeneral<Integer> arbol6 = new ArbolGeneral<>(6);
		ArbolGeneral<Integer> arbol1 = new ArbolGeneral<>(1);
		ArbolGeneral<Integer> arbol2 = new ArbolGeneral<>(2);

		arbol8.agregarHijo(arbol3);
		arbol8.agregarHijo(arbol5);

		arbol3.agregarHijo(arbol4);
		arbol3.agregarHijo(arbol7);
		arbol3.agregarHijo(arbol6);

		arbol5.agregarHijo(arbol1);

		arbol6.agregarHijo(arbol2);

		AnalizadorArbol analizador = new AnalizadorArbol();

		System.out.println("La cantidad nodos cuyos hijos suman mayor o igual (deben ser 2): "
				+ analizador.nodosConHijosDeSumaMayorIgual(arbol8));
		System.out.println("La cantidad nodos cuyos hijos suman mayor o igual (deben ser 1): " + analizador.nodosConHijosDeSumaMayorIgual(arbol3));
		System.out.println("La cantidad nodos cuyos hijos suman mayor o igual (deben ser 0): " + analizador.nodosConHijosDeSumaMayorIgual(arbol6));
		System.out.println("La cantidad nodos cuyos hijos suman mayor o igual (deben ser 0): " + analizador.nodosConHijosDeSumaMayorIgual(arbol5));
		ListaEnlazadaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		ListaEnlazadaGenerica<Integer> l2 = new ListaEnlazadaGenerica<Integer>();
		
		l=arbol8.inOrden();
		l.comenzar();
		while(!l.fin()) {
			System.out.print(l.proximo() + "-");
		}		
		
		
		
		l=arbol8.PreOrden();
		l.comenzar();
		System.out.println();
		while(!l.fin()) {
			System.out.print(l.proximo() + "-");
		}	
		
		l2=arbol8.PostOrden();
		l2.comenzar();
		System.out.println();
		while(!l2.fin()) {
			System.out.print(l2.proximo() + "-");
		}
		System.out.println();
		
		
		
		System.out.println(arbol8.Ancho());
		System.out.println(arbol8.nivel(1));
		System.out.println(arbol8.altura());
		
		System.out.println(arbol8.esAncestro(4,8));
	}

}
