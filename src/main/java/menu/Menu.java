package menu;

import crud.Create;
import crud.Delete;

import jakarta.persistence.EntityManager;
import tools.Tools;

import java.util.Scanner;

import static crud.Read.*;
import static crud.Update.*;
import static tools.Tools.getInputToLowerCase;
import static tools.Tools.incorrectInput;

public class Menu {
	private static final Scanner sc = new Scanner(System.in);

	public static void mainMenu(EntityManager entityManager) {
		String choice;
		do {
			printMainMenu();
			choice = getInputToLowerCase(sc);
			mainSwitch(entityManager, choice);
		} while (!choice.equals("e"));

	}

	private static void printMainMenu() {
		System.out.println("""
				    
				Spectacle Snakes...
				-----------------
				1. True or false - Java
				2. 1 2 3 - Java
				3. True or false - Python
				4. 1 2 3 - Python
				5. Modify tests
				e. Exit
				""");
	}

	private static void mainSwitch(EntityManager entityManager, String choice) {
		switch (choice) {
			case "1" -> javaTrueOrFalse();
			case "2" -> java123();
			case "3" -> pythonTrueOrFalse();
			case "4" -> python123();
			case "5" -> modifyTests(entityManager);
			case "e" -> System.out.println("Good bye");
			default -> incorrectInput();
		}
	}

	private static void javaTrueOrFalse() {
		//TODO QUIZ
	}

	private static void java123() {
		//TODO QUIZ
	}

	private static void pythonTrueOrFalse() {
		//TODO QUIZ
	}

	private static void python123() {
		//TODO QUIZ
	}

	private static void modifyTests(EntityManager entityManager) {
		entityManager.getTransaction().begin();
		String choice;
		do {
			printModifyTestsMenu();
			choice = getInputToLowerCase(sc);
			modifySwitch(entityManager, choice);
		} while (!choice.equals("e"));
		entityManager.getTransaction().commit();
	}

	private static void printModifyTestsMenu() {
		System.out.println("""
				    
				1. Add a question
				2. Update a question
				3. Remove a question
				4. See all questions
				5. Return
				""");
	}

	private static void modifySwitch(EntityManager entityManager, String choice) {
		switch (choice) {
			case "1" -> addQuestion(entityManager);
			case "2" -> updateQuestion(entityManager);
			case "3" -> removeQuestion(entityManager);
			case "4" -> readQuestions(entityManager, sc);
			case "e" -> System.out.println("Back to main menu");
			default -> incorrectInput();
		}
	}

	private static void addQuestion(EntityManager entityManager) {
		String choice;
		do {
			printAddMenu();
			choice = getInputToLowerCase(sc);
			addSwitch(entityManager, choice);
		} while (!choice.equals("e"));
	}

	private static void printAddMenu() {
		System.out.printf("""
					 
				To what quiz would you like to add a question?
				%s
				""", chooseQuiz());
	}

	private static void addSwitch(EntityManager entityManager, String choice) {
		switch (choice) {
			case "1" -> Create.addToJavaTrueFalse(entityManager, sc);
			case "2" -> Create.addToJava123(entityManager, sc);
			case "3" -> Create.addToPythonTrueFalse(entityManager, sc);
			case "4" -> Create.addToPython123(entityManager, sc);
			case "e" -> System.out.println("Going back");
			default -> incorrectInput();
		}
	}

	private static void updateQuestion(EntityManager entityManager) {
		String choice;
		do {
			printUpdateMenu();
			choice = getInputToLowerCase(sc);
			updateSwitch(entityManager, choice);
		} while (!choice.equals("e"));
	}

	private static void printUpdateMenu() {
		System.out.printf("""
					 
				In what quiz would you like to update a question?
				%s
				""", chooseQuiz());
	}

	private static void updateSwitch(EntityManager entityManager, String choice) {
		switch (choice) {
			case "1" -> updateJavaTrueFalse(entityManager, sc);
			case "2" -> updateJava123(entityManager, sc);
			case "3" -> updatePythonTrueFalse(entityManager, sc);
			case "4" -> updatePython123(entityManager, sc);
			case "e" -> System.out.println("Going back");
			default -> incorrectInput();
		}
	}

	private static void removeQuestion(EntityManager entityManager) {
		String choice;
		do {
			printRemoveMenu();
			choice = getInputToLowerCase(sc);
			removeSwitch(entityManager, choice);
		} while (!choice.equals("e"));
	}

	private static void printRemoveMenu() {
		System.out.printf("""
					 
				In what quiz would you like to remove a question?
				%s
				""", chooseQuiz());
	}

	private static void removeSwitch(EntityManager entityManager, String choice) {
		switch (choice) {
			case "1" -> Delete.removeFromJavaTrueFalse(entityManager, sc);
			case "2" -> Delete.removeFromJava123(entityManager, sc);
			case "3" -> Delete.removeFromPythonTrueFalse(entityManager, sc);
			case "4" -> Delete.removeFromPython123(entityManager, sc);
			case "e" -> System.out.println("Going back");
			default -> incorrectInput();
		}
	}

	public static void readQuestions(EntityManager entityManager, Scanner sc) {
		String choice;
		do {
			printReadMenu();
			choice = getInputToLowerCase(sc);
			readSwitch(entityManager, choice);
		} while (!choice.equals("e"));
	}

	private static void printReadMenu() {
		System.out.printf("""
					 
				In what quiz would you like to see all questions?
				%s
				""", chooseQuiz());
	}

	private static void readSwitch(EntityManager entityManager, String choice) {
		switch (choice) {
			case "1" -> printJavaTrueFalse(entityManager);
			case "2" -> printJava123(entityManager);
			case "3" -> printPythonTrueFalse(entityManager);
			case "4" -> printPython123(entityManager);
			case "e" -> System.out.println("Going back");
			default -> Tools.incorrectInput();
		}
	}

	public static String chooseQuiz() {
		return """
				1. Java True/False
				2. Java123
				3. Python True/False
				4. Python123
				e. Go back
				""";
	}
}