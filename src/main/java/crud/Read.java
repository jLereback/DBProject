package crud;

import entity.Java123Entity;
import entity.JavaTrueFalseEntity;
import entity.Python123Entity;
import entity.PythonTrueFalseEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class Read {

	public static void printPython123(EntityManager entityManager) {
		Query query = entityManager.createQuery("SELECT p FROM Python123Entity p");

		List<Python123Entity> list = query.getResultList();

		list.stream().map(Python123Entity::toString).forEach(System.out::println);
	}


	public static void printPythonTrueFalse(EntityManager entityManager) {
		Query query = entityManager.createQuery("SELECT p FROM PythonTrueFalseEntity p");

		List<PythonTrueFalseEntity> list = query.getResultList();

		list.stream().map(PythonTrueFalseEntity::toString).forEach(System.out::println);
	}

	public static void printJava123(EntityManager entityManager) {
		Query query = entityManager.createQuery("SELECT j FROM Java123Entity j");

		List<Java123Entity> list = query.getResultList();

		list.stream().map(Java123Entity::toString).forEach(System.out::println);
	}

	public static void printJavaTrueFalse(EntityManager entityManager) {
		Query query = entityManager.createQuery("SELECT j FROM JavaTrueFalseEntity j");

		List<JavaTrueFalseEntity> list = query.getResultList();

		list.stream().map(JavaTrueFalseEntity::toString).forEach(System.out::println);
	}
}
