package ibdb.src.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ibdb.src.model.NovelsInLibraries;
import ibdb.src.view.NovelsInLibrariesView;

public class NovelsInLibrariesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
		private NovelsInLibraries entr;
		private String msg;

		public void init() throws ServletException {
			entr = new NovelsInLibraries();
			msg = entr.openDBConnection("PgBundle");
		}

		public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");

			PrintWriter out = response.getWriter();
			out.println("<html><head></head><body>");

			if (!msg.startsWith("Servus")) {
			    out.println("<h1>Database connection failed to open " + msg + "</h1>");
			} else {
					NovelsInLibrariesView.setWriter(out);
                                        String written = "vgvbhlj";
                                        written = request.getParameter("libraryName");
					NovelsInLibrariesView.printNovelsInLibrariesPage(written, entr);
			}

			out.println("</table>");
			out.println("</html>");
		}

		public void doPost(HttpServletRequest inRequest, HttpServletResponse outResponse) throws ServletException, IOException {
			doGet(inRequest, outResponse);
		}

		public void destroy() {
			entr.closeDBConnection();
		}
}
