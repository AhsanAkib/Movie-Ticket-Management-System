import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class ShowMovieInfoGUI extends JFrame
{
	Connection conn = null;
	ResultSet rs = null;
	Statement st = null;
	 public ShowMovieInfoGUI()
	 {
	 	this.setBounds(400,0,200,5000);
	 	this.setLayout(new FlowLayout());
	 	try
		 {
			 conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online_movietickets","root","");
			 st = conn.createStatement();
		 }catch (Exception ex)
		 {
			 JOptionPane.showMessageDialog(null,ex.getMessage());
		 }
		 String query="Select * from movieschedule";
		 try{
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

	 		String m= rs.getString("movieName");
	 		JLabel title= new JLabel("Movie Name: "+m);
	 		this.add(title);


	 			String m1= rs.getString("date");
	 			JLabel title1= new JLabel("Date: "+m1);
	 			this.add(title1);

	 			String m2= rs.getString("startMonth");
	 			JLabel title2= new JLabel("Month: "+m2);
	 			this.add(title2);

	 			String m3= rs.getString("startYear");
	 			JLabel title3= new JLabel("Year: "+m3);
	 			this.add(title3);

	 			String m4= rs.getString("time");
	 			JLabel title4= new JLabel("Time: "+m4);
	 			this.add(title4);

	 			JLabel t= new JLabel(".......Movieplex.......Movieplex........Movieplex........");

	 			this.add(t);
	 		}
	 	}catch(Exception ex)
	 	{
	 		System.out.println(ex.getMessage());
	 	}
	 }
}