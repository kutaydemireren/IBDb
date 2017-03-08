package ibdb.src.domain;

import java.sql.Date;

public class Movie {
	private int mid;
	private String name;
	private Date release_date;
	private String book;

	public Movie(String name) {
		this.name = name;
	}

	public Movie(String name, String book) {
		this.name = name;
		this.book = book;
	}
	public Movie(int mid, String name, Date release_date) {
		this.mid = mid;
		this.name = name;
		this.release_date = release_date;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRelease_date() {
		return release_date;
	}

	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}

	@Override
	public String toString() {
		return "Movie [name=" + name + ", release_date=" + release_date + "]";
	}

	public String toHTML() {
		return "<tr><td>" + name + "</td><td>" + release_date.toString() + "</td><td></tr>";
	}

	public String toHTMLOnlyNames() {
		return "<tr><td>" + name + "</td><td></tr>";
	}

	public String toHTMLWithBook() {
		return "<tr><td>" + name + "</td><td>" + book + "</td><td></tr>";
	}
}
