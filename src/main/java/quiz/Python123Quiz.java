package quiz;

import entity.JavaTrueFalseEntity;
import entity.Python123Entity;
import jakarta.persistence.EntityManager;
import tools.Tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static tools.QuizTools.*;
import static tools.Tools.getBoolean;

public class Python123Quiz {
	static int quizLength;
	static int score;

	public static void python123(EntityManager entityManager,Scanner sc) {
		score = 0;
		List<Python123Entity> listOfQuestions = new ArrayList<>(entityManager.createQuery("SELECT p FROM Python123Entity p").getResultList());
		quizLength = listOfQuestions.size();

		String player = getPlayerName(sc);
		int numOfQuestions = getNumOfQuestions(sc, quizLength);

		runQuiz(numOfQuestions, listOfQuestions, sc);


	}
	private static void runQuiz(int numOfQuestions, List<Python123Entity> listOfQuestions, Scanner sc) {
		List<Integer> questionsAsked = new ArrayList<>();

		printAndGetInput(numOfQuestions, listOfQuestions, sc, questionsAsked);

		quizDone(numOfQuestions, score);
	}

	private static void printAndGetInput(int numOfQuestions, List<Python123Entity> listOfQuestions, Scanner sc, List<Integer> questionsAsked) {
		int randomNum;
		for (int i = 0; i < numOfQuestions; i++) {
			randomNum = getRandomNumber(numOfQuestions);

			randomNum = checkIfDuplicate(numOfQuestions, questionsAsked, randomNum);

			Python123Entity getQuestion = listOfQuestions.get(randomNum);

			System.out.println(getQuestion.showQuestion());
			questionsAsked.add(randomNum);
			printEnterAns123();
			int userInput = Tools.getInt123(sc);

			printRightOrWrong(userInput, getQuestion);
		}
	}


	private static void printRightOrWrong(int userInput, Python123Entity getQuestion) {
		if (userInput == getQuestion.getPython123CorrectAnswer()) {
			System.out.println("Correct answer!\n");
			score++;
		} else {
			System.out.println("You failed successfully!\n");
		}
	}
}