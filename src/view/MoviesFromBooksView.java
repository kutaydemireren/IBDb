package ibdb.src.view;

import java.io.PrintWriter;
import ibdb.src.model.MoviesFromBooks;
import ibdb.src.domain.Movie;
import java.util.LinkedList;
import java.sql.SQLException;

public class MoviesFromBooksView {
  private static PrintWriter out;

  public static void setWriter(PrintWriter out) {
    MoviesFromBooksView.out = out;
  }

  public static void printMoviesFromBooksPage(MoviesFromBooks moviesFromBooks) {
    MoviesFromBooksView.printButtons();
    MoviesFromBooksView.printHeader();
    MoviesFromBooksView.printMovies(moviesFromBooks);
  }

  private static void printHeader() {
    out.println("<h1>Adapted Movies</h1>");
    out.println("<p>Here you can find which movies are adapted from books.</p>");
  }

  private static void printMovies(MoviesFromBooks moviesFromBooks) {
    out.println("<table>");

    try {
      LinkedList<Movie> movies = moviesFromBooks.getAdaptedMovies();
      for (int i=0; i< movies.size(); i++) {
        Movie movie = movies.get(i);
        out.println(movie.toHTMLWithBook());
      }
    } catch(SQLException sqle) {
      sqle.printStackTrace(out);
    }

  }

  private static void printButtons() {
    out.println("<button type=\"button\" onclick=\"NavigateToHome()\">Home</button>");
    out.println("<button type=\"button\" onclick=\"NavigateToBooks()\">Books</button>");
    out.println("<button type=\"button\" onclick=\"NavigateToAuthors()\">Authors</button>");
    out.println("<button type=\"button\" onclick=\"NavigateToBookStores()\">Book Stores</button>");
    out.println("<button type=\"button\" onclick=\"NavigateToLibraries()\">Libraries</button>");

    out.println("<script>");
    out.println("function NavigateToHome(){ window.location = \"http://cs.drexel.edu:8080/~kd653/ibdb\"; }");
    out.println("function NavigateToBooks(){ window.location = \"http://cs.drexel.edu:8080/~kd653/ibdb/books\"; }");
    out.println("function NavigateToAuthors(){ window.location = \"http://cs.drexel.edu:8080/~kd653/ibdb/authors\"; }");
    out.println("function NavigateToBookStores(){ window.location = \"http://cs.drexel.edu:8080/~kd653/ibdb/book_stores\"; }");
    out.println("function NavigateToLibraries(){ window.location = \"http://cs.drexel.edu:8080/~kd653/ibdb/libraries\"; }");
    out.println("</script>");
  }
}
