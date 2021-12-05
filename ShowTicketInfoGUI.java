import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class ShowTicketInfoGUI extends JFrame
{
	Connection conn = null;
	ResultSet rs = null;
	Statement st = null;
	 public ShowTicketInfoGUI()
	 {
	 	this.setBounds(400,0,200,5000);
	 	this.setLayout(new FlowLayout());
	 	try
		{
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online_movietickets","root","");
			st = conn.createStatement();
		}
		catch (Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}

		String query="Select * from ticketprice";
		try
		{
		 	rs=st.executeQuery(query);
		}
		catch(Exception ex)
		{
		 	System.out.println(ex.getMessage());
		}
	 	try
	 	{
	 		while(rs.next())
	 	{
	 		

	 		String m= rs.getString("seat");
	 		JLabel title= new JLabel("Seat No.: "+m);
	 		this.add(title);

	 		String m1= rs.getString("payment");
	 		JLabel title1= new JLabel("Payment Method: "+m1);
	 		this.add(title1);


	 		JLabel t= new JLabel(".......Movieplex.......Movieplex........Movieplex........");

	 		this.add(t);
	 	}}
	 	catch(Exception ex)
	 	{
	 		System.out.println(ex.getMessage());
	 	}
	 }
}