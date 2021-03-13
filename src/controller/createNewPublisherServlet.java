package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BookDetails;
import model.Books;
import model.Publisher;

/**
 * Servlet implementation class createNewListServlet
 */
@WebServlet("/createNewPublisherServlet")
public class createNewPublisherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createNewPublisherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BooksHelper lih = new BooksHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: " + listName);
		
		String name = request.getParameter("name");
		String[] selectedBooks = request.getParameterValues("allBooksToAdd");
		List<Books> selectedBooksInList = new ArrayList<Books>();
		
		if(selectedBooks != null && selectedBooks.length > 0) {
			for(int i = 0; i<selectedBooks.length; i++) {
				System.out.println(selectedBooks[i]);
				Books b = lih.searchById(Integer.parseInt(selectedBooks[i]));
				selectedBooksInList.add(b);
			}
		}
		
		Publisher publisher = new Publisher(name);
		BookDetails bd = new BookDetails(listName, publisher);
		bd.setListOfBooks(selectedBooksInList);
		BookDetailsHelper bdh = new BookDetailsHelper();
		bdh.insertNewBookDetails(bd);
		
		System.out.println("Success!");
		System.out.println(bd.toString());
		
		getServletContext().getRequestDispatcher("/viewAllPublishersServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
