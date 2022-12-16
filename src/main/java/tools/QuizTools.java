package tools;

import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class QuizTools {

	public static int getRandomNumber(int numOfQuestions) {
		Random rand = new Random();
		return rand.nextInt(numOfQuestions);
	}

	public static int getNumOfQuestions(Scanner sc, int quizLength) {
		if (quizLength >= 10) {
			System.out.print("Would you like to have 5 or 10 questions in the quiz? ");
			return Tools.getFiveOrTen(sc);
		}
		else return Math.min(quizLength, 5);

	}

	public static String getPlayerName(Scanner sc) {
		System.out.print("Insert name: ");
		return sc.nextLine();
	}

	public static void printEnterAnsTF() {
		System.out.print("Enter answer, 1 for true, 0 for false: ");
	}

	public static void printEnterAns123() {
		System.out.print("Enter answer - 1, 2 or 3: ");
	}

	public static int checkIfDuplicate(int numOfQuestions, List<Integer> questionsAsked, int randomNum) {
		if (!questionsAsked.isEmpty() && questionsAsked.contains(randomNum)) {
			do {
				randomNum = getRandomNumber(numOfQuestions);
			} while (questionsAsked.contains(randomNum));
		}
		return randomNum;
	}

	public static void quizDone(int numOfQuestions, int score) {
		System.out.println("Quiz is done");
		System.out.println("Your score was " + score + " out of " + numOfQuestions);
		System.out.printf("That's %.0f %% correct answers\n\n", (double) score / numOfQuestions * 100);
	}
}

