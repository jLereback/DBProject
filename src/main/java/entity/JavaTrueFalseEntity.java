package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "javaTrueFalse", schema = "dbProject", catalog = "")
public class JavaTrueFalseEntity {
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

	public void setJavaTfId(int javaTfId) {
		this.javaTfId = javaTfId;
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
		if (javaTfQuestion != null ? !javaTfQuestion.equals(that.javaTfQuestion) : that.javaTfQuestion != null)
			return false;
		if (javaTfAnswer != null ? !javaTfAnswer.equals(that.javaTfAnswer) : that.javaTfAnswer != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = javaTfId;
		result = 31 * result + (javaTfQuestion != null ? javaTfQuestion.hashCode() : 0);
		result = 31 * result + (javaTfAnswer != null ? javaTfAnswer.hashCode() : 0);
		return result;
	}
}
