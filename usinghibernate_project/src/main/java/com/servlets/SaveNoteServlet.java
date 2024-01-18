package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
//import org.hibernate.Transaction;

import com.entities.Note;
import com.hib.util.hiber_utility;
//import com.mysql.cj.Session;

/**
 * Servlet implementation class SaveNoteServlet
 */
@WebServlet("/SaveNoteServlet")
public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SaveNoteServlet() {
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
		//doGet(request, response);
		
try {
			
			//title,content fetch
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			Note note = new Note(title, content, new Date());
			
			System.out.println(note.getId() +" : "+ note.getTitle());
			
			//using hibernate: save()
			SessionFactory factory =
					hiber_utility.getSessionFactory();
						Session session = 
								factory.getCurrentSession();
		
						org.hibernate.Transaction txn =
								session.beginTransaction(); 
			
			
			session.save(note);
			System.out.println("Data created ..");
			txn.commit();
			
		
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<h1 style='text-align:center;'>Note is added successfully.</h1>");
			out.println("<h1 style='text-align:center;'><a href='all_notes.jsp'>View all notes...</a></h1>");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
