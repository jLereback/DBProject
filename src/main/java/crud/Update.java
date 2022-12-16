package crud;

import entity.Java123Entity;
import entity.JavaTrueFalseEntity;
import entity.Python123Entity;
import entity.PythonTrueFalseEntity;
import jakarta.persistence.EntityManager;
import tools.Tools;

import static crud.Read.*;
import java.util.Scanner;

public class Update {

	public static void updateJava123(EntityManager entityManager, Scanner sc) {
		printJava123(entityManager);
		askForQuestionToUpdate();
		Java123Entity java123 = entityManager.find(Java123Entity.class, Tools.getInt(sc));
		System.out.print("Enter question: ");
		java123.setJava123Question(sc.nextLine());
		System.out.print("Enter answer 1: ");
		java123.setjava123Answer1(sc.nextLine());
		System.out.println("Enter answer 2: ");
		java123.setjava123Answer2(sc.nextLine());
		System.out.println("Enter answer 3: ");
		java123.setjava123Answer3(sc.nextLine());
		System.out.println("Enter correct answer (1,2,3): ");
		java123.setjava123CorrectAnswer(Tools.getInt123(sc));
		entityManager.persist(java123);

		System.out.println("You have updated a question");

	}

	public static void updateJavaTrueFalse(EntityManager entityManager, Scanner sc) {
		printJavaTrueFalse(entityManager);
		askForQuestionToUpdate();
		JavaTrueFalseEntity javaTrueFalse = entityManager.find(JavaTrueFalseEntity.class, Tools.getInt(sc));
		System.out.println("Write the new question:");
		javaTrueFalse.setJavaTfQuestion(sc.nextLine());
		System.out.print("Enter true or false: ");
		javaTrueFalse.setJavaTfAnswer(Tools.getBoolean(sc));
		entityManager.persist(javaTrueFalse);

		System.out.println("You have updated a question");
	}

	public static void updatePython123(EntityManager entityManager, Scanner sc) {
		printPython123(entityManager);
		askForQuestionToUpdate();
		Python123Entity python123 = entityManager.find(Python123Entity.class, Tools.getInt(sc));
		System.out.println("Enter a Question: ");
		python123.setPython123Question(sc.nextLine());
		System.out.print("Answer 1:");
		python123.setPython123Answer1(sc.nextLine());
		System.out.print("Answer 2: ");
		python123.setPython123Answer2(sc.nextLine());
		System.out.print("Answer 3: ");
		python123.setPython123Answer3(sc.nextLine());
		System.out.print("Enter correct answer ()1,2,3:");
		python123.setPython123CorrectAnswer(Tools.getInt123(sc));
		entityManager.persist(python123);

		System.out.println("You have updated a question");



	}

	public static void updatePythonTrueFalse(EntityManager entityManager, Scanner sc) {
		printPythonTrueFalse(entityManager);
		askForQuestionToUpdate();
		PythonTrueFalseEntity pythonTrueFalse = entityManager.find(PythonTrueFalseEntity.class, Tools.getInt(sc));
		System.out.println("Write the new question:");
		pythonTrueFalse.setPythonTfQuestion(sc.nextLine());
		System.out.print("Enter true or false: ");
		pythonTrueFalse.setPythonTfAnswer(Tools.getBoolean(sc));
		entityManager.persist(pythonTrueFalse);

		System.out.println("You have updated a question");

	}
	private static void askForQuestionToUpdate() {
		System.out.println("Which question ID would you like to update?: ");
	}

}

