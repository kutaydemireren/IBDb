package ibdb.src.model;

import java.util.LinkedList;
import ibdb.src.domain.BookStore;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class BookStores extends BaseModel {

  public LinkedList<BookStore> getBookStores() throws SQLException {
    LinkedList<BookStore> bookStores = new LinkedList<BookStore>();

    String query = "select sid, name, location from Book_stores;";

    Statement st = createStatement();
    ResultSet rs = st.executeQuery(query);

    while (rs.next()) {
      int sid = rs.getInt("sid");
      String name = rs.getString("name");
      String location = rs.getString("location");

      BookStore bookStore = new BookStore(sid, name, location);

      bookStores.add(bookStore);
    }

    rs.close();
    st.close();

    return bookStores;
  }
}
