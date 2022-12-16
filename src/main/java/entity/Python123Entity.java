package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "python123", schema = "dbProject")
public class Python123Entity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "python123Id")
	private int python123Id;
	@Basic
	@Column(name = "python123Question")
	private String python123Question;
	@Basic
	@Column(name = "python123Answer1")
	private String python123Answer1;
	@Basic
	@Column(name = "python123Answer2")
	private String python123Answer2;
	@Basic
	@Column(name = "python123Answer3")
	private String python123Answer3;
	@Basic
	@Column(name = "python123CorrectAnswer")
	private Integer python123CorrectAnswer;

	public int getPython123Id() {
		return python123Id;
	}

	public void setPython123Id(int python123Id) {
		this.python123Id = python123Id;
	}

	public String getPython123Question() {
		return python123Question;
	}

	public void setPython123Question(String python123Question) {
		this.python123Question = python123Question;
	}

	public String getPython123Answer1() {
		return python123Answer1;
	}

	public void setPython123Answer1(String python123Answer1) {
		this.python123Answer1 = python123Answer1;
	}

	public String getPython123Answer2() {
		return python123Answer2;
	}

	public void setPython123Answer2(String python123Answer2) {
		this.python123Answer2 = python123Answer2;
	}

	public String getPython123Answer3() {
		return python123Answer3;
	}

	public void setPython123Answer3(String python123Answer3) {
		this.python123Answer3 = python123Answer3;
	}

	public Integer getPython123CorrectAnswer() {
		return python123CorrectAnswer;
	}

	public void setPython123CorrectAnswer(Integer python123CorrectAnswer) {
		this.python123CorrectAnswer = python123CorrectAnswer;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Python123Entity that = (Python123Entity) o;

		if (python123Id != that.python123Id) return false;
		if (python123Question != null ? !python123Question.equals(that.python123Question) : that.python123Question != null)
			return false;
		if (python123Answer1 != null ? !python123Answer1.equals(that.python123Answer1) : that.python123Answer1 != null)
			return false;
		if (python123Answer2 != null ? !python123Answer2.equals(that.python123Answer2) : that.python123Answer2 != null)
			return false;
		if (python123Answer3 != null ? !python123Answer3.equals(that.python123Answer3) : that.python123Answer3 != null)
			return false;
		if (python123CorrectAnswer != null ? !python123CorrectAnswer.equals(that.python123CorrectAnswer) : that.python123CorrectAnswer != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = python123Id;
		result = 31 * result + (python123Question != null ? python123Question.hashCode() : 0);
		result = 31 * result + (python123Answer1 != null ? python123Answer1.hashCode() : 0);
		result = 31 * result + (python123Answer2 != null ? python123Answer2.hashCode() : 0);
		result = 31 * result + (python123Answer3 != null ? python123Answer3.hashCode() : 0);
		result = 31 * result + (python123CorrectAnswer != null ? python123CorrectAnswer.hashCode() : 0);
		return result;
	}

		@Override
		public String toString() {
			return "Question ID: " + python123Id + "\n" +
					"Question: " + python123Question + "\n" +
					"Answer 1: " + python123Answer1 + "\n" +
					"Answer 2: " + python123Answer2 + "\n" +
					"Answer 3: " + python123Answer3 + "\n" +
					"Correct answer: " + python123CorrectAnswer + "\n";
	}
}
