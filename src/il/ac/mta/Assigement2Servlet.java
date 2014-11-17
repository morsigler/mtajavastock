package il.ac.mta;

import java.io.IOException;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Assigement2Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
		int num1; int num2; int num3; int result;
		num1 = 4; num2= 3; num3=7; result = (num1+num2)*num3;
		String resultStr = new String("<h1>the result of "+num1+" + "+num2+" * "+num3+" = "+result+"<h1>");
		resp.getWriter().println(resultStr);
	
		double radius, area; 
	
		radius = 0.5;
		area = Math.PI * Math.pow(radius, 2);
		String resultArea = new String(" Area of circle with radius "+radius+" is: "+area+" square-cm");
		resp.getWriter().println(resultArea);
		
		
	}
}
