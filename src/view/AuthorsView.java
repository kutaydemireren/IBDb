package ibdb.src.view;

import java.io.PrintWriter;
import java.util.LinkedList;
import ibdb.src.domain.Author;
import ibdb.src.model.Authors;
import java.sql.SQLException;

public class AuthorsView {
  private static PrintWriter out;

  public static void setWriter(PrintWriter out) {
    AuthorsView.out = out;
  }

    public static void printAuthorsPage(String written, Authors authors) {
	AuthorsView.printButtons();
	AuthorsView.printHeader();
	AuthorsView.printAuthors(authors);
	AuthorsView.printBookCount(written, authors);
    }

  private static void printHeader() {
    out.println("<h1>Authors</h1>");
    out.println("<p>Here, you can see for each author how many books s/he wrote</p>");
  }

  private static void printAuthors(Authors authors) {
    out.println("<form>");
    try {
      LinkedList<Author> authorList = authors.getAuthors();
      for (int i=0; i< authorList.size(); i++) {
        Author author = authorList.get(i);
        out.println("<input type=\"radio\" name=\"authorName\" value='" + author.getFullName() + "'> " + author.getFullName() +"<br>");
      }
    out.println("<input type=\"submit\" value=\"Reveal!\">");
    } catch(SQLException sqle) {
      sqle.printStackTrace(out);
    }
    out.println("</form>");
  }

    private static void printBookCount(String written, Authors authors) {
    out.println("<table>");

    try {
	if(written !=null) {
	    LinkedList<Author> authorList = authors.getAuthorsWithCount(written);
	    Author author = authorList.get(0);
	    out.println(written + "has " + author.getBooksWritten());
	}
    } catch(SQLException sqle) {
	sqle.printStackTrace(out);
    }
  }

  private static void printButtons() {
    out.println("<button type=\"button\" onclick=\"NavigateToHome()\">Home</button>");
    out.println("<button type=\"button\" onclick=\"NavigateToBooks()\">Books</button>");
    out.println("<button type=\"button\" onclick=\"NavigateToAuthors()\" disabled>Authors</button>");
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
