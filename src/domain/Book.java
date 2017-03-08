package ibdb.src.domain;

public class Book {
	private long bid;
	private int published_date;
	private String name;
	private String type;
	private String library;
	private int readerCount;
	private String authorName;

	public Book(String name, String library) {
		this.name = name;
		this.library = library;
	}

	public Book(String name, int readerCount) {
		this.name = name;
		this.readerCount = readerCount;
	}

	public Book(long bid, int published_date, String name, String type) {
		this.bid = bid;
		this.published_date = published_date;
		this.name = name;
		this.type = type;
	}

	public Book(int published_date, String name, String type, String authorName) {
		this.published_date = published_date;
		this.name = name;
		this.type = type;
		this.authorName = authorName;
	}

	public int getReaderCount() {
		return readerCount;
	}

	public int getPublished_date() {
		return published_date;
	}

	public void setPublished_date(int published_date) {
		this.published_date = published_date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getBid() {
		return bid;
	}

	public void setBid(long bid) {
		this.bid = bid;
	}

	public String getLibrary() {
		return library;
	}

	@Override
	public String toString() {
		return "Book [published_date=" + published_date + ", name=" + name + ", type=" + type + "]";
	}

	public String toStringWithAuthor() {
		return "Book [published_date=" + published_date + ", name=" + name + ", type=" + type + ", author name=" + authorName + "]";
	}

	public String toHTML() {
		return "<tr><td>" + name  + "</td><td>|  " + published_date + "</td><td>|  " + type + "</td><td></tr>";
	}

	public String toHTMLWithLibrary() {
		return "<tr><td>" + library + "</td><td>" + name + "</td><td></tr>";
	}

	public String toHTMLWithReaderCount() {
		return "<tr><td>" + name + "</td><td>" + readerCount + "</td><td></tr>";
	}
}
