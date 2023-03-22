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
 * Servlet implementation class AddEmp_Controller
 */
public class AddEmp_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	EmpDAO dao=new EmpDAO();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException
	{
		resp.setContentType("text/html");
		
		PrintWriter pw=resp.getWriter();
		
		String eid=req.getParameter("id");
		String ename=req.getParameter("name");
		String econtact=req.getParameter("contact");
		String eemail=req.getParameter("email");
			
		int id=Integer.parseInt(eid);
		int contact=Integer.parseInt(econtact);
		
		EmpDTO dto=new EmpDTO(id,ename,contact,eemail);
		
		if(dao.addEmp(dto))
		{
			pw.println("<h2><font color='green'>Employee added Successfully.... :)  <a href='index.html'>home</a></h2>");
		}
		else
		{
			pw.println("<h2><font color='green'>Oops Something Went Wrong...!<a href='index.html'>home</a></h2>");
		}
		
	}

	

}
