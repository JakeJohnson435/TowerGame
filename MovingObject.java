//An object on the map that is going to be moving
//3-7-19
//Dr. G

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MovingObject extends MapObject {
	
	private int vx;
	private int vy;
	private BufferedImage bi;
	private int startyx;
	private int starty;
	
	public MovingObject(int posx, int posy, BufferedImage bi, int imageW, int imageH, int vx, int vy)
	{
		super(posx, posy, bi, imageW, imageH);
		this.bi = bi;
		this.vx=vx;
		this.vy=vy;
	}

	//Getting the posx and posy for DestroyImage.
	public int getPosX(){
		return posx;
	}

	public int getPosY(){
		return posy;
	}

	//Draws the image and compounds the movement
	public void drawImage(Graphics g)
	{
		g.drawImage(bi,posx, posy,imageW,imageH,null);
		posx+=vx;
		posy+=vy;
	}

	//Attempting to remove image, cant figure it out
	public void destroyImage(Graphics g){

		g.dispose();
		System.out.println("Fireball gone");

	}

}
