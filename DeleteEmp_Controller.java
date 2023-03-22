package app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import app.dao.EmpDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteEmp_Controller
 */
public class DeleteEmp_Controller extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	EmpDAO dao=new EmpDAO();
       
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		
		PrintWriter pw=resp.getWriter();
		
		String eid=req.getParameter("id");
		
		int id=Integer.parseInt(eid);
		
		if(dao.deleteEmp(id))
		{
			pw.println("\"<h2><font color='green'>Employee Deleted Successfully.... :)  <a href='index.html'>home</a></h2>");
		}
		else
		{
			pw.println("\"<h2><font color='red'>Oops Something Went wrong...!  <a href='index.html'>home</a></h2>");
		}
	
		
	}

}
