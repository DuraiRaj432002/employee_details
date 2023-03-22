package app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import app.dao.EmpDAO;
import app.dto.EmpDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchEmp_Controller
 */
public class SearchEmp_Controller extends HttpServlet
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
		
		EmpDTO dto=dao.searchEmp(id);
		
		if(dto!=null)
		{
			pw.println("<h3><b>Id         : "+dto.getId()+"</b></h3>");
			pw.println("<h3><b>Name       : "+dto.getName()+"</b></h3>");
			pw.println("<h3><b>Contact No : "+dto.getContact()+"</b></h3>");
			pw.println("<h3><b>Email      : "+dto.getEmail()+"</b></h3>");
			
		}
		else
		{
			pw.println("<h2><font color='green'>Oops Something Went Wrong...!<a href='index.html'>home</a></h2>");
		}
		
	}

}
