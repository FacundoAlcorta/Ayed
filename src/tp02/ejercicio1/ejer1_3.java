package tp02.ejercicio1;

import java.util.Scanner;

public class ejer1_3 {
	public static void imprimirRecursivo(ListaDeEnterosEnlazada n, int f) {
		if(!(n.fin())){
			System.out.println("------");
			n.proximo();
			f++;
			imprimirRecursivo(n,f);
		}else {
			return;
		}
		System.out.println(n.elemento(f));
	}
	
	public static void main(String[] args) {
		ListaDeEnterosEnlazada l = new ListaDeEnterosEnlazada();
		int x;
		Scanner scan = new Scanner(System.in);
		System.out.println("ingrese numero a guardar: ");
		x=scan.nextInt();
		while(x != 0){
			if(l.esVacia()) {
				l.agregarInicio(x);
			}
			else{
				l.agregarFinal(x);
			}
			System.out.println("ingrese numero a guardar: ");
			x=scan.nextInt();	
		}
		l.comenzar();
		while(!(l.fin())) {
			System.out.println("--------");
			System.out.println(l.proximo());
		}
		l.comenzar();
		int f=0;
		imprimirRecursivo(l,f);
	}
}
