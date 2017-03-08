package ibdb.src.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import ibdb.src.domain.Author;

public class Authors extends BaseModel {

  /**
  *
  * Get number of books for each author
  * @return LinkedList<Author>
  */
  public LinkedList<Author> getAuthors() throws SQLException {
    LinkedList<Author> authorList = new LinkedList<Author>();

    String query = "select A.name from Books B, Authors A, written_by W where W.name=A.name and B.bid=W.bid;";

    Statement st = createStatement();
    ResultSet rs = st.executeQuery(query);

    while (rs.next()) {
      String name = rs.getString("name");
      Author author = new Author(name);

      authorList.add(author);
    }

    rs.close();
    st.close();

    return authorList;
  }

  public LinkedList<Author> getAuthorsWithCount(String written) throws SQLException {
    LinkedList<Author> authorList = new LinkedList<Author>();

    String query = "select A.name, count(B.name) as count from Books B, Authors A, written_by W where W.name=A.name and B.bid=W.bid and A.name='";
    for(char c : written.toCharArray()) {
	query += c;
    }
    query+="' group by A.name;";

    Statement st = createStatement();
    ResultSet rs = st.executeQuery(query);

    while (rs.next()) {
      int count = rs.getInt("count");
      String name = rs.getString("name");
      Author author = new Author(name, count);

      authorList.add(author);
    }

    rs.close();
    st.close();

    return authorList;
  }
}
