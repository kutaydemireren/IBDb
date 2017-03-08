package ibdb.src.view;

import java.io.PrintWriter;
import ibdb.src.model.ReadersOfBooks;
import ibdb.src.domain.Book;
import java.util.LinkedList;
import java.sql.SQLException;

public class ReadersOfBooksView {
  private static PrintWriter out;

  public static void setWriter(PrintWriter out) {
    ReadersOfBooksView.out = out;
  }

    public static void printReadersOfBooksPage(String written, ReadersOfBooks readersOfBooks) {
    ReadersOfBooksView.printButtons();
    ReadersOfBooksView.printHeader();
    ReadersOfBooksView.printBooks(readersOfBooks);
    ReadersOfBooksView.printReaderCount(written, readersOfBooks);
  }

  private static void printHeader() {
    out.println("<h1>Number of Readers</h1>");
    out.println("<p>Here you can find how many readers each book has</p>");
  }

    private static void printBooks(ReadersOfBooks readersOfBooks) {
    out.println("<form>");

    try {
      LinkedList<Book> books = readersOfBooks.getBooks();
      for (int i=0; i< books.size(); i++) {
        Book book = books.get(i);
        out.println("<input type=\"radio\" name=\"bookName\" value='" + book.getName() + "'> " + book.getName() +"<br>");
      }
      out.println("<input type=\"submit\" value=\"Reveal!\">");
    } catch(SQLException sqle) {
      sqle.printStackTrace(out);
    }
    out.println("</form>");

  }

    private static void printReaderCount(String written, ReadersOfBooks readersOfBooks) {
	try {
	    if(written!=null){
		LinkedList<Book> readers = readersOfBooks.getReaders(written);
		out.println("<p> Number of readers of " + written + " is " + readers.get(0).getReaderCount() + "</p>");
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
