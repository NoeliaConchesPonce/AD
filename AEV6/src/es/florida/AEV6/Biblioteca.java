package es.florida.AEV6;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONObject;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import java.util.Scanner;

public class Biblioteca {
	static MongoCollection<Document> coleccion;
	/*
	 * Metode: mostrarllibres
	 * Descripcio: retorna un string de llibres en els elements de la base de dades
	 * Parametre d'entrada: no
	 * Parametre d'eixida: no
	 * */
	private static void mostrarLlibres() {
		MongoCursor<Document> cursor = coleccion.find().iterator();
		while (cursor.hasNext()) {
			JSONObject obj = new JSONObject(cursor.next().toJson());
			System.out.println("Id: " + obj.getString("Id") + " Titol: " + obj.getString("Titol"));
		}
	}
	/*
	 * Metode: mostrarLlibre
	 * Descripcio: mostra la informacio d'un llibre a través de la seus id
	 * Parametre d'entrada: string id
	 * Parametre d'eixida: no
	 * 
	 * */
	public static void mostrarLlibre(String id) {
		Bson query = eq("Id", id);

		MongoCursor<Document> cursor = coleccion.find(query).iterator();
		while (cursor.hasNext()) {
			JSONObject obj = new JSONObject(cursor.next().toJson());
			System.out.println("Id: " + obj.getString("Id"));
			System.out.println("Titol: " + obj.getString("Titol"));
			System.out.println("Autor: " + obj.getString("Autor"));
			System.out.println("Any de naixement: " + obj.getString("Any_naixement"));
			System.out.println("Any de publicacio: " + obj.getString("Any_publicacio"));
			System.out.println("Editorial: " + obj.getString("Editorial"));
			System.out.println("Nombre de pagines: " + obj.getString("Nombre_pagines"));

		}

	}
	/*
	 * Metode: crear
	 * Descripcio: crea un nou llibre amb les dades introduides pel client en la id que fique l'usuari
	 * Parametre d'entrada: no
	 * Parametre d'eixida: no
	 * 
	 * */
	public static void crear() {
		Scanner sc1 = new Scanner(System.in);
		System.out.print("Id: ");
		String id = sc1.nextLine();
		System.out.print("Titol: ");
		String titulo = sc1.nextLine();
		System.out.print("Autor: ");
		String autor = sc1.nextLine();
		System.out.print("Any de naixement: ");
		String any_nac = sc1.nextLine();
		System.out.print("Any de publicacio: ");
		String any_pub = sc1.nextLine();
		System.out.print("Editorial: ");
		String editorial = sc1.nextLine();
		System.out.print("Nombre de pagines: ");
		String n_pag = sc1.nextLine();
		Document doc = new Document();
		doc.append("Id", id);
		doc.append("Titol", titulo);
		doc.append("Autor", autor);
		doc.append("Any_naixement", any_nac);
		doc.append("Any_publicacio", any_pub);
		doc.append("Editorial", editorial);
		doc.append("Nombre_pagines", n_pag);
		coleccion.insertOne(doc);
	}
	/*
	 * Metode: actualitzarLlibre
	 * Descripcio: : actualitza (modifica) la informaci� d�un  llibre a partir de la seua id
	 * Parametre d'entrada: String id
	 * Parametre d'eixida: no
	 * 
	 * */
	public static void ActualitzarLlibre(String id) {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Introdueix els nous camps a actualiztzar un llibre");
		Bson query = eq("Id", id);
		System.out.print("Titol: ");
		String nuevoCampo = sc1.nextLine();
		if (!nuevoCampo.equals(""))
			coleccion.updateOne(query, new Document("$set", new Document("Titol", nuevoCampo)));
		System.out.print("Autor: ");
		nuevoCampo = sc1.nextLine();
		if (!nuevoCampo.equals(""))
			coleccion.updateOne(query, new Document("$set", new Document("Autor", nuevoCampo)));
		System.out.print("Any de naixement: ");
		nuevoCampo = sc1.nextLine();
		if (!nuevoCampo.equals(""))
			coleccion.updateOne(query, new Document("$set", new Document("Any_naixement", nuevoCampo)));
		System.out.print("Any de publicacio: ");
		nuevoCampo = sc1.nextLine();
		if (!nuevoCampo.equals(""))
			coleccion.updateOne(query, new Document("$set", new Document("Any_publicacio", nuevoCampo)));
		System.out.print("Editorial: ");
		nuevoCampo = sc1.nextLine();
		if (!nuevoCampo.equals(""))
			coleccion.updateOne(query, new Document("$set", new Document("Editorial", nuevoCampo)));
		System.out.print("Nombre de pagines: ");
		nuevoCampo = sc1.nextLine();
		if (!nuevoCampo.equals(""))
			coleccion.updateOne(query, new Document("$set", new Document("Nombre_pagines", nuevoCampo)));

	}
	/*
	 * Metode: borrarLlibre
	 * Descripcio: : borra un  llibre a partir de la seua id
	 * Parametre d'entrada: String id
	 * Parametre d'eixida: no
	 * 
	 * */
	
	public static void borrarLlibre(String id) {
		coleccion.deleteOne(eq("Id", id));
	}
	/*
	 * Metode: main
	 * Descripcio:desplega un menu per seleccionar quin metode utilitzar
	 * Parametre d'entrada: no
	 * Parametre d'eixida:no
	 * */
	public static void main(String[] args) throws InterruptedException {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("Biblioteca");
		coleccion= database.getCollection("Biblioteca");
// CRUD operations

		do {
			System.out.println("Opcions: " + "\n1. Mostrar els titols dels llibres"
					+ "\n2. Mostrar informacio d'un llibre" + "\n3. Crear un nou llibre" + "\n4. Actualitzar un  llibre"
					+ "\n5. Borrar un llibre" + "\n6. Tancar la biblioteca");

			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			String resposta = sc.nextLine();
			String id;
			switch (resposta) {
			case "1": {
				mostrarLlibres();
				break;
			}
			case "2": {
				System.out.println("Introdueix la id del llibre: ");
				id = sc.nextLine();
				mostrarLlibre(id);
				break;
			}
			case "3": {
				crear();
				break;
			}
			case "4": {
				System.out.println("Introdueix l'identificador del llibre a actualitzar");
				id = sc.nextLine();
				ActualitzarLlibre(id);
				break;
			}
			case "5": {
				System.out.println("Introdueix l'identificador del llibre per eliminar-ho: ");
				id = sc.nextLine();
				borrarLlibre(id);
				break;
			}
			case "6": {
				System.out.println("Adios");
				sc.close();
				mongoClient.close();
			}
			default: {
			}
				System.out.println("Has de triar una opcio de 1 a 6");
				break;
			}
			System.out.println("<Pressiona ENTER per a continuar>");

			sc.nextLine();

		} while (true);

	}

}
