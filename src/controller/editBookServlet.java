package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Books;

/**
 * Servlet implementation class editBookServlet
 */
@WebServlet("/editBookServlet")
public class editBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		BooksHelper dao = new BooksHelper();
		
		String title = request.getParameter("title");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		LocalDate ld;
		
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch(NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		
		Books bookToUpdate = dao.searchById(tempId);
		bookToUpdate.setTitle(title);
		bookToUpdate.setPublishDate(ld);
		
		dao.updateBook(bookToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllBooksServlet").forward(request, response);

	}

}
