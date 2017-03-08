package ibdb.src.view;

import java.io.PrintWriter;
import ibdb.src.model.Libraries;
import java.util.LinkedList;
import ibdb.src.domain.Library;
import java.sql.SQLException;

public class LibrariesView {
  private static PrintWriter out;

  public static void setWriter(PrintWriter out) {
    LibrariesView.out = out;
  }

  public static void printLibrariesPage(Libraries libraries) {
    LibrariesView.printButtons();
    LibrariesView.printHeader();
    LibrariesView.printContent(libraries);
    LibrariesView.printNovels();
  }

  private static void printHeader() {
    out.println("<h1>Libraries</h1>");
  }

  private static void printContent(Libraries libraries) {
    out.println("<table>");
    out.println("<tr><td>name </td><td>|  location </td><td></tr>");
    try {
      LinkedList<Library> libraryList = libraries.getLibraries();
      for (int i=0; i< libraryList.size(); i++) {
        Library library = libraryList.get(i);
        out.println(library.toHTML());
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
    out.println("<button type=\"button\" onclick=\"NavigateToLibraries()\" disabled>Libraries</button>");

    out.println("<script>");
    out.println("function NavigateToHome(){ window.location = \"http://cs.drexel.edu:8080/~kd653/ibdb\"; }");
    out.println("function NavigateToBooks(){ window.location = \"http://cs.drexel.edu:8080/~kd653/ibdb/books\"; }");
    out.println("function NavigateToAuthors(){ window.location = \"http://cs.drexel.edu:8080/~kd653/ibdb/authors\"; }");
    out.println("function NavigateToBookStores(){ window.location = \"http://cs.drexel.edu:8080/~kd653/ibdb/book_stores\"; }");
    out.println("function NavigateToLibraries(){ window.location = \"http://cs.drexel.edu:8080/~kd653/ibdb/libraries\"; }");
    out.println("</script>");
  }

  private static void printNovels() {
    out.println("<button type=\"button\" onclick=\"NavigateToNovelBooks()\">See Novels!</button>");
    out.println("<script>");
    out.println("function NavigateToNovelBooks(){ window.location = \"http://cs.drexel.edu:8080/~kd653/ibdb/libraries/novels\"; }");
    out.println("</script>");
  }
}
