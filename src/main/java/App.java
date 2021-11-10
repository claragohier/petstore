import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			emf = Persistence.createEntityManagerFactory("petstore");
			em = emf.createEntityManager();

		} finally {
			if (em != null)
				em.close();
			if (emf != null)
				emf.close();
		}
	}

}
