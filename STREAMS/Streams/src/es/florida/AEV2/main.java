package es.florida.AEV2;

public class main {

	public static void main(String[] args) {
		
		Vista vista = new Vista();
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador(modelo, vista);
		
		
		
	}

}
