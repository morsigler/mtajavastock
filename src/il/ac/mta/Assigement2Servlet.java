package il.ac.mta;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Assigement2Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
		int num1; int num2; int result;
		num1 = 2; num2= 3; result = 2*3;
		String resultStr = new String("the result of "+num1+" * "+num2+" = "+result);
		resp.getWriter().println(resultStr);
	}
}
