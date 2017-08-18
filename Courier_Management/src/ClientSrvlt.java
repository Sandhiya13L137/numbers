

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inautix.training.courier.dao.ClientDAO;
import com.inautix.training.courier.dao.ClientDAO3;
import com.inautix.training.courier.domain.Owner;

/**
 * Servlet implementation class ClientSrvlt
 */
@WebServlet("/ClientSrvlt")
public class ClientSrvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientSrvlt() {
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
		
		
		
		
			ClientDAO dao = new ClientDAO();
			List clientList =  dao.getAllClients();
			request.setAttribute("clients", clientList);
			RequestDispatcher rd = request.getRequestDispatcher("/ClientDetails.jsp");
			rd.forward(request, response);
			
		}
		
	}


