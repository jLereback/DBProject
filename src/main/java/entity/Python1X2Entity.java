package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "python1x2", schema = "dbProject", catalog = "")
public class Python1X2Entity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "python1x2Id")
	private int python1X2Id;
	@Basic
	@Column(name = "python1x2Question")
	private String python1X2Question;
	@Basic
	@Column(name = "python1x2Answer1")
	private String python1X2Answer1;
	@Basic
	@Column(name = "python1x2Answer2")
	private String python1X2Answer2;
	@Basic
	@Column(name = "python1x2Answer3")
	private String python1X2Answer3;
	@Basic
	@Column(name = "python1x2CorrectAnswer")
	private Integer python1X2CorrectAnswer;

	public int getPython1X2Id() {
		return python1X2Id;
	}

	public void setPython1X2Id(int python1X2Id) {
		this.python1X2Id = python1X2Id;
	}

	public String getPython1X2Question() {
		return python1X2Question;
	}

	public void setPython1X2Question(String python1X2Question) {
		this.python1X2Question = python1X2Question;
	}

	public String getPython1X2Answer1() {
		return python1X2Answer1;
	}

	public void setPython1X2Answer1(String python1X2Answer1) {
		this.python1X2Answer1 = python1X2Answer1;
	}

	public String getPython1X2Answer2() {
		return python1X2Answer2;
	}

	public void setPython1X2Answer2(String python1X2Answer2) {
		this.python1X2Answer2 = python1X2Answer2;
	}

	public String getPython1X2Answer3() {
		return python1X2Answer3;
	}

	public void setPython1X2Answer3(String python1X2Answer3) {
		this.python1X2Answer3 = python1X2Answer3;
	}

	public Integer getPython1X2CorrectAnswer() {
		return python1X2CorrectAnswer;
	}

	public void setPython1X2CorrectAnswer(Integer python1X2CorrectAnswer) {
		this.python1X2CorrectAnswer = python1X2CorrectAnswer;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Python1X2Entity that = (Python1X2Entity) o;

		if (python1X2Id != that.python1X2Id) return false;
		if (python1X2Question != null ? !python1X2Question.equals(that.python1X2Question) : that.python1X2Question != null)
			return false;
		if (python1X2Answer1 != null ? !python1X2Answer1.equals(that.python1X2Answer1) : that.python1X2Answer1 != null)
			return false;
		if (python1X2Answer2 != null ? !python1X2Answer2.equals(that.python1X2Answer2) : that.python1X2Answer2 != null)
			return false;
		if (python1X2Answer3 != null ? !python1X2Answer3.equals(that.python1X2Answer3) : that.python1X2Answer3 != null)
			return false;
		if (python1X2CorrectAnswer != null ? !python1X2CorrectAnswer.equals(that.python1X2CorrectAnswer) : that.python1X2CorrectAnswer != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = python1X2Id;
		result = 31 * result + (python1X2Question != null ? python1X2Question.hashCode() : 0);
		result = 31 * result + (python1X2Answer1 != null ? python1X2Answer1.hashCode() : 0);
		result = 31 * result + (python1X2Answer2 != null ? python1X2Answer2.hashCode() : 0);
		result = 31 * result + (python1X2Answer3 != null ? python1X2Answer3.hashCode() : 0);
		result = 31 * result + (python1X2CorrectAnswer != null ? python1X2CorrectAnswer.hashCode() : 0);
		return result;
	}
}
