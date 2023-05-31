package form;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		String phone = req.getParameter("phone");
		pw.println("<h2>Delete Details</h2>");
		pw.println(phone);
		
		GetSet gs = new GetSet();
		gs.setPhone(phone);
		
		Crud cr = new Crud();
		int status = cr.deleteData(gs);
		
		if(status > 0) {
			res.sendRedirect("ViewServlet");
		}else {
			pw.println("Failed to delete");
		}
		
	}

}
