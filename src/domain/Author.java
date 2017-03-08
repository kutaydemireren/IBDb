package ibdb.src.domain;

import java.util.Date;

public class Author {
	private Date DOB;
	private String full_name;
	private int books_written;

	public Author(String full_name) {
		this.full_name = full_name;
	}

	public Author(String full_name, int books_written) {
		this.full_name = full_name;
		this.books_written = books_written;
	}

	public Author(Date dOB, String full_name) {
		DOB = dOB;
		this.full_name = full_name;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public String getFullName() {
		return full_name;
	}

	public void setFullName(String full_name) {
		this.full_name = full_name;
	}

	public int getBooksWritten() {
		return books_written;
	}

	public void setBooksWritten(int books_written) {
		this.books_written = books_written;
	}

	@Override
	public String toString() {
		return "Author [DOB=" + DOB + ", full_name=" + full_name + "]";
	}

	public String toHTML() {
		return "<tr><td>" + DOB.toString() + "</td><td>" + full_name + "</td><td></tr>";
	}

	public String toHTMLCount() {
		return "<tr><td>" + full_name + "</td><td>" + books_written + "</td><td></tr>";
	}
}
