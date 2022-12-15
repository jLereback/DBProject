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




	public static void printPython123(EntityManager entityManager) {
		Query query = entityManager.createQuery("SELECT p FROM Python123Entity p");

		List<Python123Entity> list = query.getResultList();

		for (Python123Entity p : list) {
			System.out.println("Question ID :" + p.getPython123Id());
			System.out.println("Question:" + p.getPython123Question());
			System.out.println("Answer 1: " + p.getPython123Answer1());
			System.out.println("Answer 2: " + p.getPython123Answer2());
			System.out.println("Answer 3: " + p.getPython123Answer3());
			System.out.println("Correct answer: " + p.getPython123CorrectAnswer());
		}
	}

	public static void printPythonTrueFalse(EntityManager entityManager) {
		Query query = entityManager.createQuery("SELECT p FROM PythonTrueFalseEntity p");

		List<PythonTrueFalseEntity> list = query.getResultList();

		for (PythonTrueFalseEntity p : list) {
			System.out.println("Question ID :" + p.getPythonTfId());
			System.out.println("Question:" + p.getPythonTfQuestion());
			System.out.println("Correct answer: " + p.getPythonTfAnswer());
		}
	}

	public static void printJava123(EntityManager entityManager) {
		//TODO PRINT
		Query query = entityManager.createQuery("SELECT j FROM Java123Entity j");
		List<Java123Entity> list = query.getResultList();
		for (Java123Entity j : list) {
			System.out.println("Question ID: " + j.getJava123Id());
			System.out.println("Question: " + j.getJava123Question());
			System.out.println("Answer 1: " + j.getJava123Answer1());
			System.out.println("Answer 2: " + j.getJava123Answer2());
			System.out.println("Answer 3: " + j.getJava123Answer3());
			System.out.println("Correct answer" + j.getJava123CorrectAnswer());
		}
	}

	public static void printJavaTrueFalse(EntityManager entityManager) {
		//TODO PRINT
		Query query = entityManager.createQuery("SELECT j FROM JavaTrueFalseEntity j");

		List<JavaTrueFalseEntity> list = query.getResultList();

		for (JavaTrueFalseEntity j : list) {
			System.out.println("Question ID :" + j.getJavaTfId());
			System.out.println("Question:" + j.getJavaTfQuestion());
			System.out.println("Correct answer: " + j.getJavaTfAnswer());
		}
	}

}
