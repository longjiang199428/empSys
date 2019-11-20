//package com.zyz.empSys.filter;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
///**
// * 登录权限验证
// */
//public class LoginFilter implements Filter {
//	private String encoding;
//	
//	
//	@Override
//	public void init(FilterConfig filterConfig) throws ServletException {
//		this.encoding=filterConfig.getInitParameter("encoding");
//		
//		
//	}
//	
//	@SuppressWarnings("unused")
//	@Override
//	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
//			throws IOException, ServletException {
//		
//		HttpServletRequest request = (HttpServletRequest)req;
//		HttpServletResponse response =(HttpServletResponse)resp;
//		
//		Object obj = request.getSession().getAttribute("USER-IN_SESSION");
//		
//		//获取到uri对象
//		String uri = request.getRequestURI().substring(1);
//		
//		if (!"login.jsp".equals(uri) && !"loginServlet".equals(uri)) {
//			//没有登录,就跳转到index页
//			if (obj == null) {
//				response.sendRedirect(request.getContextPath()+"/login.jsp");
//				return;
//			}
//		}
//		chain.doFilter(request, response);
//	}
//	
//	@Override
//	public void destroy() {
//		
//		
//	}
//}
