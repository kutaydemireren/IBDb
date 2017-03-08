package ibdb.src.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import ibdb.src.domain.Book;

public class MainEntrance extends BaseModel  {

  public LinkedList<Book> getResult(String written) throws SQLException {
    LinkedList<Book> books = new LinkedList<Book>();

    String query = "select B.published_date, B.name as bName, B.type, A.name as aName from Books B, Authors A, written_by W where (W.name=A.name and W.DOB=A.DOB) and W.bid=B.bid and B.name='";
    for(char c : written.toCharArray()) {
      query += c;
    }
    query += "';";

    Statement st = createStatement();
    ResultSet rs = st.executeQuery(query);

    while(rs.next()) {
      int published_date = rs.getInt("published_date");
      String bName = rs.getString("bName");
      String type = rs.getString("type");
      String aName = rs.getString("aName");

      Book book = new Book(published_date, bName, type, aName);

      books.add(book);
    }

    rs.close();
    st.close();

    return books;
  }
}
