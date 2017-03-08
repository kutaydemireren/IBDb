package ibdb.src.view;

import java.io.PrintWriter;
import ibdb.src.model.MainEntrance;
import java.sql.SQLException;
import java.util.LinkedList;
import ibdb.src.domain.Book;

public class MainEntranceView {
  private static PrintWriter out;

  public static void setWriter(PrintWriter out) {
    MainEntranceView.out = out;
  }

  public static void printMainPage(String written, MainEntrance mainEntrance) {
    MainEntranceView.printButtons();
    MainEntranceView.printHeader();
    MainEntranceView.printSearchInput();
    MainEntranceView.printResultParagraph(written, mainEntrance);
  }

  private static void printHeader() {
    out.println("<h1>World's largest Internet Book Database, IBDb!</h1>");
  }

  private static void printSearchInput() {
    out.println("<form>Type a book name to search:<br> <input type=\"text\" name=\"bookName\" id=\"bookName\")> <input type=\"submit\" value=\"Search\"></form>");
  }

  private static void printResultParagraph(String written, MainEntrance mainEntrance) {
    if(written == null) {
      out.println("<p id=\"resultParagraph\">Make a search to see information about a book</p>");
    } else {
      try {
        out.println("<p>" + written +"</p>");
        LinkedList<Book> books = mainEntrance.getResult(written);
        for(int i = 0; i < books.size(); i++) {
          Book aBook = books.get(i);
          out.println("<p id=\"resultParagraph\">" + aBook.toStringWithAuthor() +"</p>");
        }
      } catch(SQLException sqle) {
        sqle.printStackTrace(out);
      }
    }
  }

  private static void printButtons() {
    out.println("<button type=\"button\" onclick=\"NavigateToHome()\" disabled>Home</button>");
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
