package tp02.ejercicio1;

public class ejer1_6 {
	
	public ListaDeEnterosEnlazada calcularSucesion (int x ) {
		ListaDeEnterosEnlazada l=new ListaDeEnterosEnlazada();
		l.comenzar();
		sucesionEntero(l,x);
		return l;		
	}
	public ListaDeEnterosEnlazada sucesionEntero(ListaDeEnterosEnlazada l, int x){
		l.agregarFinal(x);
		if(x != 1) {
			if(x % 2 == 0 ) {
				x= x / 2;
			}else {
				x= (x * 3) + 1;
			}
			sucesionEntero(l,x);
		}
		return l;
		}
	
	public static void main(String[] args) {
		int x=6;
		ejer1_6 n = new ejer1_6();
		ListaDeEnterosEnlazada l = n.calcularSucesion(x);
		l.comenzar();
		while(!(l.fin())) {
			System.out.println("--------");
			System.out.println(l.proximo());
		}
	}

}