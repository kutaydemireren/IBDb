package ibdb.src.view;

import java.io.PrintWriter;
import ibdb.src.model.NovelsInLibraries;
import ibdb.src.domain.Book;
import java.util.LinkedList;
import java.sql.SQLException;

public class NovelsInLibrariesView {
  private static PrintWriter out;

  public static void setWriter(PrintWriter out) {
    NovelsInLibrariesView.out = out;
  }

  public static void printNovelsInLibrariesPage(String written, NovelsInLibraries novelsInLibraries) {
    NovelsInLibrariesView.printButtons();
    NovelsInLibrariesView.printHeader();
    NovelsInLibrariesView.printStores(novelsInLibraries);
    NovelsInLibrariesView.printNovels(written, novelsInLibraries);
  }

  private static void printHeader() {
    out.println("<h1>Novel Counts In Libraries</h1>");
    out.println("<p>Here you can find which novels each library has.</p>");
  }

  private static void printStores(NovelsInLibraries novelsInLibraries) {
      out.println("<form>");
    try {
      LinkedList<Book> novels  = novelsInLibraries.getNovels();
      for (int i=0; i< novels.size(); i++) {
        Book book = novels.get(i);
	out.println("<input type=\"radio\" name=\"libraryName\" value='" + book.getLibrary() + "'> " + book.getLibrary() +"<br>");
      }
      out.println("<input type=\"submit\" value=\"Reveal!\">");
    } catch(SQLException sqle) {
      sqle.printStackTrace(out);
    }
    out.println("</form>");
  }

 private static void printNovels(String written, NovelsInLibraries novelsInLibraries) {
     try {
     if(written!=null){
	 LinkedList<Book> novels = novelsInLibraries.getNovels(written);
	 out.print("<p> Novels in the " + written + " are:<br>");
	 for (int i=0; i< novels.size(); i++) {
	     Book book = novels.get(i);
	     out.print("&nbsp;&nbsp;&nbsp;" + book.getName() + "");
	 }
	 out.println("</p>");
     }
     }catch(SQLException sqle) {
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
