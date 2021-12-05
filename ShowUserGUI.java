import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class ShowUserGUI extends JFrame
{
	Connection conn = null;
	ResultSet rs = null;
	Statement st = null;
	 public ShowUserGUI()
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
		 String query="Select * from user";
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
	 			//int num= rs.getInt("userid");
	 			//JLabel title= new JLabel("User No: "+num);
	 			//this.add(title);

	 			String num2= rs.getString("username");
	 			JLabel title2= new JLabel("User Name: "+num2);
	 			this.add(title2);

	 			String num4= rs.getString("email");
	 			JLabel title4= new JLabel("User Email: "+num4);
	 			this.add(title4);

	 			String num5= rs.getString("phone");
	 			JLabel title5= new JLabel("User Phone: "+num5);
	 			this.add(title5);

	 			JLabel t= new JLabel("********************************************************");

	 			this.add(t);
	 		}
	 	}catch(Exception ex)
	 	{
	 		System.out.println(ex.getMessage());
	 	}
	 }
}