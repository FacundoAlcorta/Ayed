package tp06.Ejemplo;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class CaminoPesado<T> {
	ListaGenerica<T> camino = new ListaEnlazadaGenerica<T>(); //camino minimo , es actualizado
	Integer peso = 0; //el peso del camino minimo
	
	public ListaGenerica<T> getCamino() {
		return camino;
	}
	public void setCamino(ListaGenerica<T> camino) {
		this.camino = camino;
	}
	public Integer getPeso() {
		return peso;
	}
	public void setPeso(Integer peso) {
		this.peso = peso;
	}
	@Override
	public String toString() {
		return "camino=" + camino + "\npeso=" + peso;
	}
	
}
