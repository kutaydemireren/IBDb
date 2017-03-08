package ibdb.src.domain;

public class BookStore {
  private int sid;
  private String name;
  private String location;
  private int bookCount;

  public BookStore(String name) {
    this.name = name;
  }

  public BookStore(String name, int bookCount) {
    this.name = name;
    this.bookCount = bookCount;
  }

  public BookStore(int sid, String name, String location) {
    this.sid = sid;
    this.name = name;
    this.location = location;
  }

  public int getSid() {
    return sid;
  }

  public void setSid(int sid) {
    this.sid = sid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public int getBookCount() {
    return bookCount;
  }

  public void setBookCount(int bookCount) {
    this.bookCount = bookCount;
  }

  @Override
  public String toString() {
    return "BookStore [name=" + name + ", location=" + location + "]";
  }

  public String toHTML() {
		return "<tr><td>" + name + "</td><td>|  " + location + "</td><td></tr>";
	}

  public String toHTMLWithBookCounts() {
    return "<tr><td>" + name + "</td><td>" + bookCount + "</td><td></tr>";
  }
}
