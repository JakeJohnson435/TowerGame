//Class object for towers
//Needs to contain all characteristics of the tower objects
//3-7-19
//Dr. G

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Tower extends MapObject{

	//reserving memory for the MO
	private ArrayList <MovingObject> m1;

	public Tower(int posx, int posy, BufferedImage bi, int imageW, int imageH)
	{
		super(posx, posy, bi, imageW, imageH);
		//initializing the MO then adding the fireball image to the MO for drawing on the field
		m1 = new ArrayList<>();
		try {
			m1.add(new MovingObject(posx, posy, ImageIO.read(new File("fireball.png")), 20, 32, 10, 10));
		} catch (IOException IOe) {
			System.err.println("Unable to read the tower file: ");
		}
	}
	
	//make the tower fire
	public void fire(Graphics g)
	{

		//Cycles the arraylist and fires a fireball.
		for (MovingObject tempO : m1){
			tempO.drawImage(g);
		}

		//Gets the x and y of the MO, if above a set bound, attempt to delete. Not working
		for (MovingObject tempM : m1){
			System.out.println(tempM.getPosX() + ", " + tempM.getPosY());
			if (tempM.getPosX() >= 600 || tempM.getPosY() >= 600){
				tempM.destroyImage(g);

			}
		}
	}

}
