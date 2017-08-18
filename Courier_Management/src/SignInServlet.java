

import java.awt.List;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inautix.training.courier.dao.ClientDAO;
import com.inautix.training.courier.dao.ClientDAO3;
import com.inautix.training.courier.dao.SignUpDAO;
import com.inautix.training.courier.domain.Clients;
import com.inautix.training.courier.domain.Employees;

/**
 * Servlet implementation class SignInServlet
 */
@WebServlet("/SignInServlet")
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInServlet() {
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
		/*Clients c=new Clients();
		String clientname=request.getParameter("name");
		HttpSession session=request.getSession(true);
		session.setAttribute("name",c.getname());*/
System.out.println("inside SignupSevlet doPost method");
		
		String name=request.getParameter("name");
		String password = request.getParameter("PASSWORD");
		Clients user = new Clients();
		user.setname(name);
		user.setpassword(password);
		System.out.println("Name"+name);
		System.out.println("Password"+password);
		ClientDAO3 userDao=new ClientDAO3();
		
		userDao.createClient(user);
		
			RequestDispatcher rs=request.getRequestDispatcher("SuccessfulSignUp.html");
			rs.forward(request, response);
		
			
		
	}

}/*String name = request.getParameter("txtName");
		String userId = request.getParameter("txtUserId");
		String password = request.getParameter("txtPassword");
		
		System.out.println("my name: "+name);
		System.out.println("user id: "+userId);
		System.out.println("password: "+password);
		
		User user = new User();
		user.setName(name);
		user.setUserId(userId);
		user.setPassword(password);
		UserDao userDao = new UserDao();
		System.out.println("before calling userDao");
		userDao.createUser(user);
		HttpSession session = request.getSession(true);
		session.setAttribute("name", user.getName());
		RequestDispatcher rd = request.getRequestDispatcher("/CustomerProfile.html");
		rd.forward(request, response);*/
