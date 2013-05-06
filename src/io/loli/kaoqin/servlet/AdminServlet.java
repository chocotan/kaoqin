package io.loli.kaoqin.servlet;

import io.loli.kaoqin.dao.AdminDAO;
import io.loli.kaoqin.dao.IAdminDAO;
import io.loli.kaoqin.entity.Admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IAdminDAO ad;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminServlet() {
		super();
		ad = new AdminDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("login")) {
			login(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		Admin admin = ad.findByName(name);
		if (password.equals(admin.getPassword())) {
			response.sendRedirect("submitted.jsp");
		} else {
			request.setAttribute("info", "用户名或密码错误");
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
	}
}
