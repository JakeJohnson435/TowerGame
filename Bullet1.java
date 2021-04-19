//Simple black oval bullet with a set velocity
//3-7-19
//Dr. G

import java.awt.Graphics;
import java.awt.Color;

public class Bullet1 
{
	private int vx;
	private int vy;
	private int startx;
	private int starty;

	public Bullet1(int startx, int starty, int vx, int vy)
	{
		this.startx = startx;
		this.starty = starty;
		this.vx=vx;
		this.vy=vy;
	}
			
	//renders our object to the screen
	public void drawImage(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillOval(startx, starty, 20,20);
		startx+=vx;
		starty+=vy;
	}
	

	//If we are going to be able to have enemies take damage, we need a way to know the bullet position
	public int getXpos()
	{return startx+vx;}
	
	public int getYpos()
	{return starty+vy;}
	
	
}