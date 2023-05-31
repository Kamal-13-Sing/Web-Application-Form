package form;

import java.sql.*;
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
	
		try {
			Connection con = Crud.getConnection();
			
			Statement stm = con.createStatement();
			String read = "select * from form";
			
			ResultSet data = stm.executeQuery(read);
	
			pw.println("<table border=1 >");
			
			pw.println("<button class=btn><a href='form.html'>Add New</a></button>");
			
			pw.println("<th>Name</th><th>Address</th><th>DateOfBirth</th><th>Phone No</th>"
					+ "<th>Gender</th><th>Deuration</th><th>Question</th><th colspan='2'>Operation</th> ");
			
			while(data.next()) {
				
				pw.println("<tr><td>"+data.getString(1)+"</td>");
				
				pw.println("<td>"+data.getString(2)+"</td>");
				
				pw.println("<td>"+data.getString(3)+"</td>");
				
				pw.println("<td>"+data.getString(4)+"</td>");
				
				pw.println("<td>"+data.getString(5)+"</td>");
				
				pw.println("<td>"+data.getString(6)+"</td>");
				
				pw.println("<td>"+data.getString(7)+"</td>");
				
				pw.println("<td><a href='EditServlet?phone="+data.getString(4)+"'>Edit</a></td>");
				
				pw.println("<td><a href='DeleteServlet?phone="+data.getString(4)+"'>Delete</a></td><tr>");
			}
			
			pw.println("</table>");
			
		}catch(Exception e) {
			
			System.out.println(e);
		}
		
		
		
		
		
	}

}
