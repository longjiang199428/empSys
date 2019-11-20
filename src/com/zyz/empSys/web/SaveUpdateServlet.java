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
 * 保存更新的数据
 */
@WebServlet("/saveUpdateServlet")
public class SaveUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveUpdateServlet() {
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

		// 获取请求的参数值
		Integer id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		Integer age = Integer.parseInt(request.getParameter("age"));
		Date hiredate = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			hiredate = sdf.parse(request.getParameter("hiredate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Double salary = Double.parseDouble(request.getParameter("salary"));
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");

		// 把这些数据封装到实体对象中
		Emp emp = new Emp(null, name, password, gender, age, hiredate, salary, phone, email);

		// 获取service对象, 通过service对象把数据传递到后台

		IEmpService service = new EmpService();
		service.updateEmpById(id, emp);

		// 更新完数据之后, 去员工信息列表
		response.sendRedirect("/empSys/listEmpServlet");
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
