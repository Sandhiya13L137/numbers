

import java.awt.List;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inautix.training.courier.dao.ClientDAO3;
import com.inautix.training.courier.domain.Employees;

/**
 * Servlet implementation class SignInServletEmp
 */
@WebServlet("/SignInServletEmp")
public class SignInServletEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInServletEmp() {
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
		
		Employees user = new Employees();
		user.setname(name);
		user.setpswrd(pswd);
		
		System.out.println("Name "+name);
		System.out.println("Password "+pswd);
		
		ClientDAO3 userDao=new ClientDAO3();
		
		boolean authentication=userDao.authenticateUser(user);
		if(authentication){
			HttpSession session=request.getSession(true);
			session.setAttribute("name", user.getname());
			System.out.println("inside siginservlet authentiction passed "+user.getname());
			
			RequestDispatcher rd = request.getRequestDispatcher("/EmployeeLogIn.html");
			rd.forward(request, response);
			
		}else 
		{
			request.setAttribute("key", "Login failed");
			RequestDispatcher rd = request.getRequestDispatcher("LinkSignIn.html");
			rd.forward(request, response);
		}
	}

}
/*System.out.println("inside SigninSevlet doPost method");
		
		String userId = request.getParameter("txtUserId");
		String password=request.getParameter("txtPassword");
		User user = new User();
		user.setUserId(userId);
		user.setPassword(password);
		System.out.println("password "+password);
		System.out.println("userId "+userId);
		UserDao userDao=new UserDao();
		boolean authentication=userDao.authenticateUser(user);
		if(authentication){
			HttpSession session=request.getSession(true);
			session.setAttribute("name", user.getUserId());
			System.out.println("inside siginservlet authentiction passed "+user.getUserId());
			RequestDispatcher rd = request.getRequestDispatcher("/CustomerProfile.html");
			rd.forward(request, response);
			
		}else 
		{
			request.setAttribute("key", "Login failed");
			RequestDispatcher rd = request.getRequestDispatcher("/signin.jsp");
			rd.forward(request, response);
		}
			
	*/