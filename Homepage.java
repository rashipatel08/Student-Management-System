import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Homepage extends JFrame
{
    ImageIcon image;
    private JPanel sidebar;
    private boolean sidebarVisible = false;

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

    Homepage()
    {
        setTitle("HOMEPAGE");
        setSize(500,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        image = new ImageIcon("logoimage.jpg"); //created an image icon
		setIconImage(image.getImage()); //change icon of image

        // Create a custom panel with gradient background
        GradientPanel panel = new GradientPanel();
        panel.setLayout(null); // Set null layout for manual positioning
        add(panel); // Add the panel to the frame

        
        // Create the sidebar
        sidebar = new JPanel();
        sidebar.setBackground(new Color(100, 100, 255)); // Sidebar color
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBounds(-200, 0, 200, 600); // Initially off-screen

        // Add buttons to the sidebar
        sidebar.add(new JButton("Home"));
        sidebar.add(new JButton("Profile"));
        sidebar.add(new JButton("Settings"));
        sidebar.add(new JButton("Logout"));
        panel.add(sidebar); // Add sidebar to the main panel

        // Button to toggle sidebar
        JButton toggleButton = new JButton("Toggle Sidebar");
        toggleButton.setBounds(10, 10, 150, 30);
        toggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleSidebar();
            }
        });
        panel.add(toggleButton); // Add toggle button to the main pane

        setVisible(true);
    }

    private void toggleSidebar() {
        int targetX = sidebarVisible ? -200 : 0; // Target position
        Timer timer = new Timer(5, new ActionListener() {
            int currentX = sidebar.getX();

            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentX != targetX) {
                    currentX += (targetX > currentX) ? 5 : -5; // Move towards target
                    sidebar.setBounds(currentX, 0, 200, 600);
                } else {
                    ((Timer) e.getSource()).stop(); // Stop the timer
                }
            }
        });
        timer.start();
        sidebarVisible = !sidebarVisible;
    } // Toggle visibility state

    public static void main(String[] args)
    {
        Homepage o = new Homepage();    
    }
    
}
