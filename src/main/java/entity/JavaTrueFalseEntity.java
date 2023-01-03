package entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "javaTrueFalse", schema = "dbProject")
public class  JavaTrueFalseEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "javaTFId")
	private int javaTfId;
	@Basic
	@Column(name = "javaTFQuestion")
	private String javaTfQuestion;
	@Basic
	@Column(name = "javaTFAnswer")
	private Byte javaTfAnswer;

	public int getJavaTfId() {
		return javaTfId;
	}

	public String getJavaTfQuestion() {
		return javaTfQuestion;
	}

	public void setJavaTfQuestion(String javaTfQuestion) {
		this.javaTfQuestion = javaTfQuestion;
	}

	public Byte getJavaTfAnswer() {
		return javaTfAnswer;
	}

	public void setJavaTfAnswer(Byte javaTfAnswer) {
		this.javaTfAnswer = javaTfAnswer;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		JavaTrueFalseEntity that = (JavaTrueFalseEntity) o;

		if (javaTfId != that.javaTfId) return false;
		if (!Objects.equals(javaTfQuestion, that.javaTfQuestion))
			return false;
		return Objects.equals(javaTfAnswer, that.javaTfAnswer);
	}

	@Override
	public int hashCode() {
		int result = javaTfId;
		result = 31 * result + (javaTfQuestion != null ? javaTfQuestion.hashCode() : 0);
		result = 31 * result + (javaTfAnswer != null ? javaTfAnswer.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Question ID: " + javaTfId + "\n" +
				"Question: " + javaTfQuestion + "\n" +
				"Answer: " + javaTfAnswer + "\n";
	}

	public String showQuestion() {
		return "Question: " + javaTfQuestion;
	}
}