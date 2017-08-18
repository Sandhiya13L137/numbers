

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inautix.training.atmcashposition.dao.CashDAO;

/**
 * Servlet implementation class updatecashservlet
 */
@WebServlet("/updatecashservlet")
public class updatecashservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatecashservlet() {
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
		CashDAO cashDAO = new CashDAO();
		cashDAO.getCashUpdate(100,hundered );
		cashDAO.getCashUpdate(500, fiveHundered);
		cashDAO.getCashUpdate(1000,thousand);
		cashDAO.getCashUpdate(2000,twoThousand);
		RequestDispatcher rd = request.getRequestDispatcher("/AdminService.html");
		rd.forward(request, response);
	}

}
