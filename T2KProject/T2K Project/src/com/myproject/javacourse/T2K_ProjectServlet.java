package com.myproject.javacourse;
import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class T2K_ProjectServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		int num1 = 4;
		int num2 = 3;
		int num3 = 7;
				
		num1 = 4;
		num2 = 3;
		num3 = 7;
		
		int result  = (num1+num2)*num3;
		String resultStr = new String("Result of ("+num1 + " + " + num2  + ") * " +num3 + " = " + result);
		resp.getWriter().println(resultStr);
	}
}
