package tp04.ejercicio7;

import tp04.abgen.ArbolGeneral;

public class mainEjer7 {
	public static void main(String[] args) {
		ArbolGeneral<Integer> a1 = new ArbolGeneral<Integer>(0);
		ArbolGeneral<Integer> b1 = new ArbolGeneral<Integer>(0);
		ArbolGeneral<Integer> b2 = new ArbolGeneral<Integer>(0);
		ArbolGeneral<Integer> b3 = new ArbolGeneral<Integer>(0);
		ArbolGeneral<Integer> b4 = new ArbolGeneral<Integer>(0);
		
		a1.agregarHijo(b1);
		a1.agregarHijo(b2);
		a1.agregarHijo(b3);
		a1.agregarHijo(b4);
		
		ArbolGeneral<Integer> c1 = new ArbolGeneral<Integer>(0);
		ArbolGeneral<Integer> c2 = new ArbolGeneral<Integer>(0);
		ArbolGeneral<Integer> c3 = new ArbolGeneral<Integer>(0);
		ArbolGeneral<Integer> c4 = new ArbolGeneral<Integer>(0);
		ArbolGeneral<Integer> c5 = new ArbolGeneral<Integer>(0);
		ArbolGeneral<Integer> c6 = new ArbolGeneral<Integer>(0);
		
		
		b2.agregarHijo(c1);
		b2.agregarHijo(c2);
		b2.agregarHijo(c3);
		b2.agregarHijo(c4);
		c4.agregarHijo(c5);
		c5.agregarHijo(c6);
		
	    double caudal=1000;
		RedAguaPotable red = new RedAguaPotable(a1,caudal);
		System.out.println("el minimo caudal es: " + red.minimoCaudal());
		System.out.println(a1.altura());
		
		
		
		
		
	}

}
