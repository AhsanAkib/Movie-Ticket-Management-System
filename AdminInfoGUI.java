import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminInfoGUI extends JFrame
{
	public AdminInfoGUI ()
	{
		JButton showUser = new JButton("Show User");
		JButton showMovieSchedule = new JButton("Show Movie Schedule");
		JButton showTicket = new JButton("Show Movie Ticket");
		this.setLayout(new FlowLayout());
		
		this.add(showUser);


		showUser.addActionListener
		(
		new ActionListener ()
		{
			public void actionPerformed(ActionEvent e)
			{
				ShowUserGUI a= new ShowUserGUI();
				a.setVisible(true);
				a.setTitle("User List:");
				a.getContentPane().setLayout(null);
				a.getContentPane().setBackground(Color.PINK);
			}
		}
		);

		this.add(showMovieSchedule);
		showMovieSchedule.addActionListener
		(
		new ActionListener ()
		{
			public void actionPerformed(ActionEvent e)
			{
				ShowMovieInfoGUI a= new ShowMovieInfoGUI();
				a.setVisible(true);
				a.setTitle("User List");
				a.getContentPane().setLayout(null);
				a.getContentPane().setBackground(Color.PINK);

			}
		}
		);

		this.add(showTicket);
		showTicket.addActionListener
		(
		new ActionListener ()
		{
			public void actionPerformed(ActionEvent e)
			{
				ShowTicketInfoGUI a= new ShowTicketInfoGUI();
				a.setVisible(true);
				a.setTitle("User List");
				a.getContentPane().setLayout(null);
				a.getContentPane().setBackground(Color.PINK);				

			}
		}
		);
	}
}