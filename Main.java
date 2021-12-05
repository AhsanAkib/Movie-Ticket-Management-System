import javax.swing.*;
import java.awt.*;
public class Main
{
	public static void main(String[] args)
	{	
		LoginGUI login = new LoginGUI();
		login.setVisible(true);
		login.setTitle("login");
		login.setBounds(680,280,500,300  );
		login.setResizable(false);
		//login.getContentPane().setBackground(Color.BLACK);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}