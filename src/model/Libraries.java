package ibdb.src.model;

import java.util.LinkedList;
import ibdb.src.domain.Library;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Libraries extends BaseModel {

  public LinkedList<Library> getLibraries() throws SQLException {
    LinkedList<Library> libraries = new LinkedList<Library>();

    String query = "select lid, location, name from Libraries;";

    Statement st = createStatement();
    ResultSet rs = st.executeQuery(query);

    while (rs.next()) {
      int lid = rs.getInt("lid");
      String name = rs.getString("name");
      String location = rs.getString("location");

      Library library = new Library(lid, location, name);

      libraries.add(library);
    }

    rs.close();
    st.close();

    return libraries;
  }
}
