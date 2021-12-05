import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class LoginGUI extends JFrame implements ActionListener
{
	JTextField uname;
	JPasswordField password;
	JButton login, registration, admin;
	JLabel label;
	Database db;
	public LoginGUI()
	{
		db = new Database();
		uname = new JTextField(20);
		password = new JPasswordField(20);
		login = new JButton("    Login    ");
		registration = new JButton("       Registration      ");
		admin = new JButton("                                            Admin                                                   ");

		label=new JLabel("           Movieplex             ");
		label.setFont(new Font("Times New Roman", Font.BOLD,16));
		label.setBounds(280,0,200,60);
		label.setForeground (Color.BLACK);
		

		this.add(label);
		this.add(new JLabel("Username: "));
		this.add(uname);
		this.add(new JLabel("Password: "));
		this.add(password);
		this.add(login);
		this.add(registration);
		this.add(admin);
		login.addActionListener(this);
		registration.addActionListener(this);
		admin.addActionListener(this);
		this.setSize(260,260);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent ev)
	{
		if(ev.getSource().equals(login))
		{
			if(validateField())
			{
				User user=new User(uname.getText(),new String(password.getPassword()));
				if(db.validateUser(user))
				{
					MovieScheduleGUI movieschedule = new MovieScheduleGUI();
					movieschedule.setVisible(true);
					movieschedule.setBounds(680,280,100,280);
					movieschedule.setResizable(false);
					movieschedule.setTitle("Movie schedule");
					movieschedule.getContentPane().setBackground(Color.GREEN);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid information");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Provide Valid Info");
			}
		}
		else if(ev.getSource().equals(registration))
		{
			RegistrationGUI reg = new RegistrationGUI();
			reg.setVisible(true);
			reg.setTitle("registration");
			reg.setBounds(680,280,240,300);
			reg.setResizable(false);
			reg.getContentPane().setBackground(Color.PINK);
			reg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		}
		else if(ev.getSource().equals(admin))
		{
			AdminGUI admin=new AdminGUI();
			admin.setVisible(true);
			admin.setTitle("admin");
			admin.setBounds(680,280,235,200);
			admin.setResizable(false);
			admin.getContentPane().setBackground(Color.WHITE);
			admin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		}
	}
	
	boolean validateField()
	{
		boolean result = true;
		if (uname.getText()== null || password.getText() == null || uname.getText().equals("") || new String(password.getPassword()).equals(""))
			result = false;
		return result;
	}
}