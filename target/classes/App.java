import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.petstore.entities.Address;
import fr.diginamic.petstore.entities.Animal;
import fr.diginamic.petstore.entities.Cat;
import fr.diginamic.petstore.entities.Fish;
import fr.diginamic.petstore.entities.Petstore;
import fr.diginamic.petstore.entities.Product;
import fr.diginamic.petstore.enums.FishLivEnv;
import fr.diginamic.petstore.enums.ProdType;

public class App {

	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			emf = Persistence.createEntityManagerFactory("petstore");
			em = emf.createEntityManager();
			
			Address address = new Address("1", "rue A", "34500", "Béziers");
			Address address2 = new Address("2", "rue B", "34500", "Béziers");
			Address address3 = new Address("3", "rue C", "34500", "Béziers");
			
			Petstore petstore = new Petstore("petstore A", "manager 1", address);
			Petstore petstore2 = new Petstore("petstore B", "manager 2", address2);
			Petstore petstore3 = new Petstore("petstore C", "manager 3", address3);
			
			Product product = new Product("A1", "produit 1", ProdType.ACCESSORY, 25.5);
			Product product2 = new Product("B2", "produit 2", ProdType.FOOD, 50);
			Product product3 = new Product("C3", "produit 3", ProdType.CLEANING, 2.5);

			Animal cat = new Cat(LocalDate.of(2000, 05, 20), "grey", petstore, "C1");
			Animal fish = new Fish(LocalDate.of(2002, 06, 25), "blue", petstore, FishLivEnv.FRESH_WATER);
			Animal fish2 = new Fish(LocalDate.of(2009, 01, 05), "red", petstore, FishLivEnv.SEA_WATER);

			Set<Animal> animals = new HashSet<Animal>();
			em.getTransaction().begin();
			
			em.persist(address);
			em.persist(address2);
			em.persist(address3);
			
			em.persist(petstore);
			em.persist(petstore2);
			em.persist(petstore3);
			
			em.persist(product);
			em.persist(product2);
			em.persist(product3);
			
			em.persist(cat);
			em.persist(fish);
			em.persist(fish2);
			
			animals.add(cat);
			animals.add(fish);
			animals.add(fish2);
			petstore.setAnimals(animals);
			
			em.getTransaction().commit();
			
			TypedQuery<Petstore> query = em.createQuery("SELECT p FROM Petstore p WHERE p.id = 1", Petstore.class);
			Petstore petstoreRes = query.getResultList().get(0);
			
			for(Animal animal : petstoreRes.getAnimals()) {
				System.out.println(animal.toString());
			}
		
		} finally {
			if (em != null)
				em.close();
			if (emf != null)
				emf.close();
		}
	}

}
