package com.zyz.empSys.web;

import java.io.IOException;
import java.util.List;

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
 * 查看员工列表的Servlet
 */
@WebServlet("/listEmpServlet")
public class ListEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListEmpServlet() {
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

		// 获取到service, 通过service查询所有员工信息
		IEmpService service = new EmpService();

		List<Emp> listEmp = service.findAll();

		// 如果没有获取到数据, 则说明有问题
		// 如果获取到数据, 则把获取到的数据转发到jsp
		if (listEmp == null) {
			request.setAttribute("msg", "没有找到数据");
			request.getRequestDispatcher("/WEB-INF/jsp/listEmp.jsp").forward(request, response);

			return;
		}

		request.setAttribute("listEmp", listEmp);
		request.getRequestDispatcher("/WEB-INF/jsp/listEmp.jsp").forward(request, response);
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
