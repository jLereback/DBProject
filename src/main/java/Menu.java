import entity.JavaTrueFalseEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class Menu {
	private static Scanner s = new Scanner(System.in);
	static String choice;
	static EntityManagerFactory entityManagerFactory;
	static EntityManager entityManager;


	public static void main(String[] args) {
		entityManagerFactory = Persistence.createEntityManagerFactory("default");
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		mainMenu();

		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}

	private static void mainMenu() {
		while (true) {
			switch (showMainMenuAndGetUserInput()) {
				case "1" -> javaTrueOrFalse();
				case "2" -> java123();
				case "3" -> pythonTrueOrFalse();
				case "4" -> python123();
				case "5" -> modifyTests();
				case "e" -> System.exit(0);
				default -> incorrectInput();
			}
		}
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

	private static void modifyTests() {
		while (true) {
			switch (modifyTestsMenuAndGetUserInput()) {
				case "1" -> addAQuestion();
				case "2" -> updateAQuestion();
				case "3" -> removeAQuestion();
				case "4" -> seeAllQuestions();
				case "5" -> mainMenu();
				case "e" -> System.exit(0);
				default -> incorrectInput();
			}
		}
	}


	private static String chooseQuiz() {
		return """
				1. Java True/False
				2. Java123
				3. Python True/False
				4. Python123
				e. Go back
				""";
	}

	private static void addAQuestion() {
		do {
			choice = getInput();
			System.out.printf("""
				To what quiz would you like to add a question?
				%s
				""", chooseQuiz());
			switch (choice) {
				case "1" -> addToJavaTrueFalse();
				case "2" -> addToJava123();
				case "3" -> addToPythonTrueFalse();
				case "4" -> addToPython123();
				case "e" -> System.out.println("Going back");
				default -> incorrectInput();
			}
		} while (!choice.equals("e"));
	}

	private static void addToJavaTrueFalse() {
		//TODO ADD
		JavaTrueFalseEntity javaTrueFalse = new JavaTrueFalseEntity();
		System.out.println("Write the new question:");
		javaTrueFalse.setJavaTfQuestion(s.nextLine());
		System.out.print("Enter true or false: ");
		javaTrueFalse.setJavaTfAnswer(getBoolean());
		entityManager.persist(javaTrueFalse);
	}

	private static byte getBoolean() {
		do {
			String answer = s.nextLine().toLowerCase();
			if (answer.equals("true"))
				return 1;
			else if (answer.equals("false"))
				return 0;
			else
				incorrectInput();
		} while (true);
	}

	private static void addToJava123() {
		//TODO ADD
	}

	private static void addToPythonTrueFalse() {
		//TODO ADD
	}

	private static void addToPython123() {
		//TODO ADD
	}

	private static void updateAQuestion() {
		do {
			choice = getInput();
			System.out.printf("""
				In what quiz would you like to update a question?
				%s
				""", chooseQuiz());
			switch (choice) {
				case "1" -> updateJavaTrueFalse();
				case "2" -> updateJava123();
				case "3" -> updatePythonTrueFalse();
				case "4" -> updatePython123();
				case "e" -> System.out.println("Going back");
				default -> incorrectInput();
			}
		} while (!choice.equals("e"));
	}

	private static void updatePython123() {
		//TODO UPDATE

	}

	private static void updatePythonTrueFalse() {
		//TODO UPDATE

	}

	private static void updateJava123() {
		//TODO UPDATE

	}

	private static void updateJavaTrueFalse() {
		//TODO UPDATE

	}

	private static void removeAQuestion() {

		do {
			choice = getInput();

			System.out.printf("""
				In what quiz would you like to remove a question?
				%s
				""", chooseQuiz());
			switch (choice) {
				case "1" -> removeFromJavaTrueFalse();
				case "2" -> removeFromJava123();
				case "3" -> removeFromPythonTrueFalse();
				case "4" -> removeFromPython123();
				case "e" -> System.out.println("Going back");
				default -> incorrectInput();
			}
		} while (!choice.equals("e"));
	}

	private static void removeFromPython123() {
		//TODO REMOVE

	}

	private static void removeFromPythonTrueFalse() {
		//TODO REMOVE

	}

	private static void removeFromJava123() {
		//TODO REMOVE

	}

	private static void removeFromJavaTrueFalse() {
		//TODO REMOVE

	}

	private static void seeAllQuestions() {

		do {
			choice = getInput();

			System.out.printf("""
				In what quiz would you like to see all questions?
				%s
				""", chooseQuiz());
			switch (choice) {
				case "1" -> printJavaTrueFalse();
				case "2" -> printJava123();
				case "3" -> printPythonTrueFalse();
				case "4" -> printPython123();
				case "e" -> System.out.println("Going back");
				default -> incorrectInput();
			}
		} while (!choice.equals("e"));
	}

	private static void printPython123() {
		//TODO PRINT

	}

	private static void printPythonTrueFalse() {
		//TODO PRINT

	}

	private static void printJava123() {
		//TODO PRINT

	}

	private static void printJavaTrueFalse() {
		//TODO PRINT

	}

	private static void incorrectInput() {
		System.out.println("Incorrect input, please try again!");
	}

	private static String showMainMenuAndGetUserInput() {
		System.out.println("""
						Spectacle Snakes...
						-----------------
						1. True or false - Java
						2. 1 2 3 - Java
						3. True or false - Python
						4. 1 2 3 - Python
						5. Modify tests
				""");

		return getInput();
	}

	private static String modifyTestsMenuAndGetUserInput() {
		System.out.println("""
					1. Add a question
					2. Update a question
					3. Remove a question
					4. See all questions
					5. Return
				""");
		return getInput();
	}

	private static String getInput() {
		return s.next().toLowerCase();
	}
}
