

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.inautix.training.courier.dao.ClientDAO3;
import com.inautix.training.courier.domain.Clients;
import com.inautix.training.courier.domain.Employees;

/**
 * Servlet implementation class SignInClient
 */
@WebServlet("/SignInClient")
public class SignInClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInClient() {
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
        String name = request.getParameter("name");
		String pswd = request.getParameter("PASSWORD");
		String id1=request.getParameter("id");
		int id=Integer.parseInt(id1);
		Clients user = new Clients();
		user.setname(name);
		user.setpassword(pswd);
		user.setid(id);
		System.out.println("Name "+name);
		System.out.println("Password "+pswd);
		System.out.println("Id "+id);
		ClientDAO3 userDao=new ClientDAO3();
		
		boolean authentication=userDao.authenticateClient(user);
		if(authentication){
			HttpSession session=request.getSession(true);
			session.setAttribute("id", user.getid());
			System.out.println("inside siginservlet authentiction passed "+user.getname());
			Employees emp=new Employees();
			ClientDAO3 dao=new ClientDAO3();
			emp=dao.getEmployeeDetails1(id);
            request.setAttribute("m", emp);
       

			RequestDispatcher rd = request.getRequestDispatcher("CLIENTS.jsp");
			rd.forward(request, response);
			
		}else 
		{
			request.setAttribute("key", "Login failed");
			RequestDispatcher rd = request.getRequestDispatcher("ClientLogIn.html");
			rd.forward(request, response);
		}

	}

}
