

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inautix.training.atmcashposition.dao.CashDAO;
import com.inautix.training.atmcashposition.dao.CustomerDAO;
import com.inautix.training.atmcashposition.domain.Cash;

/**
 * Servlet implementation class TranctionServlet
 */
@WebServlet("/TranctionServlet")
public class TranctionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TranctionServlet() {
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
		
		int hundered = Integer.parseInt(request.getParameter("100"));
		
		int fiveHundered=Integer.parseInt(request.getParameter("500"));
		
		int thousand=Integer.parseInt(request.getParameter("1000"));
		
		int twoThousand=Integer.parseInt(request.getParameter("2000"));
		int currentAmount=(hundered*100)+(fiveHundered*500)+(thousand*1000)+(twoThousand*2000);
		System.out.println(hundered);
		System.out.println(fiveHundered);
		System.out.println(thousand);
		System.out.println(twoThousand);
		CashDAO cashDAO = new CashDAO();
		Cash cash = new Cash();
		Cash cash1=cashDAO.getCashDetails(100);
		int oldHundered=cash1.getAmount();
		int newHundered=oldHundered-hundered;
		Cash cash2=cashDAO.getCashDetails(500);
		int old5Hundered=cash2.getAmount();
		int new5Hundered=old5Hundered-fiveHundered;
		Cash cash3=cashDAO.getCashDetails(1000);
		int oldThousand=cash3.getAmount();
		int newThousand=oldThousand-thousand;
		Cash cash4=cashDAO.getCashDetails(2000);
		int old2Thousand=cash4.getAmount();
		int new2Thousand=old2Thousand-twoThousand;
		
		
		HttpSession session=request.getSession(false);  
		int enteredAmount=(int) session.getAttribute("enteredamount");
		int currentBalance=(int) session.getAttribute("currentBalance");
		int newBalance = currentBalance-enteredAmount;
		int cardnum = (int) session.getAttribute("cardnum");
		CustomerDAO cusDAO = new CustomerDAO();
		
		if(enteredAmount==currentAmount){
			
			RequestDispatcher rd = request.getRequestDispatcher("/TransactionComplete.html");
			rd.forward(request, response);
			cashDAO.getCashUpdate(100,newHundered );
			cashDAO.getCashUpdate(500,new5Hundered);
			cashDAO.getCashUpdate(1000,newThousand);
			cashDAO.getCashUpdate(2000,new2Thousand);
			cusDAO.getBalanceUpdate(cardnum, newBalance);
			cusDAO.getWithdrawUpdate(cardnum, enteredAmount);
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("/InvalidAmount.html");
			rd.forward(request, response);
		}
		//CashDAO cashDAO = new CashDAO();
		//cashDAO.getCashUpdate(100,() )
		
		}
	}


