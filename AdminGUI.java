import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminGUI extends JFrame implements ActionListener
{
	JTextField adName;
	JPasswordField adPass;
	JButton go;
	JLabel l;

	Database db;

	public AdminGUI()
	{
		db=new Database();

		adName=new JTextField(15);
		adPass=new JPasswordField(15);
		go=new JButton("Go");

		this.setLayout(new FlowLayout());
		l=new JLabel("..Welcome To Admin..");
		l.setFont(new Font("Times New Roman", Font.BOLD,16));
		l.setBounds(140,0,100,30);
		l.setForeground (Color.RED);
		this.add(l);
		this.add(new JLabel("    Username: "));
		this.add(adName);
		this.add(new JLabel("      Password: "));
		this.add(adPass);
		this.add(go);

		go.addActionListener(this);

		this.setSize(260,260);
		this.setLayout(new FlowLayout());
	}

	public void actionPerformed(ActionEvent a)
	 {
	 	if(a.getSource().equals(go))
	 	{
			if(validateField())
			{
				Admin admin=new Admin(adName.getText(),new String(adPass.getPassword()));
				if(db.validateAdmin(admin))
				{
					AdminInfoGUI info=new AdminInfoGUI();
					info.setVisible(true);
					info.setBounds(680,280,520,400);
					info.setResizable(false);
					info.setDefaultCloseOperation(AdminGUI.EXIT_ON_CLOSE);
					info.setTitle("Admin");
					info.getContentPane().setBackground(Color.ORANGE);
					info.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Information Invalid");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Enter Valid Info");
			}
		}
	 }

	boolean validateField()
	{
		boolean result=true;

		if(adName.getText()==null || adPass.getText()==null || adName.getText().equals("") || new String(adPass.getPassword()).equals(""))
		{
			result=false;
		}
		return result;
	}
}