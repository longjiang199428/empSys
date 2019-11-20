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
 * 删除员工
 */
@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取web.xml中的全局配置参数
		ServletContext context = request.getServletContext();
		String encoding = context.getInitParameter("encoding");
		
		//设置请求和响应的编码
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset="+ encoding);
		
		//获取到待删除的参数
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		//通过service删除该员工
		IEmpService service = new EmpService();
		Emp emp = service.findEmpById(id);
		
		if(emp ==null) {
			request.setAttribute("deleteMsg", "该员工不存在");
			request.getRequestDispatcher("WEB-INF/jsp/listEmp.jsp").forward(request, response);
			
			return;
		}
		service.deleteEmpById(id);
		
		//删除之后,要重定向到员工列表
		
		response.sendRedirect("/empSys/listEmpServlet");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
