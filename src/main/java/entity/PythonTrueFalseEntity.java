package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pythonTrueFalse", schema = "dbProject", catalog = "")
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

	public void setPythonTfId(int pythonTfId) {
		this.pythonTfId = pythonTfId;
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
		if (pythonTfQuestion != null ? !pythonTfQuestion.equals(that.pythonTfQuestion) : that.pythonTfQuestion != null)
			return false;
		if (pythonTfAnswer != null ? !pythonTfAnswer.equals(that.pythonTfAnswer) : that.pythonTfAnswer != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = pythonTfId;
		result = 31 * result + (pythonTfQuestion != null ? pythonTfQuestion.hashCode() : 0);
		result = 31 * result + (pythonTfAnswer != null ? pythonTfAnswer.hashCode() : 0);
		return result;
	}
}
