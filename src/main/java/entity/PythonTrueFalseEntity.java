package entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "pythonTrueFalse", schema = "dbProject")
public class PythonTrueFalseEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "pythonTFId")
	private int pythonTfId;
	@Basic
	@Column(name = "pythonTFQuestion")
	private String pythonTfQuestion;
	@Basic
	@Column(name = "pythonTFAnswer")
	private Byte pythonTfAnswer;

	public int getPythonTfId() {
		return pythonTfId;
	}

	public String getPythonTfQuestion() {
		return pythonTfQuestion;
	}

	public void setPythonTfQuestion(String pythonTfQuestion) {
		this.pythonTfQuestion = pythonTfQuestion;
	}

	public Byte getPythonTfAnswer() {
		return pythonTfAnswer;
	}

	public void setPythonTfAnswer(Byte pythonTfAnswer) {
		this.pythonTfAnswer = pythonTfAnswer;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		PythonTrueFalseEntity that = (PythonTrueFalseEntity) o;

		if (pythonTfId != that.pythonTfId) return false;
		if (!Objects.equals(pythonTfQuestion, that.pythonTfQuestion))
			return false;
		return Objects.equals(pythonTfAnswer, that.pythonTfAnswer);
	}

	@Override
	public int hashCode() {
		int result = pythonTfId;
		result = 31 * result + (pythonTfQuestion != null ? pythonTfQuestion.hashCode() : 0);
		result = 31 * result + (pythonTfAnswer != null ? pythonTfAnswer.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Question ID: " + pythonTfId + "\n" +
				"Question: " + pythonTfQuestion + "\n" +
				"Answer: " + pythonTfAnswer + "\n";
	}

	public String showQuestion() {
		return "Question: " + pythonTfQuestion;
	}
}