package tp02.ejercicio1;

import java.util.Scanner;

public class ejer1_2 {
	
	
	public static void imprimir(ListaDeEnteros l, int f) {
		if(!(l.fin())){
			System.out.println("------");
			l.proximo();
			f++;
			imprimir(l,f);
		}else {
			return;
		}
		System.out.println(l.elemento(f));
	}
	
	public static void main(String[] args) {
		ListaDeEnteros l = new ListaDeEnterosConArreglos();
		int x;
		int e;
		Scanner scan = new Scanner(System.in);
		for (x=1;x<3;x++) {
			System.out.println("ingrese numero a guardar: ");
			e=scan.nextInt();
			l.agregarEn(e, x);
		}
		scan.close();
		for (x=1;x<3;x++) {
			System.out.println(l.elemento(x));
		}
		int f=1;
		imprimir(l,f);
	}

}
