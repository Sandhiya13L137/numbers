

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.inautix.training.courier.dao.UpdateStatus;
import com.inautix.training.courier.domain.StatusUpdate;


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
        String id=request.getParameter("id");
        String status=request.getParameter("status");
        
        
        System.out.println("Client id:" +id);
        System.out.println("Status:" +status);
        StatusUpdate su=new StatusUpdate();
        su.setid(Integer.parseInt(id));
        su.setstatus(status);
        UpdateStatus da=new UpdateStatus();
        da.updatestatus(su);
        RequestDispatcher rd = request.getRequestDispatcher("ThanksforUpdate.html");
		rd.forward(request, response);
	}

}
