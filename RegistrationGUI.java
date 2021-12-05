import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegistrationGUI extends JFrame
{
	Database db;
	public RegistrationGUI ()
	{
		db = new Database();
		
		JLabel labelUname = new JLabel("Username: ");
		JLabel labelPass = new JLabel("Password: ");
		JLabel labelEmail = new JLabel("Email: ");
		JLabel labelPhone = new JLabel("Phone: ");
		
		
		JTextField uname = new JTextField(20);
		JPasswordField pass = new JPasswordField(15);
		JTextField email= new JTextField(18);
		JTextField phone = new JTextField(15);
		
		JButton register = new JButton("Register");
		
		
		this.setLayout(new FlowLayout());
		this.add(labelUname);
		this.add(uname);
		this.add(labelPass);
		this.add(pass);
		this.add(labelEmail);
		this.add(email);
		this.add(labelPhone);
		this.add(phone);
		this.add(register);

		register.addActionListener
		(
			new ActionListener ()
			{
				public void actionPerformed(ActionEvent e)
				{
					User user = new User();
					user.uname = uname.getText();
					user.pass = new String(pass.getPassword());
					user.email = email.getText();
					user.phone = phone.getText();
					
					db.registerUser(user);
					JOptionPane.showMessageDialog(null,"Registration Successful!!!");
				}	
			}
		);
	}
}