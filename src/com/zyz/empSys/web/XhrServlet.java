package com.zyz.empSys.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zyz.empSys.dao.impl.EmpDao;
import com.zyz.empSys.domain.Emp;

/**
 * Servlet implementation class XhrServlet
 */
@WebServlet("/XhrServlet")
public class XhrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XhrServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String name = req.getParameter("name");
		EmpDao dao = new EmpDao();
		Emp emp = dao.findEmpByName(name);
		
		//1表示存在
		//0表示不存在
		if (emp !=null) {
			resp.getWriter().write("1");
		}else {
			resp.getWriter().write("0");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
