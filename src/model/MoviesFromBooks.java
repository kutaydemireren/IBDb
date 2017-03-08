package ibdb.src.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import ibdb.src.domain.Movie;

public class MoviesFromBooks extends BaseModel {

  /**
  *
  * Get names of books with a movie adaptation
  * @return LinkedList<Movie>
  */
  public LinkedList<Movie> getAdaptedMovies() throws SQLException {
    LinkedList<Movie> movies = new LinkedList<Movie>();

    String query = "select M.name as movie, B.name as book from Movies M, Books B, based_on O where M.mid=O.mid and B.bid=O.bid;";

    Statement st = createStatement();
    ResultSet rs = st.executeQuery(query);

    while (rs.next()) {
      String name = rs.getString("movie");
      String book = rs.getString("book");
      Movie movie = new Movie(name, book);

      movies.add(movie);
    }

    rs.close();
    st.close();

    return movies;
  }
}
