package ibdb.src.view;

import java.io.PrintWriter;
import ibdb.src.model.BookStores;
import java.util.LinkedList;
import ibdb.src.domain.BookStore;
import java.sql.SQLException;

public class BookStoresView {
  private static PrintWriter out;

  public static void setWriter(PrintWriter out) {
    BookStoresView.out = out;
  }

  public static void printBookStoresPage(BookStores bookStores) {
    BookStoresView.printButtons();
    BookStoresView.printHeader();
    BookStoresView.printContent(bookStores);
    BookStoresView.printBookCount();
  }

  private static void printHeader() {
    out.println("<h1>Book Stores</h1>");
  }

  private static void printContent(BookStores bookStores) {
    out.println("<table>");
    out.println("<tr><td>name </td><td>|  location </td><td></tr>");
    try {
      LinkedList<BookStore> bookStoreList = bookStores.getBookStores();
      for (int i=0; i< bookStoreList.size(); i++) {
        BookStore bookStore = bookStoreList.get(i);
        out.println(bookStore.toHTML());
      }
    } catch(SQLException sqle) {
      sqle.printStackTrace(out);
    }
  }

  private static void printButtons() {
    out.println("<button type=\"button\" onclick=\"NavigateToHome()\">Home</button>");
    out.println("<button type=\"button\" onclick=\"NavigateToBooks()\">Books</button>");
    out.println("<button type=\"button\" onclick=\"NavigateToAuthors()\">Authors</button>");
    out.println("<button type=\"button\" onclick=\"NavigateToBookStores()\" disabled>Book Stores</button>");
    out.println("<button type=\"button\" onclick=\"NavigateToLibraries()\">Libraries</button>");

    out.println("<script>");
    out.println("function NavigateToHome(){ window.location = \"http://cs.drexel.edu:8080/~kd653/ibdb\"; }");
    out.println("function NavigateToBooks(){ window.location = \"http://cs.drexel.edu:8080/~kd653/ibdb/books\"; }");
    out.println("function NavigateToAuthors(){ window.location = \"http://cs.drexel.edu:8080/~kd653/ibdb/authors\"; }");
    out.println("function NavigateToBookStores(){ window.location = \"http://cs.drexel.edu:8080/~kd653/ibdb/book_stores\"; }");
    out.println("function NavigateToLibraries(){ window.location = \"http://cs.drexel.edu:8080/~kd653/ibdb/libraries\"; }");
    out.println("</script>");
  }

  private static void printBookCount() {
    out.println("<button type=\"button\" onclick=\"NavigateToBookCount()\">Reveal which book store has how many books</button>");
    out.println("<script>");
    out.println("function NavigateToBookCount(){ window.location = \"http://cs.drexel.edu:8080/~kd653/ibdb/book_stores/book_counts  \"; }");
    out.println("</script>");
  }
}
