package es.florida.AEV2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Modelo {

	private String fichero;
	private String palabra;
	
	public Modelo(){ //esta clase tiene los datos
		fichero = "AE02_T1_2_Streams_Groucho.txt";
	}
	
	
	/*Métode: contenidoFichero
	 * Descripció: llig el contingut del fitxer i tornarlo per poder mostrarlo en la clase vista
	 * Paràmetres d'entrada: String fichero
	 * Paràmetres d'eixida: ArrayList<String> contingut del fitxer
	 * */
	public ArrayList<String> contenidoFichero(String fichero){
		ArrayList<String> contenidoFichero = new ArrayList<String>();
		File f = new File(fichero);
		
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			while(linea != null) {
				contenidoFichero.add(linea);
				linea = br.readLine();
			}
			br.close();
			fr.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		
		return contenidoFichero;
	}
	
	/*Métode: buscarPalabras
	 * Descripció: busca la paraula que tu li pases a un textFile per trobar coincidencies de la 
	 * mateixa i retorna cuantes paraules coincident n'hi han
	 * Paràmetres d'entrada: String fichero, String paraula
	 * Paràmetres d'eixida: int coincidenciasTotales (cantitat de paraules iguals)
	 * */
	public static int buscarPalabras (String fichero, String palabra) {
		File f = new File(fichero);
		int coincidenciasTotales = 0;
		
		try {
			if(f.exists()) {
				//Abre lectura del fichero
				BufferedReader leerFichero = new BufferedReader(new FileReader(fichero));
				
				String leoLinea;
				//lineas leidas
				
				while((leoLinea = leerFichero.readLine()) != null){
					String[] palabras = leoLinea.split(" ");
					
					for(int i=0; i < palabras.length; i++) {
						//pasar las palabras encontradas a minuscula
						palabras[i] = palabras[i].toLowerCase();
						palabra = palabra.toLowerCase();
						//comprobamos si las palabras son iguales
						if(palabras[i].equals(palabra)) {
							/*aumentamos las coincidencias*/
							 coincidenciasTotales = coincidenciasTotales + 1;
						}
					}
				}
				leerFichero.close();
				
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

		}
		
		return coincidenciasTotales;
		
	}
	
	
	/*Métode: reemplazarPalabras
	 * Descripció: busca la paraula en el text,que li pases per un textFile, per trobarla i la reemplaça per una que 
	 * tu li pases en un altre textFile. A més crea un fitxer nou en les paraules canviades y et mostra el nou text 
	 * en el área de baix de la interficie gràfica 
	 * Paràmetres d'entrada: String fichero, String palabra, String palabranueva
	 * Paràmetres d'eixida: String textoFichero (un string amb el nou text en els cambis)
	 * */
	public String reemplazarPalabra(String fichero, String palabra, String palabranueva) {
		File f1 = new File(fichero);
		File f2 = new File("fichero_reemplazado.txt");
		String textoFichero = "";

		try {
			if(f1.exists()) {
				//Abrir lectura fichero
				BufferedReader leerFichero = new BufferedReader(new FileReader(fichero));
				
				String leoLinea;
				
				while((leoLinea = leerFichero.readLine()) != null) {
					textoFichero += leoLinea+ "\n";
				}
				
				
				textoFichero = textoFichero.replaceAll(palabra, palabranueva);
				
				f2.createNewFile();
				BufferedWriter bw = new BufferedWriter(new FileWriter(f2));
//				for (int i = 0; i < leoLinea.length(); i++) {
////					bw.write(textoFichero);
//				}
				
				 FileOutputStream fileOut = new FileOutputStream("fichero_reemplazado.txt");
				 fileOut.write(textoFichero.getBytes());
				
			}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

		}
		
		return textoFichero;
	}
	
	
	/*Métode: fichero
	 * Descripció: retorna el fitxer en el text
	 * Paràmetres d'entrada: no
	 * Paràmetres d'eixida: String fichero
	 * */
	public String fichero() {
		return fichero;
	}
	

}
