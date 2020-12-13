import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class ValidateDriver extends HttpServlet
{
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		PrintWriter out = response.getWriter();

		ServletContext context=getServletContext();
		String driver = context.getInitParameter("DRIVER");
		String user = context.getInitParameter("USERNAME");
		String password = context.getInitParameter("PASSWORD");
		String url = context.getInitParameter("URL");

		String first_name = request.getParameter("Drivername");
		out.print("<html><body>");

		try
		{
			Class.forName(driver);
              		Connection c = DriverManager.getConnection(url, user, password);
			if(c != null)
			{
				Statement st = c.createStatement();
				ResultSet rs = st.executeQuery("Select * from Driver");
				int flag=0;
				while(rs.next())
				{
					String fname = rs.getString("first_name");
					if(first_name.equals(fname))
					{
						flag=1;
						String nm = rs.getString("name");
						String pn = rs.getString("phone_no");
						out.print("<h1>Driver Details</h1><br><hr>");
						out.print("<h1>First_Name : " + fname + "</h2><br>");
						out.print("<h2>Name : " + nm + "</h2><br>");
						out.print("<h2>Phone_No : " + pn + "</h2><br>");
						break;
					}
				}
				rs.close();
				if(flag==0)
				{
					out.print("<h2>Sorry....! Invalid Credentials.</h2><br><br><h2>Please Go Back and Try Again</h2>");
				}
			}
			else
			{
				System.out.println("Failed to estabish connection");
			}
		}
		catch(ClassNotFoundException | SQLException e)
		{
			out.print("" + e);
			//System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		}
		out.print("</body></html>");
		out.close();
	}
}
