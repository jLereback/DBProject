package quiz;

import entity.JavaTrueFalseEntity;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static tools.QuizTools.*;
import static tools.Tools.getBoolean;

public class JavaTrueFalseQuiz {
	static int quizLength;
	static int score;

	public static void javaTrueOrFalse(EntityManager entityManager, Scanner sc) {
		score = 0;
		List<JavaTrueFalseEntity> listOfQuestions = new ArrayList<>(entityManager.createQuery("SELECT j FROM JavaTrueFalseEntity j").getResultList());
		quizLength = listOfQuestions.size();

		String player = getPlayerName(sc);
		int numOfQuestions = getNumOfQuestions(sc, quizLength);

		runQuiz(numOfQuestions, listOfQuestions, sc);
	}

	private static void runQuiz(int numOfQuestions, List<JavaTrueFalseEntity> listOfQuestions, Scanner sc) {
		List<Integer> questionsAsked = new ArrayList<>();

		printAndGetInput(numOfQuestions, listOfQuestions, sc, questionsAsked);

		quizDone(numOfQuestions, score);
	}

	private static void printAndGetInput(int numOfQuestions, List<JavaTrueFalseEntity> listOfQuestions, Scanner sc, List<Integer> questionsAsked) {
		int randomNum;
		for (int i = 0; i < numOfQuestions; i++) {
			randomNum = getRandomNumber(numOfQuestions);

			randomNum = checkIfDuplicate(numOfQuestions, questionsAsked, randomNum);

			JavaTrueFalseEntity getQuestion = listOfQuestions.get(randomNum);

			System.out.println(getQuestion.showQuestion());
			questionsAsked.add(randomNum);
			printEnterAnsTF();
			byte userInput = getBoolean(sc);

			printRightOrWrong(userInput, getQuestion);
		}
	}

	private static void printRightOrWrong(byte userInput, JavaTrueFalseEntity getQuestion) {
		if (userInput == getQuestion.getJavaTfAnswer()) {
			System.out.println("Correct answer!\n");
			score++;
		} else {
			System.out.println("You failed successfully!\n");
		}
	}
}