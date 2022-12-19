package quiz;

import entity.LeaderboardEntity;
import entity.PythonTrueFalseEntity;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static tools.QuizTools.*;
import static tools.Tools.getBoolean;

public class PythonTrueFalseQuiz {
	static int quizLength;
	static int numCorrectAnswers;
	static int score;
	static String playerName;


	public static void pythonTrueOrFalse(EntityManager entityManager, Scanner sc) {

		numCorrectAnswers = 0;
		List<PythonTrueFalseEntity> listOfQuestions = new ArrayList<>(entityManager.createQuery("SELECT p FROM PythonTrueFalseEntity p").getResultList());
		quizLength = listOfQuestions.size();

		playerName = createPlayer(entityManager, sc);
		int numOfQuestions = getNumOfQuestions(sc, quizLength);

		runQuiz(numOfQuestions, listOfQuestions, sc);

		addToLeaderBoard(entityManager, playerName);
	}


	private static void addToLeaderBoard(EntityManager entityManager, String playerName) {
		entityManager.getTransaction().begin();

		if (checkIfPlayerExist(entityManager, playerName)) {
			LeaderboardEntity leaderboard = entityManager.find(LeaderboardEntity.class, getPlayerID(entityManager, playerName));
			if (checkScore(entityManager, playerName) > score) {
				return;
			} else {
				leaderboard.setLbPythonTfScore(score);
				entityManager.persist(leaderboard);
			}
		}

		entityManager.getTransaction().commit();

	}


	public static boolean checkIfPlayerExist(EntityManager entityManager, String playerName) {
		return entityManager.createQuery("SELECT lbPlayerName FROM LeaderboardEntity")
				.getResultStream().filter(name -> name.equals(playerName)).reduce((first, second) -> second).isPresent();
	}

	public static int checkScore(EntityManager entityManager, String playerName) {
		return Integer.parseInt(String.valueOf(entityManager.createQuery("SELECT lbPythonTfScore FROM LeaderboardEntity WHERE lbPlayerName='" + playerName + "'")
				.getResultStream().findFirst().orElse("0")));

	}

	public static int getPlayerID(EntityManager entityManager, String playerName) {
		return Integer.parseInt(String.valueOf(entityManager.createQuery("SELECT leaderboardId FROM LeaderboardEntity WHERE lbPlayerName='" + playerName + "'")
				.getResultStream().findFirst().get()));

	}


	private static void runQuiz(int numOfQuestions, List<PythonTrueFalseEntity> listOfQuestions, Scanner sc) {
		List<Integer> questionsAsked = new ArrayList<>();

		printAndGetInput(numOfQuestions, listOfQuestions, sc, questionsAsked);

		score = quizDoneAndGetScore(numOfQuestions, numCorrectAnswers);
	}

	private static void printAndGetInput(int numOfQuestions, List<PythonTrueFalseEntity> listOfQuestions, Scanner sc, List<Integer> questionsAsked) {
		int randomNum;
		for (int i = 0; i < numOfQuestions; i++) {
			randomNum = getRandomNumber(numOfQuestions);

			randomNum = checkIfDuplicate(numOfQuestions, questionsAsked, randomNum);

			PythonTrueFalseEntity getQuestion = listOfQuestions.get(randomNum);

			System.out.println(getQuestion.showQuestion());
			questionsAsked.add(randomNum);
			printEnterAnsTF();
			byte userInput = getBoolean(sc);

			printRightOrWrong(userInput, getQuestion);
		}
	}


	private static void printRightOrWrong(byte userInput, PythonTrueFalseEntity getQuestion) {
		if (userInput == getQuestion.getPythonTfAnswer()) {
			System.out.println("Correct answer!\n");
			numCorrectAnswers++;
		} else {
			System.out.println("You failed successfully!\n");
		}
	}
}