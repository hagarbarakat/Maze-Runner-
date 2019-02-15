package model;

import java.io.IOException;


import controller.Controller;
import javafx.scene.image.Image;

public class Albert extends Monster{
	//Kills tha player

	Controller c= new Controller();
	private int health;
	private static Albert instance=null;
	public static Albert getInstance()
	{
		if(instance==null)
		{
			instance=new Albert();
		
		}
		return instance;
	}
	private int locationX;
	private int locationY;
	private int dx;
	private int dy,prevx,prevy;
	private Albert()
	{
		
		locationX=7;
		locationY=8;
		this.setName("Albert");
		this.setLocationX(7);
		this.setLocationY(8);
		this.setIcon(new Image("/Webp.net-gifmaker (6).gif"));
	}
	@Override
	public void claim()  {

		try {
			c.setScene("Lose","Alber has eaten you!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}

	@Override
	public void ammo() {}

	public int getHealth() {
		return health;
	}

	public void updateLocation ()
	{
		locationX+=dx;
		locationY+=dy;
	}
	public int getX() {return locationX;}
	public int getY() {return locationY;}

	public void setLoaction(int y, int x)
	{
		locationX=x;
		locationY=y;
	}
	
	public void setDirection(String direction)
	{
		if(direction.equals("left"))
		{
			dx=-1;
			dy=0;
		}else if(direction.equals("right"))
		{
			dx=1;
			dy=0;
		}
		else if(direction.equals("up"))
		{
			dx=0;
			dy=-1;
		}
		else if(direction.equals("down"))
		{
			dx=0;
			dy=1;
		}
	}
	public int getPrevx() {
		return prevx;
	}
	public void setPrevx(int prevx) {
		this.prevx = prevx;
	}
	public int getPrevy() {
		return prevy;
	}
	public void setPrevy(int prevy) {
		this.prevy = prevy;
	}


	
	
	

}
