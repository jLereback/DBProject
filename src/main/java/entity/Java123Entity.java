package entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity

@Table(name = "java123", schema = "dbProject")
public class Java123Entity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "java123Id")
	private int java123Id;
	@Basic
	@Column(name = "java123Question")
	private String java123Question;
	@Basic
	@Column(name = "java123Answer1")
	private String java123Answer1;
	@Basic
	@Column(name = "java123Answer2")
	private String java123Answer2;
	@Basic
	@Column(name = "java123Answer3")
	private String java123Answer3;
	@Basic
	@Column(name = "java123CorrectAnswer")
	private Integer java123CorrectAnswer;

	public int getJava123Id() {
		return java123Id;
	}

	public String getJava123Question() {
		return java123Question;
	}

	public void setJava123Question(String java123Question) {
		this.java123Question = java123Question;
	}

	public void setjava123Answer1(String java123Answer1) {
		this.java123Answer1 = java123Answer1;
	}

	public void setjava123Answer2(String java123Answer2) {
		this.java123Answer2 = java123Answer2;
	}


	public void setjava123Answer3(String java123Answer3) {
		this.java123Answer3 = java123Answer3;
	}

	public Integer getJava123CorrectAnswer() {
		return java123CorrectAnswer;
	}

	public void setjava123CorrectAnswer(Integer java123CorrectAnswer) {
		this.java123CorrectAnswer = java123CorrectAnswer;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Java123Entity that = (Java123Entity) o;

		if (java123Id != that.java123Id) return false;
		if (!Objects.equals(java123Question, that.java123Question))
			return false;
		if (!Objects.equals(java123Answer1, that.java123Answer1))
			return false;
		if (!Objects.equals(java123Answer2, that.java123Answer2))
			return false;
		if (!Objects.equals(java123Answer3, that.java123Answer3))
			return false;
		return Objects.equals(java123CorrectAnswer, that.java123CorrectAnswer);
	}

	@Override
	public int hashCode() {
		int result = java123Id;
		result = 31 * result + (java123Question != null ? java123Question.hashCode() : 0);
		result = 31 * result + (java123Answer1 != null ? java123Answer1.hashCode() : 0);
		result = 31 * result + (java123Answer2 != null ? java123Answer2.hashCode() : 0);
		result = 31 * result + (java123Answer3 != null ? java123Answer3.hashCode() : 0);
		result = 31 * result + (java123CorrectAnswer != null ? java123CorrectAnswer.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Question ID: " + java123Id + "\n" +
				"Question: " + java123Question + "\n" +
				"Answer 1: " + java123Answer1 + "\n" +
				"Answer 2: " + java123Answer2 + "\n" +
				"Answer 3: " + java123Answer3 + "\n" +
				"Correct answer: " + java123CorrectAnswer + "\n";
	}

	public String showQuestion() {
		return "Question: " + java123Question + "\n" +
				"Answer 1: " + java123Answer1 + "\n" +
				"Answer 2: " + java123Answer2 + "\n" +
				"Answer 3: " + java123Answer3;
	}
}