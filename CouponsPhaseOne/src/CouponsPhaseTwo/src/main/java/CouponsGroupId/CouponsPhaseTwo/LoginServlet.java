package CouponsGroupId.CouponsPhaseTwo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * <p>USER-NAME : <input type="text" name="username"></p> <p>PASSWORD : <input
		 * type="password" name="password"></p> <input type="radio" name="userType"
		 * value="customer" checked> Customer<br> <input type="radio" name="userType"
		 * value="company"> Company <br> <input type="radio" name="userType"
		 * value="admininstrator"> Administrator<br>
		 */

		PrintWriter out = response.getWriter();
		out.append("Login servlet \n");

		String userType = request.getParameter("userType");
		switch (userType) {
		case "customer":
			// checking authentication...............
			// redirect since authorized
			request.getSession().setAttribute("customer", "ok");
			response.sendRedirect("http://localhost:8080/likeProject/customer.html");
			return;
		case "company":
			request.getSession().setAttribute("company", "ok");
			response.sendRedirect("http://localhost:8080/likeProject/company.html");
			return;
		case "admininstrator":
			request.getSession().setAttribute("admininstrator", "ok");
			response.sendRedirect("http://localhost:8080/likeProject/admin.html");
			return;
		}

	}

}