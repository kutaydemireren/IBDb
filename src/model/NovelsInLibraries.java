package ibdb.src.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import ibdb.src.domain.Book;

public class NovelsInLibraries extends BaseModel {

  /**
  *
  * Get books shared by libraries that are novels
  * @return LinkedList<Movie>
  */
  public LinkedList<Book> getNovels() throws SQLException {
    LinkedList<Book> novels = new LinkedList<Book>();

    String query = "select L.name as library, B.name as novel from Books B, Libraries L, share S where B.bid=S.bid and L.lid=S.lid and B.type='novel';";

    Statement st = createStatement();
    ResultSet rs = st.executeQuery(query);

    while (rs.next()) {
      String library = rs.getString("library");
      String novelName = rs.getString("novel");
      Book novel = new Book(novelName, library);

      novels.add(novel);
    }

    rs.close();
    st.close();

    return novels;
  }

 public LinkedList<Book> getNovels(String written) throws SQLException {
     LinkedList<Book> novels = new LinkedList<Book>();
     
     String query = "select L.name as library, B.name as novel from Books B, Libraries L, share S where B.bid=S.bid and L.lid=S.lid and B.type='novel' and L.name='";
     for(char c : written.toCharArray()) {
	 query += c;
     }
     query += "';";
    Statement st = createStatement();
    ResultSet rs = st.executeQuery(query);

    while (rs.next()) {
	String library = rs.getString("library");
	String novelName = rs.getString("novel");
	Book novel = new Book(novelName, library);

	novels.add(novel);
    }

    rs.close();
    st.close();

    return novels;
    }
}
