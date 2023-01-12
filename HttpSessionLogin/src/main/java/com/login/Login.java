package com.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		request.getRequestDispatcher("./link.html").include(request, response);
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		
		if(pwd.equals("admin"))
		{
			out.println("You are successfully logged in");
			out.println("Welcome "+name);
			
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
		}
		else
		{
			out.println("Incorrect Name or Password");
			request.getRequestDispatcher("./login.html").include(request, response);
		}
		out.close();
	}

}
