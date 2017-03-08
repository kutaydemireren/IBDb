package ibdb.src.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import ibdb.src.domain.Book;

public class Books extends BaseModel {

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
