package form;

import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		
		PrintWriter pw = res.getWriter();
		
		pw.println("Update Servlet");
		
		String name = req.getParameter("name");
		String address = req.getParameter("add");
		String phone = req.getParameter("pno");
		String dob = req.getParameter("dob");
		String gender = req.getParameter("gender");
		String duration = req.getParameter("course");
		String qns = req.getParameter("cmnt");
		/*
		pw.println("Name: "+name);
		pw.println("<br>Address: "+address);
		pw.println("<br>Date of Birth: "+dob);
		pw.println("<br>Phone No: "+phone);
		pw.println("<br>Gender: "+gender);
		pw.println("<br>Duration: "+duration);
		pw.println("<br>Any Question?: "+qns);
		*/
		
		GetSet gs = new GetSet();
		
		gs.setName(name);
		gs.setAddress(address);
		gs.setDob(dob);
		gs.setPhone(phone);
		gs.setGender(gender);
		gs.setCourse(duration);
		gs.setTextarea(qns);
		
		Crud cr = new Crud();
		int status = cr.updateData(gs);
		
		if(status > 0) {
			pw.println("<p>SuccessFully Updated</p>");
			//req.getRequestDispatcher("form.html").include(req,res);
			res.sendRedirect("ViewServlet");
		}else {
			pw.println("Failed to Updated");
		}
		
	}


}
