package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "java1x2", schema = "dbProject", catalog = "")
public class Java1X2Entity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "java1x2Id")
	private int java1X2Id;
	@Basic
	@Column(name = "java1x2Question")
	private String java1X2Question;
	@Basic
	@Column(name = "java1x2Answer1")
	private String java1X2Answer1;
	@Basic
	@Column(name = "java1x2Answer2")
	private String java1X2Answer2;
	@Basic
	@Column(name = "java1x2Answer3")
	private String java1X2Answer3;
	@Basic
	@Column(name = "java1x2CorrectAnswer")
	private Integer java1X2CorrectAnswer;

	public int getJava1X2Id() {
		return java1X2Id;
	}

	public void setJava1X2Id(int java1X2Id) {
		this.java1X2Id = java1X2Id;
	}

	public String getJava1X2Question() {
		return java1X2Question;
	}

	public void setJava1X2Question(String java1X2Question) {
		this.java1X2Question = java1X2Question;
	}

	public String getJava1X2Answer1() {
		return java1X2Answer1;
	}

	public void setJava1X2Answer1(String java1X2Answer1) {
		this.java1X2Answer1 = java1X2Answer1;
	}

	public String getJava1X2Answer2() {
		return java1X2Answer2;
	}

	public void setJava1X2Answer2(String java1X2Answer2) {
		this.java1X2Answer2 = java1X2Answer2;
	}

	public String getJava1X2Answer3() {
		return java1X2Answer3;
	}

	public void setJava1X2Answer3(String java1X2Answer3) {
		this.java1X2Answer3 = java1X2Answer3;
	}

	public Integer getJava1X2CorrectAnswer() {
		return java1X2CorrectAnswer;
	}

	public void setJava1X2CorrectAnswer(Integer java1X2CorrectAnswer) {
		this.java1X2CorrectAnswer = java1X2CorrectAnswer;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Java1X2Entity that = (Java1X2Entity) o;

		if (java1X2Id != that.java1X2Id) return false;
		if (java1X2Question != null ? !java1X2Question.equals(that.java1X2Question) : that.java1X2Question != null)
			return false;
		if (java1X2Answer1 != null ? !java1X2Answer1.equals(that.java1X2Answer1) : that.java1X2Answer1 != null)
			return false;
		if (java1X2Answer2 != null ? !java1X2Answer2.equals(that.java1X2Answer2) : that.java1X2Answer2 != null)
			return false;
		if (java1X2Answer3 != null ? !java1X2Answer3.equals(that.java1X2Answer3) : that.java1X2Answer3 != null)
			return false;
		if (java1X2CorrectAnswer != null ? !java1X2CorrectAnswer.equals(that.java1X2CorrectAnswer) : that.java1X2CorrectAnswer != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = java1X2Id;
		result = 31 * result + (java1X2Question != null ? java1X2Question.hashCode() : 0);
		result = 31 * result + (java1X2Answer1 != null ? java1X2Answer1.hashCode() : 0);
		result = 31 * result + (java1X2Answer2 != null ? java1X2Answer2.hashCode() : 0);
		result = 31 * result + (java1X2Answer3 != null ? java1X2Answer3.hashCode() : 0);
		result = 31 * result + (java1X2CorrectAnswer != null ? java1X2CorrectAnswer.hashCode() : 0);
		return result;
	}
}
