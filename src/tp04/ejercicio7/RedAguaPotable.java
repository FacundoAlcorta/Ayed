package tp04.ejercicio7;

import tp02.ejercicio2.ListaGenerica;
import tp04.abgen.ArbolGeneral;

public class RedAguaPotable {
	private ArbolGeneral<Integer> maestro;
	private Double caud;
	
	public RedAguaPotable(ArbolGeneral<Integer> a, double caa) {
		maestro=a;
		this.caud=caa;
	}
	
	private double getCaudalenca�omaestro() {
		return caud;
	}
	
	
	private double ca�erias(double caudal,ArbolGeneral<Integer> arb) {
		double cau=caudal;
		double caudalm=caudal;
		ListaGenerica<ArbolGeneral<Integer>> hijos=arb.getHijos();
		hijos.comenzar();
		if (arb.esHoja()) {
			return caudal;
		}
		while(!hijos.fin()){
			cau=ca�erias(caudal/hijos.tamanio(),hijos.proximo());//busco el minimo y lo retorno
			if(cau<caudalm) { //actualizo si el resultado de la recursion fue menor al minimo actual
				caudalm=cau;
			}
		}
		return caudalm;
		}
		public double minimoCaudal() {
		return ca�erias(this.getCaudalenca�omaestro(),this.maestro);
		}

}
