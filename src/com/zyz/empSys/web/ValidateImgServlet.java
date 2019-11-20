package com.zyz.empSys.web;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidateImgServlet
 */
@WebServlet("/validateImgServlet")
public class ValidateImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 产生图片
	 */
	public ValidateImgServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//验证码是通过img标签触发的,所以是get方式,重写servlet方法:
		/**
		 * BufferedImage(int width,int height,int imageType)构建了一个
		 * BufferedImage一个预定义的图片类型,TYPE_INT_RGB 代表8位RGB分量包装成整张图片
		 */
		
		Random r = new Random();
		
		BufferedImage bi =new BufferedImage(85, 30, BufferedImage.TYPE_INT_RGB);
		
		Graphics g= bi.getGraphics();
		Color c = new Color(200, 200, 255);
		g.setColor(c);//背景颜色
		
		g.fillRect(0, 0, 85, 30);//背景框
		
		for(int i=1;i<=5;i++) {
			int rr =r.nextInt(256);
			int gg =r.nextInt(256);
			int bb =r.nextInt(256);
			g.setColor(new Color(rr,gg,bb));
			
			int x1=r.nextInt(10)+6;
			int y1=r.nextInt(20)+8;
			int x2=r.nextInt(10)+70;
			int y2=r.nextInt(20)+8;
			
			g.drawLine(x1, y1, x2, y2);
			
		}
		
		//字母数字组合:
		char[] ch="ABCDEFGHJKLMNPQRSTUVEXY3456789".toCharArray();
		int len =ch.length;
		int index;
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<4;i++) {
			index = r.nextInt(len);
			g.setColor(new Color(r.nextInt(80), r.nextInt(180), r.nextInt(255)));
			g.drawString(ch[index] +"",(i*15)+10 , 20);
			sb.append(ch[index]);
			
		}
		request.getSession().setAttribute("validateCodeByServer", sb.toString());// 将生产的验证码保存下来，以便之后的检验输入是否一致
		ImageIO.write(bi, "JPG", response.getOutputStream());
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
