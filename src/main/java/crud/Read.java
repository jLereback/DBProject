package crud;

import entity.LeaderboardEntity;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class Read {
	public static void printPython123(EntityManager entityManager) {
		entityManager.createQuery("SELECT p FROM Python123Entity p")
				.getResultStream().map(result -> result.toString()).forEach(System.out::println);
	}

	public static void printPythonTrueFalse(EntityManager entityManager) {
		entityManager.createQuery("SELECT p FROM PythonTrueFalseEntity p")
				.getResultStream().map(result -> result.toString()).forEach(System.out::println);
	}

	public static void printJava123(EntityManager entityManager) {
		entityManager.createQuery("SELECT j FROM Java123Entity j")
				.getResultStream().map(result -> result.toString()).forEach(System.out::println);
	}

	public static void printJavaTrueFalse(EntityManager entityManager) {
		entityManager.createQuery("SELECT j FROM JavaTrueFalseEntity j")
				.getResultStream().map(result -> result.toString()).forEach(System.out::println);
	}

	public static void printPython123Leaderboard(EntityManager entityManager) {
		List<LeaderboardEntity> players = new ArrayList<>(entityManager.createQuery("SELECT l FROM LeaderboardEntity l").getResultList());
		System.out.println("Player\t\tScore(%)");
		players.forEach(player -> System.out.println(player.python123Leaderboard()));
	}

	public static void printJavaTfLeaderboard(EntityManager entityManager) {
		List<LeaderboardEntity> players = new ArrayList<>(entityManager.createQuery("SELECT l FROM LeaderboardEntity l").getResultList());
		System.out.println("Player\t\tScore(%)");
		players.forEach(player -> System.out.println(player.javaTfLeaderboard()));
	}

	public static void printJava123Leaderboard(EntityManager entityManager) {
		List<LeaderboardEntity> players = new ArrayList<>(entityManager.createQuery("SELECT l FROM LeaderboardEntity l").getResultList());
		System.out.println("Player\t\tScore(%)");
		players.forEach(player -> System.out.println(player.java123Leaderboard()));
	}

	public static void printPythonTfLeaderboard(EntityManager entityManager) {
		List<LeaderboardEntity> players = new ArrayList<>(entityManager.createQuery("SELECT l FROM LeaderboardEntity l").getResultList());
		System.out.println("Player\t\tScore(%)");
		players.forEach(player -> System.out.println(player.pythonTfLeaderboard()));
	}

	public static void printTotalNumOfPlayers(EntityManager entityManager) {
		System.out.println("Total number of players are " + entityManager.createQuery("SELECT COUNT(lbPlayerName) FROM LeaderboardEntity").getSingleResult());
	}
}