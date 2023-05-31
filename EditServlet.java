package form;

import java.sql.*;
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		String ph = req.getParameter("phone");
		pw.println("<h2>Update Details</h2>");
		
		try {
			Connection con = Crud.getConnection();
			
			PreparedStatement ps = con.prepareStatement("select * from form where phone=?");
			ps.setString(1, ph);
			
			ResultSet data = ps.executeQuery();
			 
		while(data.next()) {
			
			pw.println("<form method='post' action='UpdateServlet'>");
			
			pw.println("Full Name: <input type='text' name='name' value='"+data.getString(1)+"'>");
			
			pw.println("<br><br>Address: <input type='text' name='add' value='"+data.getString(2)+"'>");
			
			pw.println("<br><br>Date Of Birth: <input type='date' name='dob' value='"+data.getString(3)+"'>");
			
			pw.println("<br><br>Phone No: <input type='number' name='pno' value='"+data.getString(4)+"'>");
			
			pw.println("<br><br>Gender: <input type='radio' name='gender' value='Male'>Male"
					 + "<input type='radio' name='gender' value='Female'>Female");
			
			pw.println("<br><br>Deuration: <select name='course' value='"+data.getString(6)+"'>"
					+ "	<option value='6 Month'>6 Month</option>"
					+ "	<option value='9 Month'>9 Month</option>"
					+ "	<option value='1 Year'>1 Year</option>"
					+ "	</select><br><br>");
			
			pw.println("Any quires: <textarea name='cmnt'>"+data.getString(7)+"</textarea>");
			
			pw.println("<input type='submit' value='Update'>");
			
			pw.println("</form>");
		
		}
			
		
	}catch(Exception ex) {
		
		System.out.println(ex);
	}
		
		
	}

}
