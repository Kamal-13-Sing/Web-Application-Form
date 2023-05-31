package form;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void  doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException {
		res.setContentType("text/html");
		
		PrintWriter pw = res.getWriter();
		
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		String dob = req.getParameter("dob");
		
		String phone = req.getParameter("pno");
		String gen = req.getParameter("gender");
		String course = req.getParameter("course");
		String qns = req.getParameter("qns");
	//--String lang[] = req.getParameterValues("lang");
		
		/*
		pw.println("Name: "+name);
		pw.println("<br>Address: "+address);
		pw.println("<br>Date of Birth: "+dob);
		pw.println("<br>Phone No: "+phone);
		pw.println("<br>Gender: "+gen);
		pw.println("<br>Duration: "+course);
		pw.println("<br>Any Question?: "+qns);
		*/
		/*
		pw.println("<br>Hobbies: ");
		for(String a : lang) {
			pw.println(a+",");		
		}
		*/
//------------------set data-------------------------------
		
		GetSet gs = new GetSet();
		
		gs.setName(name);
		gs.setAddress(address);
		gs.setDob(dob);
		gs.setPhone(phone);
		gs.setGender(gen);
		gs.setCourse(course);
		gs.setTextarea(qns);
	//--gs.setLanguage(lang);
		
		//Crud crd = new Crud();
		//crd.insertdata(gs);
		int status = Crud.insertData(gs);
		
		if(status > 0 ) {
			pw.print("<p>Recorded data</p>");
			req.getRequestDispatcher("form.html").include(req,res);
		}else {
			pw.print("<p>Failed to insert</p>");
		}
		
		pw.close();
		
	}


}
