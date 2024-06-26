package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Query;

import model.DBHelper;
import model.User;
import model.UserDAO;

/**
 * Servlet implementation class EditSevlet
 */
@WebServlet("/edit")
public class EditSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO dao = new UserDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void loadDB(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
    	List<User> list = dao.getAll();          
        request.setAttribute("listUser", list);
        RequestDispatcher rd = request.getRequestDispatcher("view/User.jsp");
        rd.forward(request, response);
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User user = dao.getUser(id);	 
		request.setAttribute("user", user);
        RequestDispatcher rd = request.getRequestDispatcher("view/Edit.jsp");
        rd.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        boolean gender=  Integer.parseInt(request.getParameter("gender"))==1 ? true:false;
       
        int id = Integer.parseInt(request.getParameter("id"));
        
        User user = new User(id,username,gender,email,password);
        System.out.println(user);
        dao.updateUser(user);
        loadDB(request,response);
        
	}

}
