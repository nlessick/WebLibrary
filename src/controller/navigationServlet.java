package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Books;

/**
 * Servlet implementation class navigationServlet
 */
@WebServlet("/navigationServlet")
public class navigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public navigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	BooksHelper bookHelp = new BooksHelper();

    	String act = request.getParameter("doThisToBook");

    	String path = "/viewAllBooksServlet";

    	if (act == null) {
    		
    		getServletContext().getRequestDispatcher("/viewAllBooksServlet").forward(request, response);
    	    	
    	} else if (act.equals("delete")) {

    		try {

    			Integer tempId = Integer.parseInt(request.getParameter("id"));
    			Books bookToDelete = bookHelp.searchById(tempId);
    			bookHelp.deleteBook(bookToDelete);

    		} catch (NumberFormatException e) {

    			System.out.println("Forgot to select an item");

    		}

    	} else if (act.equals("edit")) {

    		try {

    			Integer tempId = Integer.parseInt(request.getParameter("id"));
    			Books bookToEdit = bookHelp.searchById(tempId);
    			request.setAttribute("bookToEdit", bookToEdit);
    			path = "/edit-book.jsp";
    			
    			request.setAttribute("month", bookToEdit.getPublishDate().getMonthValue());
    			request.setAttribute("day", bookToEdit.getPublishDate().getDayOfMonth());
    			request.setAttribute("year", bookToEdit.getPublishDate().getYear());

    		} catch (NumberFormatException e) {

    			System.out.println("Forgot to select an item");

    		}

    	} else if (act.equals("add")) {

    		path = "/index.html";

    	}

    	getServletContext().getRequestDispatcher(path).forward(request, response);

    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
