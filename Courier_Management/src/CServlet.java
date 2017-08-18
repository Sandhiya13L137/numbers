

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inautix.training.courier.dao.ClientDAO;
import com.inautix.training.courier.dao.ClientDAO3;
import com.inautix.training.courier.domain.Clients;

/**
 * Servlet implementation class CServlet
 */
@WebServlet("/CServlet")
public class CServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CServlet() {
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
		System.out.println("inside ClientProfileServlet doPost");
		String id=request.getParameter("id");
		int clientid=Integer.parseInt(id);
		String clientname=request.getParameter("name");
		String clientdate=request.getParameter("date");
		String clientpswd=request.getParameter("PASSWORD");
		String address=request.getParameter("address");
		String address2=request.getParameter("address2");
		System.out.println("Client id "+clientid);
		System.out.println("Client Name "+clientname);
		System.out.println("Date "+clientdate);
		System.out.println("Client Password "+clientpswd);
		System.out.println("Client address "+address);
		System.out.println("Client address(to be delivered) "+address2);
		Clients client = new Clients();
		client.setid(clientid);
		client.setname(clientname);
		client.setdate(clientdate);
		client.setpassword(clientpswd);
		client.setaddress(address);
		client.setaddress2(address2);
		ClientDAO clientdao=new ClientDAO();
		clientdao.createClient(client);
		
		RequestDispatcher rs=request.getRequestDispatcher("ThanksForRegistering.html");
		rs.forward(request, response);
		
	}

}
