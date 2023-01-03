package crud;

import entity.Java123Entity;
import entity.JavaTrueFalseEntity;
import entity.Python123Entity;
import entity.PythonTrueFalseEntity;
import jakarta.persistence.EntityManager;
import tools.Tools;

import java.util.Scanner;

import static crud.Read.*;

public class Delete {
	public static void removeFromPython123(EntityManager entityManager, Scanner sc) {
		printPython123(entityManager);
		System.out.println("Which question would you like to remove?");
		Python123Entity python123 = entityManager.find(Python123Entity.class, Tools.getInt(sc));
		entityManager.remove(python123);
		System.out.println("You have removed a question");
	}

	public static void removeFromPythonTrueFalse(EntityManager entityManager, Scanner sc) {
		printPythonTrueFalse(entityManager);
		System.out.println("Which question would you like to remove?");
		PythonTrueFalseEntity pythonTrueFalse = entityManager.find(PythonTrueFalseEntity.class, Tools.getInt(sc));
		entityManager.remove(pythonTrueFalse);
		System.out.println("You have removed a question");
	}

	public static void removeFromJava123(EntityManager entityManager, Scanner sc) {
		printJava123(entityManager);
		System.out.println("Which question would you like to remove?");
		Java123Entity java123 = entityManager.find(Java123Entity.class, Tools.getInt(sc));
		entityManager.remove(java123);
		System.out.println("You have removed a question");
	}

	public static void removeFromJavaTrueFalse(EntityManager entityManager, Scanner sc) {
		printJavaTrueFalse(entityManager);
		System.out.println("Which question would you like to remove?");
		JavaTrueFalseEntity javaTrueFalse = entityManager.find(JavaTrueFalseEntity.class, Tools.getInt(sc));
		entityManager.remove(javaTrueFalse);
		System.out.println("You have removed a question");
	}
}