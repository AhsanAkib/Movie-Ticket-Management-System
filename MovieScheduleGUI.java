import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MovieScheduleGUI extends JFrame
{
	Database db;
	public MovieScheduleGUI ()
	{
		db = new Database();
		

		JLabel labelMovieName = new JLabel("MovieName: ");
		JLabel labelDate = new JLabel("      Date: ");
		JLabel labelMonth = new JLabel("     Month: ");
		JLabel labelYear = new JLabel("      Year: ");
		JLabel labelTime = new JLabel("      Time:");
		
		
		JTextField date = new JTextField(10);
		JTextField time = new JTextField(10);
		
		String movieList[] = {"Spider Man Far From Home ","Fagun Haway","Avengers Endgame"};
		String dateList[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		String monthList[] = {"Jan","Feb", "Mar","Apr","May", "Jun","Jul","Aug", "Sep","Oct","Nov", "Dec"};
		String yearList[] = {"2019"};
		String timeList[] = {"12.00 AM","03.00 PM", "07.00 PM"};


		JComboBox startMovieName = new JComboBox(movieList);		
		JComboBox startDate = new JComboBox(dateList);
		JComboBox startMonth = new JComboBox(monthList);
		JComboBox startYear = new JComboBox(yearList);
		JComboBox startTime = new JComboBox(timeList);
		JButton check = new JButton("Check");
		
		
		this.setLayout(new FlowLayout());
		this.add(labelMovieName);
		this.add(startMovieName);

		this.add(labelDate);
		this.add(startDate);

		this.add(labelMonth);
		this.add(startMonth);

		this.add(labelYear);
		this.add(startYear);

		this.add(labelTime);
		this.add(startTime);

		this.add(check);
		
		
		check.addActionListener
		(
		new ActionListener ()
		{
			public void actionPerformed(ActionEvent e)
			{
				MovieSchedule movieschedule = new MovieSchedule();
				
				movieschedule.movieName = startMovieName .getSelectedItem().toString();
				movieschedule.date = startDate.getSelectedItem().toString();
				movieschedule.month = startMonth.getSelectedItem().toString();
				movieschedule.year = startYear.getSelectedItem().toString();
				movieschedule.time = startTime.getSelectedItem().toString();
				
				db.checkUser(movieschedule);
				if(e.getSource().equals(check))
				{
					TicketPriceGUI tckt=new TicketPriceGUI();
					tckt.setVisible(true);
					tckt.setBounds(680,280,250,100);
					tckt.setResizable(false);
					tckt.setTitle("TicketPriceGUI");
					tckt.getContentPane().setBackground(Color.RED);
					tckt.setDefaultCloseOperation(AdminGUI.EXIT_ON_CLOSE);
				}
			}
		}
		);
	}
}