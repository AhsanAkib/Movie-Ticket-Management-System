import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicketPriceGUI extends JFrame
{
	Database db;
	public TicketPriceGUI()
	{
		db= new Database();

		
		JLabel l;
		JLabel labelSeat = new JLabel("Select Seat: ");
		JLabel labelPrice = new JLabel("Ticket Price: ");
		JLabel labelPayment = new JLabel("Payment Method: ");
		
		

		String seatList[] = {"A1","A2", "B1", "B2", "C1", "C2", "D1", "D2","E1","E2", "F1", "F2", "G1", "G2", "H1", "H2","I1", "I2", "J1", "J2"};
		String paymentList[] = {"BKash","Rocket", "NexusPay", "iPay"};

		JComboBox seat= new JComboBox(seatList);
		JComboBox payment= new JComboBox(paymentList);
		JButton go = new JButton("Go");



		
		this.setLayout(new FlowLayout());
		this.add(labelPrice);
		l=new JLabel("500");
		//l.setBounds(140,0,100,30);
		l.setForeground (Color.BLUE);
		this.add(l);
		this.add(labelSeat);
		this.add(seat);
		this.add(labelPayment);
		this.add(payment);
		this.add(go);

		go.addActionListener
		(
		new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				TicketPrice ticketprice = new TicketPrice();

				ticketprice.seats= seat.getSelectedItem().toString();
				ticketprice.payments= payment.getSelectedItem().toString();

				db.checkUser(ticketprice);
				JOptionPane.showMessageDialog(null, "Payment Confirmed!!");
			}
		}
		);
	}
}

/*import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicketPriceGUI extends JFrame
{
	Database db;
	public TicketPriceGUI()
	{
		db= new Database();

		//labels
		JLabel l;
		JLabel labelSeat = new JLabel("        Select Seat:        ");
		JLabel labelPrice = new JLabel("Ticket Price: ");
		JLabel labelPayment = new JLabel("Payment Method: ");
		
		//input components

		//String seatList[] = {"A1","A2", "B1", "B2", "C1", "C2", "D1", "D2","E1","E2", "F1", "F2", "G1", "G2", "H1", "H2","I1", "I2", "J1", "J2"};
		JCheckBox a1 = new JCheckBox("A1");
		JCheckBox a2 = new JCheckBox("A2");
		JCheckBox b1 = new JCheckBox("B1");
		JCheckBox b2 = new JCheckBox("B2");
		JCheckBox c1 = new JCheckBox("C1");
		JCheckBox c2 = new JCheckBox("C2");
		JCheckBox d1 = new JCheckBox("D1");
		JCheckBox d2 = new JCheckBox("D2");
		JCheckBox e1 = new JCheckBox("E1");
		JCheckBox e2 = new JCheckBox("E2");
		JCheckBox f1 = new JCheckBox("F1");
		JCheckBox f2 = new JCheckBox("F2");
		JCheckBox g1 = new JCheckBox("G1");
		JCheckBox g2 = new JCheckBox("G2");
		JCheckBox h1 = new JCheckBox("H1");
		JCheckBox h2 = new JCheckBox("H2");
		JCheckBox i1 = new JCheckBox("I1");
		JCheckBox i2 = new JCheckBox("I2");
		//JCheckBox j1 = new JCheckBox("J1");
		//JCheckBox j2 = new JCheckBox("J2");

		
		String paymentList[] = {"BKash","Rocket", "NexusPay", "iPay"};

		//JComboBox seat= new JComboBox(seatList);
		JComboBox payment= new JComboBox(paymentList);
		JButton go = new JButton("    Go    ");


		//adding the components
		this.setLayout(new FlowLayout());
		this.add(labelPrice);
		l=new JLabel("1000");
		//l.setBounds(140,0,100,30);
		l.setForeground (Color.BLUE);
		this.add(l);
		this.add(labelSeat);
		//this.add(seat);
		this.add(a1);
		this.add(a2);
		this.add(b1);
		this.add(b2);
		this.add(c1);
		this.add(c2);
		this.add(d1);
		this.add(d2);
		this.add(e1);
		this.add(e2);
		this.add(f1);
		this.add(f2);
		this.add(g1);
		this.add(g2);
		this.add(h1);
		this.add(h2);
		this.add(i1);
		this.add(i2);

		this.add(labelPayment);
		this.add(payment);
		this.add(go);

		go.addActionListener
		(
		new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				TicketPrice ticketprice = new TicketPrice();

				//ticketprice.seats= seat.getSelectedItem().toString();
				ticketprice.seats= a1.toString();
				ticketprice.seats= a2.toString();
				ticketprice.seats= b1.toString();
				ticketprice.seats= b2.toString();
				ticketprice.seats= c1.toString();
				ticketprice.seats= c2.toString();
				ticketprice.seats= d1.toString();
				ticketprice.seats= d2.toString();
				ticketprice.seats= e1.toString();
				ticketprice.seats= e2.toString();
				ticketprice.seats= f1.toString();
				ticketprice.seats= f2.toString();
				ticketprice.seats= g1.toString();
				ticketprice.seats= g2.toString();
				ticketprice.seats= h1.toString();
				ticketprice.seats= h2.toString();
				ticketprice.seats= i1.toString();
				ticketprice.seats= i2.toString();


				ticketprice.payments= payment.getSelectedItem().toString();

				db.checkUser(ticketprice);
				JOptionPane.showMessageDialog(null, "Payment Confirmed. Thank you.");
			}
		}
		);
	}
}*/

