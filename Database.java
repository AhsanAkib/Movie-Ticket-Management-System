import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class Database
{
	Connection conn = null;
	ResultSet rs = null;
	Statement st = null;
	 
	public Database()
	{
		try
		{
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online_movietickets","root","");
			st = conn.createStatement();
		}
		catch (Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
	}

	
	public void registerUser(User user)
	{
		String query = "INSERT INTO `user` (`userid`, `username`, `password`, `email`, `mobile`) VALUES (NULL, '"+user.uname+"', '"+user.pass+"', '"+user.email+"', '"+user.phone+"');";
		try
		{
			st.executeUpdate(query);
			
		}
		catch (Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
	}
	 
	
	public void checkUser(MovieSchedule movieschedule)
	{
		String query = "INSERT INTO `movieschedule` (`movieId`, ``, `movieName`, `date`, `startMonth`, `startYear`, `time`) VALUES (NULL, '"+movieschedule.movieName+"', "+movieschedule.date+", '"+movieschedule.month+"', '"+movieschedule.year+"', '"+movieschedule.time+"');";
		try
		{
			st.executeUpdate(query);
			
		}catch (Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
	}


	 
	public void checkUser(TicketPrice ticketprice)
	{
		String query = "INSERT INTO `ticketprice` (`ticketId`, `seat`, `payment`) VALUES (NULL, '"+ticketprice.seats+"', '"+ticketprice.payments+"');";
		try
		{
			st.executeUpdate(query);
			
		}catch (Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
	}

	 
	public boolean validateUser(User user)
	{
		String query = "select password from user where username='"+user.uname+"'";
		try
		{
			rs = st.executeQuery(query);
			while (rs.next())
			{
				if (rs.getString("password").equals(user.pass))
				{
					return true;
				}
			}
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		return false;
	}

	 
	public boolean validateAdmin(Admin admin)
	{
		String query = "select adminPassword from admin where adminName='"+admin.adName+"'";
		try
		{
			rs = st.executeQuery(query);
			while (rs.next())
			{
				if (rs.getString("adminPassword").equals(admin.adPass))
				{
					return true;
				}
			}
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		return false;
	 }
}