package app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import app.dao.EmpDAO;
import app.dto.EmpDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayAllEmp_Controller
 */
public class DisplayAllEmp_Controller extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	EmpDAO dao=new EmpDAO();
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		
		List<EmpDTO> employee=dao.displayAllEmp();
		if(employee.size()==0)
		{
			pw.println("<h1>No Employee in Database...!</h1>");
		}
		else
		{
			pw.println("<table border='10'>");
			pw.println("<tr><th>ID</th><th>NAME</th><th>CONTACT NO</th><th>E-MAIL</th></tr>");
			
			for(EmpDTO dto : employee)
			{
				pw.println("<tr>");
				
				pw.println("<td>"+dto.getId()+"</td>" +"<td>"+dto.getName()+"</td>"+"<td>"+dto.getContact()+"</td>"+"<td>"+dto.getEmail()+"</td>");
				
			}
			
			pw.println("</table>");
		}
		
		pw.println("<h1><a href='index.html'>Home</a></h1>");
	}

}
