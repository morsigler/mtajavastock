package il.ac.mta;

import java.io.IOException;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Assigement2Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
		//exercise 2
		int num1; int num2; int num3; int result;
		num1 = 4; num2= 3; num3=7; result = (num1+num2)*num3;
		String resultStr = new String("<h1>the result of "+num1+" + "+num2+" * "+num3+" = "+result+"<h1>");
		resp.getWriter().println(resultStr);
	
		//exercise 3
		//part 1
		double radius, area; 
		radius = 50;
		area = Math.PI * Math.pow(radius, 2);
		String resultArea = new String("Area of circle with radius "+radius+" is: "+area+" square-cm");
	
		//part 2
		double angle, hypotenuse, angleInRadians, opposite ;
		angle = 30; hypotenuse = 50;
		angleInRadians = Math.toRadians(angle);
		opposite = hypotenuse* Math.sin(angleInRadians);
		String resultOpposite = new String("Length of opposite where angle B is 30 degrees and  Hypotenuse length is 50 cm is: "+opposite+" cm");
		
		//part 3
		double base, exp, value;
		base = 20; exp = 13;
		value = Math.pow(base, exp);
		String resultPow = new String("Power of 20 with exp of 13 is: "+value);
		
		//printing all calculations
		String resultCalculate = resultArea+"<br>"+resultOpposite+"<br>"+resultPow+"</br>";
		resp.getWriter().println(resultCalculate);
	}
}
