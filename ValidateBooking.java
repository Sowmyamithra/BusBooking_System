import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class ValidateBooking extends HttpServlet
{
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		PrintWriter out = response.getWriter();

		ServletContext context=getServletContext();
		String driver = context.getInitParameter("DRIVER");
		String user = context.getInitParameter("USERNAME");
		String password = context.getInitParameter("PASSWORD");
		String url = context.getInitParameter("URL");

		String frm_add = request.getParameter("from");
		String to_add = request.getParameter("to");
		out.print("<html><body>");

		try
		{
			Class.forName(driver);
              		Connection c = DriverManager.getConnection(url, user, password);
			if(c != null)
			{
				Statement st = c.createStatement();
				ResultSet rs = st.executeQuery("Select * from Route");
				int flag=0;
				while(rs.next())
				{
					String frm = rs.getString("frm_add");	
					String to = rs.getString("to_add");
					//out.print("<p>" + frm_add + "," + to_add + "," + frm + "," + to + "</p>");
					if(frm.equalsIgnoreCase(frm_add) && to.equalsIgnoreCase(to_add))
					{
						flag=1;
						out.print("<h1>Current Services are avialable</h1>");
						break;
					}
				}
				rs.close();
				if(flag==0)
				{
					out.print("<h2>Sorry....! Current Service is not available.</h2><br><br><h2>Please Go Back and Try Again</h2>");
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
