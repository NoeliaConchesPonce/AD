package es.florida.AEV3;

import java.util.ArrayList;
import java.util.Scanner;
import org.w3c.dom.*;

import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.*;

public class Biblioteca {
	
	/*
	 * Métode: main
	 * Descripció:desplega un menu per seleccionar quin metode utilitzar
	 * Paràmetre d'entrada: no
	 * Paràmetre d'eixida:no
	 * */

	public static void main(String args[]) throws IOException {

		do {
			System.out.println("Opcions: " + "\n1. Mostrar els títols dels llibres"
					+ "\n2. Mostrar informació d'un llibre" + "\n3. Crear un nou llibre" + "\n4. Actualitzar un  llibre"
					+ "\n5. Borrar un llibre" + "\n6. Tancar la biblioteca");

			Scanner sc = new Scanner(System.in);
			String resposta = sc.nextLine();
			switch (resposta) {
			case "1": {
				ArrayList<Llibre> llibre = llegirLlibres();
				for (int i = 0; i < llibre.size(); i++) {
					System.out.println(llibre.get(i).getIdentificador() + " " + llibre.get(i).getTitol());
				}
				break;
			}
			case "2": {
				System.out.println("Introdueix la id del llibre: ");
				mostrarLlibre(recuperarLlibre(Integer.parseInt(sc.nextLine())));

				break;
			}
			case "3": {
				System.out.println("Introdueix el titol del nou llibre: ");
				String nouTitol = sc.nextLine();
				System.out.println("Introdueix l'autor del nou llibre: ");
				String nouAutor = sc.nextLine();
				System.out.println("Introdueix l'any de publicacio del nou llibre: ");
				int nouAnyPublicacio = Integer.parseInt(sc.nextLine());
				System.out.println("Introdueix l'editorial del nou llibre: ");
				String novaEditorial = sc.nextLine();
				System.out.println("Introdueix el nombre de pagines del nou llibre: ");
				int nouNombrePagines = Integer.parseInt(sc.nextLine());

				Llibre noullibre = new Llibre(0, nouTitol, nouAutor, nouAnyPublicacio, novaEditorial, nouNombrePagines);
				crearLlibre(noullibre);

				break;
			}
			case "4": {
				System.out.println("Introdueix l'identificador del llibre a actualitzar");
				actualitzarLlibre(Integer.parseInt(sc.nextLine()));

				break;
			}
			case "5": {
				System.out.println("Introdueix l'identificador del llibre per eliminar-ho: ");
				borrarLlibre(Integer.parseInt(sc.nextLine()));

				break;
			}
			case "6": {

				System.exit(0);
			}
			default: {
			}
				System.out.println("Has de triar una opció de 1 a 6");
				break;
			}
			System.out.println("<Pressiona ENTER per a continuar>");

			sc.nextLine();

		} while (true);
	}

	/*
	 * Métode: llegirLlibres
	 * Descripció: retorna un string de llibres en el elements del document xml
	 * Paràmetre d'entrada: no
	 * Paràmetre d'eixida: llibres
	 * */
	public static ArrayList<Llibre> llegirLlibres() {
		/* lista que almacena los libros del xml */
		ArrayList<Llibre> llibres = new ArrayList<Llibre>();
		Llibre llibre = null;

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(new File("Llibres.xml"));
			Element raiz = document.getDocumentElement();
			System.out.println("Contenido XML " + raiz.getNodeName() + ":");
			NodeList nodeList = document.getElementsByTagName("llibre");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				System.out.println("");
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					int id = Integer.parseInt(eElement.getAttribute("id"));
					String titol = eElement.getElementsByTagName("titol").item(0).getTextContent();
					String autor = eElement.getElementsByTagName("autor").item(0).getTextContent();
					int anyPublicacio = Integer
							.parseInt(eElement.getElementsByTagName("any_de_publicacio").item(0).getTextContent());
					String editorial = eElement.getElementsByTagName("editorial").item(0).getTextContent();
					int nombrePagines = Integer
							.parseInt(eElement.getElementsByTagName("nombre_de_pagines").item(0).getTextContent());

					llibre = new Llibre(id, titol, autor, anyPublicacio, editorial, nombrePagines);
					llibres.add(llibre);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return llibres;
	}

	/*
	 * Métode: mostrarLlibre
	 * Descripció: mostra els elements del xml de llibres
	 * Paràmetre d'entrada: objecte llibre
	 * Paràmetre d'eixida: no
	 * 
	 * */
	
	public static void mostrarLlibre(Llibre llibre) {
		System.out.println(llibre.getIdentificador());
		System.out.println(llibre.getTitol());
		System.out.println(llibre.getAutor());
		System.out.println(llibre.getAnyPublicacio());
		System.out.println(llibre.getEditorial());
		System.out.println(llibre.getNombrePagines());

	}
	
	/*
	 * Métode: crearLlibre
	 * Descripció: extrau els llibres de l'array i els escriu en el xml, escribint-ho darrere de l'ultima id
	 * Paràmetre d'entrada: objecte llibre
	 * Paràmetre d'eixida: ultimaID
	 * 
	 * */

	public static int crearLlibre(Llibre llibre) {
		String id = "";
		int ultimaID = 1;
		try {
			ArrayList<Llibre> llibres = llegirLlibres();
			llibres.add(llibre);
			DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder build = dFact.newDocumentBuilder();
			Document doc = build.newDocument();
			Element raiz = doc.createElement("llibres");
			doc.appendChild(raiz);
			
			

			for (Llibre lli : llibres) {

				Element llibre1 = doc.createElement("llibre");

				llibre1.setAttribute("id", Integer.toString(ultimaID));
				raiz.appendChild(llibre1);
				Element titol = doc.createElement("titol");
				titol.appendChild(doc.createTextNode(String.valueOf(lli.getTitol())));
				llibre1.appendChild(titol);
				Element autor = doc.createElement("autor");
				autor.appendChild(doc.createTextNode(String.valueOf(lli.getAutor())));
				llibre1.appendChild(autor);
				Element anyo = doc.createElement("any_de_publicacio");
				anyo.appendChild(doc.createTextNode(String.valueOf(lli.getAnyPublicacio())));
				llibre1.appendChild(anyo);
				Element editorial = doc.createElement("editorial");
				editorial.appendChild(doc.createTextNode(String.valueOf(lli.getEditorial())));
				llibre1.appendChild(editorial);
				Element nombrepags = doc.createElement("nombre_de_pagines");
				nombrepags.appendChild(doc.createTextNode(String.valueOf(lli.getNombrePagines())));
				llibre1.appendChild(nombrepags);
				
				//actua como contador
				ultimaID++;

			}
			TransformerFactory tranFactory = TransformerFactory.newInstance(); // Crear serializador
			Transformer aTransformer = tranFactory.newTransformer();
			aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1"); // Darle formato al documento
			aTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			try {

				FileWriter fw = new FileWriter("Llibres.xml");// Definir el nombre del fichero y guardar
				StreamResult result = new StreamResult(fw);
				aTransformer.transform(source, result);
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (TransformerException ex) {
			System.out.println("Error escribiendo el documento");
		} catch (ParserConfigurationException ex) {
			System.out.println("Error construyendo el documento");
		}

		return ultimaID;
	}

	/*
	 * Métode: recuperarLlibre
	 * Descripció: : torna un objecte llibre a partir d’un identificador
	 * Paràmetre d'entrada: id
	 * Paràmetre d'eixida: recuperarLlibre.get(i)
	 * 
	 * */
	
	public static Llibre recuperarLlibre(int id) {

		ArrayList<Llibre> recuperarLlibre = llegirLlibres();
		for (int i = 0; i < recuperarLlibre.size(); i++) {
			if (id == recuperarLlibre.get(i).getIdentificador()) {
				return recuperarLlibre.get(i);
			}
		}
		return null;

	}

	/*
	 * Métode: actualitzarLlibre
	 * Descripció: : actualitza (modifica) la informació d’un objecte llibre a partir d’un identificador
	 * Paràmetre d'entrada: id
	 * Paràmetre d'eixida: no
	 * 
	 * */
	
	public static void actualitzarLlibre(int id) {
		ArrayList<Llibre> llibres = llegirLlibres();
		Llibre llibreActualitzar = llibres.get(id -1);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Actualitza el titol: ");
		String nouTitol = sc.nextLine();
		System.out.println("Actualitza l'autor: ");
		String nouAutor = sc.nextLine();
		System.out.println("Actualitza l'any de publicacio: ");
		String nouAny = sc.nextLine();
		System.out.println("Actualitza la editorial: ");
		String novaEditorial = sc.nextLine();
		System.out.println("Actualitza el nombre de pagines: ");
		String nouNombrePags = sc.nextLine();
		
		llibreActualitzar.setTitol(nouTitol);
		llibreActualitzar.setAutor(nouAutor);
		llibreActualitzar.setAnyPublicacio(Integer.parseInt(nouAny));
		llibreActualitzar.setEditorial(novaEditorial);
		llibreActualitzar.setNombrePagines(Integer.parseInt(nouNombrePags));
		
		int ultimaID = 1;
		try {
			DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder build = dFact.newDocumentBuilder();
			Document doc = build.newDocument();
			Element raiz = doc.createElement("llibres");
			doc.appendChild(raiz);
			
			

			for (Llibre lli : llibres) {

				Element llibre1 = doc.createElement("llibre");

				llibre1.setAttribute("id", Integer.toString(ultimaID));
				raiz.appendChild(llibre1);
				Element titol = doc.createElement("titol");
				titol.appendChild(doc.createTextNode(String.valueOf(lli.getTitol())));
				llibre1.appendChild(titol);
				Element autor = doc.createElement("autor");
				autor.appendChild(doc.createTextNode(String.valueOf(lli.getAutor())));
				llibre1.appendChild(autor);
				Element anyo = doc.createElement("any_de_publicacio");
				anyo.appendChild(doc.createTextNode(String.valueOf(lli.getAnyPublicacio())));
				llibre1.appendChild(anyo);
				Element editorial = doc.createElement("editorial");
				editorial.appendChild(doc.createTextNode(String.valueOf(lli.getEditorial())));
				llibre1.appendChild(editorial);
				Element nombrepags = doc.createElement("nombre_de_pagines");
				nombrepags.appendChild(doc.createTextNode(String.valueOf(lli.getNombrePagines())));
				llibre1.appendChild(nombrepags);
				
				//actua como contador
				ultimaID++;

			}
			TransformerFactory tranFactory = TransformerFactory.newInstance(); // Crear serializador
			Transformer aTransformer = tranFactory.newTransformer();
			aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1"); // Darle formato al documento
			aTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			try {

				FileWriter fw = new FileWriter("Llibres.xml");// Definir el nombre del fichero y guardar
				StreamResult result = new StreamResult(fw);
				aTransformer.transform(source, result);
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (TransformerException ex) {
			System.out.println("Error escribiendo el documento");
		} catch (ParserConfigurationException ex) {
			System.out.println("Error construyendo el documento");
		}
	}
	
	/*
	 * Métode: borrarLlibre
	 * Descripció: : borra un objecte llibre a partir d’un identificador
	 * Paràmetre d'entrada: id
	 * Paràmetre d'eixida: no
	 * 
	 * */
	
	public static void borrarLlibre(int id) {
		ArrayList<Llibre> llibres = llegirLlibres();
		llibres.remove(id - 1);
		
		int ultimaID = 1;
		try {
			DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder build = dFact.newDocumentBuilder();
			Document doc = build.newDocument();
			Element raiz = doc.createElement("llibres");
			doc.appendChild(raiz);
			
			

			for (Llibre lli : llibres) {

				Element llibre1 = doc.createElement("llibre");

				llibre1.setAttribute("id", Integer.toString(ultimaID));
				raiz.appendChild(llibre1);
				Element titol = doc.createElement("titol");
				titol.appendChild(doc.createTextNode(String.valueOf(lli.getTitol())));
				llibre1.appendChild(titol);
				Element autor = doc.createElement("autor");
				autor.appendChild(doc.createTextNode(String.valueOf(lli.getAutor())));
				llibre1.appendChild(autor);
				Element anyo = doc.createElement("any_de_publicacio");
				anyo.appendChild(doc.createTextNode(String.valueOf(lli.getAnyPublicacio())));
				llibre1.appendChild(anyo);
				Element editorial = doc.createElement("editorial");
				editorial.appendChild(doc.createTextNode(String.valueOf(lli.getEditorial())));
				llibre1.appendChild(editorial);
				Element nombrepags = doc.createElement("nombre_de_pagines");
				nombrepags.appendChild(doc.createTextNode(String.valueOf(lli.getNombrePagines())));
				llibre1.appendChild(nombrepags);
				
				//actua como contador
				ultimaID++;

			}
			TransformerFactory tranFactory = TransformerFactory.newInstance(); // Crear serializador
			Transformer aTransformer = tranFactory.newTransformer();
			aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1"); // Darle formato al documento
			aTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			try {

				FileWriter fw = new FileWriter("Llibres.xml");// Definir el nombre del fichero y guardar
				StreamResult result = new StreamResult(fw);
				aTransformer.transform(source, result);
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (TransformerException ex) {
			System.out.println("Error escribiendo el documento");
		} catch (ParserConfigurationException ex) {
			System.out.println("Error construyendo el documento");
		}
		
		
		
	}

}
