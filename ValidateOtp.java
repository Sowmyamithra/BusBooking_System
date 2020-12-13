import java.io.*;
import java.util.Random; 
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class ValidateOtp extends HttpServlet
{
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		
		HttpSession session = request.getSession();
		String num = (String)session.getAttribute("otp");
		String otp = (String)request.getParameter("otp");
		PrintWriter out = response.getWriter();
		//out.print("<html><body>" + otp + " # "+ num + "</body></html>");
		if(num.equals(otp))
		{
			out.print("<html><body><h1>Successfully Booked</h1></body></html>");
		}
		else
		{
			out.print("<html><body><p>Invalid OTP</p><br><a href = 'Otp.html'>Go To....</body></html>");
		}
		out.close();
	}
}