package com.zyz.empSys.web;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 防止表单重复提交的servlet,<br>
 * 在这里生成唯一的标识[token],存储在session中<br>
 * 并且还需要发送给srgister.jsp中<br>
 */
@WebServlet("/doSubmitServlet")
public class DoSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoSubmitServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 生成唯一标识UUID
		UUID uuid = UUID.randomUUID();
		// 把该token存储到session中
		request.getSession().setAttribute("token_in_session", uuid.toString());

		// 把该token发送到request.jsp中,以便请求的时候携带
		request.setAttribute("token_in_request", uuid.toString());

		// 请求转发
		request.getRequestDispatcher("/register.jsp").forward(request, response);
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
