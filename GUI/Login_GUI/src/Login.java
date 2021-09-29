import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login implements ActionListener {
	
	private static JLabel userLabel;
	private static JTextField userText;
	private static JLabel passwordLabel;
	private static JPasswordField passwordText;
	private static JButton loginButton;
	private static JLabel success;
	
	public static void main(String[] args) {
		
		JPanel panel = new JPanel();
		JFrame frame = new JFrame("Examples in Swing");
		
		frame.setSize(350,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		
		panel.setLayout(null);
		
		userLabel = new JLabel("User");
		userLabel.setBounds(10,20,80,25);
		panel.add(userLabel);
		
		userText = new JTextField(20);
		userText.setBounds(100,20,165,25);
		userText.setAlignmentX(0);
		panel.add(userText);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10,50,80,25);
		panel.add(passwordLabel);
		
		// hides characters
		passwordText = new JPasswordField(20);
		passwordText.setBounds(100,50,165,25);
		panel.add(passwordText);
		
		// create login button
		loginButton = new JButton("Login");
		loginButton.setBounds(10,80,80,25);
		loginButton.addActionListener(new Login());
		panel.add(loginButton);
		
		success = new JLabel("");
		success.setBounds(10,110,300,25);
		panel.add(success);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String user = userText.getText();
		String password = passwordText.getText();
		System.out.println("User name:" + user + "Password:" + password);
		
		if(user.equals("username") && password.equals("password")) {
			success.setText("logged in success!");
		}
	}
}
