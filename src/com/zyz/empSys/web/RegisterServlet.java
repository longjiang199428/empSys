package com.zyz.empSys.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 * 完成注册功能的servlet
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取web.xml中的全局配置参数
		ServletContext context = request.getServletContext();
		String encoding = context.getInitParameter("encoding");

		// 设置请求和响应的编码
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset=" + encoding);

		/**
		 * 获取token
		 */
		// 请求中的token
		String token_in_request = request.getParameter("token");
		// Session中的token
		String token_in_session = (String) request.getSession().getAttribute("token_in_session");

		// 比较
		if (token_in_session == null || !token_in_session.equals(token_in_request)) {
			// 这两个token不同的时候
			request.setAttribute("tokenMsg", "表单已提交,请稍等,马上给你服务");
			request.getRequestDispatcher("/register.jsp").forward(request, response);

			return;
		} else {

			// 两个token形同的时候,允许后面的注册操作.
			// 必须把session中的token清空,防止后面的请求再次拿不到session
			request.getSession().removeAttribute("token_in_session");
		}

		// 获取请求的参数值
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		Integer age = Integer.parseInt(request.getParameter("age"));
		Date hiredate = null;

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
			hiredate = sdf.parse(request.getParameter("hiredate"));
		} catch (ParseException e) {

			e.printStackTrace();
		}

		Double salary = Double.parseDouble(request.getParameter("salary"));
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");

		// 把这些数据分装到实体对象中
		Emp emp = new Emp(null, name, password, gender, age, hiredate, salary, phone, email);

		// 获取servlet对象,通过service对象把数据传递到后台

		// 先判断用户名是否已经存在,如果已经存在,则不允许注册
		IEmpService service = new EmpService();

		Emp e = service.findEmpByName(name);

		if (e != null) {
			// 用户已经被占用的时候

			// 把信息绑定到请求中,然后转发到注册页面
			request.setAttribute("msg", "该用户名已存在,请重新取名字");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}

		// 名字可以被注册的时候

		// 调用service中的注册方法
		service.register(emp);

		// 注册成功之后,重定向到主页面
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache", "no-cache");
		response.getWriter().write("注册成功,3s后回到主页");
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
