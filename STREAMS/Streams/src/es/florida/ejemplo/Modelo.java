package es.florida.ejemplo;

public class Modelo {

	private String mensaje1;
	private String mensaje2;
	
	Modelo(){ //esta clase tiene los datos
		this.mensaje1 = "Este es el mensaje 1";
		this.mensaje2 = "Este es el mensaje 2";
	}
	
	public String getMensaje1() {
		return mensaje1;
	}
	
	public String getMensaje2() {
		return mensaje2;
	}

}
