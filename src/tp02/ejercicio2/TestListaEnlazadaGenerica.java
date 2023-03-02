package tp02.ejercicio2;

public class TestListaEnlazadaGenerica {
	public static void main(String[] args) {
		int x;
		ListaEnlazadaGenerica<Alumno> lista = new ListaEnlazadaGenerica<Alumno>();   
		for(x=0;x<4;x++) {
			lista.agregarFinal(new Alumno("234/3","facundo","alcorta",42881285,"facugmail.com"));
		}
		//Alumno a;
		while(!(lista.fin())) {
			//a=lista.proximo();
			//System.out.println("legajo: " + a.legajo);
			//System.out.println("nombre: " + a.nombre);
			//System.out.println("apellido: " + a.apellido);
			//System.out.println("dni: " + a.dni);
			//System.out.println("email: " + a.email);
			System.out.println(lista.toString());
			
		}
	}
}
