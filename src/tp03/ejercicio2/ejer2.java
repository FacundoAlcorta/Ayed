package tp03.ejercicio2;

public class ejer2 {
	public static void main(String[] args) {
		ArbolBinario<Integer> arbol = new ArbolBinario<Integer>(6);
		ArbolBinario<Integer> hijoIzq = new ArbolBinario<Integer>(7);
		ArbolBinario<Integer> hijoDer = new ArbolBinario<Integer>(5);
		arbol.agregarHijoIzquierdo(hijoIzq);
		arbol.agregarHijoDerecho(hijoDer);
		ArbolBinario<Integer> hijodelhijoi = new ArbolBinario<Integer>(9);
		ArbolBinario<Integer> hijodelhijod = new ArbolBinario<Integer>(6);
		hijoIzq.agregarHijoDerecho(hijodelhijod);
		hijoIzq.agregarHijoIzquierdo(hijodelhijoi);
		
		System.out.println("la cantidad de hojas de del arbol es: " + arbol.contarHojas(arbol));
		System.out.println("-------------");
		arbol.recorridoPorNiveles();
		ArbolBinario<Integer> b= new ArbolBinario<Integer>(null);
		b=arbol.espejo(arbol);
		System.out.println("-------------");
		System.out.println("la cantidad de hojas de del arbol es: " + b.contarHojas(b));
		b.recorridoPorNiveles();
		
	}

}
