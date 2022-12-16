package crud;

import jakarta.persistence.EntityManager;

public class Read {
	public static void printPython123(EntityManager entityManager) {
		entityManager.createQuery("SELECT p FROM Python123Entity p")
				.getResultStream().map(result -> result.toString()).forEach(System.out::println);
	}

	public static void printPythonTrueFalse(EntityManager entityManager) {
		entityManager.createQuery("SELECT p FROM PythonTrueFalseEntity p")
				.getResultStream().map(result -> result.toString()).forEach(System.out::println);
	}

	public static void printJava123(EntityManager entityManager) {
		entityManager.createQuery("SELECT j FROM Java123Entity j")
				.getResultStream().map(result -> result.toString()).forEach(System.out::println);
	}

	public static void printJavaTrueFalse(EntityManager entityManager) {
		entityManager.createQuery("SELECT j FROM JavaTrueFalseEntity j")
				.getResultStream().map(result -> result.toString()).forEach(System.out::println);
	}
}