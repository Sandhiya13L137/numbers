

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inautix.training.courier.dao.ClientDAO;
import com.inautix.training.courier.dao.GetEmpDet;
import com.inautix.training.courier.dao.UpdateStatus;
import com.inautix.training.courier.domain.Employees;
import com.inautix.training.courier.domain.StatusUpdate;

/**
 * Servlet implementation class StatusServlet
 */
@WebServlet("/StatusServlet")
public class StatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatusServlet() {
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
		 String id1=request.getParameter("id");
		 int id=Integer.parseInt(id1);
	        
	        
	        System.out.println("Client id:" +id);
	        
	        
	       Employees emp=new Employees();
	   
	        
	        GetEmpDet da=new GetEmpDet();
	        emp=da.getempdet(id);
	        System.out.println(emp.getname());
	        System.out.println(emp.getdate());
	        System.out.println(emp.getamount());
	        System.out.println(emp.getstatus());

	        request.setAttribute("name", emp.getname());
            request.setAttribute("date", emp.getdate());
            request.setAttribute("amount", emp.getamount());
            request.setAttribute("status", emp.getstatus());
            RequestDispatcher rd = request.getRequestDispatcher("/CLIENTS.jsp");

            rd.forward(request, response);




	}

}

