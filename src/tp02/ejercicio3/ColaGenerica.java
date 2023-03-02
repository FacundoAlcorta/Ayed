package tp02.ejercicio3;
import tp02.ejercicio2.*;

public class ColaGenerica<T> {
	private ListaEnlazadaGenerica<T> dato = new ListaEnlazadaGenerica<T>();
	
	public void encolar(T elem) {
		this.dato.agregarFinal(elem);
	}
	
	public T desencolar() {
		T temp= this.dato.elemento(1);
		this.dato.eliminarEn(1);
		return temp;
	}
	
	public T tope() {
		return this.dato.elemento(this.dato.tamanio());
	}
	
	public boolean esVacia() {
		return this.dato.esVacia();
	}

}
