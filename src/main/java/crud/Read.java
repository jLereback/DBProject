package crud;

import entity.Java123Entity;
import entity.JavaTrueFalseEntity;
import entity.Python123Entity;
import entity.PythonTrueFalseEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import tools.Tools;



import java.util.List;
import java.util.Scanner;

import static menu.Menu.chooseQuiz;
import static tools.Tools.getInputToLowerCase;

public class Read {


	public static void printQuestions(EntityManager entityManager, Scanner sc) {
		String choice;
		do {
			System.out.printf("""
					     
					In what quiz would you like to see all questions?
					%s
					""", chooseQuiz());
			choice = getInputToLowerCase(sc);
			switch (choice) {
				case "1" -> printJavaTrueFalse(entityManager);
				case "2" -> printJava123(entityManager);
				case "3" -> printPythonTrueFalse(entityManager);
				case "4" -> printPython123(entityManager);
				case "e" -> System.out.println("Going back");
				default -> Tools.incorrectInput();
			}
		} while (!choice.equals("e"));
	}

	static void printPython123(EntityManager entityManager) {


		Query query = entityManager.createQuery("SELECT p FROM Python123Entity p");

		List<Python123Entity> list = query.getResultList();

		for (Python123Entity p : list) {
			System.out.print("Question ID :" + p.getPython123Id());
			System.out.println("\t Question:" + p.getPython123Question());
			System.out.println("Answer 1: " + p.getPython123Answer1());
			System.out.println("Answer 2: " + p.getPython123Answer2());
			System.out.println("Answer 3: " + p.getPython123Answer3());
			System.out.println("Correct answer: " + p.getPython123CorrectAnswer());
		}

	}

	static void printPythonTrueFalse(EntityManager entityManager) {

		Query query = entityManager.createQuery("SELECT p FROM PythonTrueFalseEntity p");

		List<PythonTrueFalseEntity> list = query.getResultList();

		for (PythonTrueFalseEntity p : list) {
			System.out.print("Question ID :" + p.getPythonTfId());
			System.out.println("\t Question:" + p.getPythonTfQuestion());
			System.out.println("Correct answer: " + p.getPythonTfAnswer());
		}


	}

	static void printJava123(EntityManager entityManager) {
		//TODO PRINT
		Query query = entityManager.createQuery("SELECT j FROM Java123Entity j");
		List<Java123Entity> list = query.getResultList();
		for (Java123Entity j : list) {
			System.out.print("Question ID: " + j.getJava123Id());
			System.out.println("\t Question: " + j.getJava123Question());
			System.out.println("Answer 1: " + j.getJava123Answer1());
			System.out.println("Answer 2: " + j.getJava123Answer2());
			System.out.println("Answer 3: " + j.getJava123Answer3());
			System.out.println("Correct answer" + j.getJava123CorrectAnswer());
		}

	}

	static void printJavaTrueFalse(EntityManager entityManager) {
		//TODO PRINT
		Query query = entityManager.createQuery("SELECT j FROM JavaTrueFalseEntity j");

		List<JavaTrueFalseEntity> list = query.getResultList();

		for (JavaTrueFalseEntity p : list) {
			System.out.print("Question ID :" + p.getJavaTfId());
			System.out.println("\t Question:" + p.getJavaTfQuestion());
			System.out.println("Correct answer: " + p.getJavaTfAnswer());
		}

	}

}
