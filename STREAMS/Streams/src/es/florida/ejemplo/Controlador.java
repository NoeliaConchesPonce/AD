package es.florida.ejemplo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador { /*tiene que saber que metodos hay en vista y modelo*/
	private Modelo modelo;
	private Vista vista;
	private ActionListener actionListenerBtn1, actionListenerBtn2; 
	//cuando lo definimos el controlador estara escuchando hasta que se haga un push en el control
	
	Controlador(Modelo modelo, Vista vista){
		this.modelo = modelo;
		this.vista = vista;
		control();
	}
	
	private void control() {
		actionListenerBtn1 = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) { 
				//cuando se haga click en el boton hará las acciones de abajo
				//se conectara ha modelo y ejecutará lo que haya en modelo
				String mensaje1 = modelo.getMensaje1();
				//muestra el mensaje de modelo 
				vista.mostrarMensaje(mensaje1);
				//le pasamos el mensaje a vista para poder ver el mensaje
				
			}
		};
		//asociamos el metodo a getboton 1 de vista para que lo muestre
		//para que este asociada a la accion de vista
		vista.getBtn1().addActionListener(actionListenerBtn1);
		
		actionListenerBtn2 = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) { 
				//cuando se haga click en el boton hará las acciones de abajo
				//se conectara ha modelo y ejecutará lo que haya en modelo
				String mensaje2 = modelo.getMensaje2();
				//muestra el mensaje de modelo 
				vista.mostrarMensaje(mensaje2);
				//le pasamos el mensaje a vista para poder ver el mensaje
				
			}
		};
		//asociamos el metodo a getboton 1 de vista para que lo muestre
		//para que este asociada a la accion de vista
		vista.getBtn2().addActionListener(actionListenerBtn2);
	}
	}
	


