package tp06.ejercicio5;

import tp02.ejercicio2.ListaGenerica;

public class caminoMinimo {
	ListaGenerica<String> caminominimo;
	int valorMinimo=Integer.MAX_VALUE;
	
	
	public void setValorMinimo(Integer a) {
		valorMinimo=a;
	}
	
	public int getValorMinimo() {
		return valorMinimo;
	}
	
	public ListaGenerica<String> getCaminoMinimo(){
		return caminominimo;
	}

	public void copiar(ListaGenerica<String> caminoAct) {
			//Vacio la lista
					int tamanio = caminominimo.tamanio();
					for (int i = 1; i <= tamanio; i++) {
						caminominimo.eliminarEn(i);
					}
					//Copio los elementos
					caminoAct.comenzar();
					while (!caminoAct.fin()) {
						caminominimo.agregarFinal(caminoAct.proximo());
					}

		}
		
	}
	
	
	

