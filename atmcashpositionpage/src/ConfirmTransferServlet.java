

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
 * Servlet implementation class ConfirmTransferServlet
 */
@WebServlet("/ConfirmTransferServlet")
public class ConfirmTransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmTransferServlet() {
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
		int payeeAcc = Integer.parseInt(request.getParameter("PayeeAccNumber"));
		int transferAmount=Integer.parseInt(request.getParameter("TransferAmount"));
		CustomerDAO cusDAO = new CustomerDAO();
		boolean auth = cusDAO.getAuthenticForTransfer(payeeAcc);
		if(auth){
		Customer cus = cusDAO.getCustomerDetailForTransfer(payeeAcc);
		int payeeBalance=cus.getBalance();
		int newPayeeBalance=payeeBalance+transferAmount;
		HttpSession session=request.getSession(false);  
		  int Cardnum =(int)session.getAttribute("cardnum");
		Customer cus2 = cusDAO.getCostumerDetails(Cardnum);
		int cusBalance=cus2.getBalance();
		int newCusBalance=cusBalance-transferAmount;
		cusDAO.getBalanceUpdate(Cardnum,newCusBalance);
		cusDAO.getBalanceUpdateForTransfer(payeeAcc, newPayeeBalance);
		request.setAttribute("payeeAccNum", payeeAcc);
		request.setAttribute("transferAmount",transferAmount);
		RequestDispatcher rd = request.getRequestDispatcher("/confrimTransfer.jsp");
		rd.forward(request, response);
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("/InvalidTransfer.html");
			rd.forward(request, response);
		}
		
	}

}
