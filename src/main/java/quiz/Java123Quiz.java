package quiz;

import entity.Java123Entity;
import entity.LeaderboardEntity;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static tools.QuizTools.*;
import static tools.Tools.getInt123;

public class Java123Quiz {
	static int quizLength;
	static int numCorrectAnswers;
	static int score;
	static String playerName;

	public static void java123(EntityManager entityManager, Scanner sc) {
		numCorrectAnswers = 0;
		List<Java123Entity> listOfQuestions = new ArrayList<>(entityManager.createQuery("SELECT j FROM Java123Entity j").getResultList());
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
				entityManager.getTransaction().commit();
				return;
			} else {
				leaderboard.setLbJava123Score(score);
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
		return Integer.parseInt(String.valueOf(entityManager.createQuery("SELECT lbJava123Score FROM LeaderboardEntity WHERE lbPlayerName='" + playerName + "'")
				.getResultStream().findFirst().orElse(0)));
	}

	public static int getPlayerID(EntityManager entityManager, String playerName) {
		return Integer.parseInt(String.valueOf(entityManager.createQuery("SELECT leaderboardId FROM LeaderboardEntity WHERE lbPlayerName='" + playerName + "'")
				.getResultStream().findFirst().get()));
	}

	private static void runQuiz(int numOfQuestions, List<Java123Entity> listOfQuestions, Scanner sc) {
		List<Integer> questionsAsked = new ArrayList<>();

		printAndGetInput(numOfQuestions, listOfQuestions, sc, questionsAsked);

		score = quizDoneAndGetScore(numOfQuestions, numCorrectAnswers);
	}

	private static void printAndGetInput(int numOfQuestions, List<Java123Entity> listOfQuestions, Scanner sc, List<Integer> questionsAsked) {
		int randomNum;
		for (int i = 0; i < numOfQuestions; i++) {
			randomNum = getRandomNumber(numOfQuestions);

			randomNum = checkIfDuplicate(numOfQuestions, questionsAsked, randomNum);

			Java123Entity getQuestion = listOfQuestions.get(randomNum);

			System.out.println(getQuestion.showQuestion());
			questionsAsked.add(randomNum);
			printEnterAns123();
			int userInput = getInt123(sc);

			printRightOrWrong(userInput, getQuestion);
		}
	}

	private static void printRightOrWrong(int userInput, Java123Entity getQuestion) {
		if (userInput == getQuestion.getJava123CorrectAnswer()) {
			System.out.println("Correct answer!\n");
			numCorrectAnswers++;
		} else {
			System.out.println("You failed successfully!\n");
		}
	}
}