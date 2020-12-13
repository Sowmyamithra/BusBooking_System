import java.io.*;
import java.util.Random; 
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class ValidatePayment extends HttpServlet
{
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		String n1 = request.getParameter("seats");
		int n = Integer.valueOf(n1);
		double price = (double)n * 255.5;
		Random rand = new Random();
		int a = rand.nextInt(10);
		if(a == 0)
		{
			a = rand.nextInt(10);
		}
		int b = rand.nextInt(10);
		int c = rand.nextInt(10);
		int d = rand.nextInt(10); 
		HttpSession session = request.getSession();
		int num = a * 1000 + b * 100 + c * 10 + d;
		String str = Integer.toString(num);
		session.setAttribute("otp", str);
		PrintWriter out = response.getWriter();
		out.print("<p>Total Price : <h1>" + price + "</h1></p>");
		out.print("<html><body>your otp is : <h1>" + num + "</h1><br>");
		out.print("<a href = 'Otp.html'>Go To....</a></body></html>");	
		out.close();
	}
}