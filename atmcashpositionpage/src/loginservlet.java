

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.Option;

import com.inautix.training.atmcashposition.controller.CustomerController;
import com.inautix.training.atmcashposition.dao.CustomerDAO;
import com.inautix.training.atmcashposition.domain.Customer;

/**
 * Servlet implementation class loginservlet
 */
@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public loginservlet() {
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
		//response.setContentType("text/html"); 
		//PrintWriter out = response.getWriter();
		String cardnum=request.getParameter("cardnum");
		int cardNum = Integer.parseInt(cardnum);
		String pinnum=request.getParameter("password");
		int pinNum= Integer.parseInt(pinnum);
		 PrintWriter out=response.getWriter();  
		CustomerDAO cusDao = new CustomerDAO();
		Customer cus = cusDao.getCostumerDetails(cardNum);
		 System.out.println(cardNum);
		int cuspin=cus.getPinnum();
	
		if(pinNum==cuspin){
			HttpSession session=request.getSession(); 
			 session.setAttribute("cardnum",cardNum);
			RequestDispatcher rd = request.getRequestDispatcher("/Option.html");
			rd.forward(request, response);
			
			
		}else 
		{
			RequestDispatcher rd = request.getRequestDispatcher("/InvalidCredential.html");
			rd.forward(request, response);  
		}
		
		}

		
	}


