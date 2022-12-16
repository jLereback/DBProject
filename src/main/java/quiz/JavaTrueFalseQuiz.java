package quiz;

import entity.JavaTrueFalseEntity;
import jakarta.persistence.EntityManager;
import tools.Tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class JavaTrueFalseQuiz {
	static int quizLength;

	public static void javaTrueOrFalse(EntityManager entityManager, Scanner sc) {

		List<JavaTrueFalseEntity> listOfQuestions = new ArrayList<>(entityManager.createQuery("SELECT j FROM JavaTrueFalseEntity j").getResultList());
		quizLength = listOfQuestions.size();

		String player = getPlayerName(sc);
		int numOfQuestions = getNumOfQuestions(sc);

		runQuiz(numOfQuestions, listOfQuestions, sc);
	}

	private static void runQuiz(int numOfQuestions, List<JavaTrueFalseEntity> listOfQuestions, Scanner sc) {
		List<Integer> questionsAsked = new ArrayList<>();
		int score;

		int randomNum;
		for (int i = 0; i < numOfQuestions; i++) {
			randomNum = getRandomNumber(numOfQuestions);

			if (!questionsAsked.isEmpty() && questionsAsked.contains(randomNum)) {
				do {
					randomNum = getRandomNumber(numOfQuestions);
				} while (questionsAsked.contains(randomNum));
			}

			JavaTrueFalseEntity getQuestion = listOfQuestions.get(randomNum);

			System.out.println(getQuestion.showQuestion());
			questionsAsked.add(randomNum);
			sc.nextLine();
		}
	}

	private static int getRandomNumber(int numOfQuestions) {
		Random rand = new Random();
		return rand.nextInt(numOfQuestions + 1);
	}

	private static int getNumOfQuestions(Scanner sc) {
		if (quizLength >= 10) {
			System.out.print("Would you like to have 5 or 10 questions in the quiz? ");
			return Tools.getFiveOrTen(sc);
		} else
			return Math.min(quizLength, 5);
	}

	private static String getPlayerName(Scanner sc) {
		System.out.print("Insert name: ");
		return sc.nextLine();
	}
}
