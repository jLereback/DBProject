package menu;

import crud.Create;
import crud.Delete;

import jakarta.persistence.EntityManager;

import java.util.Scanner;

import static crud.Read.printQuestions;
import static crud.Update.*;

public class Menu {
	private static final Scanner sc = new Scanner(System.in);


	public static void mainMenu(EntityManager entityManager) {
		String choice;
		do {
			showMainMenu();
			choice = getInputToLowerCase();
			switch (choice) {
				case "1" -> javaTrueOrFalse();
				case "2" -> java123();
				case "3" -> pythonTrueOrFalse();
				case "4" -> python123();
				case "5" -> modifyTests(entityManager);
				case "e" -> System.out.println("Good bye");
				default -> incorrectInput();
			}
		} while (!choice.equals("e"));

	}

	private static void javaTrueOrFalse() {
		//QUIZ
	}

	private static void java123() {
		//QUIZ
	}

	private static void pythonTrueOrFalse() {
		//QUIZ
	}

	private static void python123() {
		//QUIZ
	}

	private static void modifyTests(EntityManager entityManager) {
		entityManager.getTransaction().begin();
		String choice;
		do {
			modifyTestsMenu();
			choice = getInputToLowerCase();
			switch (choice) {
				case "1" -> addAQuestion(entityManager);
				case "2" -> updateAQuestion(entityManager);
				case "3" -> removeAQuestion(entityManager);
				case "4" -> printQuestions(entityManager, sc);
				case "e" -> System.out.println("Back to main menu");
				default -> incorrectInput();
			}
		} while (!choice.equals("e"));
		entityManager.getTransaction().commit();
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

	private static void addAQuestion(EntityManager entityManager) {
		String choice;
		do {
			System.out.printf("""
					     
					To what quiz would you like to add a question?
					%s
					""", chooseQuiz());
			choice = getInputToLowerCase();
			switch (choice) {
				case "1" -> Create.addToJavaTrueFalse(entityManager, sc);
				case "2" -> Create.addToJava123(entityManager, sc);
				case "3" -> Create.addToPythonTrueFalse(entityManager, sc);
				case "4" -> Create.addToPython123(entityManager, sc);
				case "e" -> System.out.println("Going back");
				default -> incorrectInput();
			}
		} while (!choice.equals("e"));
	}

	private static void updateAQuestion(EntityManager entityManager) {
		String choice;
		do {
			System.out.printf("""
					     
					In what quiz would you like to update a question?
					%s
					""", chooseQuiz());
			choice = getInputToLowerCase();
			switch (choice) {
				case "1" -> updateJavaTrueFalse(entityManager, sc);
				case "2" -> updateJava123(entityManager, sc);
				case "3" -> updatePythonTrueFalse(entityManager, sc);
				case "4" -> updatePython123(entityManager, sc);
				case "e" -> System.out.println("Going back");
				default -> incorrectInput();
			}
		} while (!choice.equals("e"));
	}

	private static void removeAQuestion(EntityManager entityManager) {
		String choice;
		do {
			System.out.printf("""
					     
					In what quiz would you like to remove a question?
					%s
					""", chooseQuiz());
			choice = getInputToLowerCase();
			switch (choice) {
				case "1" -> Delete.removeFromJavaTrueFalse(entityManager, sc);
				case "2" -> Delete.removeFromJava123(entityManager, sc);
				case "3" -> Delete.removeFromPythonTrueFalse(entityManager, sc);
				case "4" -> Delete.removeFromPython123(entityManager, sc);
				case "e" -> System.out.println("Going back");
				default -> incorrectInput();
			}
		} while (!choice.equals("e"));
	}

	private static void incorrectInput() {
		System.out.println("Incorrect input, please try again!");
	}

	private static void showMainMenu() {
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

	private static void modifyTestsMenu() {
		System.out.println("""
				    
				1. Add a question
				2. Update a question
				3. Remove a question
				4. See all questions
				5. Return
				""");
	}

	private static String getInputToLowerCase() {
		return sc.nextLine().toLowerCase();
	}
}
