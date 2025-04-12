import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class StudentLoginpage extends JFrame
{
	//Created Instance variable
	JLabel username,password,heading;
	JTextField textfield;
	JPasswordField pwd;
	JButton login;
	JCheckBox checkbox;
	ImageIcon image;

	// Custom JPanel to create a gradient background
	class GradientPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Create a gradient from top to bottom
            Color color1 = Color.WHITE;// Start color
            Color color2 = new Color(201, 160, 220); // End color
            GradientPaint gradientPaint = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
            g2d.setPaint(gradientPaint);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
    }

	// Custom JCheckBox to match the gradient background
    class TransparentCheckBox extends JCheckBox {
        public TransparentCheckBox(String text) {
            super(text);
            setContentAreaFilled(false); // Make the checkbox background transparent
            setFocusPainted(false); // Remove focus border
            setBorderPainted(false); // Remove border
            setOpaque(false); // Make it non-opaque
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Optionally, you can customize the checkbox appearance here
        }
    }
	
	StudentLoginpage()
	{
		setTitle("STUDENT MANAGEMENT SYSTEM"); //set a title of the frame 
		setSize(500,600); // given the size of frame
		setLocationRelativeTo(null);// Center the window on the screen
		//setResizable(false); //frame size can't be change 
		setDefaultCloseOperation(EXIT_ON_CLOSE); //exit out of application	
		//setLayout(null); // added a default layout 
	

		// Create a custom panel with gradient background
        GradientPanel panel = new GradientPanel();
        panel.setLayout(null); // Set null layout for manual positioning
        add(panel); // Add the panel to the frame

		heading = new JLabel("<html><b><u>Student Login Page</b></u></html>");
		heading.setBounds(140,110,300,30);
		heading.setHorizontalTextPosition(JLabel.CENTER);
		heading.setFont(new Font("serif",Font.PLAIN,24));
		panel.add(heading);

		username = new JLabel("Username or Email : "); // created label username 
		textfield = new JTextField(10); //created textfield for username
		username.setBounds(30,170,150,30);
        textfield.setBounds(200,170,250,30);
		panel.add(username); //added username label to frame 
		panel.add(textfield); // added textfield to frame
		//username.setVerticalAlignment(JLabel.CENTER);
		//username.setHorizontalAlignment(JLabel.CENTER);

		password = new JLabel("Password : "); // created label password
		pwd = new JPasswordField(10); //created label passwordfield
		password.setBounds(30, 220, 150, 30);
        pwd.setBounds(200, 220, 250, 30);
		panel.add(password);
		panel.add(pwd);
		
		image = new ImageIcon("logoimage.jpg"); //created an image icon
		setIconImage(image.getImage()); //change icon of image

		//getContentPane().setBackground(new Color(0xC9A0DC)); //change color of background

        checkbox = new TransparentCheckBox("Remember me");
        checkbox.setBounds(200, 275, 120, 20);
        panel.add(checkbox);
		
		login = new JButton("Login"); // made a login button
        login.setBounds(340, 270, 100, 30);
		panel.add(login);

		//setBackground(new Color(0xC9A0DC)); //added background color to the frame

		// "Don't have an account?" link
		JLabel dontHaveAccount = new JLabel("<html>Don't have an account?<u>Signup</u></html>");
		dontHaveAccount.setBounds(200, 310, 200, 30);
		dontHaveAccount.setForeground(Color.BLACK);
		dontHaveAccount.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Change cursor to hand
		dontHaveAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openSignupPage();
			}
		});
		panel.add(dontHaveAccount);

		setVisible(true); //made frame visible
	}

	private void openSignupPage() {
        // Open the signup page
        new StudentSignuppage();
        this.dispose(); // Close the current login page
    }
	
	public static void main(String[] args)
	{
		StudentLoginpage o = new StudentLoginpage();
	}
}