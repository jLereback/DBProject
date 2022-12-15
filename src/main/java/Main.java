import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import static menu.Menu.mainMenu;

public class Main {
	static EntityManagerFactory entityManagerFactory;
	static EntityManager entityManager;
	public static void main(String[] args) {
		initialize();
		mainMenu(entityManager);
		terminate();
	}

	private static void terminate() {
		entityManager.close();
		entityManagerFactory.close();
	}

	private static void initialize() {
		entityManagerFactory = Persistence.createEntityManagerFactory("default");
		entityManager = entityManagerFactory.createEntityManager();
	}
}
