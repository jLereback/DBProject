package entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "leaderboard", schema = "dbProject")
public class LeaderboardEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "leaderboardId")
	private int leaderboardId;
	@Basic
	@Column(name = "LBPlayerName")
	private String lbPlayerName;
	@Basic
	@Column(name = "LBJavaTFScore")
	private Integer lbJavaTfScore;
	@Basic
	@Column(name = "LBJava123Score")
	private Integer lbJava123Score;
	@Basic
	@Column(name = "LBPythonTFScore")
	private Integer lbPythonTfScore;
	@Basic
	@Column(name = "LBPython123Score")
	private Integer lbPython123Score;

	public int getLeaderboardId() {
		return leaderboardId;
	}

	public void setLeaderboardId(int leaderboardId) {
		this.leaderboardId = leaderboardId;
	}

	public String getLbPlayerName() {
		return lbPlayerName;
	}

	public void setLbPlayerName(String lbPlayerName) {
		this.lbPlayerName = lbPlayerName;
	}

	public Integer getLbJavaTfScore() {
		return lbJavaTfScore;
	}

	public void setLbJavaTfScore(Integer lbJavaTfScore) {
		this.lbJavaTfScore = lbJavaTfScore;
	}

	public Integer getLbJava123Score() {
		return lbJava123Score;
	}

	public void setLbJava123Score(Integer lbJava123Score) {
		this.lbJava123Score = lbJava123Score;
	}

	public Integer getLbPythonTfScore() {
		return lbPythonTfScore;
	}

	public void setLbPythonTfScore(Integer lbPythonTfScore) {
		this.lbPythonTfScore = lbPythonTfScore;
	}

	public Integer getLbPython123Score() {
		return lbPython123Score;
	}

	public void setLbPython123Score(Integer lbPython123Score) {
		this.lbPython123Score = lbPython123Score;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LeaderboardEntity that = (LeaderboardEntity) o;
		return leaderboardId == that.leaderboardId && Objects.equals(lbPlayerName, that.lbPlayerName) && Objects.equals(lbJavaTfScore, that.lbJavaTfScore) && Objects.equals(lbJava123Score, that.lbJava123Score) && Objects.equals(lbPythonTfScore, that.lbPythonTfScore) && Objects.equals(lbPython123Score, that.lbPython123Score);
	}

	@Override
	public int hashCode() {
		return Objects.hash(leaderboardId, lbPlayerName, lbJavaTfScore, lbJava123Score, lbPythonTfScore, lbPython123Score);
	}

	@Override
	public String toString() {
		return "LeaderboardEntity{" +
				"leaderboardId=" + leaderboardId +
				", lbPlayerName='" + lbPlayerName + '\'' +
				", lbJavaTfScore=" + lbJavaTfScore +
				", lbJava123Score=" + lbJava123Score +
				", lbPythonTfScore=" + lbPythonTfScore +
				", lbPython123Score=" + lbPython123Score +
				'}';
	}

	public String javaTfLeaderboard() {
		return lbPlayerName + ", "+ lbJavaTfScore;
	}

	public String java123Leaderboard() {
		return lbPlayerName + ", "+ lbJava123Score;
	}

	public String pythonTfLeaderboard() {
		return lbPlayerName + ", "+ lbPythonTfScore;
	}

	public String python123Leaderboard() {
		return lbPlayerName + ", "+ lbPython123Score;
	}
}
