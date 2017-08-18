

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inautix.training.courier.dao.ClientDAO3;
import com.inautix.training.courier.domain.Owner;

/**
 * Servlet implementation class OwnerServlet
 */
@WebServlet("/OwnerServlet")
public class OwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OwnerServlet() {
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
		String name=request.getParameter("name");
		String id=request.getParameter("id");
		Owner own=new Owner();
		own.setname(name);
		own.setid(id);
		System.out.println("Name:"+name);
		System.out.println("Id:"+id);
		ClientDAO3 clientdao=new ClientDAO3();
		
		boolean authentication=clientdao.authenticateOwner(own);
		if(authentication){
			HttpSession session=request.getSession(true);
			session.setAttribute("name", own.getname());
			System.out.println("inside siginservlet authentiction passed "+own.getname());
			ClientDAO3 dao=new ClientDAO3();
			List clientList=dao.getAllEmployees();
			request.setAttribute("clients", clientList);
			RequestDispatcher rd = request.getRequestDispatcher("OwnerFile.jsp");
			rd.forward(request, response);
			
		}
		else 
		{
			request.setAttribute("key", "Login failed");
			RequestDispatcher rd = request.getRequestDispatcher("OWNER.html");
			rd.forward(request, response);
		}
		
	}
}

