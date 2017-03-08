package ibdb.src.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import ibdb.src.domain.Book;

public class ReadersOfBooks extends BaseModel {

  /**
  *
  * Get number of readers each book has
  * @return LinkedList<Movie>
  */
  public LinkedList<Book> getReaders(String written) throws SQLException {
    LinkedList<Book> readers = new LinkedList<Book>();

    String query = "select B.name, Count(R.username) as count from Books B, Readers R, Have H where B.bid=H.bid and R.rid=H.rid and B.name='";
    for(char c : written.toCharArray()) {
	query += c;
    }
    query += "' group by B.name;";

    Statement st = createStatement();
    ResultSet rs = st.executeQuery(query);

    while (rs.next()) {
      String bookName = rs.getString("name");
      int count = rs.getInt("count");
      Book book = new Book(bookName, count);

      readers.add(book);
    }

    rs.close();
    st.close();

    return readers;
  }

    public LinkedList<Book> getBooks() throws SQLException {
	LinkedList<Book> books = new LinkedList<Book>();

	String query = "select bid, published_date, name, type from Books;";

	Statement st = createStatement();
	ResultSet rs = st.executeQuery(query);

	while (rs.next()) {
	    long bid = rs.getLong("bid");
	    int published_date = rs.getInt("published_date");
	    String name = rs.getString("name");
	    String type = rs.getString("type");

	    Book book = new Book(bid, published_date, name, type);

	    books.add(book);
	}

	rs.close();
	st.close();

	return books;

    }
}
