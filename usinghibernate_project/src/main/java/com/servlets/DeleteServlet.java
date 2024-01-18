package com.servlets;

import java.io.IOException;

import java.io.Serializable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hib.util.hiber_utility;
import com.entities.Note;

/**
 * Servlet implementation class DeleteServlet
 */


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		SessionFactory factory =
				hiber_utility.getSessionFactory();
					Session session = 
							factory.getCurrentSession();
	
					org.hibernate.Transaction txn =
							session.beginTransaction(); 
		try {
			
			 int note_Id = Integer.parseInt(request.getParameter("note_id").trim());
			 
			 Note note = (Note) session.get(Note.class, note_Id);
			 session.delete(note);
			 
			 response.sendRedirect("all_notes.jsp");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		txn.commit();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/all_notes.jsp");
//		dispatcher.forward(request, response);

//		int noteId=Integer.parseInt(request.getParameter("noteId").trim());
//		SessionFactory factory =
//				hiber_utility.getSessionFactory();
//					Session session = 
//							factory.getCurrentSession();
//	
//					org.hibernate.Transaction txn =
//							session.beginTransaction(); 
//					
//					
//					Note note=(Note)session.get(Note.class, noteId);
//					session.delete(note);	
		
		//txn.commit();
//		session.close();
	//	response.sendRedirect("all_notes.jsp");
		
		
	}

}
