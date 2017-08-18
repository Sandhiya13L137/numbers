

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inautix.training.courier.dao.ClientDAO3;
import com.inautix.training.courier.domain.Employees;

/**
 * Servlet implementation class EmpDetServlet
 */
@WebServlet("/EmpDetServlet")
public class EmpDetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpDetServlet() {
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
		System.out.println("inside SigninSevlet doPost method");
        String name = request.getParameter("name");
        String date=request.getParameter("date");
		String courierid1 = request.getParameter("courierid");
		int courierid=Integer.parseInt(courierid1);
		String amount=request.getParameter("amount");
		
		String status=request.getParameter("status");
		Employees user = new Employees();
		user.setname(name);
		user.setdate(date);
		user.setid(courierid);
		user.setamount(amount);
		user.setstatus(status);
		System.out.println("Name "+name);
		System.out.println("Date "+date);
		System.out.println("Courier Id "+courierid);
		System.out.println("Amount "+amount);
		System.out.println("Status "+status);
		
		ClientDAO3 userDao=new ClientDAO3();
		userDao.createEmployee1(user);
		
			RequestDispatcher rd = request.getRequestDispatcher("LogOut.html");
			rd.forward(request, response);
			
		
	}

}
