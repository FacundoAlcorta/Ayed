package tp02.ejercicio3;

import java.util.Scanner;
import tp02.ejercicio2.*;

public class TestBalanceo {
	
	public static boolean esBalanceado(String s) {
		ListaEnlazadaGenerica<Character> apertura= new ListaEnlazadaGenerica<Character>();
		apertura.agregarFinal('(');
		apertura.agregarFinal('[');
		apertura.agregarFinal('{');
		
		ListaEnlazadaGenerica<Character> cierre= new ListaEnlazadaGenerica<Character>();
		apertura.agregarFinal(')');
		apertura.agregarFinal(']');
		apertura.agregarFinal('}');
		
		PilaGenerica<Character> pila = new PilaGenerica<Character>();
		Character actual,elem;
		
		for(int i=0; i<s.length();i++) {
			actual= s.charAt(i);
			if(apertura.incluye(actual)) {
				pila.Apilar(actual);
			} else {
				elem=pila.Desapilar();
				if(apertura.posicion(elem) != cierre.posicion(actual)) {
					return false;
				}
			}
		}
		if(pila.esVacia()) {
			return false;
		}
		return true;
			
	}

	
	
	public static void main(String [] args) {
		Scanner consola = new Scanner(System.in);
		System.out.println("ingrese un string: ");
		String s= consola.nextLine();
		consola.close();
		
		System.out.println();
		if (esBalanceado(s))
			System.out.println("la expresion" + s + "esta balanceada");
		else System.out.println("la expresion" + s + "NO esta balanceada");
		
	}
}
