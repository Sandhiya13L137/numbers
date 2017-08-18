

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inautix.training.atmcashposition.dao.AdminDAO;
import com.inautix.training.atmcashposition.dao.CustomerDAO;
import com.inautix.training.atmcashposition.domain.Admin;
import com.inautix.training.atmcashposition.domain.Customer;

/**
 * Servlet implementation class Adminloginservlet
 */
@WebServlet("/Adminloginservlet")
public class Adminloginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adminloginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("ID"));
		
		int pin= Integer.parseInt(request.getParameter("PIN"));
		 PrintWriter out=response.getWriter();  
		AdminDAO adminDao = new AdminDAO();
		Admin admin = adminDao.getAdminDetails(id);
		 System.out.println(id);
		int adminpin=admin.getPin();
	
		if(pin==adminpin){
			
			RequestDispatcher rd = request.getRequestDispatcher("/AdminService.html");
			rd.forward(request, response);
			
			
		}else 
		{
			RequestDispatcher rd = request.getRequestDispatcher("/InvalidCredential.html");
			rd.forward(request, response);  
		}
	}

}
