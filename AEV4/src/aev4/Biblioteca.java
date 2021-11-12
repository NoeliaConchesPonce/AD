package aev4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Biblioteca {
	/*Métode: main
	 * Descripcio:crida als métodes per inicialitzarlos
	 * PArametres d'entrada:String[] args
	 * Parametres d'eixida:no
	 * */
	public static void main(String[] args) {
		String fichero = "Biblioteca.csv";
		
		//transferirDades(contenidoFichero(fichero));
		consultaLlibres();
		consultaEditorials();
		
	}

	/*
	 * Métode: contenidoFichero 
	 * Descripció: llig el contingut del fitxer i tornarlo per poder mostrarlo en la clase vista 
	 * Paràmetres d'entrada: String fichero
	 * Paràmetres d'eixida: ArrayList<String> contingut del fitxer
	 */
	public static ArrayList<String> contenidoFichero(String fichero) {
		ArrayList<String> contenidoFichero = new ArrayList<String>();
		File f = new File(fichero);

		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			while (linea != null) {
				contenidoFichero.add(linea);
				linea = br.readLine();
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}

		return contenidoFichero;
	}
	/*Métode:trasferirDades
	 * Descripcio:llig les dades del fitxer y les transfereix a la base de dades
	 * Paràmetres d'entrada:ArrayList<String> fichero
	 * paràmetres d'eixida:no
	 * */
	public static void transferirDades(ArrayList<String> fichero) {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");

			PreparedStatement psInsertar = con.prepareStatement(
					"INSERT INTO Llibres (Id,Titol,Autor,Any_de_naixement,Any_de_publicacio,Editorial,NombrePags) VALUES (null,?,?,?,?,?,?)");

			for (int i = 1; i < fichero.size(); i++) {
				// me creo un string que lea cada linea del array y las separo por cada ; es un valor de columna 
				String[] valores = fichero.get(i).split(";");
				//compruebo que los datos del string no sean nulos
				for(int j = 0; j< valores.length; j++ ) {
					//si son nulos 
					if(valores [j].equals("")) {
						System.out.println("entro");
						if (j == 0 || j == 1 || j == 4) {
							//en caso de ser string les pongo N.C
							valores[j] = "N.C";
						}else {
							//en caso de ser int les pongo un 0
							valores[j] = "0";
						}
						
					}
				}
				// inserto los datos del csv en la base de datos
				psInsertar.setString(1, valores[0]);
				psInsertar.setString(2, valores[1]);
				psInsertar.setInt(3, Integer.parseInt(valores[2]));
				psInsertar.setInt(4, Integer.parseInt(valores[3]));
				psInsertar.setString(5, valores[4]);
				psInsertar.setInt(6, Integer.parseInt(valores[5]));
				
				int resultadoInsertar = psInsertar.executeUpdate();
			}



		} catch (Exception e) {
			System.out.println(e);

		}
	}
	
	/*Métode:consultaLlibres
	 * Descripció:crea una consulta sql a la base de dades i la mostra per consola
	 * Paràmetres d'entrada: no
	 * Paràmetres d'eixida: no
	 * */
	public static void consultaLlibres () {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
			
			Statement stmt= con.createStatement();
			ResultSet rs= stmt.executeQuery("SELECT Titol, Autor, Any_de_publicacio FROM llibres WHERE Any_de_naixement < 1950 AND Any_de_naixement > 0");
			System.out.println("Els llibres publicats abans del 1950 son: ");
			while(rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
				}
				rs.close();
				stmt.close();
				con.close();



		} catch (Exception e) {
			System.out.println(e);

		}
	}
	
	/*Métode:consultaEditorials
	 * Descripció:crea una consulta sql a la base de dades i la mostra per consola
	 * Paràmetres d'entrada:no
	 * Paràmetres d'eixida:no
	 * */
	public static void consultaEditorials () {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
			
			Statement stmt= con.createStatement();
			ResultSet rs= stmt.executeQuery("SELECT Editorial FROM llibres WHERE Any_de_publicacio > 1999");
			System.out.println("Els llibres publicats després de l'any 1999 son: ");
			while(rs.next()) {
				System.out.println(rs.getString(1));
				}
				rs.close();
				stmt.close();
				con.close();



		} catch (Exception e) {
			System.out.println(e);

		}
	}
}
