

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inautix.training.atmcashposition.dao.CustomerDAO;
import com.inautix.training.atmcashposition.domain.Customer;

/**
 * Servlet implementation class CheckbalanceServlet
 */
@WebServlet("/CheckbalanceServlet")
public class CheckbalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckbalanceServlet() {
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
			HttpSession session=request.getSession(false);  
			  int currentCardnum =(int)session.getAttribute("cardnum"); 
			  System.out.println(currentCardnum);
			  CustomerDAO cusDAO = new CustomerDAO();
			  Customer cus = cusDAO.getCostumerDetails(currentCardnum);
			  int NewBalance=cus.getBalance();
			  System.out.println(NewBalance);
			  request.setAttribute("newBalance", NewBalance);
	          RequestDispatcher rd = request.getRequestDispatcher("/Checkbalance.jsp");
	          rd.forward(request, response);

	}

}
