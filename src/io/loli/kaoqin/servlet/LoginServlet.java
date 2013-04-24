package io.loli.kaoqin.servlet;

import io.loli.kaoqin.javabean.Person;
import io.loli.kaoqin.prop.LoginMessage;
import io.loli.kaoqin.service.PersonService;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private PersonService ps = null;
	private final static String LOGIN = "../user/login.jsp"; //$NON-NLS-1$
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		ps = new PersonService();
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = (String)request.getParameter("action"); //$NON-NLS-1$
		//判断是注册登录还是登出
		if(action.equals("regist")){ //$NON-NLS-1$
			regist(request,response);
		}else if(action.equals("login")){ //$NON-NLS-1$
			login(request,response);
		}else if(action.equals("logout")){ //$NON-NLS-1$
			logout(request,response);
		}else if(action.equals("update")){ //$NON-NLS-1$
			update(request,response);
		}else{
			response.sendRedirect(LOGIN);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

	private void regist(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
		Person p = new Person();
		
		p.setUsername(request.getParameter("username")); //$NON-NLS-1$
		p.setPassword(request.getParameter("password")); //$NON-NLS-1$
		p.setEmail(request.getParameter("email"));
		p.setTel(request.getParameter("tel"));
		p.setAddress(request.getParameter("address"));
		ps.save(p);
		request.setAttribute("info", LoginMessage.getString("LoginServlet.regist.success.info")); //$NON-NLS-1$ //$NON-NLS-2$
		RequestDispatcher dispatcher = request.getRequestDispatcher(LOGIN); 
		dispatcher.forward(request, response); 
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		List<Person> list = ps.findByUsername(request.getParameter("username")); //$NON-NLS-1$
		if(list.size()==0){
			request.setAttribute("info", LoginMessage.getString("LoginServlet.login.info")); //$NON-NLS-1$ //$NON-NLS-2$
			RequestDispatcher dispatcher = request.getRequestDispatcher(LOGIN); 
			dispatcher.forward(request, response); 
			return;
		}
		Person p =(Person)list.get(0);
		if(request.getParameter("password").equals(p.getPassword())){ //$NON-NLS-1$
			response.sendRedirect("index.jsp"); //$NON-NLS-1$
			request.getSession().setAttribute("person", p); //$NON-NLS-1$
		}else{
			request.setAttribute("info", LoginMessage.getString("LoginServlet.login.info")); //$NON-NLS-1$ //$NON-NLS-2$
			RequestDispatcher dispatcher = request.getRequestDispatcher(LOGIN); 
			dispatcher.forward(request, response); 
		}
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		if(null!=request.getSession().getAttribute("person")){ //$NON-NLS-1$
			request.getSession().removeAttribute("person"); //$NON-NLS-1$
			request.setAttribute("info", LoginMessage.getString("LoginServlet.logout.success")); //$NON-NLS-1$ //$NON-NLS-2$
			RequestDispatcher dispatcher = request.getRequestDispatcher(LOGIN); 
			dispatcher.forward(request, response); 
		}else{
			response.sendRedirect(LOGIN);
		}
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Person p = (Person)request.getSession().getAttribute("person"); //$NON-NLS-1$
		try {
			p.setUsername(p.getUsername());
			p.setPassword(request.getParameter("password")); //$NON-NLS-1$
			p.setAddress(request.getParameter("address")); //$NON-NLS-1$
			p.setEmail(request.getParameter("email")); //$NON-NLS-1$
			p.setTel(request.getParameter("tel")); //$NON-NLS-1$
			ps.update(p);
			request.getSession().setAttribute("person", ps.findById(p.getId())); //$NON-NLS-1$
			request.setAttribute("info", LoginMessage.getString("LoginServlet.changeInfo.success")); //$NON-NLS-1$ //$NON-NLS-2$
		} catch (Exception e) {
		} finally {
			// 跳转到用户信息界面
			RequestDispatcher dispatcher = request.getRequestDispatcher("info.jsp");  //$NON-NLS-1$
			dispatcher.forward(request, response); 
		}
	}
}
