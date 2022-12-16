package quiz;

import entity.JavaTrueFalseEntity;
import entity.PythonTrueFalseEntity;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static tools.QuizTools.*;
import static tools.Tools.getBoolean;

public class PythonTrueFalseQuiz {
	static int quizLength;
	static int score;


	public static void pythonTrueOrFalse(EntityManager entityManager, Scanner sc) {

			score = 0;
			List<PythonTrueFalseEntity> listOfQuestions = new ArrayList<>(entityManager.createQuery("SELECT p FROM PythonTrueFalseEntity p").getResultList());
			quizLength = listOfQuestions.size();

			String player = getPlayerName(sc);
			int numOfQuestions = getNumOfQuestions(sc, quizLength);

			runQuiz(numOfQuestions, listOfQuestions, sc);
		}

		private static void runQuiz(int numOfQuestions, List<PythonTrueFalseEntity> listOfQuestions, Scanner sc) {
			List<Integer> questionsAsked = new ArrayList<>();

			printAndGetInput(numOfQuestions, listOfQuestions, sc, questionsAsked);

			quizDone(numOfQuestions, score);
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
				score++;
			} else {
				System.out.println("You failed successfully!\n");
			}
		}
	}