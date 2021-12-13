package es.florida.aev5;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.w3c.dom.*;

import es.florida.ae5.Llibre;

import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.*;

public class Principal {
	
	/*
	 * M�tode: main
	 * Descripci�:desplega un menu per seleccionar quin metode utilitzar
	 * Par�metre d'entrada: no
	 * Par�metre d'eixida:no
	 * */

	public static void main(String args[]) throws IOException {
		
		// Carregala configuracioi crea un sessionfactory
				Configuration configuration= new Configuration().configure("hibernate.cfg.xml");
				configuration.addClass(Llibre.class);
				ServiceRegistry registry= new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
				SessionFactory sessionFactory= configuration.buildSessionFactory(registry);
				// Obri una nova sessióde la sessionfactory
				Session session= sessionFactory.openSession();
				session.beginTransaction();
				session.getTransaction().commit();
		do {
			System.out.println("Opcions: " + "\n1. Mostrar els titols dels llibres"
					+ "\n2. Mostrar informacio d'un llibre" + "\n3. Crear un nou llibre" + "\n4. Actualitzar un  llibre"
					+ "\n5. Borrar un llibre" + "\n6. Tancar la biblioteca");

			Scanner sc = new Scanner(System.in);
			String resposta = sc.nextLine();
			switch (resposta) {
			case "1": {
				List<Llibre> llibre = llegirLlibres(session);
				for (int i = 0; i < llibre.size(); i++) {
					System.out.println(llibre.get(i).getIdentificador() + " " + llibre.get(i).getTitol());
				}
				break;
			}
			case "2": {
				System.out.println("Introdueix la id del llibre: ");
				mostrarLlibre(recuperarLlibre(Integer.parseInt(sc.nextLine()), session));

				break;
			}
			case "3": {
				
				crearLlibre(session);

				break;
			}
			case "4": {
				System.out.println("Introdueix l'identificador del llibre a actualitzar");
				actualitzarLlibre(Integer.parseInt(sc.nextLine()), session);

				break;
			}
			case "5": {
				System.out.println("Introdueix l'identificador del llibre per eliminar-ho: ");
				borrarLlibre(Integer.parseInt(sc.nextLine()), session);

				break;
			}
			case "6": {
				System.out.println("Adios");
				System.exit(0);
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

	/*
	 * M�tode: llegirLlibres
	 * Descripci�: retorna un string de llibres en el elements del document xml
	 * Par�metre d'entrada: no
	 * Par�metre d'eixida: llibres
	 * */
	public static List<Llibre> llegirLlibres(Session session) {
		/* lista que almacena los libros del xml */
		

		List <Llibre> listaLlibres= new ArrayList <Llibre>();
		listaLlibres= session.createQuery("FROM Llibre").list() ;
		

		return listaLlibres;
	}

	

	/*
	 * M�tode: mostrarLlibre
	 * Descripci�: mostra els elements del xml de llibres
	 * Par�metre d'entrada: objecte llibre
	 * Par�metre d'eixida: no
	 * 
	 * */
	
	public static void mostrarLlibre(Llibre llibre) {
		System.out.println(llibre.getIdentificador());
		System.out.println(llibre.getTitol());
		System.out.println(llibre.getAutor());
		System.out.println(llibre.getAnyPublicacio());
		System.out.println(llibre.getAnyNaixement());
		System.out.println(llibre.getEditorial());
		System.out.println(llibre.getNombrePagines());

	}
	
	/*
	 * M�tode: crearLlibre
	 * Descripci�: extrau els llibres de l'array i els escriu en el xml, escribint-ho darrere de l'ultima id
	 * Par�metre d'entrada: objecte llibre
	 * Par�metre d'eixida: ultimaID
	 * 
	 * */

	public static void crearLlibre(Session session) {
		Scanner sc = new Scanner(System.in);
		String nouLlibre = sc.nextLine();
		System.out.println("Introdueix el titol del nou llibre: ");
		String nouTitol = sc.nextLine();
		System.out.println("Introdueix l'autor del nou llibre: ");
		String nouAutor = sc.nextLine();
		System.out.println("Introdueix l'any de naixement de l'autor: ");
		int nouAnyNaixement = Integer.parseInt(sc.nextLine());
		System.out.println("Introdueix l'any de publicacio del nou llibre: ");
		int nouAnyPublicacio = Integer.parseInt(sc.nextLine());
		System.out.println("Introdueix l'editorial del nou llibre: ");
		String novaEditorial = sc.nextLine();
		System.out.println("Introdueix el nombre de pagines del nou llibre: ");
		int nouNombrePagines = Integer.parseInt(sc.nextLine());
		
		Llibre lli= new Llibre(nouTitol, nouAutor, nouAnyNaixement, nouAnyPublicacio, novaEditorial, nouNombrePagines);
		Serializable id= session.save(lli);
		session.getTransaction().commit();
	}

	/*
	 * M�tode: recuperarLlibre
	 * Descripci�: : torna un objecte llibre a partir d�un identificador
	 * Par�metre d'entrada: id
	 * Par�metre d'eixida: recuperarLlibre.get(i)
	 * 
	 * */
	
	public static Llibre recuperarLlibre(int id, Session session) {

		Llibre llib= (Llibre) session.get(Llibre.class, id);

		return llib;
		
		

	}

	/*
	 * M�tode: actualitzarLlibre
	 * Descripci�: : actualitza (modifica) la informaci� d�un objecte llibre a partir d�un identificador
	 * Par�metre d'entrada: id
	 * Par�metre d'eixida: no
	 * 
	 * */
	
	public static void actualitzarLlibre(int id, Session session) {
		Llibre llibr= (Llibre) session.load(Llibre.class, id);
		llibr.setAnyPublicacio(2010);
		llibr.setEditorial("Planeta");
		session.update(llibr);
	}
	
	/*
	 * M�tode: borrarLlibre
	 * Descripci�: : borra un objecte llibre a partir d�un identificador
	 * Par�metre d'entrada: id
	 * Par�metre d'eixida: no
	 * 
	 * */
	
	public static void borrarLlibre(int id, Session session) {
		Llibre llibreBorrar= new Llibre();
		llibreBorrar.setIdentificador(id);
		session.delete(llibreBorrar);
		
		
		
	}

}

