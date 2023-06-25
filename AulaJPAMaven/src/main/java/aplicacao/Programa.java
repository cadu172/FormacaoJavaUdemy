package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.boot.model.source.internal.hbm.CompositeIdentifierSingularAttributeSourceManyToOneImpl;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager manager = factory.createEntityManager();
		
		Pessoa p1 = new Pessoa(null,"Carlos Eduardo","cadu172@gmail.com");
		Pessoa p2 = new Pessoa(null,"Marco Antonio Silva","marco@gmail.com");
		Pessoa p3 = new Pessoa(null,"Ronaldo Silva","r9@gmail.com");
		
		manager.getTransaction().begin();
		manager.persist(p1);
		manager.persist(p2);
		manager.persist(p3);
		manager.getTransaction().commit();
		
		// localizando uma pessoal usando o find (obs: esta INSTANCIA esta sendo monitorada)
		Pessoa p = manager.find(Pessoa.class, 1);
		
		manager.getTransaction().begin();
		manager.remove(p);
		manager.getTransaction().commit();
		
		//System.out.println(p1);
		
		System.out.println("Finish...");
		
		/*System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);*/

	}

}
