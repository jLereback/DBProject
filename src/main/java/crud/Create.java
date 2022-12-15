package crud;

import entity.Java123Entity;
import entity.JavaTrueFalseEntity;
import entity.Python123Entity;
import entity.PythonTrueFalseEntity;
import jakarta.persistence.EntityManager;
import tools.Tools;

import java.util.Scanner;

public class Create {

	public static void addToJavaTrueFalse(EntityManager entityManager, Scanner sc) {
		JavaTrueFalseEntity javaTrueFalse = new JavaTrueFalseEntity();
		System.out.println("Write the new question:");
		javaTrueFalse.setJavaTfQuestion(sc.nextLine());
		System.out.print("Enter true or false: ");
		javaTrueFalse.setJavaTfAnswer(Tools.getBoolean(sc));
		entityManager.persist(javaTrueFalse);

		System.out.println("You have added a question");
		System.out.println(javaTrueFalse.getJavaTfId() + " | " + javaTrueFalse.getJavaTfQuestion() + " | " + javaTrueFalse.getJavaTfAnswer());
	}

	public static void addToJava123(EntityManager entityManager, Scanner sc) {
		Java123Entity java123 = new Java123Entity();
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

		System.out.println("You have added this question: ");
		System.out.println(java123.getJava123Id() + " | " + java123.getJava123Question() + " | " + java123.getJava123CorrectAnswer());
	}

	public static void addToPythonTrueFalse(EntityManager entityManager, Scanner sc) {
		PythonTrueFalseEntity pythonTrueFalse = new PythonTrueFalseEntity();
		System.out.println("Write the new question:");
		pythonTrueFalse.setPythonTfQuestion(sc.nextLine());
		System.out.print("Enter true or false: ");
		pythonTrueFalse.setPythonTfAnswer(Tools.getBoolean(sc));
		entityManager.persist(pythonTrueFalse);

		System.out.println("You have added a question");
		System.out.println(pythonTrueFalse.getPythonTfId() + " | " + pythonTrueFalse.getPythonTfQuestion() + " | " + pythonTrueFalse.getPythonTfAnswer());
	}

	public static void addToPython123(EntityManager entityManager, Scanner sc) {
		Python123Entity python123 = new Python123Entity();
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

		System.out.println("You have added a question");
		System.out.println(python123.getPython123Id() + " | " + python123.getPython123Question() + " | " + python123.getPython123CorrectAnswer());
	}

}
