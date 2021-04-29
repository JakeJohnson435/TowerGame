//Demo code to demonstrate GUI Building
//3-7-19
//Updated 11/29/2020
//Dr. G


import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.Graphics;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class GameDriver extends JFrame
{
	
	private int counter = 0;
	
	private ArrayList<Bullet1> b1;
	private ArrayList<MovingObject> m1;
	private ArrayList<Tower> t1;
	private int mouse_x;
	private int mouse_y;

	
	//constructor
	public GameDriver() {

	    //Naming the JFrame
		super("Tower Shooty Game");

		//Reserving memory for the tower and the fireball
		t1 = new ArrayList<Tower>();
		m1 = new ArrayList<MovingObject>();

		//Setting up the JFrame Panels
		getContentPane().setLayout(null);

		//This Panel contains the start button, money and lives counter.
        JPanel control = new JPanel();
        control.setBounds(0, 0, 125, 261);
        getContentPane().add(control);
        control.setLayout(null);
        
        JLabel lbl_money = new JLabel("Money : ");
        lbl_money.setBounds(10, 11, 99, 29);
        control.add(lbl_money);
        
        JLabel lbl_lives = new JLabel("Lives : ");
        lbl_lives.setBounds(10, 40, 99, 29);
        control.add(lbl_lives);

        //setting the panel for the field, also when clicking on the field, reserves an x and y point for the tower
        MyCanvas panel = new MyCanvas(4,4);
        panel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                mouse_x = e.getX();
                mouse_y = e.getY();

            }
        });
        panel.setBounds(135, 0, 500, 500);
        getContentPane().add(panel);
        panel.setLayout(new GridLayout(1, 0, 0, 0));
        
        JButton btnStart = new JButton("START");
        btnStart.addMouseListener(new MouseAdapter() {
    
        	public void mouseClicked(MouseEvent e) {
        	    //Increases the money counter
        		lbl_money.setText("Money : " + counter++ );

        		//Adds the tower to the field
                try {
                	
                t1.add(new Tower(mouse_x, mouse_y, ImageIO.read(new File("Crystal.png")), 20, 20));
          
                } catch (IOException IOe) {
					System.err.println("Unable to read the tower file: ");
				}

        	}
        });
        btnStart.setBounds(10, 80, 89, 23);
        control.add(btnStart);

        //Sets the field image
        for (int x = 0; x< 1; x++)
			for (int y = 0; y < 1; y++)
				((MyCanvas)panel).addPicture(x, y,"grass_02.png");

        //Sets the timer when clicking the start button, draws a tower and sends it the fire command
        Timer timer = new Timer(500, new ActionListener() {
            public void actionPerformed(ActionEvent evt) 
            {

                panel.paint(panel.getGraphics());
                
                if (!t1.isEmpty()) 
                {
                    for(Tower tempTower : t1)
                    {
                        tempTower.drawImage(panel.getGraphics());
                        tempTower.fire(panel.getGraphics());
                    }
                }

            }});

        //Starts timer
        timer.start();
		
	}
	

	
	public static void main(String[] args) {
		
		//Setting the driver and the size of the JFrame window
		GameDriver m = new GameDriver();
		m.setSize(1000, 1000);
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m.setVisible(true);
		
	}
}
