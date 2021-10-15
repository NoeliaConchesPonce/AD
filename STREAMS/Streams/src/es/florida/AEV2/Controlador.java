package es.florida.AEV2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import es.florida.AEV2.Modelo;
import es.florida.AEV2.Vista;

public class Controlador {

	private Modelo modelo;
	private Vista vista;
	private ActionListener actionListenerBuscar, actionListenerReemplazar;
	private String fichero;
	//cuando lo definimos el controlador estara escuchando hasta que se haga un push en el control
	
	Controlador(Modelo modelo, Vista vista){
		this.modelo = modelo;
		this.vista = vista;
		control();
		String texto = "";
		//bucle que recorre todas las lineas del fichero
		for(String linea : modelo.contenidoFichero(modelo.fichero())){
			//voy a escribir las lineas en el textfield
			texto += linea+"\n";
			
			}
		vista.getTextAreaOriginal().setText(texto); 

	}
	
	/*Métode: control
	 * Descripció: realitza les funcions de la interficie emprant els métodes de les
	 * clases modelo i vista
	 * Paràmetres d'entrada: no
	 * Paràmetres d'eixida: no
	 * */
	private void control() {
		
		String fichero = modelo.fichero();
		actionListenerBuscar = new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				buscarPalabras(fichero);
			}
		};
		
		vista.getBtnBuscar().addActionListener(actionListenerBuscar);
		
		actionListenerReemplazar = new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				String textoReemplazado = modelo.reemplazarPalabra(fichero, vista.getTextFieldBuscar().getText(), vista.getTextFieldReemplazar().getText());
				vista.getTextAreaModificado().setText(textoReemplazado);
			}
		};
		
		vista.getBtnReemplazar().addActionListener(actionListenerReemplazar);

	}
	
	
	/*Métode: buscarPalabras
	 * Descripció: llig el contingut del textFile de buscar i executa el botó buscar
	 * Paràmetres d'entrada: String fichero
	 * Paràmetres d'eixida: no
	 * */
	
	private void buscarPalabras(String fichero) {
		int coincidenciasTotales = modelo.buscarPalabras(fichero, vista.getTextFieldBuscar().getText());
		vista.mensajeBucarPalabra("coincidencias " + coincidenciasTotales);
	}
}
