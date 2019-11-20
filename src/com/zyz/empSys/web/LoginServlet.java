package com.zyz.empSys.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zyz.empSys.domain.Emp;
import com.zyz.empSys.service.IEmpService;
import com.zyz.empSys.service.impl.EmpService;

/**
 * 登录的servlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取web.xml中的全局配置参数
		ServletContext context = request.getServletContext();
		String encoding = context.getInitParameter("encoding");

		// 设置请求和响应的编码
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset=" + encoding);

		// 获取前台传递的参数
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		request.getSession().setAttribute("USER_IN_SESSION", "user");

		// 获取验证码
		String validateCode = request.getParameter("validateCode");

		// 获取到服务器中的验证码
		String validateCodeByServer = (String) request.getSession().getAttribute("validateCodeByServer");

		// 和服务器中产生的验证码进行比较
		if (!validateCodeByServer.equals(validateCode)) {
			request.setAttribute("validateMsg", "验证码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);

			return;
		}

		// 通过service去后台查找是否有该用户
		IEmpService service = new EmpService();

		Emp emp = service.findEmpByNameAndPassword(name, password);

		// 用户或密码错误的时候
		if (emp == null) {
			request.setAttribute("msg", "用户名或密码有误, 请检查后登录...");
			request.getRequestDispatcher("/login.jsp").forward(request, response);

			return;
		}

		// 登录成功之后,需要把对象添加到session中
		request.getSession().setAttribute("emp", emp);
		// 然后重定向到主页
		response.getWriter().write("登录成功, 3s后回到主页...");
		response.setHeader("refresh", "3;url=/empSys/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
