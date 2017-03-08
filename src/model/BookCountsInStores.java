package ibdb.src.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import ibdb.src.domain.BookStore;

public class BookCountsInStores extends BaseModel {

  /**
  *
  * Get number of Books each Bookstore has
  * @return LinkedList<Movie>
  */
  public LinkedList<BookStore> getBookStores() throws SQLException {
    LinkedList<BookStore> bookStores = new LinkedList<BookStore>();

    String query = "select distinct K.name from Books B, Book_stores K, sold_in S where B.bid=S.bid and K.sid=S.sid;";

    Statement st = createStatement();
    ResultSet rs = st.executeQuery(query);

    while (rs.next()) {
      String storeName = rs.getString("name");
      BookStore bookStore = new BookStore(storeName);

      bookStores.add(bookStore);
    }

    rs.close();
    st.close();

    return bookStores;
  }

  public LinkedList<BookStore> getBookCount(String written) throws SQLException {
    LinkedList<BookStore> bookStores = new LinkedList<BookStore>();

    String query = "select K.name, Count(B.name) as count from Books B, Book_stores K, sold_in S where B.bid=S.bid and K.sid=S.sid and K.name='";
    for(char c : written.toCharArray()) {
	query += c;
    }

    query+="' group by K.name;";

    Statement st = createStatement();
    ResultSet rs = st.executeQuery(query);

    while (rs.next()) {
      String storeName = rs.getString("name");
      int count = rs.getInt("count");
      BookStore bookStore = new BookStore(storeName, count);

      bookStores.add(bookStore);
    }

    rs.close();
    st.close();

    return bookStores;
  }
}
