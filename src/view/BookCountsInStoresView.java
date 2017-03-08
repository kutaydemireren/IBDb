package ibdb.src.view;

import java.io.PrintWriter;
import ibdb.src.model.BookCountsInStores;
import ibdb.src.domain.BookStore;
import java.util.LinkedList;
import java.sql.SQLException;

public class BookCountsInStoresView {
  private static PrintWriter out;

  public static void setWriter(PrintWriter out) {
    BookCountsInStoresView.out = out;
  }

    public static void printBookCountsInStoresPage(String written, BookCountsInStores bookCountsInStores) {
	BookCountsInStoresView.printButtons();
	BookCountsInStoresView.printHeader();
	BookCountsInStoresView.printBookStores(bookCountsInStores);
	BookCountsInStoresView.printBookCount(written, bookCountsInStores);
    }

  private static void printHeader() {
    out.println("<h1>Number Of Books</h1>");
    out.println("<p>Here you can find how many book each store has.</p>");
  }

    private static void printBookStores(BookCountsInStores bookCountsInStores) {
	out.println("<form>");
	
	try {
	    LinkedList<BookStore> bookStores = bookCountsInStores.getBookStores();
	    for (int i=0; i< bookStores.size(); i++) {
		BookStore bookStore = bookStores.get(i);
		out.println("<input type=\"radio\" name=\"bookStoreName\" value='" + bookStore.getName() + "'> " + bookStore.getName() +"<br>");
	    }
	    out.println("<input type=\"submit\" value=\"Reveal!\">");
	}catch(SQLException sqle) {
	    sqle.printStackTrace(out);
	}
	out.println("</form>");
    }

    private static void printBookCount(String written, BookCountsInStores bookCountsInStores) {
	out.println("<form>");
	try {
	    if(written!=null) {
		LinkedList<BookStore> bookStores = bookCountsInStores.getBookCount(written);
		BookStore bookStore = bookStores.get(0);
		out.println(written + " has " + bookStore.getBookCount() + " books in the store.");
	    }
	} catch(SQLException sqle) {
	    sqle.printStackTrace(out);
	}
	out.println("</form>");
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
