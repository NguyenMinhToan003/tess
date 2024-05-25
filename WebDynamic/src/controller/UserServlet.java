package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserDAO;


@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
   
    private UserDAO dao = new UserDAO();

    public UserServlet() {
        super();
    }

    public void loadDB(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
    	List<User> list = dao.getAll();          
        request.setAttribute("listUser", list);
        RequestDispatcher rd = request.getRequestDispatcher("view/User.jsp");
        rd.forward(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        	loadDB(request,response);
        } catch (Exception e) {
            throw new ServletException("Error retrieving users", e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        boolean gender=  Integer.parseInt(request.getParameter("gender"))==1 ? true: false ;
        System.out.println(username+password+email+gender+ "   kq");
        User user = new User(username,gender,email,password);
        dao.addUser(user);
        loadDB(request,response);
    }
}
