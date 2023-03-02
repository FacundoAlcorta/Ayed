package tp04.ejercicio5;

public class AreaEmpresa {
	private String identificacion;
	private Integer retardo;
	
	public AreaEmpresa(String i, Integer ret) {
		identificacion=i;
		retardo=ret;
	}
	
	public Integer getRetardo() {
		return retardo;
	}
	public String getIdentificacion() {
		return identificacion;
	}
}

