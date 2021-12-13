package es.florida.ae5;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Principal {

	public static void main(String[] args) {
		// Carregala configuracioi crea un sessionfactory
		Configuration configuration= new Configuration().configure("hibernate.cfg.xml");
		configuration.addClass(Llibre.class);
		ServiceRegistry registry= new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory= configuration.buildSessionFactory(registry);
		// Obri una nova sessióde la sessionfactory
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		
		//Ací les operacio/nsCRUD (crear, llegir, actualitzar, borrar)
		
		//Llegir un objecte
		//Recuperarun objectea partirdel seuid
		Llibre llibre1 = (Llibre) session.get(Llibre.class, 23);
		
		//Crear nou objecte
		Llibre lli= new Llibre("Una sala llena de corazones rotos", "Anne Tyler", 1941, 2021, "Lumen", 200) ;
		Serializable id= session.save(lli);
		
		// Actualitza la información d’un objecte donat el seu id
		Llibre llibre= (Llibre) session.load(Llibre.class, 23);
		llibre.setEditorial("Planeta");
		llibre.setAnyPublicacio(2017);
		session.update(llibre);
		
		//Borra run objecte donat el seu id
		Llibre lli2= new Llibre();
		lli2.setIdentificador(21);
		session.delete(lli2);
		
		//Commit de la transacció i tanca de sessió
		session.getTransaction().commit();
		session.close();
	}

}
