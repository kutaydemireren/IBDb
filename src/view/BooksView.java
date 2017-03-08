package ibdb.src.view;

import java.io.PrintWriter;
import java.util.LinkedList;
import ibdb.src.domain.Book;
import ibdb.src.model.Books;
import java.sql.SQLException;

public class BooksView {
  private static PrintWriter out;

  public static void setWriter(PrintWriter out) {
    BooksView.out = out;
  }

    public static void printBooksPage(Books books) {
    BooksView.printButtons();
    BooksView.printHeader();
    BooksView.printContent(books);
    BooksView.printExtraButtons();
  }

  private static void printHeader() {
    out.println("<h1>Books</h1>");
  }

  private static void printContent(Books books) {
    out.println("<table>");
    out.println("<tr><td>name </td><td>|  published_date </td><td>|  type </td><td></tr>");
    try {
      LinkedList<Book> bookList = books.getBooks();
      for (int i=0; i< bookList.size(); i++) {
        Book book = bookList.get(i);
        out.println(book.toHTML());
      }
    } catch(SQLException sqle) {
      sqle.printStackTrace(out);
    }
  }

  private static void printButtons() {
    out.println("<button type=\"button\" onclick=\"NavigateToHome()\">Home</button>");
    out.println("<button type=\"button\" onclick=\"NavigateToBooks()\" disabled>Books</button>");
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

  private static void printExtraButtons() {
    out.println("<button type=\"button\" onclick=\"NavigateToAdaptedMovies()\">Movies adapted from books</button>");
    out.println("<button type=\"button\" onclick=\"NavigateToReaderCount()\">Reveal how much books are read!</button>");

    out.println("<script>");
    out.println("function NavigateToAdaptedMovies(){ window.location = \"http://cs.drexel.edu:8080/~kd653/ibdb/books/adapted_movies\"; }");
    out.println("function NavigateToReaderCount(){ window.location = \"http://cs.drexel.edu:8080/~kd653/ibdb/books/readers\"; }");
    out.println("</script>");
  }
}
