

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inautix.training.atmcashposition.dao.CashDAO;
import com.inautix.training.atmcashposition.dao.CustomerDAO;
import com.inautix.training.atmcashposition.domain.Customer;

/**
 * Servlet implementation class WithdrawServlet
 */
@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WithdrawServlet() {
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
		
		String amount=request.getParameter("Withdraw");
		int enteredAmount = Integer.parseInt(amount);
		System.out.println("enteredAmount"+enteredAmount);
		  HttpSession session=request.getSession(false);  
		  int currentCardnum =(int)session.getAttribute("cardnum");  
			 session.setAttribute("enteredamount",enteredAmount);
		  System.out.println(currentCardnum);
		  
		  CustomerDAO cusDao = new CustomerDAO();
			Customer cus = cusDao.getCostumerDetails(currentCardnum);
			int currentBalance=cus.getBalance();
			session.setAttribute("currentBalance", currentBalance);
			System.out.println("currentBalance"+currentBalance);
			if(enteredAmount < currentBalance){
				CashDAO cashDAO = new CashDAO();
				List cashlist=cashDAO.getAllCashPosition();
				request.setAttribute("cashList", cashlist);
				RequestDispatcher rd = request.getRequestDispatcher("/cashposition.jsp");
				rd.forward(request, response);
			}
			else{
				request.setAttribute("Balance",currentBalance );
				RequestDispatcher rd = request.getRequestDispatcher("/InvalidBalance.jsp");
				rd.forward(request, response);
								
			}
		 
	}

}
