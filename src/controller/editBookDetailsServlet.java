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
 * Servlet implementation class editBookDetailsServlet
 */
@WebServlet("/editBookDetailsServlet")
public class editBookDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editBookDetailsServlet() {
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
		BookDetailsHelper dao = new BookDetailsHelper();
		BooksHelper lih = new BooksHelper();
		PublishersHelper ph = new PublishersHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		BookDetails listToUpdate = dao.searchForBookDetailsById(tempId);
		
		String newListName = request.getParameter("listName");
		
		String publisherName = request.getParameter("name");
		Publisher newPublisher = ph.findPublisher(publisherName);
		
		try {
			String[] selectedBooks = request.getParameterValues("allBooksToAdd");
			List<Books> selectedBooksInList = new ArrayList<Books>();
			
			for(int i = 0; i <selectedBooks.length; i++) {
				System.out.println(selectedBooks[i]);
				Books b = lih.searchById(Integer.parseInt(selectedBooks[i]));
				selectedBooksInList.add(b);
			}
			listToUpdate.setListOfBooks(selectedBooksInList);
		} catch(NullPointerException ex) {
			List<Books> selectedBooksInList = new ArrayList<Books>();
			listToUpdate.setListOfBooks(selectedBooksInList);
		}
		listToUpdate.setListName(newListName);
		listToUpdate.setPublisher(newPublisher);
		
		dao.updateList(listToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

}
